package it.ictgroup.asr.service.timer;

import it.ictgroup.asr.management.AppProperties;
import it.ictgroup.asr.service.InviiService;
import it.ictgroup.asr.util.MasterUtils;

import java.io.Serializable;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import org.jboss.logging.Logger;

@Singleton
public class _03_CorreggiErroriTimer implements Serializable
{

   Logger logger = Logger.getLogger(getClass());

   private static final long serialVersionUID = 1L;

   @Inject
   InviiService inviiService;

   boolean isWorking = false;

   @Schedule(hour = "*", minute = "0/30", persistent = false, info = "ogni 30 minuto di ogni ora")
   // @TransactionTimeout(value = 10L, unit = TimeUnit.MINUTES)
   @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
   public void execute()
   {
      // logger.info("************_01_P7mFolderPollerTimer");
      if (!MasterUtils.doIhaveToRun(AppProperties.masterUrl.value()))
      {
         logger.info("Skipping execution on development / slave installation");
         return;
      }

      if (!isWorking)
      {
         logger.info("Executing now!");
         executeNow();
      }
      else
      {
         logger.info("Former execution is still running");
      }

   }

   @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
   public void executeNow()
   {
      isWorking = true;
      try
      {
         inviiService.verificaInvii();
      }
      catch (Throwable e)
      {
         logger.info(e.getMessage());
      }
      finally
      {
         isWorking = false;
      }
   }

}
