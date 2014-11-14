package it.ictgroup.asr.controller;

import it.ictgroup.asr.model.Flussoc2r;
import it.ictgroup.asr.repository.Flussoc2rRepository;

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
public class Flussoc2rController extends AbstractLazyController<Flussoc2r>
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
   @OwnRepository(Flussoc2rRepository.class)
   Flussoc2rRepository flussoc2rRepository;

}