package it.ictgroup.asr.service;

import it.ictgroup.asr.model.BaseFlusso;
import it.ictgroup.asr.model.Flussoa1;
import it.ictgroup.asr.model.Flussoa2;
import it.ictgroup.asr.model.Flussoa2r;
import it.ictgroup.asr.model.Flussoc1;
import it.ictgroup.asr.model.Flussoc2;
import it.ictgroup.asr.model.Flussoc2r;
import it.ictgroup.asr.model.enums.TipologiaFlusso;
import it.ictgroup.asr.repository.ElaborazioniRepository;
import it.ictgroup.asr.util.FlowerFileHelper;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.jboss.ejb3.annotation.TransactionTimeout;
import org.jboss.logging.Logger;

@Stateless
public class FlussoService implements Serializable
{
   Logger logger = Logger.getLogger(this.getClass());

   private static final long serialVersionUID = 1L;

   @Inject
   ElaborazioniRepository elaborazioniRepository;

   @SuppressWarnings("rawtypes")
   private <T extends BaseFlusso> FlowerFileHelper getFlowerFileHelper(TipologiaFlusso tipologiaFlusso)
            throws Exception
   {
      switch (tipologiaFlusso)
      {
      case A1:
         return new FlowerFileHelper<Flussoa1>(Flussoa1.class);
      case A2:
         return new FlowerFileHelper<Flussoa2>(Flussoa2.class);
      case A2R:
         return new FlowerFileHelper<Flussoa2r>(Flussoa2r.class);
      case C1:
         return new FlowerFileHelper<Flussoc1>(Flussoc1.class);
      case C2:
         return new FlowerFileHelper<Flussoc2>(Flussoc2.class);
      case C2R:
         return new FlowerFileHelper<Flussoc2r>(Flussoc2r.class);
      default:
         throw new Exception();
      }
   }

   @TransactionTimeout(value = 18000, unit = TimeUnit.SECONDS)
   public <T extends BaseFlusso> void parse(TipologiaFlusso tipologiaFlusso, String nomeFile,
            String folder,
            Long idElaborazione) throws Exception
   {
      @SuppressWarnings("unchecked")
      FlowerFileHelper<T> filedReader = getFlowerFileHelper(tipologiaFlusso);
      int i = 0;
      try (Scanner scanner = new Scanner(Paths.get(folder + nomeFile), StandardCharsets.UTF_8.name()))
      {
         T flussoa1 = null;
         while (scanner.hasNextLine())
         {
            i++;
            flussoa1 = filedReader.valorize(scanner.nextLine());
            if (i % 10 == 0)
               logger.info(tipologiaFlusso.name() + ")" + i);
            flussoa1.getElaborazione().setId(idElaborazione);
            elaborazioniRepository.persistAsync(flussoa1);
         }
      }
      elaborazioniRepository.eseguito(idElaborazione, i);
      logger.info(tipologiaFlusso.name() + " ESEGUITO: " + idElaborazione + " file: " + folder + nomeFile);
   }

