package it.ictgroup.asr.service.rs;

import it.ictgroup.asr.management.AppConstants;
import it.ictgroup.asr.management.AppProperties;
import it.ictgroup.asr.util.MasterUtils;

import java.net.URL;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/v1/master")
@Stateless
@LocalBean
public class MasterRest
{

   @GET
   @Produces("text/plain")
   @Path("/checkRunning")
   public String checkRunning()
   {
      try
      {
         return Boolean.TRUE.toString();
      }
      catch (Exception e)
      {
         return "Errore: " + e.getMessage();
      }
   }

   @GET
   @Produces("text/plain")
   @Path("/checkMaster")
   public String checkMaster()
   {
      if (!AppProperties.masterUrl.value().toUpperCase()
               .contains(System.getProperty(AppConstants.HOSTNAME_PROPERTY).toUpperCase()))
      {
         try
         {
            byte[] masterIsRunning = MasterUtils.getBytesFromUrl(new URL(AppProperties.masterUrl.value()));
            // if (Boolean.parseBoolean(new String(masterIsRunning)))
            if (masterIsRunning != null && masterIsRunning.length > 0
                     && "TRUE".equals(new String(masterIsRunning).toUpperCase()))
            {
               return "Master is running on " + AppProperties.masterUrl.value()
                        + " so execution would be skipped on "
                        + System.getProperty(AppConstants.HOSTNAME_PROPERTY);
            }
            else
            {
               return "Master does not seem to be running on " + AppProperties.masterUrl.value()
                        + " so execution would happen on "
                        + System.getProperty(AppConstants.HOSTNAME_PROPERTY);
            }
         }
         catch (Exception e)
         {
            return e.getClass().getCanonicalName() + " - " + e.getMessage();
         }
      }
      else
      {
         return "I am master";
      }
   }

}
