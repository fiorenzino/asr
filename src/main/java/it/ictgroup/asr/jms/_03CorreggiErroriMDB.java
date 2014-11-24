package it.ictgroup.asr.jms;

import it.ictgroup.asr.management.AppConstants;
import it.ictgroup.asr.management.AppKeys;
import it.ictgroup.asr.model.Elaborazione;
import it.ictgroup.asr.repository.ElaborazioniRepository;
import it.ictgroup.asr.repository.InviiRepository;
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

@MessageDriven(name = "_03CorreggiErroriMDB", activationConfig = {
         @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
         @ActivationConfigProperty(propertyName = "destination", propertyValue = AppConstants.CORREGGI_ERRORI_ASR_QUEUE),
         @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
         @ActivationConfigProperty(propertyName = "maxSession", propertyValue = "1"),
         @ActivationConfigProperty(propertyName = "transactionTimeout", propertyValue = "3600"),
         @ActivationConfigProperty(propertyName = "dLQMaxResent", propertyValue = "0") })
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class _03CorreggiErroriMDB implements MessageListener
{

   Logger logger = Logger.getLogger(getClass());

   @Inject
   ElaborazioniRepository elaborazioniRepository;
   @Inject
   InviiRepository inviiRepository;

   @Inject
   FlussoService flussoService;

   public void onMessage(Message message)
   {
      MapMessage msg = (MapMessage) message;
      Long idElaborazione = null;
      Long idInvio = null;

      try
      {
         idElaborazione = msg.getLong(AppKeys.ELABORAZIONE_ID.name());
         idInvio = msg.getLong(AppKeys.INVIO_ID.name());
         logger.info("_03CorreggiErroriMDB: onMessage(), idElaborazione:" + idElaborazione);

         Elaborazione elaborazione = elaborazioniRepository.fetch_newtx(idElaborazione);

         flussoService.updateRigheInErrore(
                  elaborazione.getId(),
                  elaborazione.getFileName(),
                  elaborazione.getConfigurazione().getTipologiaFlusso());
         inviiRepository.updateLavorazioneErrori(idInvio);

      }
      catch (Throwable e)
      {
         logger.error(e.getMessage(), e);
      }
   }
}
