package it.ictgroup.asr.repository;

import it.ictgroup.asr.model.Invio;
import it.ictgroup.asr.model.enums.StatoElaborazione;
import it.ictgroup.asr.model.enums.StatoInvio;
import it.ictgroup.asr.model.enums.TipologiaInvio;

import java.util.Date;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.giavacms.commons.model.Search;

@Stateless
@LocalBean
public class InviiRepository extends BaseRepository<Invio>
{

   private static final long serialVersionUID = 1L;

   @Override
   protected String getDefaultOrderBy()
   {
      return " id asc ";
   }

   @Override
   protected void applyRestrictions(Search<Invio> search, String alias,
            String separator, StringBuffer sb, Map<String, Object> params)
   {

      // id;
      if (search.getObj().getId() != null)
      {
         sb.append(separator).append(alias)
                  .append(".id = :id ");
         params.put("id", search.getObj().getId());
         separator = " and ";
      }

      // tipologia di invio
      if (search.getObj().getTipologiaInvio() != null)
      {
         sb.append(separator).append(alias)
                  .append(".tipologiaInvio = :tipologiaInvio ");
         params.put("tipologiaInvio", search.getObj().getTipologiaInvio());
         separator = " and ";
      }

      // statoInvio
      if (search.getObj().getStatoInvio() != null)
      {
         sb.append(separator).append(alias)
                  .append(".statoInvio = :statoInvio ");
         params.put("statoInvio", search.getObj().getStatoInvio());
         separator = " and ";
      }
   }

   public Invio getInvioBySiglaAndTipo(String sigla, TipologiaInvio tipologiaInvio)
   {
      Invio invio = null;
      try
      {
         invio = getEm()
                  .createQuery("select i from Invio i where i.sigla = :SIGLA and i.tipologiaInvio = :TIPOLOGIA",
                           Invio.class).setParameter("TIPOLOGIA", tipologiaInvio)
                  .setParameter("SIGLA", sigla).getSingleResult();
      }
      catch (Exception e)
      {
         logger.info(e.getMessage());
      }

      return invio;
   }

   public void updateStato(Long id, StatoInvio statoInvio) throws Exception
   {
      getEm().createNativeQuery(
               "UPDATE Invio as I SET I.StatoInvio = :STATO WHERE I.ID = :ID")
               .setParameter("ID", id)
               .setParameter("STATO", statoInvio).executeUpdate();
   }
}