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