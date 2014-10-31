package it.ictgroup.asr.controller;

import it.coopservice.commons2.annotations.EditPage;
import it.coopservice.commons2.annotations.ListPage;
import it.coopservice.commons2.annotations.OwnRepository;
import it.coopservice.commons2.annotations.ViewPage;
import it.coopservice.commons2.controllers.AbstractLazyController;
import it.ictgroup.asr.model.Configurazione;
import it.ictgroup.asr.repository.ConfigurazioniRepository;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class ConfigurazioniController extends AbstractLazyController<Configurazione>
         implements Serializable
{

   private static final long serialVersionUID = 1L;

   @EditPage
   protected static final String EDIT_PAGE = "/clienti/edit.xhtml";

   @ViewPage
   protected static final String VIEW_PAGE = "/clienti/view.xhtml";

   @ListPage
   protected static final String LIST_PAGE = "/clienti/list.xhtml";

   @Inject
   @OwnRepository(ConfigurazioniRepository.class)
   ConfigurazioniRepository configurazioniRepository;

}