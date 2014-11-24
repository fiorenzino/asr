package it.ictgroup.asr.repository;

import it.ictgroup.asr.model.Flussoc2;

import java.util.HashMap;
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

   public boolean updateWithErrori(String nomefile, String regioneAddebitante, String codiceStrutturaErogante,
            String progressivoRigaPerRicetta, String id, String err01, String err02, String err03,
            String err04, String err05, String err06, String err07, String err08, String err09, String err10)
   {
      // String key = flussoc2.getRegioneAddebitante() + flussoc2.getCodiceStrutturaErogante() + flussoc2.getId() +
      // flussoc2.getProgressivoRigaPerRicetta();
      int numRow;
      try
      {
         numRow = getEm()
                  .createNativeQuery(
                           "UPDATE  "
                                    + Flussoc2.TABLE_NAME
                                    + "SET err01= :err01, err02= :err02, err03= :err03, err04= :err04, err05= :err05, "
                                    + " err06= :err06, err07= :err07, err08= :err08, err09= :err09, err10= :err10"
                                    + " WHERE nomefile= :nomefile, progressivoRigaPerRicetta= :progressivoRigaPerRicetta, "
                                    + "regioneAddebitante = :regioneAddebitante, codiceStrutturaErogante = :codiceStrutturaErogante, "
                                    + " id = :id")
                  .setParameter("err01", err01)
                  .setParameter("err02", err02)
                  .setParameter("err03", err03)
                  .setParameter("err04", err04)
                  .setParameter("err05", err05)
                  .setParameter("err06", err06)
                  .setParameter("err07", err07)
                  .setParameter("err08", err08)
                  .setParameter("err09", err09)
                  .setParameter("err10", err10)
                  .setParameter("nomefile", nomefile)
                  .setParameter("regioneAddebitante", regioneAddebitante)
                  .setParameter("progressivoRigaPerRicetta", progressivoRigaPerRicetta)
                  .setParameter("codiceStrutturaErogante", codiceStrutturaErogante)
                  .setParameter("id", id)
                  .executeUpdate();
      }
      catch (Exception e)
      {
         logger.info("flussoc2 non trovato - nomefile: " + nomefile + ", regioneAddebitante:" + regioneAddebitante
                  + ", id: " + id + ", codiceStrutturaErogante" +
                  codiceStrutturaErogante + ",progressivoRigaPerRicetta: " + progressivoRigaPerRicetta);
         return false;
      }

      return numRow > 0 ? true : false;

   }

   public boolean findErrori(String nomefile, String regioneAddebitante, String codiceStrutturaErogante,
            String progressivoRigaPerRicetta, String id)
   {
      // String key = flussoc2.getRegioneAddebitante() + flussoc2.getCodiceStrutturaErogante() + flussoc2.getId() +
      // flussoc2.getProgressivoRigaPerRicetta();
      Long numRow;
      try
      {
         Object res = getEm()
                  .createNativeQuery(
                           "SELECT count(id) FROM  "
                                    + Flussoc2.TABLE_NAME
                                    + " WHERE nomefile= :nomefile AND progressivoRigaPerRicetta= :progressivoRigaPerRicetta AND "
                                    + "regioneAddebitante = :regioneAddebitante AND codiceStrutturaErogante = :codiceStrutturaErogante "
                                    + " AND id = :id")
                  .setParameter("nomefile", nomefile)
                  .setParameter("regioneAddebitante", regioneAddebitante)
                  .setParameter("progressivoRigaPerRicetta", progressivoRigaPerRicetta)
                  .setParameter("codiceStrutturaErogante", codiceStrutturaErogante)
                  .setParameter("id", id)
                  .getSingleResult();
         numRow = Long.parseLong(res.toString());
      }
      catch (Exception e)
      {
         logger.info("flussoc2 non trovato - nomefile: " + nomefile + ", regioneAddebitante:" + regioneAddebitante
                  + ", id: " + id + ", codiceStrutturaErogante" +
                  codiceStrutturaErogante + ",progressivoRigaPerRicetta: " + progressivoRigaPerRicetta);
         return false;
      }

      return numRow > 0 ? true : false;

   }

   public Map<String, Flussoc2> getMappaRigheDaCorreggere(String nomeFile, List<Long> ids)
   {
      Search<Flussoc2> search = new Search<Flussoc2>(Flussoc2.class);
      search.getObj().setNomeFile(nomeFile);

      List<Flussoc2> righe = getList(search, 0, 0);
      Map<String, Flussoc2> mappa = new HashMap<String, Flussoc2>();
      for (Flussoc2 flussoc2 : righe)
      {
         mappa.put(flussoc2.getProgressivoRigaPerRicetta(), flussoc2);
      }
      return mappa;
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