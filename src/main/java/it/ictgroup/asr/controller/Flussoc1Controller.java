package it.ictgroup.asr.controller;

import it.ictgroup.asr.model.Flussoc1;
import it.ictgroup.asr.repository.Flussoc1Repository;

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