package it.ictgroup.asr.repository;

import it.ictgroup.asr.model.Flussoa2;

import java.util.List;
import java.util.Map;

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
      return " id asc ";
   }

   @Override
   protected void applyRestrictions(Search<Flussoa2> search, String alias,
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