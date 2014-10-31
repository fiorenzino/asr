package it.ictgroup.asr.service;

import it.ictgroup.asr.model.Flussoa1;
import it.ictgroup.asr.model.Flussoa2;
import it.ictgroup.asr.model.enums.TipologiaFlusso;
import it.ictgroup.asr.repository.Flussoa1Repository;
import it.ictgroup.asr.repository.Flussoa2Repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.coury.jfilehelpers.engines.FileHelperEngine;
import org.jboss.logging.Logger;

@Stateless
public class FlussoaService implements Serializable
{
   private static final long serialVersionUID = 1L;

   @Inject
   Flussoa1Repository flussoa1Repository;

   @Inject
   Flussoa2Repository flussoa2Repository;

   Logger logger = Logger.getLogger(this.getClass());

   public void parse(TipologiaFlusso tipologiaFlusso, String nomeFile) throws Exception
   {
      switch (tipologiaFlusso)
      {
      case A1:
         elaboraA1(nomeFile);
         break;
      case A2:
         elaboraA2(nomeFile);
         break;

      default:
         break;
      }
   }

   private void elaboraA1(String nomeFile) throws
            Exception
   {
      FileHelperEngine<Flussoa1> fileHelperEngine = new FileHelperEngine<>(Flussoa1.class);
      List<Flussoa1> righe = new ArrayList<>();
      righe = fileHelperEngine.readFile(nomeFile);
      if (righe != null)
      {

         for (Flussoa1 flussoa1 : righe)
         {
            logger.info(flussoa1);
            flussoa1Repository.persist(flussoa1);
         }
         logger.info(righe.size());
      }

   }

   private void elaboraA2(String nomeFile) throws
            Exception
   {
      FileHelperEngine<Flussoa2> fileHelperEngine = new FileHelperEngine<>(Flussoa2.class);
      List<Flussoa2> righe = new ArrayList<>();
      righe = fileHelperEngine.readFile(nomeFile);
      if (righe != null)
      {
         for (Flussoa2 flussoa2 : righe)
         {
            logger.info(flussoa2);
            flussoa2Repository.persist(flussoa2);
         }
         logger.info(righe.size());
      }
   }

}
