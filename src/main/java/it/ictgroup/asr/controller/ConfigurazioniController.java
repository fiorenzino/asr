package it.ictgroup.asr.controller;

import it.ictgroup.asr.model.Configurazione;
import it.ictgroup.asr.repository.ConfigurazioniRepository;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.giavacms.commons.annotation.EditPage;
import org.giavacms.commons.annotation.ListPage;
import org.giavacms.commons.annotation.OwnRepository;
import org.giavacms.commons.annotation.ViewPage;
import org.giavacms.commons.controller.AbstractLazyController;

@Named
@SessionScoped
public class ConfigurazioniController extends AbstractLazyController<Configurazione>
         implements Serializable
{

   private static final long serialVersionUID = 1L;

   @EditPage
   protected static final String EDIT_PAGE = "/configurazioni/edit.xhtml";

   @ListPage
   @ViewPage
   protected static final String LIST_PAGE = "/configurazioni/list.xhtml";

   @Inject
   @OwnRepository(ConfigurazioniRepository.class)
   ConfigurazioniRepository configurazioniRepository;

}