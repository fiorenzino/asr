package it.ictgroup.asr.repository;

import it.ictgroup.asr.model.Flussoc2r;

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
public class Flussoc2rRepository extends BaseRepository<Flussoc2r>
{

   private static final long serialVersionUID = 1L;

   @Override
   protected String getDefaultOrderBy()
   {
      return " uid asc ";
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

   @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
   public List<Flussoc2r> getList_newtx(Search<Flussoc2r> ricerca, int startRow, int pageSize) throws Exception
   {
      return super.getList(ricerca, startRow, pageSize);
   }

   @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
   public int getListSize_newtx(Search<Flussoc2r> ricerca) throws Exception
   {
      // TODO Auto-generated method stub
      return super.getListSize(ricerca);
   }

}