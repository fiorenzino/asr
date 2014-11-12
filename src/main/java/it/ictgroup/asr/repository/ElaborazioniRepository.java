package it.ictgroup.asr.repository;

import it.coopservice.commons2.domain.Search;
import it.coopservice.commons2.utils.DateUtils;
import it.ictgroup.asr.model.Elaborazione;
import it.ictgroup.asr.model.enums.StatoElaborazione;

import java.util.Date;
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
               .createNativeQuery("SELECT DISTINCT(fileName) FROM Elaborazione where configurazione_id=  :ID")
               .setParameter("ID", id).getResultList();
      return result;
   }

   // @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
   public void avviato(Long id) throws Exception
   {
      getEm().createNativeQuery(
               "UPDATE Elaborazione as E SET E.StatoElaborazione = :STATO, E.dataStart = :DATA WHERE E.ID = :ID")
               .setParameter("ID", id)
               .setParameter("DATA", new Date())
               .setParameter("STATO", StatoElaborazione.AVVIATO.name()).executeUpdate();
   }

   // @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
   public void errore(Long id) throws Exception
   {
      getEm().createNativeQuery(
               "UPDATE Elaborazione as E SET E.StatoElaborazione = :STATO, E.dataEnd = :DATA WHERE E.ID = :ID")
               .setParameter("ID", id)
               .setParameter("DATA", new Date())
               .setParameter("STATO", StatoElaborazione.ERRORE.name()).executeUpdate();
   }

   public void eseguito(Long id) throws Exception
   {
      getEm().createNativeQuery(
               "UPDATE Elaborazione as E SET E.StatoElaborazione = :STATO, "
                        + " E.dataEnd = :DATA WHERE E.ID = :ID")
               .setParameter("ID", id)
               .setParameter("DATA", new Date())
               .setParameter("STATO", StatoElaborazione.ESEGUITO.name()).executeUpdate();
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
            query = "DELETE FROM Flussoa1 WHERE elaborazione_id = :ID";
            break;
         case A2:
            query = "DELETE FROM Flussoa2 WHERE elaborazione_id = :ID";
            break;
         case A2R:
            query = "DELETE FROM Flussoa2 WHERE elaborazione_id = :ID";
            break;
         case B:
            query = null;
            break;
         case C1:
            query = "DELETE FROM Flussoc1 WHERE elaborazione_id = :ID";
            break;
         case C2:
            query = "DELETE FROM Flussoc2 WHERE elaborazione_id = :ID";
            break;
         case C2R:
            query = "DELETE FROM Flussoc2r WHERE elaborazione_id = :ID";
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
}