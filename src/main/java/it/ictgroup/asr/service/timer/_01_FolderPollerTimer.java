package it.ictgroup.asr.service.timer;

import it.ictgroup.asr.management.AppProperties;
import it.ictgroup.asr.service.FolderService;
import it.ictgroup.asr.util.MasterUtils;

import java.io.Serializable;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;

import org.jboss.logging.Logger;

@Singleton
public class _01_FolderPollerTimer implements Serializable
{

   Logger logger = Logger.getLogger(getClass());

   private static final long serialVersionUID = 1L;

   @Inject
   FolderService folderService;

   boolean isWorking = false;

   @Schedule(hour = "*", minute = "0/2", persistent = false, info = "ogni 2 minuto di ogni ora")
   // @TransactionTimeout(value = 10L, unit = TimeUnit.MINUTES)
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

   public void executeNow()
   {
      isWorking = true;
      try
      {
         folderService.verifica(10, 50);
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
