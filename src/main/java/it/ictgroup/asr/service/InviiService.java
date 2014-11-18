package it.ictgroup.asr.service;

import it.ictgroup.asr.model.Applicazione;
import it.ictgroup.asr.model.Elaborazione;
import it.ictgroup.asr.model.Invio;
import it.ictgroup.asr.model.enums.StatoInvio;
import it.ictgroup.asr.model.enums.TipologiaInvio;
import it.ictgroup.asr.repository.ApplicazioniRepository;
import it.ictgroup.asr.repository.ElaborazioniRepository;
import it.ictgroup.asr.repository.InviiRepository;
import it.ictgroup.asr.util.SiglaUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class InviiService
{

   @Inject
   ElaborazioniRepository elaborazioniRepository;

   @Inject
   InviiRepository inviiRepository;

   @Inject
   ApplicazioniRepository applicazioniRepository;

   public void verifica() throws Exception
   {
      // carico tutti gli invii non

      Map<TipologiaInvio, List<Elaborazione>> mappa = elaborazioniRepository.getElaborazioniNonCongiunte();
      for (TipologiaInvio tipologiaInvio : mappa.keySet())
      {
         List<Elaborazione> elaborazioni = mappa.get(tipologiaInvio);
         for (Elaborazione elaborazione : elaborazioni)
         {
            String sigla = SiglaUtils.getSiglaByFileName(elaborazione.getFileName());
            Invio invio = inviiRepository.getInvioBySiglaAndTipo(sigla, tipologiaInvio);
            if (invio == null)
            {
               invio = new Invio();
               invio.setSigla(sigla);
               invio.setTipologiaInvio(tipologiaInvio);
               Applicazione applicazione = applicazioniRepository.findBySigla(SiglaUtils.getApplicazione(elaborazione
                        .getFileName()));
               invio.setApplicazione(applicazione);
               Date periodoA = SiglaUtils.getPeriodoA(elaborazione
                        .getFileName());
               invio.setPeriodoA(periodoA);
               Date periodoDa = SiglaUtils.getPeriodoA(elaborazione
                        .getFileName());
               invio.setPeriodoDa(periodoDa);
               invio.setStatoInvio(StatoInvio.INCOMPLETO);
            }
            switch (elaborazione.getConfigurazione().getTipologiaFlusso())
            {
            case A1:
            case C1:
               invio.setFile1(elaborazione);
               if (invio.getFile2() != null)
               {
                  invio.setStatoInvio(StatoInvio.IN_ATTESA_DI_ESITO);
               }
               break;
            case A2:
            case C2:
               invio.setFile2(elaborazione);
               if (invio.getFile1() != null)
               {
                  invio.setStatoInvio(StatoInvio.IN_ATTESA_DI_ESITO);
               }
               break;
            case A2R:
            case C2R:
               invio.setFileRitorno(elaborazione);
               invio.setStatoInvio(StatoInvio.ESIATATO_CON_ERRORI);
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
               inviiRepository.persist(invio);
            }
            elaborazione.setCongiunta(true);
            elaborazioniRepository.update(elaborazione);
         }
      }

   }
}
