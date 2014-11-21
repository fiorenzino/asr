package it.ictgroup.asr.repository;

import it.ictgroup.asr.model.Flussoa2;
import it.ictgroup.asr.util.annotations.FieldFixedLength;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.giavacms.commons.model.Search;

@Stateless
@LocalBean
public class Flussoa2Repository extends BaseRepository<Flussoa2>
{

   private static final long serialVersionUID = 1L;

   @Override
   protected String getDefaultOrderBy()
   {
      return " uid asc ";
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

   public boolean updateWithErrori(String nomefile, String regioneAddebitante, String aziendaUsl,
            String codiceIstituto,
            String numerodellascheda, String err01, String err02, String err03,
            String err04, String err05, String err06, String err07, String err08, String err09, String err10)
   {
      /*
       * FLUSSO A1 - A2 - regione addebitante -> regioneAddebitante - cod asl/azienda -> aziendaUsl - cod istituto ->
       * codiceIstituto - num scheda -> numeroDellaScheda
       */
      int numRow;
      try
      {
         numRow = getEm()
                  .createNativeQuery(
                           "UPDATE flussoa2 "
                                    + " SET err01= :err01, err02= :err02, err03= :err03, err04= :err04, err05= :err05, "
                                    + " err06= :err06, err07= :err07, err08= :err08, err09= :err09, err10= :err10"
                                    + " WHERE nomefile= :nomefile, numerodellascheda= :numerodellascheda, "
                                    + "regioneAddebitante = :regioneAddebitante, codiceASL = :codiceASL")
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
                  .setParameter("numerodellascheda", numerodellascheda)
                  .setParameter("aziendaUsl", aziendaUsl)
                  .executeUpdate();
      }
      catch (Exception e)
      {
         logger.info("flussoa2 non trovato - nomefile: " + nomefile + ", regioneAddebitante:" + regioneAddebitante
                  + ", codiceASL: " + aziendaUsl + ", codiceIstituto" +
                  codiceIstituto + ",numerodellascheda: " + numerodellascheda);
         return false;
      }

      return numRow > 0 ? true : false;

   }

   public Map<String, Flussoa2> getMappaRigheDaCorreggere(String nomeFile, List<Long> ids)
   {
      Search<Flussoa2> search = new Search<Flussoa2>(Flussoa2.class);
      search.getObj().setNomeFile(nomeFile);

      List<Flussoa2> righe = getList(search, 0, 0);
      Map<String, Flussoa2> mappa = new HashMap<String, Flussoa2>();
      for (Flussoa2 flussoa2 : righe)
      {
         mappa.put(flussoa2.getNumeroDellaScheda(), flussoa2);
      }
      return mappa;
   }

   @Asynchronous
   public void persistAsync(Flussoa2 flussoa2)
   {
      try
      {
         getEm().persist(flussoa2);
      }
      catch (Exception e)
      {
         logger.info(e.getMessage());
      }
   }

}