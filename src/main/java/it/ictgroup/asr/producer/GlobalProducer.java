package it.ictgroup.asr.producer;

import it.coopservice.commons2.producer.AbstractProducer;
import it.ictgroup.asr.model.enums.StatoElaborazione;
import it.ictgroup.asr.model.enums.TipologiaFlusso;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.faces.model.SelectItem;
import javax.inject.Named;

@Named
@SessionScoped
public class GlobalProducer extends AbstractProducer
{

   private static final long serialVersionUID = 1L;

   @Produces
   @Named
   public SelectItem[] getTipologieFlussoItems()
   {
      if (super.getItems().get(TipologiaFlusso.class) == null)
      {
         List<SelectItem> tipologieFlussoItemss = new ArrayList<SelectItem>();
         tipologieFlussoItemss.add(new SelectItem(null, "Tipologia flusso..."));
         for (TipologiaFlusso stato : TipologiaFlusso.values())
         {
            tipologieFlussoItemss.add(new SelectItem(stato));
         }
         super.getItems().put(TipologiaFlusso.class, tipologieFlussoItemss.toArray(new SelectItem[] {}));
      }
      return super.getItems().get(TipologiaFlusso.class);
   }

   @Produces
   @Named
   public SelectItem[] getStatiElaborazioneItems()
   {
      if (super.getItems().get(StatoElaborazione.class) == null)
      {
         List<SelectItem> statiElaborazioneItemss = new ArrayList<SelectItem>();
         statiElaborazioneItemss.add(new SelectItem(null, "Stato elaborazione..."));
         for (StatoElaborazione stato : StatoElaborazione.values())
         {
            statiElaborazioneItemss.add(new SelectItem(stato));
         }
         super.getItems().put(StatoElaborazione.class, statiElaborazioneItemss.toArray(new SelectItem[] {}));
      }
      return super.getItems().get(StatoElaborazione.class);
   }

}
