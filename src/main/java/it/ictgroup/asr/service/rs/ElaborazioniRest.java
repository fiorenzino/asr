package it.ictgroup.asr.service.rs;

import it.ictgroup.asr.repository.ElaborazioniRepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/v1/elaborazioni")
@Stateless
@LocalBean
public class ElaborazioniRest
{

   @Inject
   ElaborazioniRepository elaborazioniRepository;

   @GET
   @Produces("text/plain")
   @Path("/{id}/elimina")
   public String elimina(@PathParam("id") String id) throws Exception
   {
      // _01_P7mFolderPollerTimer.executeNow();
      elaborazioniRepository.eliminaConRigheFlusso(Long.valueOf(id));
      return "OK";
   }

}
