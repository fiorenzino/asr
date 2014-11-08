package it.ictgroup.asr.repository;

import it.coopservice.commons2.domain.Search;
import it.ictgroup.asr.model.Flussoa2;

import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class Flussoa2Repository extends BaseRepository<Flussoa2>
{

   private static final long serialVersionUID = 1L;

   @Override
   protected String getDefaultOrderBy()
   {
      return " id asc ";
   }

   @Override
   protected void applyRestrictions(Search<Flussoa2> search, String alias,
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

      // regioneAddebitante;
      if (search.getObj().getRegioneAddebitante() != null)
      {
         sb.append(separator).append(alias)
                  .append(".regioneAddebitante = :regioneAddebitante ");
         params.put("regioneAddebitante", search.getObj().getRegioneAddebitante());
         separator = " and ";
      }

      // codiceIstituto;
      if (search.getObj().getCodiceIstituto() != null)
      {
         sb.append(separator).append(alias)
                  .append(".codiceIstituto = :codiceIstituto ");
         params.put("codiceIstituto", search.getObj().getCodiceIstituto());
         separator = " and ";
      }

      // numeroDellaScheda;
      if (search.getObj().getNumeroDellaScheda() != null)
      {
         sb.append(separator).append(alias)
                  .append(".numeroDellaScheda = :numeroDellaScheda ");
         params.put("numeroDellaScheda", search.getObj().getNumeroDellaScheda());
         separator = " and ";
      }

   }

   public Flussoa2 getRiferimento(Flussoa2 flussoa2)
   {
      Search<Flussoa2> search = new Search<Flussoa2>(Flussoa2.class);
      search.getObj().setRegioneAddebitante(flussoa2.getRegioneAddebitante());
      // search.getObj().setAziendaUsl(flussoa2.getAziendaUsl()); // TODO dov'è????
      search.getObj().setCodiceIstituto(flussoa2.getCodiceIstituto());
      search.getObj().setNumeroDellaScheda(flussoa2.getNumeroDellaScheda());
      List<Flussoa2> resList = getList(search, 0, 0);
      return (resList != null && resList.size() > 0) ? resList.get(0) : null;
   }

}