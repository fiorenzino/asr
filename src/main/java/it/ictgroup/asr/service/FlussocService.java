package it.ictgroup.asr.service;

import it.ictgroup.asr.model.Flussoc1;
import it.ictgroup.asr.model.Flussoc2;
import it.ictgroup.asr.model.enums.TipologiaFlusso;
import it.ictgroup.asr.repository.Flussoc1Repository;
import it.ictgroup.asr.repository.Flussoc2Repository;

import java.io.Serializable;
import java.util.ArrayList;
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

   Logger logger = Logger.getLogger(this.getClass());

   public void parse(TipologiaFlusso tipologiaFlusso, String nomeFile) throws Exception
   {
      switch (tipologiaFlusso)
      {
      case C1:
         elaboraC1(nomeFile);
         break;
      case C2:
         elaboraC2(nomeFile);
         break;

      default:
         break;
      }
   }

   private void elaboraC1(String nomeFile) throws
            Exception
   {
      FileHelperEngine<Flussoc1> fileHelperEngine = new FileHelperEngine<>(Flussoc1.class);
      List<Flussoc1> righe = new ArrayList<>();
      righe = fileHelperEngine.readFile(nomeFile);
      if (righe != null)
      {

         for (Flussoc1 flussoa1 : righe)
         {
            logger.info(flussoa1);
            flussoc1Repository.persist(flussoa1);
         }
         System.out.println(righe.size());
      }

   }

   private void elaboraC2(String nomeFile) throws
            Exception
   {
      FileHelperEngine<Flussoc2> fileHelperEngine = new FileHelperEngine<>(Flussoc2.class);
      List<Flussoc2> righe = new ArrayList<>();
      righe = fileHelperEngine.readFile(nomeFile);
      if (righe != null)
      {
         for (Flussoc2 flussoc2 : righe)
         {
            logger.info(flussoc2);
            flussoc2Repository.persist(flussoc2);
         }
         System.out.println(righe.size());
      }
   }

}
