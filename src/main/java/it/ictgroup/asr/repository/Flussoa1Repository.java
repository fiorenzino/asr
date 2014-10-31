package it.ictgroup.asr.repository;

import it.coopservice.commons2.domain.Search;
import it.ictgroup.asr.model.Flussoa1;

import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class Flussoa1Repository extends BaseRepository<Flussoa1>
{

   private static final long serialVersionUID = 1L;

   @Override
   protected String getDefaultOrderBy()
   {
      return " id asc ";
   }

   @Override
   protected void applyRestrictions(Search<Flussoa1> search, String alias,
            String separator, StringBuffer sb, Map<String, Object> params)
   {

      // id lotto;
      if (search.getObj().getUid() != null)
      {
         sb.append(separator).append(alias)
                  .append(".uid = :uid ");
         params.put("uid", search.getObj().getUid());
         separator = " and ";
      }

   }

}