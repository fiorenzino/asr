package it.ictgroup.asr.producer;

import it.ictgroup.asr.model.Configurazione;
import it.ictgroup.asr.model.enums.StatoElaborazione;
import it.ictgroup.asr.model.enums.StatoInvio;
import it.ictgroup.asr.model.enums.TipologiaFlusso;
import it.ictgroup.asr.model.enums.TipologiaInvio;
import it.ictgroup.asr.repository.ConfigurazioniRepository;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.giavacms.commons.producer.AbstractProducer;
import org.giavacms.commons.util.PrimeUtils;
import org.primefaces.model.menu.MenuModel;

@Named
@SessionScoped
public class GlobalProducer extends AbstractProducer
{

   private static final long serialVersionUID = 1L;

   @Inject
   ConfigurazioniRepository configurazioniRepository;

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

   @Produces
   @Named
   public SelectItem[] getStatiInvioItems()
   {
      if (super.getItems().get(StatoInvio.class) == null)
      {
         List<SelectItem> statiElaborazioneItemss = new ArrayList<SelectItem>();
         statiElaborazioneItemss.add(new SelectItem(null, "Stato invio..."));
         for (StatoInvio stato : StatoInvio.values())
         {
            statiElaborazioneItemss.add(new SelectItem(stato));
         }
         super.getItems().put(StatoInvio.class, statiElaborazioneItemss.toArray(new SelectItem[] {}));
      }
      return super.getItems().get(StatoInvio.class);
   }

   @Produces
   @Named
   public SelectItem[] getTipologieInvioItems()
   {
      if (super.getItems().get(TipologiaInvio.class) == null)
      {
         List<SelectItem> tipologieInvioItemss = new ArrayList<SelectItem>();
         tipologieInvioItemss.add(new SelectItem(null, "Tipologia di invio..."));
         for (TipologiaInvio tipologiaInvio : TipologiaInvio.values())
         {
            tipologieInvioItemss.add(new SelectItem(tipologiaInvio));
         }
         super.getItems().put(TipologiaInvio.class, tipologieInvioItemss.toArray(new SelectItem[] {}));
      }
      return super.getItems().get(TipologiaInvio.class);
   }

   @Produces
   @Named
   public MenuModel getBreadCrumbs()
   {
      return PrimeUtils.primeBreadcrumbs();
   }

   public SelectItem[] getConfigurazioniItems(TipologiaInvio tipologiaInvio)
   {
      List<SelectItem> configurazioniItems = new ArrayList<SelectItem>();
      configurazioniItems.add(new SelectItem(null, "configurazione..."));
      for (Configurazione configurazione : configurazioniRepository.getAllList())
      {
         if (configurazione.getTipologiaFlusso().name().startsWith(tipologiaInvio.name())
                  && configurazione.getTipologiaFlusso().name().endsWith("R"))
            configurazioniItems.add(new SelectItem(configurazione.getId(), configurazione.getNome()));
      }
      return configurazioniItems.toArray(new SelectItem[] {});
   }
}
