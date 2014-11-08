package it.ictgroup.asr.repository;

import it.coopservice.commons2.domain.Search;
import it.ictgroup.asr.model.Flussoc2;

import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

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

      // uid lotto;
      if (search.getObj().getUid() != null)
      {
         sb.append(separator).append(alias)
                  .append(".uid = :uid ");
         params.put("uid", search.getObj().getUid());
         separator = " and ";
      }

      // regioneAddebitante;
      if (search.getObj().getId() != null)
      {
         sb.append(separator).append(alias)
                  .append(".regioneAddebitante = :regioneAddebitante ");
         params.put("regioneAddebitante", search.getObj().getRegioneAddebitante());
         separator = " and ";
      }

      // zonaTerritoriale;
      if (search.getObj().getId() != null)
      {
         sb.append(separator).append(alias)
                  .append(".zonaTerritoriale = :zonaTerritoriale ");
         params.put("zonaTerritoriale", search.getObj().getZonaTerritoriale());
         separator = " and ";
      }

      // zonaTerritoriale;
      if (search.getObj().getId() != null)
      {
         sb.append(separator).append(alias)
                  .append(".zonaTerritoriale = :zonaTerritoriale ");
         params.put("zonaTerritoriale", search.getObj().getZonaTerritoriale());
         separator = " and ";
      }

      // id lotto;
      if (search.getObj().getId() != null)
      {
         sb.append(separator).append(alias)
                  .append(".id = :id ");
         params.put("id", search.getObj().getId());
         separator = " and ";
      }

      // progressivoRigaPerRicetta;
      if (search.getObj().getProgressivoRigaPerRicetta() != null)
      {
         sb.append(separator).append(alias)
                  .append(".progressivoRigaPerRicetta = :progressivoRigaPerRicetta ");
         params.put("progressivoRigaPerRicetta", search.getObj().getProgressivoRigaPerRicetta());
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

}