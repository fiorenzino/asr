package it.ictgroup.asr.repository;

import it.coopservice.commons2.domain.Search;
import it.ictgroup.asr.model.Elaborazione;
import it.ictgroup.asr.model.enums.StatoElaborazione;

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

      List<String> result = getEm()
               .createNativeQuery("SELECT DISTINCT(fileName) FROM Elaborazione where configurazione_id=  :ID")
               .setParameter("ID", id).getResultList();
      return result;
   }

   public void eseguito(Long id) throws Exception
   {
      getEm().createNativeQuery("UPDATE Elaborazione as E SET E.StatoElaborazione = :STATO WHERE E.ID = :ID")
               .setParameter("ID", id)
               .setParameter("STATO", StatoElaborazione.ESEGUITO.name()).executeUpdate();
   }
}