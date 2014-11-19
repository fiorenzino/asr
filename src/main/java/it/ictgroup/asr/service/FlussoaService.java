package it.ictgroup.asr.service;

import it.ictgroup.asr.model.Flussoa1;
import it.ictgroup.asr.model.Flussoa2;
import it.ictgroup.asr.model.Flussoa2r;
import it.ictgroup.asr.model.enums.TipologiaFlusso;
import it.ictgroup.asr.repository.ElaborazioniRepository;
import it.ictgroup.asr.repository.Flussoa1Repository;
import it.ictgroup.asr.repository.Flussoa2Repository;
import it.ictgroup.asr.repository.Flussoa2rRepository;
import it.ictgroup.asr.util.FlowerFileHelper;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.ejb.Stateless;
import javax.inject.Inject;

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
   Flussoa2rRepository flussoa2rRepository;

   @Inject
   ElaborazioniRepository elaborazioniRepository;

   Logger logger = Logger.getLogger(this.getClass());

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
      case A2R:
         elaboraA2r(nomeFile, folder,
                  idElaborazione);
         break;
      default:
         throw new Exception("Errore: flusso A non elaborabile");
      }
   }

   private void elaboraA1(String nomeFile, String folder,
            Long idElaborazione) throws
            Exception
   {
      FlowerFileHelper<Flussoa1> filedReader = new FlowerFileHelper<Flussoa1>(Flussoa1.class);
      int i = 0;
      try (Scanner scanner = new Scanner(Paths.get(folder + nomeFile), StandardCharsets.UTF_8.name()))
      {
         Flussoa1 flussoa1 = null;
         while (scanner.hasNextLine())
         {
            i++;
            flussoa1 = filedReader.valorize(scanner.nextLine());
            logger.info(TipologiaFlusso.A1.name() + ")" + i);
            flussoa1.getElaborazione().setId(idElaborazione);
            flussoa1Repository.persistAsync(flussoa1);
         }
      }
      elaborazioniRepository.eseguito(idElaborazione, i);
      logger.info("A1 ESEGUITO: " + idElaborazione + " file: " + folder + nomeFile);
   }

   private void elaboraA2(String nomeFile, String folder,
            Long idElaborazione) throws
            Exception
   {
      FlowerFileHelper<Flussoa2> filedReader = new FlowerFileHelper<Flussoa2>(Flussoa2.class);
      int i = 0;
      try (Scanner scanner = new Scanner(Paths.get(folder + nomeFile), StandardCharsets.UTF_8.name()))
      {
         Flussoa2 flussoa2 = null;
         while (scanner.hasNextLine())
         {
            i++;
            flussoa2 = filedReader.valorize(scanner.nextLine());
            logger.info(TipologiaFlusso.A2.name() + ")" + i);
            flussoa2.getElaborazione().setId(idElaborazione);
            flussoa2Repository.persistAsync(flussoa2);
         }
      }
      elaborazioniRepository.eseguito(idElaborazione, i);
      logger.info("A2 ESEGUITO: " + idElaborazione + " file: " + folder + nomeFile);
   }

   private void elaboraA2r(String nomeFile, String folder,
            Long idElaborazione) throws
            Exception
   {
      FlowerFileHelper<Flussoa2r> filedReader = new FlowerFileHelper<Flussoa2r>(Flussoa2r.class);
      int i = 0;
      try (Scanner scanner = new Scanner(Paths.get(folder + nomeFile), StandardCharsets.UTF_8.name()))
      {
         Flussoa2r flussoa2r = null;
         while (scanner.hasNextLine())
         {
            i++;
            flussoa2r = filedReader.valorize(scanner.nextLine());
            logger.info(TipologiaFlusso.A2R.name() + ")" + i);
            flussoa2r.getElaborazione().setId(idElaborazione);
            flussoa2rRepository.persistAsync(flussoa2r);
         }
      }
      elaborazioniRepository.eseguito(idElaborazione, i);
      logger.info("A2R ESEGUITO: " + idElaborazione + " file: " + folder + nomeFile);

   }

   // private void elaboraA1(String nomeFile, String folder,
   // Long idElaborazione) throws
   // Exception
   // {
   // FileHelperEngine<Flussoa1> fileHelperEngine = new FileHelperEngine<>(Flussoa1.class);
   // List<Flussoa1> righe = righe = fileHelperEngine.readFile(folder + nomeFile);
   // if (righe != null && righe.size() > 0)
   // {
   // logger.info(righe.size());
   // int i = 0;
   // for (Flussoa1 flussoa1 : righe)
   // {
   // i++;
   // logger.info(TipologiaFlusso.A1.name() + ")" + i + "/" + righe.size());
   // flussoa1.getElaborazione().setId(idElaborazione);
   // flussoa1Repository.persist(flussoa1);
   // }
   // elaborazioniRepository.eseguito(idElaborazione, i);
   // logger.info("A1 ESEGUITO: " + idElaborazione + " file: " + folder + nomeFile);
   // }
   //
   // }

   // private void elaboraA2(String nomeFile, String folder,
   // Long idElaborazione) throws
   // Exception
   // {
   // FileHelperEngine<Flussoa2> fileHelperEngine = new FileHelperEngine<>(Flussoa2.class);
   // List<Flussoa2> righe = righe = fileHelperEngine.readFile(folder + nomeFile);
   // if (righe != null && righe.size() > 0)
   // {
   // logger.info(righe.size());
   // int i = 0;
   // for (Flussoa2 flussoa2 : righe)
   // {
   // i++;
   // logger.info(TipologiaFlusso.A2.name() + ")" + i + "/" + righe.size());
   // flussoa2.getElaborazione().setId(idElaborazione);
   // flussoa2Repository.persist(flussoa2);
   // }
   // elaborazioniRepository.eseguito(idElaborazione, i);
   // logger.info("ESEGUITO A2: " + idElaborazione + " file: " + folder + nomeFile);
   // }
   //
   // }

   // private void elaboraA2r(String nomeFile, String folder,
   // Long idElaborazione) throws
   // Exception
   // {
   // FileHelperEngine<Flussoa2r> fileHelperEngine = new FileHelperEngine<>(Flussoa2r.class);
   // List<Flussoa2r> righe = righe = fileHelperEngine.readFile(folder + nomeFile);
   // if (righe != null && righe.size() > 0)
   // {
   // logger.info(righe.size());
   // int i = 0;
   // for (Flussoa2r flussoa2r : righe)
   // {
   // i++;
   // logger.info(TipologiaFlusso.A2R.name() + ")" + i + "/" + righe.size());
   // flussoa2r.getElaborazione().setId(idElaborazione);
   // flussoa2rRepository.persist(flussoa2r);
   // }
   // elaborazioniRepository.eseguito(idElaborazione, i);
   // logger.info("A2R ESEGUITO: " + idElaborazione + " file: " + folder + nomeFile);
   // }
   //
   // }

   // private void elaboraA2(String nomeFile, String folder,
   // Long idElaborazione) throws
   // Exception
   // {
   // FlussoA2Controller flussoA2Controller = new FlussoA2Controller(folder + nomeFile);
   // List<Flussoa2> righe = flussoA2Controller.execute();
   //
   // if (righe != null && righe.size() > 0)
   // {
   // logger.info(righe.size());
   // int i = 0;
   // for (Flussoa2 flussoa2 : righe)
   // {
   // i++;
   // logger.info(i + "/" + righe.size());
   // if (flussoA2Controller.isWithErrori())
   // {
   // Flussoa2 riferimento = flussoa2Repository.getRiferimento(flussoa2);
   // if (riferimento != null)
   // {
   // valorizzaErrori(riferimento, flussoa2);
   // flussoa2Repository.update(riferimento);
   // }
   // else
   // {
   // logger.info("non trovo per il flusso A2: " + flussoa2);
   // }
   // }
   // else
   // {
   // flussoa2.getElaborazione().setId(idElaborazione);
   // flussoa2Repository.persist(flussoa2);
   // }
   //
   // }
   // elaborazioniRepository.eseguito(idElaborazione, flussoA2Controller.isWithErrori());
   // logger.info("ESEGUITO");
   //
   // }
   // }

   // private void valorizzaErrori(Flussoa2 riferimento, Flussoa2 conErrori)
   // {
   // riferimento.setErr01(conErrori.getErr01());
   // riferimento.setErr02(conErrori.getErr02());
   // riferimento.setErr03(conErrori.getErr03());
   // riferimento.setErr04(conErrori.getErr04());
   // riferimento.setErr05(conErrori.getErr05());
   // riferimento.setErr06(conErrori.getErr06());
   // riferimento.setErr07(conErrori.getErr07());
   // riferimento.setErr08(conErrori.getErr08());
   // riferimento.setErr09(conErrori.getErr09());
   // riferimento.setErr10(conErrori.getErr10());
   // }

}
