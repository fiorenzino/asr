package it.ictgroup.asr.repository;

import it.ictgroup.asr.model.Flussoa2r;

import java.util.Map;

import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.giavacms.commons.model.Search;

@Stateless
@LocalBean
public class Flussoa2rRepository extends BaseRepository<Flussoa2r>
{

   private static final long serialVersionUID = 1L;

   @Override
   protected String getDefaultOrderBy()
   {
      return " uid asc ";
   }

   @Override
   protected void applyRestrictions(Search<Flussoa2r> search, String alias,
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

   @Asynchronous
   public void persistAsync(Flussoa2r flussoa2r)
   {
      try
      {
         getEm().persist(flussoa2r);
      }
      catch (Exception e)
      {
         logger.info(e.getMessage());
      }
   }

}