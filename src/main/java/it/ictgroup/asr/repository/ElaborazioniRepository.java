package it.ictgroup.asr.repository;

import it.ictgroup.asr.model.Elaborazione;
import it.ictgroup.asr.model.Flussoa1;
import it.ictgroup.asr.model.Flussoa2;
import it.ictgroup.asr.model.Flussoa2r;
import it.ictgroup.asr.model.Flussoc1;
import it.ictgroup.asr.model.Flussoc2;
import it.ictgroup.asr.model.Flussoc2r;
import it.ictgroup.asr.model.enums.StatoElaborazione;
import it.ictgroup.asr.model.enums.TipologiaFlusso;
import it.ictgroup.asr.model.enums.TipologiaInvio;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.giavacms.commons.model.Search;
import org.giavacms.commons.util.DateUtils;

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

      // getStatoElaborazione
      if (search.getObj().getStatoElaborazione() != null)
      {
         sb.append(separator).append(alias)
                  .append(".statoElaborazione = :statoElaborazione ");
         params.put("statoElaborazione", search.getObj().getStatoElaborazione());
         separator = " and ";
      }

      // configurazione.nome
      if (search.getObj().getConfigurazione().getNome() != null
               && !search.getObj().getConfigurazione().getNome().trim().isEmpty())
      {
         sb.append(separator).append(alias)
                  .append(".configurazione.nome LIKE :nomeConf ");
         params.put("nomeConf", likeParam(search.getObj().getConfigurazione().getNome().trim()));
         separator = " and ";
      }

      // fileName
      if (search.getObj().getFileName() != null && !search.getObj().getFileName().trim().isEmpty())
      {
         sb.append(separator).append(alias)
                  .append(".fileName LIKE :fileName ");
         params.put("fileName", likeParam(search.getObj().getFileName()));
         separator = " and ";
      }

      // dataCreazione da
      if (search.getFrom().getDataCreazione() != null)
      {
         sb.append(separator).append(alias).append(".dataCreazione >= :daDataCreazione ");
         params.put("daDataCreazione", DateUtils.toBeginOfDay(search.getFrom().getDataCreazione()));
         separator = " and ";
      }
      // dataCreazione a
      if (search.getTo().getDataCreazione() != null)
      {
         sb.append(separator).append(alias).append(".dataCreazione <= :aDataCreazione ");
         params.put("aDataPreparazione", DateUtils.toEndOfDay(search.getTo().getDataCreazione()));
         separator = " and ";
      }

   }

   public List<String> getFilePerConfigurazione(Long id)
   {

      List<String> result = getEm()
               .createNativeQuery(
                        "SELECT DISTINCT(fileName) FROM " + Elaborazione.TABLE_NAME + " where configurazione_id=  :ID")
               .setParameter("ID", id).getResultList();
      return result;
   }

   @Asynchronous
   public void avviato(Long id)
   {
      try
      {
         getEm().createNativeQuery(
                  "UPDATE  " + Elaborazione.TABLE_NAME
                           + " SET statoElaborazione = :STATO, dataStart = :DATA WHERE id = :ID")
                  .setParameter("ID", id)
                  .setParameter("DATA", new Date())
                  .setParameter("STATO", StatoElaborazione.AVVIATO.name()).executeUpdate();
      }
      catch (Exception e)
      {
         logger.info(e.getMessage());
      }

   }

   @Asynchronous
   public void errore(Long id, String message, int righe)
   {
      try
      {
         getEm().createNativeQuery(
                  "UPDATE  "
                           + Elaborazione.TABLE_NAME
                           + " SET statoElaborazione = :STATO, dataEnd = :DATA, message = :MSG, righe = :RIGHE WHERE id = :ID")
                  .setParameter("ID", id)
                  .setParameter("MSG", message)
                  .setParameter("RIGHE", righe)
                  .setParameter("DATA", new Date())
                  .setParameter("STATO", StatoElaborazione.ERRORE.name()).executeUpdate();
      }
      catch (Exception e)
      {
         logger.info(e.getMessage());
      }

   }

   @Asynchronous
   public void eseguito(Long id, int righe)
   {
      try
      {
         getEm().createNativeQuery(
                  "UPDATE  " + Elaborazione.TABLE_NAME + " SET statoElaborazione = :STATO, "
                           + " dataEnd = :DATA, righe = :RIGHE WHERE id = :ID")
                  .setParameter("ID", id)
                  .setParameter("RIGHE", righe)
                  .setParameter("DATA", new Date())
                  .setParameter("STATO", StatoElaborazione.ESEGUITO.name()).executeUpdate();
      }
      catch (Exception e)
      {
         logger.info(e.getMessage());
      }

   }

   public Map<TipologiaInvio, List<Elaborazione>> getElaborazioniNonCongiunteEseguite()
   {
      Map<TipologiaInvio, List<Elaborazione>> mappa = new HashMap<TipologiaInvio, List<Elaborazione>>();
      List<Elaborazione> list = getEm()
               .createQuery(
                        "SELECT e FROM " + Elaborazione.class.getSimpleName()
                                 + "  WHERE congiunta = :congiunta AND statoElaborazione = :statoElaborazione",
                        Elaborazione.class)
               .setParameter("congiunta", false)
               .setParameter("statoElaborazione", StatoElaborazione.ESEGUITO)
               .getResultList();
      for (Elaborazione elaborazione : list)
      {
         List<Elaborazione> lista = null;
         switch (elaborazione.getConfigurazione().getTipologiaFlusso())
         {
         case A1:
         case A2:
         case A2R:
            if (mappa.containsKey(TipologiaInvio.A))
            {
               lista = mappa.get(TipologiaInvio.A);

            }
            else
            {
               lista = new ArrayList<Elaborazione>();
               mappa.put(TipologiaInvio.A, lista);
            }
            break;
         case B:
            break;
         case C1:
         case C2:
         case C2R:
            if (mappa.containsKey(TipologiaInvio.C))
            {
               lista = mappa.get(TipologiaInvio.C);

            }
            else
            {
               lista = new ArrayList<Elaborazione>();
               mappa.put(TipologiaInvio.C, lista);
            }
            break;
         case D:
            break;
         case E:
            break;
         case F:
            break;
         case G:
            break;
         }
         lista.add(elaborazione);
      }
      return mappa;
   }

   public void eliminaConRigheFlusso(Long id) throws Exception
   {
      Elaborazione elaborazione = fetch(id);
      String query = null;
      if (true)
      {
         switch (elaborazione.getConfigurazione().getTipologiaFlusso())
         {
         case A1:
            query = "DELETE FROM  " + Flussoa1.TABLE_NAME + " WHERE elaborazione_id = :ID";
            break;
         case A2:
            query = "DELETE FROM  " + Flussoa2.TABLE_NAME + " WHERE elaborazione_id = :ID";
            break;
         case A2R:
            query = "DELETE FROM  " + Flussoa2r.TABLE_NAME + " WHERE elaborazione_id = :ID";
            break;
         case B:
            query = null;
            break;
         case C1:
            query = "DELETE FROM  " + Flussoc1.TABLE_NAME + " WHERE elaborazione_id = :ID";
            break;
         case C2:
            query = "DELETE FROM  " + Flussoc2.TABLE_NAME + " WHERE elaborazione_id = :ID";
            break;
         case C2R:
            query = "DELETE FROM  " + Flussoc2r.TABLE_NAME + " WHERE elaborazione_id = :ID";
            break;
         case D:
            query = null;
            break;
         case E:
            query = null;
            break;
         case F:
            query = null;
            break;
         case G:
            query = null;
            break;
         }

      }
      getEm().createNativeQuery(query).setParameter("ID", id).executeUpdate();
      delete(id);
   }

   public int countRighe(Long id, TipologiaFlusso tipologiaFlusso) throws Exception
   {
      String query = "";
      switch (tipologiaFlusso)
      {
      case A1:
         query = "select count(*) FROM " + Flussoa1.TABLE_NAME + " WHERE elaborazione_id = :ID";
         break;
      case A2:
         query = "select count(*) FROM " + Flussoa2.TABLE_NAME + " WHERE elaborazione_id = :ID";
         break;
      case A2R:
         query = "select count(*) FROM " + Flussoa2r.TABLE_NAME + " WHERE elaborazione_id = :ID";
         break;
      case B:
         query = null;
         break;
      case C1:
         query = "select count(*) FROM " + Flussoc1.TABLE_NAME + " WHERE elaborazione_id = :ID";
         break;
      case C2:
         query = "select count(*) FROM " + Flussoc2.TABLE_NAME + " WHERE elaborazione_id = :ID";
         break;
      case C2R:
         query = "select count(*) FROM " + Flussoc2r.TABLE_NAME + " WHERE elaborazione_id = :ID";
         break;
      case D:
         query = null;
         break;
      case E:
         query = null;
         break;
      case F:
         query = null;
         break;
      case G:
         query = null;
         break;
      }

      BigInteger result = (BigInteger) getEm().createNativeQuery(query).setParameter("ID", id).getSingleResult();
      return result != null ? result.intValue() : 0;
   }

   @Asynchronous
   public void persistAsync(Object t)
   {
      try
      {
         getEm().persist(t);
      }
      catch (Exception e)
      {
         logger.info(e.getMessage());
      }
   }
}