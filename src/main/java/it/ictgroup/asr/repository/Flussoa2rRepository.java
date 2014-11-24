package it.ictgroup.asr.repository;

import it.ictgroup.asr.model.Flussoa2r;

import java.util.List;
import java.util.Map;

import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

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

   @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
   public List<Flussoa2r> getList_newtx(Search<Flussoa2r> ricerca, int startRow, int pageSize) throws Exception
   {
      return super.getList(ricerca, startRow, pageSize);
   }

   @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
   public int getListSize_newtx(Search<Flussoa2r> ricerca) throws Exception
   {
      // TODO Auto-generated method stub
      return super.getListSize(ricerca);
   }

}