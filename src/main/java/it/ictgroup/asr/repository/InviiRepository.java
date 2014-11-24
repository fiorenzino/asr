package it.ictgroup.asr.repository;

import it.ictgroup.asr.model.Invio;
import it.ictgroup.asr.model.enums.StatoInvio;
import it.ictgroup.asr.model.enums.TipologiaInvio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.giavacms.commons.model.Search;

@Stateless
@LocalBean
public class InviiRepository extends BaseRepository<Invio>
{

   private static final long serialVersionUID = 1L;

   @Override
   protected String getDefaultOrderBy()
   {
      return " id asc ";
   }

   @Override
   protected void applyRestrictions(Search<Invio> search, String alias,
            String separator, StringBuffer sb, Map<String, Object> params)
   {

      // id;
      if (search.getObj().getId() != null)
      {
         sb.append(separator).append(alias)
                  .append(".id = :id ");
         params.put("id", search.getObj().getId());
         separator = " and ";
      }

      // tipologia di invio
      if (search.getObj().getTipologiaInvio() != null)
      {
         sb.append(separator).append(alias)
                  .append(".tipologiaInvio = :tipologiaInvio ");
         params.put("tipologiaInvio", search.getObj().getTipologiaInvio());
         separator = " and ";
      }

      // statoInvio
      if (search.getObj().getStatoInvio() != null)
      {
         sb.append(separator).append(alias)
                  .append(".statoInvio = :statoInvio ");
         params.put("statoInvio", search.getObj().getStatoInvio());
         separator = " and ";
      }

      // applicazione id
      if (search.getObj().getApplicazione() != null && search.getObj().getApplicazione().getId() != null)
      {
         sb.append(separator).append(alias)
                  .append(".applicazione.id = :applicazioneId ");
         params.put("applicazioneId", search.getObj().getApplicazione().getId());
         separator = " and ";
      }

      // sigla
      if (search.getObj().getSigla() != null && !search.getObj().getSigla().trim().isEmpty())
      {
         sb.append(separator).append(alias)
                  .append(".sigla = :sigla ");
         params.put("sigla", search.getObj().getSigla().trim());
         separator = " and ";
      }

   }

   @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
   public Invio getInvioBySiglaAndTipo(String sigla, TipologiaInvio tipologiaInvio)
   {
      Invio invio = null;
      try
      {
         invio = getEm()
                  .createQuery(
                           "select i from " + Invio.class.getSimpleName()
                                    + " i where i.sigla = :SIGLA and i.tipologiaInvio = :TIPOLOGIA",
                           Invio.class).setParameter("TIPOLOGIA", tipologiaInvio)
                  .setParameter("SIGLA", sigla).getSingleResult();
         invio.getApplicazione().getNome();
         if (invio.getFile1() != null && invio.getFile1().getConfigurazione() != null)
         {
            invio.getFile1().getConfigurazione().getTipologiaFlusso();
         }
         if (invio.getFile2() != null && invio.getFile2().getConfigurazione() != null)
         {
            invio.getFile2().getConfigurazione().getTipologiaFlusso();
         }
         if (invio.getFileRitorno() != null && invio.getFileRitorno().getConfigurazione() != null)
         {
            invio.getFileRitorno().getConfigurazione().getTipologiaFlusso();
         }

      }
      catch (Exception e)
      {
         logger.info(e.getMessage());
      }

      return invio;
   }

   @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
   public List<Invio> getInviiDaCorreggere()
   {
      // TODO OTTIMIZZARE QUERY CON FETCH DELLE CONFIGURAZIONI
      List<Invio> invii = new ArrayList<Invio>();
      try
      {
         invii = getEm()
                  .createQuery(
                           "select i from " + Invio.class.getSimpleName()
                                    + " i where i.applicatiErrori = :APPLICA "
                                    + " and i.statoInvio = :STATO",
                           Invio.class)
                  .setParameter("APPLICA", false)
                  .setParameter("STATO", StatoInvio.ESITATO_CON_ERRORI).getResultList();
         for (Invio invio : invii)
         {
            invio.getApplicazione().getNome();
            if (invio.getFile1() != null && invio.getFile1().getConfigurazione() != null)
            {
               invio.getFile1().getConfigurazione().getTipologiaFlusso();
            }
            if (invio.getFile2() != null && invio.getFile2().getConfigurazione() != null)
            {
               invio.getFile2().getConfigurazione().getTipologiaFlusso();
            }
            if (invio.getFileRitorno() != null && invio.getFileRitorno().getConfigurazione() != null)
            {
               invio.getFileRitorno().getConfigurazione().getTipologiaFlusso();
            }
         }

      }
      catch (Exception e)
      {
         logger.info(e.getMessage());
      }

      return invii;
   }

   @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
   public void updateStato(Long id, StatoInvio statoInvio) throws Exception
   {
      getEm().createNativeQuery(
               "UPDATE " + Invio.TABLE_NAME + " SET statoInvio = :STATO WHERE id = :ID")
               .setParameter("ID", id)
               .setParameter("STATO", statoInvio.name()).executeUpdate();
   }

   @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
   public <T> T persist_newtx(T t) throws Exception
   {
      getEm().persist(t);
      return t;
   }

   @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
   public void updateLavorazioneErrori(Long idInvio)
   {
      getEm().createNativeQuery(
               "UPDATE " + Invio.TABLE_NAME + " SET applicatiErrori = :APPLICATIERRORI WHERE id = :ID")
               .setParameter("ID", idInvio)
               .setParameter("APPLICATIERRORI", true).executeUpdate();

   }
}