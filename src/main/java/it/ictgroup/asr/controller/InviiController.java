package it.ictgroup.asr.controller;

import it.ictgroup.asr.model.Invio;
import it.ictgroup.asr.model.enums.StatoInvio;
import it.ictgroup.asr.repository.InviiRepository;
import it.ictgroup.asr.service.InviiService;

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
public class InviiController extends AbstractLazyController<Invio>
         implements Serializable
{

   private static final long serialVersionUID = 1L;

   @EditPage
   protected static final String EDIT_PAGE = "/invii/edit.xhtml";

   @ListPage
   @ViewPage
   protected static final String LIST_PAGE = "/invii/list.xhtml";

   @Inject
   @OwnRepository(InviiRepository.class)
   InviiRepository inviiRepository;

   @Inject
   InviiService inviiService;

   public String elabora()
   {
      try
      {
         inviiService.verifica();
         FacesMessageUtils.addFacesMessage("Verifica Invii effettuata con successo.");
      }
      catch (Exception e)
      {
         FacesMessageUtils.addFacesMessage("Eccezione durante la verifica invii!");
      }
      return null;
   }

   public String caricaFileRisposta()
   {
      return modElement();
   }

   public String segnaSenzaErrori()
   {
      Invio invio = getModel().getRowData();
      invio.setStatoInvio(StatoInvio.ESISTATO_SENZA_ERRORI);
      inviiRepository.update(invio);
      FacesMessageUtils.addFacesMessage("Aggiornato con successo");
      return null;
   }

}