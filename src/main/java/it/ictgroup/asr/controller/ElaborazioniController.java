package it.ictgroup.asr.controller;

import it.coopservice.commons2.annotations.EditPage;
import it.coopservice.commons2.annotations.ListPage;
import it.coopservice.commons2.annotations.OwnRepository;
import it.coopservice.commons2.annotations.ViewPage;
import it.coopservice.commons2.controllers.AbstractLazyController;
import it.ictgroup.asr.model.Elaborazione;
import it.ictgroup.asr.repository.ElaborazioniRepository;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

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

}