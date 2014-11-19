package it.ictgroup.asr.jms;

import it.ictgroup.asr.management.AppConstants;
import it.ictgroup.asr.management.AppKeys;
import it.ictgroup.asr.model.enums.TipologiaFlusso;
import it.ictgroup.asr.repository.ElaborazioniRepository;
import it.ictgroup.asr.service.FlussoaService;
import it.ictgroup.asr.service.FlussocService;

import java.util.concurrent.TimeUnit;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.jboss.ejb3.annotation.TransactionTimeout;
import org.jboss.logging.Logger;

@MessageDriven(name = "_01ElaboraFlussoMDB", activationConfig = {
         @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
         @ActivationConfigProperty(propertyName = "destination", propertyValue = AppConstants.FLUSSI_ASR_QUEUE),
         @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
         @ActivationConfigProperty(propertyName = "maxSession", propertyValue = "1"),
         @ActivationConfigProperty(propertyName = "transactionTimeout", propertyValue = "3600"),
         @ActivationConfigProperty(propertyName = "dLQMaxResent", propertyValue = "0") })
@TransactionTimeout(value = 60 * 60, unit = TimeUnit.SECONDS)
public class _01ElaboraFlussoMDB implements MessageListener
{

   Logger logger = Logger.getLogger(getClass());

   @Inject
   FlussoaService flussoaService;

   @Inject
   FlussocService flussocService;

   @Inject
   ElaborazioniRepository elaborazioniRepository;

   public void onMessage(Message message)
   {
      MapMessage msg = (MapMessage) message;
      TipologiaFlusso tipologiaFlusso = null;
      String nomeFile = null;
      String folder = null;
      Long idElaborazione = null;
      try
      {
         tipologiaFlusso = TipologiaFlusso.valueOf(msg.getString(AppKeys.TIPOLOGIA_FLUSSO.name()));
         nomeFile = msg.getString(AppKeys.NOME_FILE.name());
         folder = msg.getString(AppKeys.NOME_FOLDER.name());
         idElaborazione = msg.getLong(AppKeys.ELABORAZIONE_ID.name());

         logger.info("onMessage(), tipologiaFlusso:" + tipologiaFlusso + " nomeFile = " + nomeFile);
         switch (tipologiaFlusso)
         {
         case A1:
         case A2:
         case A2R:
            elaborazioniRepository.avviato(idElaborazione);
            flussoaService.parse(tipologiaFlusso, nomeFile, folder, idElaborazione);
            break;

         case C1:
         case C2:
         case C2R:
            elaborazioniRepository.avviato(idElaborazione);
            flussocService.parse(tipologiaFlusso, nomeFile, folder, idElaborazione);
            break;
         case B:
         case D:
         case E:
         case F:
         case G:

            break;
         default:
            break;
         }
      }
      catch (Throwable e)
      {
         logger.error(e.getMessage(), e);
         elaborazioniRepository.errore(idElaborazione);
      }
   }
}
