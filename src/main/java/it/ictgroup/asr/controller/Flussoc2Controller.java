package it.ictgroup.asr.controller;

import it.coopservice.commons2.annotations.EditPage;
import it.coopservice.commons2.annotations.ListPage;
import it.coopservice.commons2.annotations.OwnRepository;
import it.coopservice.commons2.annotations.ViewPage;
import it.coopservice.commons2.controllers.AbstractLazyController;
import it.ictgroup.asr.model.Flussoc2;
import it.ictgroup.asr.repository.Flussoc2Repository;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class Flussoc2Controller extends AbstractLazyController<Flussoc2>
         implements Serializable
{

   private static final long serialVersionUID = 1L;

   @EditPage
   protected static final String EDIT_PAGE = "/flussoc2/edit.xhtml";

   @ViewPage
   protected static final String VIEW_PAGE = "/flussoc2/view.xhtml";

   @ListPage
   protected static final String LIST_PAGE = "/flussoc2/list.xhtml";

   @Inject
   @OwnRepository(Flussoc2Repository.class)
   Flussoc2Repository flussoc2Repository;

}