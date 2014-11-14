package it.ictgroup.asr.controller;

import it.ictgroup.asr.model.Flussoa1;
import it.ictgroup.asr.repository.Flussoa1Repository;

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