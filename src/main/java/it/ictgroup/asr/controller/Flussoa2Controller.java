package it.ictgroup.asr.controller;

import it.coopservice.commons2.annotations.EditPage;
import it.coopservice.commons2.annotations.ListPage;
import it.coopservice.commons2.annotations.OwnRepository;
import it.coopservice.commons2.annotations.ViewPage;
import it.coopservice.commons2.controllers.AbstractLazyController;
import it.ictgroup.asr.model.Flussoa2;
import it.ictgroup.asr.repository.Flussoa2Repository;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class Flussoa2Controller extends AbstractLazyController<Flussoa2>
         implements Serializable
{

   private static final long serialVersionUID = 1L;

   @EditPage
   protected static final String EDIT_PAGE = "/flussoa/edit.xhtml";

   @ViewPage
   protected static final String VIEW_PAGE = "/flussoa/view.xhtml";

   @ListPage
   protected static final String LIST_PAGE = "/flussoa/list.xhtml";

   @Inject
   @OwnRepository(Flussoa2Repository.class)
   Flussoa2Repository flussoa2Repository;

}