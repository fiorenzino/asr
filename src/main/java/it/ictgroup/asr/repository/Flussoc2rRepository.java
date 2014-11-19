package it.ictgroup.asr.repository;

import it.ictgroup.asr.model.Flussoc2r;

import java.util.Map;

import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.giavacms.commons.model.Search;

@Stateless
@LocalBean
public class Flussoc2rRepository extends BaseRepository<Flussoc2r>
{

   private static final long serialVersionUID = 1L;

   @Override
   protected String getDefaultOrderBy()
   {
      return " x asc ";
   }

   @Override
   protected void applyRestrictions(Search<Flussoc2r> search, String alias,
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
   public void persistAsync(Flussoc2r flussoc2r)
   {
      try
      {
         getEm().persist(flussoc2r);
      }
      catch (Exception e)
      {
         logger.info(e.getMessage());
      }
   }

}