   // private void elaboraC1(String nomeFile, String folder,
   // Long idElaborazione) throws
   // Exception
   // {
   // FileHelperEngine<Flussoc1> fileHelperEngine = new FileHelperEngine<>(Flussoc1.class);
   // List<Flussoc1> righe = fileHelperEngine.readFile(folder + nomeFile);
   // if (righe != null && righe.size() > 0)
   // {
   // logger.info(righe.size());
   // int i = 0;
   // for (Flussoc1 flussoc1 : righe)
   // {
   // i++;
   // logger.info(TipologiaFlusso.C1.name() + ")" + i + "/" + righe.size());
   // flussoc1.getElaborazione().setId(idElaborazione);
   // flussoc1Repository.persist(flussoc1);
   // }
   // elaborazioniRepository.eseguito(idElaborazione, i);
   // logger.info("C1 ESEGUITO: " + idElaborazione + " file: " + folder + nomeFile);
   // }
   //
   // }
   //
   // private void elaboraC2(String nomeFile, String folder,
   // Long idElaborazione) throws
   // Exception
   // {
   // FileHelperEngine<Flussoc2> fileHelperEngine = new FileHelperEngine<>(Flussoc2.class);
   // List<Flussoc2> righe = fileHelperEngine.readFile(folder + nomeFile);
   // if (righe != null && righe.size() > 0)
   // {
   // logger.info(righe.size());
   // int i = 0;
   // for (Flussoc2 flussoc2 : righe)
   // {
   // i++;
   // logger.info(TipologiaFlusso.C2.name() + ")" + i + "/" + righe.size());
   // flussoc2.getElaborazione().setId(idElaborazione);
   // flussoc2Repository.persist(flussoc2);
   // }
   // elaborazioniRepository.eseguito(idElaborazione, i);
   // logger.info("C2 ESEGUITO: " + idElaborazione + " file: " + folder + nomeFile);
   // }
   //
   // }
   //
   // private void elaboraC2r(String nomeFile, String folder,
   // Long idElaborazione) throws
   // Exception
   // {
   // FileHelperEngine<Flussoc2r> fileHelperEngine = new FileHelperEngine<>(Flussoc2r.class);
   // List<Flussoc2r> righe = fileHelperEngine.readFile(folder + nomeFile);
   // if (righe != null && righe.size() > 0)
   // {
   // logger.info(righe.size());
   // int i = 0;
   // for (Flussoc2r flussoc2r : righe)
   // {
   // i++;
   // logger.info(TipologiaFlusso.C1.name() + ")" + i + "/" + righe.size());
   // flussoc2r.getElaborazione().setId(idElaborazione);
   // flussoc2rRepository.persist(flussoc2r);
   // }
   // elaborazioniRepository.eseguito(idElaborazione, i);
   // logger.info("C2R ESEGUITO: " + idElaborazione + " file: " + folder + nomeFile);
   // }
   //
   // }

   // private void elaboraC2(String nomeFile, String folder,
   // Long idElaborazione) throws
   // Exception
   // {
   //
   // FlussoC2Controller flussoc2Controller = new FlussoC2Controller(folder + nomeFile);
   // List<Flussoc2> righe = flussoc2Controller.execute();
   // if (righe != null)
   // {
   // logger.info(righe.size());
   // int i = 0;
   // for (Flussoc2 flussoc2 : righe)
   // {
   // i++;
   // logger.info(i + "/" + righe.size());
   // if (flussoc2Controller.isWithErrori())
   // {
   // Flussoc2 riferimento = flussoc2Repository.getRiferimento(flussoc2);
   // if (riferimento != null)
   // {
   // valorizzaErrori(riferimento, flussoc2);
   // flussoc2Repository.update(riferimento);
   // }
   // else
   // {
   // logger.info("non trovo per il flusso C2: " + flussoc2);
   // }
   // }
   // else
   // {
   // flussoc2.getElaborazione().setId(idElaborazione);
   // flussoc2Repository.persist(flussoc2);
   // }
   // }
   // elaborazioniRepository.eseguito(idElaborazione, flussoc2Controller.isWithErrori());
   // logger.info(righe.size());
   // }
   // }

   // private void valorizzaErrori(Flussoc2 riferimento, Flussoc2 conErrori)
   // {
   // riferimento.setErr10(conErrori.getErr10());
   // riferimento.setErr01(conErrori.getErr01());
   // riferimento.setErr08(conErrori.getErr08());
   // riferimento.setErr09(conErrori.getErr09());
   // riferimento.setErr04(conErrori.getErr04());
   // riferimento.setErr06(conErrori.getErr06());
   // riferimento.setErr07(conErrori.getErr07());
   // riferimento.setErr03(conErrori.getErr03());
   // riferimento.setErr05(conErrori.getErr05());
   // riferimento.setErr02(conErrori.getErr02());
   // }
}
