package it.ictgroup.asr.jms;

import it.ictgroup.asr.management.AppConstants;
import it.ictgroup.asr.management.AppKeys;
import it.ictgroup.asr.model.enums.TipologiaFlusso;
import it.ictgroup.asr.repository.ElaborazioniRepository;
import it.ictgroup.asr.service.FlussoService;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.jboss.logging.Logger;

@MessageDriven(name = "_01ElaboraFlussoMDB", activationConfig = {
         @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
         @ActivationConfigProperty(propertyName = "destination", propertyValue = AppConstants.FLUSSI_ASR_QUEUE),
         @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
         @ActivationConfigProperty(propertyName = "maxSession", propertyValue = "1"),
         @ActivationConfigProperty(propertyName = "transactionTimeout", propertyValue = "3600"),
         @ActivationConfigProperty(propertyName = "dLQMaxResent", propertyValue = "0") })
// @TransactionTimeout(value = 6 * 60 * 60, unit = TimeUnit.SECONDS)
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class _01ElaboraFlussoMDB implements MessageListener
{

   Logger logger = Logger.getLogger(getClass());

   @Inject
   FlussoService flussoService;

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
         elaborazioniRepository.avviato_newtx(idElaborazione);
         flussoService.parse(tipologiaFlusso, nomeFile, folder, idElaborazione);
      }
      catch (Throwable e)
      {
         try
         {
            logger.error(e.getMessage(), e);
            elaborazioniRepository.errore(idElaborazione, e.getMessage(), 0);
         }
         catch (Throwable e2)
         {
            logger.error(e2.getMessage(), e2);
         }

      }
   }
}
