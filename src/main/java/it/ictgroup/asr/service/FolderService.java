package it.ictgroup.asr.service;

import it.ictgroup.asr.management.AppConstants;
import it.ictgroup.asr.management.AppKeys;
import it.ictgroup.asr.model.Configurazione;
import it.ictgroup.asr.model.Elaborazione;
import it.ictgroup.asr.repository.ConfigurazioniRepository;
import it.ictgroup.asr.repository.ElaborazioniRepository;
import it.ictgroup.asr.util.FileUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

@Stateless
public class FolderService
{

   @Inject
   ConfigurazioniRepository configurazioniRepository;

   @Inject
   ElaborazioniRepository elaborazioniRepository;

   @Inject
   @JMSConnectionFactory("jms/connectionFactory")
   private JMSContext context;

   @Resource(lookup = AppConstants.FLUSSI_ASR_QUEUE)
   private Queue flussiQueue;

   public void send(Map<String, Object> map)
   {
      context.createProducer().send(flussiQueue, map);
   }

   public void verifica() throws Exception
   {
      List<Configurazione> configurazioni = configurazioniRepository.getAllList();

      for (Configurazione configurazione : configurazioni)
      {
         // precarico la lista dei files elaborati
         List<String> filesElaborati = elaborazioniRepository.getFilePerConfigurazione(configurazione.getId());
         // leggo la cartella dei files
         List<String> filesInCartellaFiltrati = FileUtils.listFilesWithFilter(configurazione.getFolder(),
                  filesElaborati);
         // se trovo un file che non ho elaborato, lo mando in coda
         for (String fileName : filesInCartellaFiltrati)
         {
            Elaborazione elaborazione = new Elaborazione(configurazione, new Date(), fileName);
            elaborazioniRepository.persist(elaborazione);
            Map<String, Object> map = new HashMap<>();
            // TIPOLOGIA_FLUSSO, NOME_FILE, ELABORAZIONE_ID, NOME_FOLDER
            map.put(AppKeys.NOME_FILE.name(), fileName);
            map.put(AppKeys.TIPOLOGIA_FLUSSO.name(), configurazione.getTipologiaFlusso().name());
            map.put(AppKeys.ELABORAZIONE_ID.name(), elaborazione.getId());
            map.put(AppKeys.NOME_FOLDER.name(), configurazione.getFolder());
            send(map);
         }
      }
   }
}
