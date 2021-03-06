package it.ictgroup.asr.repository;

import it.ictgroup.asr.model.Flussoc1;

import java.util.Map;

import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.giavacms.commons.model.Search;

@Stateless
@LocalBean
public class Flussoc1Repository extends BaseRepository<Flussoc1>
{

   private static final long serialVersionUID = 1L;

   @Override
   protected String getDefaultOrderBy()
   {
      return " uid asc ";
   }

   @Override
   protected void applyRestrictions(Search<Flussoc1> search, String alias,
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

   @Asynchronous
   public void persistAsync(Flussoc1 flussoc1)
   {
      try
      {
         getEm().persist(flussoc1);
      }
      catch (Exception e)
      {
         logger.info(e.getMessage());
      }
   }

}