package it.ictgroup.asr.repository;

import it.ictgroup.asr.model.Flussoc2;

import java.util.List;
import java.util.Map;

import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.giavacms.commons.model.Search;

@Stateless
@LocalBean
public class Flussoc2Repository extends BaseRepository<Flussoc2>
{

   private static final long serialVersionUID = 1L;

   @Override
   protected String getDefaultOrderBy()
   {
      return " uid asc ";
   }

   @Override
   protected void applyRestrictions(Search<Flussoc2> search, String alias,
            String separator, StringBuffer sb, Map<String, Object> params)
   {

      // elaborazione;
      if (search.getObj().getElaborazione() != null && search.getObj().getElaborazione().getId() != null)
      {
         sb.append(separator).append(alias)
                  .append(".elaborazione.id = :elaborazioneId ");
         params.put("elaborazioneId", search.getObj().getElaborazione().getId());
         separator = " and ";
      }

      // nomeFile;
      if (search.getObj().getNomeFile() != null && !search.getObj().getNomeFile().trim().isEmpty())
      {
         sb.append(separator).append(alias)
                  .append(".nomeFile = :nomeFile ");
         params.put("nomeFile", search.getObj().getNomeFile().trim().isEmpty());
         separator = " and ";
      }

   }

   public Flussoc2 getRiferimento(Flussoc2 flussoc2)
   {
      Search<Flussoc2> search = new Search<Flussoc2>(Flussoc2.class);
      search.getObj().setRegioneAddebitante(flussoc2.getRegioneAddebitante());
      search.getObj().setZonaTerritoriale(flussoc2.getZonaTerritoriale());
      search.getObj().setId(flussoc2.getId());
      search.getObj().setProgressivoRigaPerRicetta(flussoc2.getProgressivoRigaPerRicetta());
      List<Flussoc2> resList = getList(search, 0, 0);
      return (resList != null && resList.size() > 0) ? resList.get(0) : null;
   }

   @Asynchronous
   public void persistAsync(Flussoc2 flussoc2)
   {
      try
      {
         getEm().persist(flussoc2);
      }
      catch (Exception e)
      {
         logger.info(e.getMessage());
      }
   }

}