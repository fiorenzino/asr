package it.ictgroup.asr.util;

import it.ictgroup.asr.management.AppConstants;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.jboss.logging.Logger;

public class MasterUtils
{
   static Logger logger = Logger.getLogger(MasterUtils.class);

   public static boolean amItheMaster(String masterUrl)
   {
      if (masterUrl.toUpperCase().contains(
               System.getProperty(AppConstants.HOSTNAME_PROPERTY).toUpperCase()))
      {
         logger.info("I am the master");
         return true;
      }
      else
      {
         logger.info("I am NOT the master");
         return false;
      }
   }

   public static boolean isRunning(String anUrl)
   {
      try
      {

         byte[] serverAtGivenUrlIsRunning = getBytesFromUrl(new URL(anUrl));
         // if (Boolean.parseBoolean(new String(masterIsRunning)))
         if (serverAtGivenUrlIsRunning != null && serverAtGivenUrlIsRunning.length > 0
                  && "TRUE".equals(new String(serverAtGivenUrlIsRunning).toUpperCase()))
         {
            logger.info("Server @ " + anUrl + " is running");
            return true;
         }
         else
         {
            logger.info("Server @ " + anUrl + " is NOT running");
            return false;
         }
      }
      catch (MalformedURLException e)
      {
         logger.error(e.getMessage(), e);
         logger.info("Got an exception while checking for url " + anUrl
                  + ". This is NOT normal, so I am NOT going to act on behalf of it.");
         return true;
      }

   }

   public static boolean doIhaveToRun(String masterUrl)
   {
      if (amItheMaster(masterUrl))
      {
         return true;
      }
      else
      {
         boolean masterIsRunning = isRunning(masterUrl);
         // if (Boolean.parseBoolean(new String(masterIsRunning)))
         if (masterIsRunning)
         {
            logger.info("Master is running on " + masterUrl
                     + " so skipping execution on "
                     + System.getProperty(AppConstants.HOSTNAME_PROPERTY));
            return false;
         }
         else
         {
            logger.info("Master does not seem to be running on " + masterUrl
                     + " so execution happening on "
                     + System.getProperty(AppConstants.HOSTNAME_PROPERTY));
            return true;
         }
      }
   }

   public static byte[] getBytesFromUrl(URL url)
   {
      InputStream is = null;
      ByteArrayOutputStream os = null;
      try
      {
         is = url.openStream();
         os = new ByteArrayOutputStream();
         byte buffer[] = new byte[1];
         while (is.read(buffer) != -1)
         {
            os.write(buffer);
         }
         return os.toByteArray();
      }
      catch (Exception e)
      {
         logger.error(e.getMessage());
         return null;
      }
      finally
      {
         if (is != null)
         {
            try
            {
               is.close();
            }
            catch (Throwable t)
            {
            }
         }
         if (os != null)
         {
            try
            {
               os.close();
            }
            catch (Throwable t)
            {
            }
         }
      }
   }
}
