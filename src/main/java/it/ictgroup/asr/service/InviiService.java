package it.ictgroup.asr.service;

import it.ictgroup.asr.management.AppConstants;
import it.ictgroup.asr.model.Applicazione;
import it.ictgroup.asr.model.Elaborazione;
import it.ictgroup.asr.model.Invio;
import it.ictgroup.asr.model.enums.StatoInvio;
import it.ictgroup.asr.model.enums.TipologiaFlusso;
import it.ictgroup.asr.model.enums.TipologiaInvio;
import it.ictgroup.asr.repository.ApplicazioniRepository;
import it.ictgroup.asr.repository.ElaborazioniRepository;
import it.ictgroup.asr.repository.InviiRepository;
import it.ictgroup.asr.util.QueueUtils;
import it.ictgroup.asr.util.SiglaUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

import org.jboss.logging.Logger;

@Stateless
public class InviiService
{

   Logger logger = Logger.getLogger(InviiService.class);

   @Inject
   ElaborazioniRepository elaborazioniRepository;

   @Inject
   InviiRepository inviiRepository;

   @Inject
   ApplicazioniRepository applicazioniRepository;

   @Inject
   FlussoService flussoService;

   @Inject
   @JMSConnectionFactory("java:/ConnectionFactory")
   private JMSContext context;

   @Resource(lookup = AppConstants.VERIFICA_INVIO_ASR_QUEUE)
   private Queue verificaInvioAsrQueue;

   @Resource(lookup = AppConstants.CORREGGI_ERRORI_ASR_QUEUE)
   private Queue correggiErroriAsrQueue;

   @Asynchronous
   @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
   public void verificaInvii_async()
   {
      try
      {
         verificaInvii();
      }
      catch (Exception e)
      {
         logger.info(e.getMessage());
      }
   }

   @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
   public void verificaInvii() throws Exception
   {
      // carico tutti gli invii non

      Map<TipologiaInvio, List<Elaborazione>> mappa = elaborazioniRepository.getElaborazioniNonCongiunteEseguite();
      for (TipologiaInvio tipologiaInvio : mappa.keySet())
      {
         List<Elaborazione> elaborazioni = mappa.get(tipologiaInvio);
         for (Elaborazione elaborazione : elaborazioni)
         {
            String sigla = SiglaUtils.getSiglaByFileName(elaborazione.getFileName());
            Invio invio = inviiRepository.getInvioBySiglaAndTipo(sigla, tipologiaInvio);
            boolean sendToVerify = false;
            if (invio == null)
            {
               Date periodoDa = SiglaUtils.getPeriodoDa(elaborazione
                        .getFileName());
               Date periodoA = SiglaUtils.getPeriodoA(elaborazione
                        .getFileName());
               Applicazione applicazione = applicazioniRepository.findBySigla(SiglaUtils.getApplicazione(elaborazione
                        .getFileName()));
               invio = new Invio(sigla, tipologiaInvio, applicazione, periodoA, periodoDa, StatoInvio.INCOMPLETO);
               invio = inviiRepository.persist_newtx(invio);
            }
            switch (elaborazione.getConfigurazione().getTipologiaFlusso())
            {
            case A1:
            case C1:
               invio.setFile1(elaborazione);
               if (invio.getFile2() != null && invio.getFileRitorno() == null)
               {
                  invio.setStatoInvio(StatoInvio.IN_ATTESA_DI_ESITO);
                  sendToVerify = true;
               }
               break;
            case A2:
            case C2:
               invio.setFile2(elaborazione);
               if (invio.getFile1() != null && invio.getFileRitorno() == null)
               {
                  invio.setStatoInvio(StatoInvio.IN_ATTESA_DI_ESITO);
                  sendToVerify = true;
               }
               break;
            case A2R:
            case C2R:
               invio.setFileRitorno(elaborazione);
               invio.setStatoInvio(StatoInvio.ESITATO_CON_ERRORI);
               break;
            default:
               break;
            }
            if (invio.getId() != null)
            {
               inviiRepository.update(invio);
            }
            else
            {
               logger.info("NON HO ID");
            }
            elaborazione.setCongiunta(true);
            elaborazioniRepository.updateCongiunta(elaborazione.getId());
            if (sendToVerify)
            {
               QueueUtils.sendVerificaInvioAsr(context, verificaInvioAsrQueue, invio);
            }
         }
      }

   }

   @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
   public void verificaCongruenza(Long idElaborazione1, Long idElaborazione2, Long idInvio,
            TipologiaFlusso tipologiaFlusso1,
            TipologiaFlusso tipologiaFlusso2)
   {
      try
      {
         int count1 = elaborazioniRepository.countRighe(idElaborazione1, tipologiaFlusso1);
         int count2 = elaborazioniRepository.countRighe(idElaborazione2, tipologiaFlusso2);
         if (count1 != count2)
         {
            inviiRepository.updateStato(idInvio, StatoInvio.ERRORE_COERENZA);
         }
      }
      catch (Exception e)
      {
         logger.info(e.getMessage());
      }
   }

   @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
   public void correggiErrori()
   {
      List<Invio> inviiDaCorreggere = inviiRepository.getInviiDaCorreggere();
      for (Invio invio : inviiDaCorreggere)
      {
         correggiSingolo(invio);
      }
   }

   @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
   public void correggiSingolo(Invio invio)
   {
      QueueUtils.sendCorreggiErroriAsr(context, correggiErroriAsrQueue, invio.getFileRitorno().getId(),
               invio.getId());
   }
}
