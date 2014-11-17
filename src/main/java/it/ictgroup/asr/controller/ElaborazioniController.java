package it.ictgroup.asr.controller;

import it.ictgroup.asr.model.Elaborazione;
import it.ictgroup.asr.repository.ElaborazioniRepository;
import it.ictgroup.asr.service.FolderService;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.giavacms.commons.annotation.EditPage;
import org.giavacms.commons.annotation.ListPage;
import org.giavacms.commons.annotation.OwnRepository;
import org.giavacms.commons.annotation.ViewPage;
import org.giavacms.commons.controller.AbstractLazyController;
import org.giavacms.commons.util.FacesMessageUtils;

@Named
@SessionScoped
public class ElaborazioniController extends AbstractLazyController<Elaborazione>
         implements Serializable
{

   private static final long serialVersionUID = 1L;

   @EditPage
   protected static final String EDIT_PAGE = "/elaborazioni/edit.xhtml";

   @ViewPage
   protected static final String VIEW_PAGE = "/elaborazioni/view.xhtml";

   @ListPage
   protected static final String LIST_PAGE = "/elaborazioni/list.xhtml";

   @Inject
   @OwnRepository(ElaborazioniRepository.class)
   ElaborazioniRepository elaborazioniRepository;

   @Inject
   FolderService folderService;

   @Inject
   Flussoa1Controller flussoa1Controller;

   @Inject
   Flussoa2Controller flussoa2Controller;

   @Inject
   Flussoa2rController flussoa2rController;

   @Inject
   Flussoc1Controller flussoc1Controller;

   @Inject
   Flussoc2Controller flussoc2Controller;

   @Inject
   Flussoc2rController flussoc2rController;

   @Override
   public String viewElement()
   {
      Elaborazione elaborazione = (Elaborazione) getModel().getRowData();
      elaborazione = getRepository().fetch(elaborazione.getId());
      setElement(elaborazione);
      switch (getElement().getConfigurazione().getTipologiaFlusso())
      {
      case A1:
         flussoa1Controller.reset();
         flussoa1Controller.getSearch().getObj().setElaborazione(getElement());
         flussoa1Controller.refreshModel();
         break;
      case A2:
         flussoa2Controller.reset();
         flussoa2Controller.getSearch().getObj().setElaborazione(getElement());
         flussoa2Controller.refreshModel();
         break;
      case A2R:
         flussoa2rController.reset();
         flussoa2rController.getSearch().getObj().setElaborazione(getElement());
         flussoa2rController.refreshModel();
         break;
      case C1:
         flussoc1Controller.reset();
         flussoc1Controller.getSearch().getObj().setElaborazione(getElement());
         flussoc1Controller.refreshModel();
         break;
      case C2:
         flussoc2Controller.reset();
         flussoc2Controller.getSearch().getObj().setElaborazione(getElement());
         flussoc2Controller.refreshModel();
         break;
      case C2R:
         flussoc2rController.reset();
         flussoc2rController.getSearch().getObj().setElaborazione(getElement());
         flussoc2rController.refreshModel();
         break;

      default:
         FacesMessageUtils.addFacesMessage("Errore non conosco la tipologia di flusso");
         return null;
      }
      return super.viewElement();
   }

   @Override
   public String view(Object key)
   {
      setElement(getRepository().fetch(key));

      // impostazioni locali
      // da specializzare in sottoclassi
      // settaggi nel super handler
      setEditMode(false);
      setReadOnlyMode(true);
      // vista di destinazione
      return viewPage();
   }

   public String edit(Object key)
   {
      setElement(getRepository().fetch(key));

      // impostazioni locali
      // da specializzare in sottoclassi
      // settaggi nel super handler
      setEditMode(true);
      setReadOnlyMode(false);
      // vista di destinazione
      return editPage();
   }

   @Override
   public String delete()
   {
      Elaborazione elaborazione = (Elaborazione) getModel().getRowData();
      try
      {
         elaborazioniRepository.eliminaConRigheFlusso(elaborazione.getId());
      }
      catch (Exception e)
      {
         e.printStackTrace();
         FacesMessageUtils.addFacesMessage("Errore durante eliminazione!");
         return null;
      }
      return listPage();
   }

   public String restart()
   {
      Elaborazione elaborazione = (Elaborazione) getModel().getRowData();
      try
      {
         elaborazioniRepository.eliminaConRigheFlusso(elaborazione.getId());
      }
      catch (Exception e)
      {
         e.printStackTrace();
         FacesMessageUtils.addFacesMessage("Errore durante eliminazione!");
         return null;
      }

      folderService.lancia(elaborazione.getFileName(), elaborazione.getConfigurazione());
      return listPage();
   }

   public String elabora()
   {
      try
      {
         folderService.verifica();
         FacesMessageUtils.addFacesMessage("ELaborazione effettuata con successo.");
      }
      catch (Exception e)
      {
         FacesMessageUtils.addFacesMessage("Eccezione durante il lancio!");
      }
      return null;
   }

}