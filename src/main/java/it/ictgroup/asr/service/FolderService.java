package it.ictgroup.asr.service;

import it.ictgroup.asr.model.Configurazione;
import it.ictgroup.asr.repository.ConfigurazioniRepository;

import java.util.List;

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
   @JMSConnectionFactory("jms/connectionFactory")
   private JMSContext context;

   @Resource(lookup = "jms/dataQueue")
   private Queue dataQueue;

   public void send(String body)
   {
      context.createProducer().send(dataQueue, body);
   }

   public void verifica(int i, int f)
   {
      List<Configurazione> configurazioni = configurazioniRepository.getAllList();

      for (Configurazione configurazione : configurazioni)
      {
         // leggo la cartella dei files

         // se trovo un file che non ho elaborato, lo mando in coda

      }
   }
}
