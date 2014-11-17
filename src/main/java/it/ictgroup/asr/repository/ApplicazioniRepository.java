package it.ictgroup.asr.repository;

import it.ictgroup.asr.model.Applicazione;

import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.giavacms.commons.model.Search;

@Stateless
@LocalBean
public class ApplicazioniRepository extends BaseRepository<Applicazione>
{

   private static final long serialVersionUID = 1L;

   @Override
   protected String getDefaultOrderBy()
   {
      return " nome asc ";
   }

   @Override
   protected void applyRestrictions(Search<Applicazione> search, String alias,
            String separator, StringBuffer sb, Map<String, Object> params)
   {

      // id lotto;
      if (search.getObj().getId() != null)
      {
         sb.append(separator).append(alias)
                  .append(".id = :id ");
         params.put("id", search.getObj().getId());
         separator = " and ";
      }

   }

   public Applicazione findBySigla(String sigla)
   {
      Applicazione applicazione = null;
      try
      {
         applicazione = getEm().createQuery("select a from Applicazione a where a.sigla = :sigla", Applicazione.class)
                  .setParameter("sigla", sigla)
                  .getSingleResult();
      }
      catch (Exception e)
      {
         logger.info(e.getMessage());
      }
      return applicazione;
   }

}