package it.ictgroup.asr.service.rs;

import it.ictgroup.asr.service.FolderService;
import it.ictgroup.asr.service.InviiService;

import java.util.concurrent.TimeUnit;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.jboss.ejb3.annotation.TransactionTimeout;

@Path("/v1/timer")
@Stateless
@LocalBean
public class TimerRest
{

   @Inject
   FolderService folderService;

   @Inject
   InviiService inviiService;

   @GET
   @Produces("text/plain")
   @Path("/folderPoller")
   @TransactionTimeout(value = 10L, unit = TimeUnit.MINUTES)
   public String folderPoller() throws Exception
   {
      // _01_P7mFolderPollerTimer.executeNow();
      folderService.verifica();
      return "OK";
   }

   @GET
   @Produces("text/plain")
   @Path("/invii")
   @TransactionTimeout(value = 10L, unit = TimeUnit.MINUTES)
   public String invii() throws Exception
   {
      // _01_P7mFolderPollerTimer.executeNow();
      inviiService.verificaInvii();
      return "OK";
   }

}
