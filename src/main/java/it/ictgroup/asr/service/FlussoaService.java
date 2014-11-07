package it.ictgroup.asr.service;

import it.ictgroup.asr.model.Flussoa1;
import it.ictgroup.asr.model.Flussoa2;
import it.ictgroup.asr.model.enums.TipologiaFlusso;
import it.ictgroup.asr.repository.ElaborazioniRepository;
import it.ictgroup.asr.repository.Flussoa1Repository;
import it.ictgroup.asr.repository.Flussoa2Repository;
import it.ictgroup.asr.service.controller.FlussoA2Controller;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.coury.jfilehelpers.engines.FileHelperEngine;
import org.jboss.ejb3.annotation.TransactionTimeout;
import org.jboss.logging.Logger;

@Stateless
public class FlussoaService implements Serializable
{
   private static final long serialVersionUID = 1L;

   @Inject
   Flussoa1Repository flussoa1Repository;

   @Inject
   Flussoa2Repository flussoa2Repository;

   @Inject
   ElaborazioniRepository elaborazioniRepository;

   Logger logger = Logger.getLogger(this.getClass());

   @TransactionTimeout(value = 18000, unit = TimeUnit.SECONDS)
   public void parse(TipologiaFlusso tipologiaFlusso, String nomeFile, String folder,
            Long idElaborazione) throws Exception
   {
      switch (tipologiaFlusso)
      {
      case A1:
         elaboraA1(nomeFile, folder,
                  idElaborazione);
         break;
      case A2:
         elaboraA2(nomeFile, folder,
                  idElaborazione);
         break;

      default:
         break;
      }
   }

   private void elaboraA1(String nomeFile, String folder,
            Long idElaborazione) throws
            Exception
   {
      FileHelperEngine<Flussoa1> fileHelperEngine = new FileHelperEngine<>(Flussoa1.class);
      List<Flussoa1> righe = righe = fileHelperEngine.readFile(folder + nomeFile);
      if (righe != null && righe.size() > 0)
      {
         logger.info(righe.size());
         int i = 0;
         for (Flussoa1 flussoa1 : righe)
         {
            i++;
            logger.info(i + "/" + righe.size());
            flussoa1.getElaborazione().setId(idElaborazione);
            flussoa1Repository.persist(flussoa1);
         }
         elaborazioniRepository.eseguito(idElaborazione);
         logger.info("ESEGUITO");
      }

   }

   private void elaboraA2(String nomeFile, String folder,
            Long idElaborazione) throws
            Exception
   {
      FlussoA2Controller flussoA2Controller = new FlussoA2Controller(folder + nomeFile);
      List<Flussoa2> righe = flussoA2Controller.execute();

      if (righe != null && righe.size() > 0)
      {
         logger.info(righe.size());
         int i = 0;
         for (Flussoa2 flussoa2 : righe)
         {
            i++;
            logger.info(i + "/" + righe.size());
            if (flussoA2Controller.isWithErrori())
            {
               Flussoa2 riferimento = flussoa2Repository.getRiferimento(flussoa2);
               if (riferimento != null)
               {
                  valorizzaErrori(riferimento, flussoa2);
                  flussoa2Repository.update(riferimento);
               }
               else
               {
                  logger.info("non trovo per il flusso A2: " + flussoa2);
               }
            }
            else
            {
               flussoa2.getElaborazione().setId(idElaborazione);
               flussoa2Repository.persist(flussoa2);
            }

         }
         elaborazioniRepository.eseguito(idElaborazione);
         logger.info("ESEGUITO");

      }
   }

   private void valorizzaErrori(Flussoa2 riferimento, Flussoa2 conErrori)
   {
      riferimento.setErr01(conErrori.getErr01());
      riferimento.setErr02(conErrori.getErr02());
      riferimento.setErr03(conErrori.getErr03());
      riferimento.setErr04(conErrori.getErr04());
      riferimento.setErr05(conErrori.getErr05());
      riferimento.setErr06(conErrori.getErr06());
      riferimento.setErr07(conErrori.getErr07());
      riferimento.setErr08(conErrori.getErr08());
      riferimento.setErr09(conErrori.getErr09());
      riferimento.setErr10(conErrori.getErr10());
   }

}
