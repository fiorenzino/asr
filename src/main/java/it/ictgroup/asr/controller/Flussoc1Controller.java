package it.ictgroup.asr.controller;

import it.coopservice.commons2.annotations.EditPage;
import it.coopservice.commons2.annotations.ListPage;
import it.coopservice.commons2.annotations.OwnRepository;
import it.coopservice.commons2.annotations.ViewPage;
import it.coopservice.commons2.controllers.AbstractLazyController;
import it.ictgroup.asr.model.Flussoc1;
import it.ictgroup.asr.repository.Flussoc1Repository;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class Flussoc1Controller extends AbstractLazyController<Flussoc1>
         implements Serializable
{

   private static final long serialVersionUID = 1L;

   @EditPage
   protected static final String EDIT_PAGE = "/flussoc1/edit.xhtml";

   @ViewPage
   protected static final String VIEW_PAGE = "/flussoc1/view.xhtml";

   @ListPage
   protected static final String LIST_PAGE = "/flussoc1/list.xhtml";

   @Inject
   @OwnRepository(Flussoc1Repository.class)
   Flussoc1Repository flussoc1Repository;

}