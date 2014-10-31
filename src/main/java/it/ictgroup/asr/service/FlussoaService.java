package it.ictgroup.asr.service;

import it.coopservice.commons2.domain.Search;
import it.ictgroup.asr.model.Flussoa1;
import it.ictgroup.asr.model.Flussoa2;
import it.ictgroup.asr.model.Flussoc1;
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
            // File A1: archivio contenente le informazioni anagrafiche dell’utente.
            // File A2: archivio contenente le informazioni sanitarie dell’utente. La segnalazione degli errori deve
            // essere effettuata in tale archivio anche in caso di errori riscontrati nell’archivio dei dati anagrafici.
            // Il collegamento delle informazioni contenute nei suddetti archivi è garantito dalla presenza di una
            // chiave univoca costituita da:
            // codice regione addebitante + codice ASL/Azienda + codice istituto + numero scheda.
            // TODO sufficiente per determinare se la riga è già in db???
            Search<Flussoa1> search = new Search<Flussoa1>(Flussoa1.class);
            search.getObj().setRegioneAddebitante(flussoa1.getRegioneAddebitante());
            search.getObj().setAziendaUsl(flussoa1.getAziendaUsl());
            search.getObj().setCodiceIstitutoDiRicovero(flussoa1.getCodiceIstitutoDiRicovero());
            search.getObj().setNumeroDellaScheda(flussoa1.getNumeroDellaScheda());
            List<Flussoa1> resList = flussoa1Repository.getList(search, 0, 0);
            if(resList != null && resList.size() > 0)
               flussoa1Repository.update(flussoa1);
            else
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
            // File A1: archivio contenente le informazioni anagrafiche dell’utente.
            // File A2: archivio contenente le informazioni sanitarie dell’utente. La segnalazione degli errori deve
            // essere effettuata in tale archivio anche in caso di errori riscontrati nell’archivio dei dati anagrafici.
            // Il collegamento delle informazioni contenute nei suddetti archivi è garantito dalla presenza di una
            // chiave univoca costituita da:
            // codice regione addebitante + codice ASL/Azienda + codice istituto + numero scheda.
            // TODO sufficiente per determinare se la riga è già in db???
            Search<Flussoa2> search = new Search<Flussoa2>(Flussoa2.class);
            search.getObj().setRegioneAddebitante(flussoa2.getRegioneAddebitante());
//            search.getObj().setAziendaUsl(flussoa2.getAziendaUsl());  // TODO dov'è????
            search.getObj().setCodiceIstituto(flussoa2.getCodiceIstituto());
            search.getObj().setNumeroDellaScheda(flussoa2.getNumeroDellaScheda());
            List<Flussoa2> resList = flussoa2Repository.getList(search, 0, 0);
            if(resList != null && resList.size() > 0)
               flussoa2Repository.update(flussoa2);
            else
               flussoa2Repository.persist(flussoa2);
         }
         logger.info(righe.size());
      }
   }

}
