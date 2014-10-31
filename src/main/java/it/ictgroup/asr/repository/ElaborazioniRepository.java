package it.ictgroup.asr.repository;

import it.coopservice.commons2.domain.Search;
import it.ictgroup.asr.model.Elaborazione;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class ElaborazioniRepository extends BaseRepository<Elaborazione>
{

   private static final long serialVersionUID = 1L;

   @Override
   protected String getDefaultOrderBy()
   {
      return " id asc ";
   }

   @Override
   protected void applyRestrictions(Search<Elaborazione> search, String alias,
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

      // id configurazione;
      if (search.getObj().getConfigurazione() != null && search.getObj().getConfigurazione().getId() != null)
      {
         sb.append(separator).append(alias)
                  .append(".configurazione.id = :configurazioneId ");
         params.put("configurazioneId", search.getObj().getConfigurazione().getId());
         separator = " and ";
      }

   }

   public List<String> getFilePerConfigurazione(Long id)
   {
      List<String> result = new ArrayList<String>();
      Search<Elaborazione> search = new Search<Elaborazione>(Elaborazione.class);
      search.getObj().getConfigurazione().setId(id);
      List<Elaborazione> list = getList(search, 0, 0);
      for (Elaborazione elaborazione : list)
      {
         result.add(elaborazione.getFileName());
      }
      return result;
   }
}