package it.ictgroup.asr.repository;

import it.coopservice.commons2.domain.Search;
import it.ictgroup.asr.model.Flussoc2;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.Map;

@Stateless
@LocalBean
public class Flussoc2Repository extends BaseRepository<Flussoc2>
{

   private static final long serialVersionUID = 1L;

   @Override
   protected String getDefaultOrderBy()
   {
      return " id asc ";
   }

   @Override
   protected void applyRestrictions(Search<Flussoc2> search, String alias,
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

}