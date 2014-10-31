package it.ictgroup.asr.controller;

import it.coopservice.commons2.annotations.EditPage;
import it.coopservice.commons2.annotations.ListPage;
import it.coopservice.commons2.annotations.OwnRepository;
import it.coopservice.commons2.annotations.ViewPage;
import it.coopservice.commons2.controllers.AbstractLazyController;
import it.ictgroup.asr.model.Flussoa1;
import it.ictgroup.asr.repository.Flussoa1Repository;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class Flussoa1Controller extends AbstractLazyController<Flussoa1>
         implements Serializable
{

   private static final long serialVersionUID = 1L;

   @EditPage
   protected static final String EDIT_PAGE = "/flussoa1/edit.xhtml";

   @ViewPage
   protected static final String VIEW_PAGE = "/flussoa1/view.xhtml";

   @ListPage
   protected static final String LIST_PAGE = "/flussoa1/list.xhtml";

   @Inject
   @OwnRepository(Flussoa1Repository.class)
   Flussoa1Repository clientiRepository;

  

}