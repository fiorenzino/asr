package it.ictgroup.asr.jms;

import it.ictgroup.asr.management.AppConstants;
import it.ictgroup.asr.management.AppKeys;
import it.ictgroup.asr.model.enums.TipologiaFlusso;
import it.ictgroup.asr.service.InviiService;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.jboss.logging.Logger;

@MessageDriven(name = "_02VerificaInvioMDB", activationConfig = {
         @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
         @ActivationConfigProperty(propertyName = "destination", propertyValue = AppConstants.VERIFICA_INVIO_ASR_QUEUE),
         @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
         @ActivationConfigProperty(propertyName = "maxSession", propertyValue = "20"),
         @ActivationConfigProperty(propertyName = "dLQMaxResent", propertyValue = "0") })
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class _02VerificaInvioMDB implements MessageListener
{

   Logger logger = Logger.getLogger(getClass());

   @Inject
   InviiService inviiService;

   public void onMessage(Message message)
   {
      MapMessage msg = (MapMessage) message;
      Long idElaborazione1 = null;
      Long idElaborazione2 = null;
      Long idInvio = null;
      TipologiaFlusso tipologiaFlusso1 = null;
      TipologiaFlusso tipologiaFlusso2 = null;
      try
      {
         idElaborazione1 = msg.getLong(AppKeys.ELABORAZIONE_ID_1.name());
         idElaborazione2 = msg.getLong(AppKeys.ELABORAZIONE_ID_2.name());
         idInvio = msg.getLong(AppKeys.INVIO_ID.name());
         tipologiaFlusso1 = TipologiaFlusso.valueOf(msg.getString(AppKeys.TIPOLOGIA_FLUSSO_1.name()));
         tipologiaFlusso2 = TipologiaFlusso.valueOf(msg.getString(AppKeys.TIPOLOGIA_FLUSSO_2.name()));

         logger.info("_02VerificaInvioMDB: onMessage(), idElaborazione1:" + idElaborazione1 + " idElaborazione2 = "
                  + idElaborazione2
                  + " idInvio =" + idInvio + " tipologiaFlusso1= " + tipologiaFlusso1 + " tipologiaFlusso2= "
                  + tipologiaFlusso2);
         inviiService.verificaCongruenza(idElaborazione1, idElaborazione2, idInvio, tipologiaFlusso1, tipologiaFlusso2);

      }
      catch (Throwable e)
      {
         logger.error(e.getMessage(), e);
      }
   }
}
