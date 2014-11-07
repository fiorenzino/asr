package it.ictgroup.asr.service;

import it.ictgroup.asr.model.Flussoc1;
import it.ictgroup.asr.model.Flussoc2;
import it.ictgroup.asr.model.enums.TipologiaFlusso;
import it.ictgroup.asr.repository.ElaborazioniRepository;
import it.ictgroup.asr.repository.Flussoc1Repository;
import it.ictgroup.asr.repository.Flussoc2Repository;
import it.ictgroup.asr.service.controller.FlussoC2Controller;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.coury.jfilehelpers.engines.FileHelperEngine;
import org.jboss.ejb3.annotation.TransactionTimeout;
import org.jboss.logging.Logger;

@Stateless
public class FlussocService implements Serializable
{
   private static final long serialVersionUID = 1L;

   @Inject
   Flussoc1Repository flussoc1Repository;

   @Inject
   Flussoc2Repository flussoc2Repository;

   @Inject
   ElaborazioniRepository elaborazioniRepository;

   Logger logger = Logger.getLogger(this.getClass());

   @TransactionTimeout(value = 18000, unit = TimeUnit.SECONDS)
   public void parse(TipologiaFlusso tipologiaFlusso, String nomeFile, String folder,
            Long idElaborazione) throws Exception
   {
      switch (tipologiaFlusso)
      {
      case C1:
         elaboraC1(nomeFile, folder,
                  idElaborazione);
         break;
      case C2:
         elaboraC2(nomeFile, folder,
                  idElaborazione);
         break;

      default:
         break;
      }
   }

   private void elaboraC1(String nomeFile, String folder,
            Long idElaborazione) throws
            Exception
   {
      FileHelperEngine<Flussoc1> fileHelperEngine = new FileHelperEngine<>(Flussoc1.class);
      List<Flussoc1> righe = fileHelperEngine.readFile(folder + nomeFile);
      if (righe != null && righe.size() > 0)
      {
         logger.info(righe.size());
         int i = 0;
         for (Flussoc1 flussoc1 : righe)
         {
            i++;
            logger.info(i + "/" + righe.size());
            flussoc1.getElaborazione().setId(idElaborazione);
            flussoc1Repository.persist(flussoc1);
         }
         elaborazioniRepository.eseguito(idElaborazione);
         logger.info("ESEGUITO");
      }

   }

   private void elaboraC2(String nomeFile, String folder,
            Long idElaborazione) throws
            Exception
   {

      FlussoC2Controller flussoc2Controller = new FlussoC2Controller(folder + nomeFile);
      List<Flussoc2> righe = flussoc2Controller.execute();
      if (righe != null)
      {
         logger.info(righe.size());
         int i = 0;
         for (Flussoc2 flussoc2 : righe)
         {
            i++;
            logger.info(i + "/" + righe.size());
            if (flussoc2Controller.isWithErrori())
            {
               Flussoc2 riferimento = flussoc2Repository.getRiferimento(flussoc2);
               if (riferimento != null)
               {
                  valorizzaErrori(riferimento, flussoc2);
                  flussoc2Repository.update(riferimento);
               }
               else
               {
                  logger.info("non trovo per il flusso C2: " + flussoc2);
               }
            }
            else
            {
               flussoc2.getElaborazione().setId(idElaborazione);
               flussoc2Repository.persist(flussoc2);
            }
         }
         elaborazioniRepository.eseguito(idElaborazione);
         logger.info(righe.size());
      }
   }

   private void valorizzaErrori(Flussoc2 riferimento, Flussoc2 conErrori)
   {
      riferimento.setErr10(conErrori.getErr10());
      riferimento.setErr01(conErrori.getErr01());
      riferimento.setErr08(conErrori.getErr08());
      riferimento.setErr09(conErrori.getErr09());
      riferimento.setErr04(conErrori.getErr04());
      riferimento.setErr06(conErrori.getErr06());
      riferimento.setErr07(conErrori.getErr07());
      riferimento.setErr03(conErrori.getErr03());
      riferimento.setErr05(conErrori.getErr05());
      riferimento.setErr02(conErrori.getErr02());
   }
}
