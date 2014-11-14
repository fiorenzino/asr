package it.ictgroup.asr.controller;

import it.ictgroup.asr.model.Flussoa2;
import it.ictgroup.asr.repository.Flussoa2Repository;

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