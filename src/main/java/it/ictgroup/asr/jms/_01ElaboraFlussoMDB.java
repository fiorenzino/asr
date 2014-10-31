package it.ictgroup.asr.jms;

import it.ictgroup.asr.management.AppConstants;
import it.ictgroup.asr.management.AppKeys;
import it.ictgroup.asr.model.enums.TipologiaFlusso;
import it.ictgroup.asr.service.FlussoaService;
import it.ictgroup.asr.service.FlussocService;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.jboss.logging.Logger;

@MessageDriven(name = "GeneraXmlMDB", activationConfig = {
         @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
         @ActivationConfigProperty(propertyName = "destination", propertyValue = AppConstants.FLUSSI_ASR_QUEUE),
         @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
         @ActivationConfigProperty(propertyName = "maxSession", propertyValue = "5"),
         @ActivationConfigProperty(propertyName = "transactionTimeout", propertyValue = "3600"),
         @ActivationConfigProperty(propertyName = "dLQMaxResent", propertyValue = "0") })
public class _01ElaboraFlussoMDB implements MessageListener
{

   Logger logger = Logger.getLogger(getClass());

   @Inject
   FlussoaService flussoaService;

   @Inject
   FlussocService flussocService;

   public void onMessage(Message message)
   {
      MapMessage msg = (MapMessage) message;
      TipologiaFlusso tipologiaFlusso = null;
      String nomeFile = null;

      try
      {
         tipologiaFlusso = TipologiaFlusso.valueOf(msg.getString(AppKeys.TIPOLOGIA_FLUSSO.name()));
         nomeFile = msg.getString(AppKeys.NOME_FILE.name());
         logger.info("onMessage(), tipologiaFlusso:" + tipologiaFlusso + " nomeFile = " + nomeFile);
         switch (tipologiaFlusso)
         {
         case A1:
         case A2:
            flussoaService.parse(tipologiaFlusso, nomeFile);
            break;

         case C1:
         case C2:
            flussocService.parse(tipologiaFlusso, nomeFile);
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
      }
   }
}
