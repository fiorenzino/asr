package it.ictgroup.asr.util;

import it.ictgroup.asr.management.AppKeys;
import it.ictgroup.asr.model.Invio;

import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSContext;
import javax.jms.Queue;

public class QueueUtils
{
   public static void sendVerificaInvioAsr(JMSContext context, Queue verificaInvioAsrQueue, Invio invio)
   {
      Map<String, Object> map = new HashMap<>();
      map.put(AppKeys.ELABORAZIONE_ID_1.name(), invio.getFile1().getId());
      map.put(AppKeys.ELABORAZIONE_ID_2.name(), invio.getFile2().getId());
      map.put(AppKeys.INVIO_ID.name(), invio.getId());
      map.put(AppKeys.TIPOLOGIA_FLUSSO_1.name(), invio.getFile1().getConfigurazione().getTipologiaFlusso().name());
      map.put(AppKeys.TIPOLOGIA_FLUSSO_2.name(), invio.getFile2().getConfigurazione().getTipologiaFlusso().name());
      context.createProducer().send(verificaInvioAsrQueue, map);
   }

   public static void sendCorreggiErroriAsr(JMSContext context, Queue correggiErroriAsrQueue, Long id, Long invioId)
   {
      Map<String, Object> map = new HashMap<>();
      map.put(AppKeys.ELABORAZIONE_ID.name(), id);
      map.put(AppKeys.INVIO_ID.name(), invioId);
      context.createProducer().send(correggiErroriAsrQueue, map);
   }
}
