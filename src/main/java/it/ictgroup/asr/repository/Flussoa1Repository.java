package it.ictgroup.asr.repository;

import it.ictgroup.asr.model.Flussoa1;

import java.util.Map;

import javax.ejb.*;

import org.giavacms.commons.model.Search;

@Stateless
@LocalBean
public class Flussoa1Repository extends BaseRepository<Flussoa1>
{

   private static final long serialVersionUID = 1L;

   @Override
   protected String getDefaultOrderBy()
   {
      return " uid asc ";
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

   @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
   public void bulkDeleteDuplicates()
   {
      getEm().createNativeQuery(
               "delete from " + Flussoa1.TABLE_NAME + " "
               + "where "
                  + "uid not in ( "
                     + "select "
                        + "max(a1.uid) as uid "
                     + "from "
                        + "flussoa1 a1 "
                     + "group by "
                        + "a1.codiceistitutodiricovero, "
                        + "a1.numerodellascheda"
                     + ")"
               ).executeUpdate();
   }

}