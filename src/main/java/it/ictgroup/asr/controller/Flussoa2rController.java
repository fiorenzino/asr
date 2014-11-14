package it.ictgroup.asr.controller;

import it.ictgroup.asr.model.Flussoa2r;
import it.ictgroup.asr.repository.Flussoa2rRepository;

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
public class Flussoa2rController extends AbstractLazyController<Flussoa2r>
         implements Serializable
{

   private static final long serialVersionUID = 1L;

   @EditPage
   protected static final String EDIT_PAGE = "/flussoar/edit.xhtml";

   @ViewPage
   protected static final String VIEW_PAGE = "/flussoar/view.xhtml";

   @ListPage
   protected static final String LIST_PAGE = "/flussoar/list.xhtml";

   @Inject
   @OwnRepository(Flussoa2rRepository.class)
   Flussoa2rRepository flussoa2rRepository;

}