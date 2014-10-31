package it.ictgroup.asr.service;

import it.coopservice.commons2.domain.Search;
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

         for (Flussoc1 flussoc1 : righe)
         {
            logger.info(flussoc1);
            // File C1: archivio contenente le informazioni anagrafiche dell’utente.
            // File C2: archivio contenente le informazioni sanitarie dell’utente. La segnalazione degli errori deve
            // essere effettuata in tale archivio anche in caso di errori riscontrati nell’archivio dei dati anagrafici.
            // Il collegamento delle informazioni contenute nei suddetti archivi è garantito dalla presenza di una
            // chiave univoca costituita da:
            // codice regione addebitante + codice ASL/Azienda + ID + progressivo riga.
            // TODO sufficiente per determinare se la riga è già in db???
            Search<Flussoc1> search = new Search<Flussoc1>(Flussoc1.class);
            search.getObj().setRegioneAddebitante(flussoc1.getRegioneAddebitante());
            search.getObj().setZonaTerritoriale(flussoc1.getZonaTerritoriale());
            search.getObj().setId(flussoc1.getId());
            search.getObj().setProgressivoPeRigaPerRicetta(flussoc1.getProgressivoPeRigaPerRicetta());
            List<Flussoc1> resList = flussoc1Repository.getList(search, 0, 0);
            if(resList != null && resList.size() > 0)
               flussoc1Repository.update(flussoc1);
            else
               flussoc1Repository.persist(flussoc1);
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
            // File C1: archivio contenente le informazioni anagrafiche dell’utente.
            // File C2: archivio contenente le informazioni sanitarie dell’utente. La segnalazione degli errori deve
            // essere effettuata in tale archivio anche in caso di errori riscontrati nell’archivio dei dati anagrafici.
            // Il collegamento delle informazioni contenute nei suddetti archivi è garantito dalla presenza di una
            // chiave univoca costituita da:
            // codice regione addebitante + codice ASL/Azienda + ID + progressivo riga.
            // TODO sufficiente per determinare se la riga è già in db???
            Search<Flussoc2> search = new Search<Flussoc2>(Flussoc2.class);
            search.getObj().setRegioneAddebitante(flussoc2.getRegioneAddebitante());
            search.getObj().setZonaTerritoriale(flussoc2.getZonaTerritoriale());
            search.getObj().setId(flussoc2.getId());
            search.getObj().setProgressivoRigaPerRicetta(flussoc2.getProgressivoRigaPerRicetta());
            List<Flussoc2> resList = flussoc2Repository.getList(search, 0, 0);
            if(resList != null && resList.size() > 0)
               flussoc2Repository.update(flussoc2);
            else
               flussoc2Repository.persist(flussoc2);
         }
         System.out.println(righe.size());
      }
   }

}
