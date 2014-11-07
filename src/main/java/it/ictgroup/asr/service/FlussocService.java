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

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.coury.jfilehelpers.engines.FileHelperEngine;
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
      riferimento.setErroreRegioneZonaAddebito(conErrori.getErroreRegioneZonaAddebito());
      riferimento.setErroriAnagrafici(conErrori.getErroriAnagrafici());
      riferimento.setErroriDataPrestazione(conErrori.getErroriDataPrestazione());
      riferimento.setErroriEsenzioni(conErrori.getErroriEsenzioni());
      riferimento.setErroriIdentificativoStruttura(conErrori.getErroriIdentificativoStruttura());
      riferimento.setErroriImporto(conErrori.getErroriImporto());
      riferimento.setErroriNumeroPrestazioni(conErrori.getErroriNumeroPrestazioni());
      riferimento.setErroriPrestazione(conErrori.getErroriPrestazione());
      riferimento.setErroriRecord(conErrori.getErroriRecord());
      riferimento.setErroriResidenza(conErrori.getErroriResidenza());
   }
}
