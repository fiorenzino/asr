package it.ictgroup.asr.controller;

import it.ictgroup.asr.model.Applicazione;
import it.ictgroup.asr.repository.ApplicazioniRepository;

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
public class ApplicazioniController extends AbstractLazyController<Applicazione>
         implements Serializable
{

   private static final long serialVersionUID = 1L;

   @EditPage
   protected static final String EDIT_PAGE = "/applicazioni/edit.xhtml";

   @ListPage
   @ViewPage
   protected static final String LIST_PAGE = "/applicazioni/list.xhtml";

   @Inject
   @OwnRepository(ApplicazioniRepository.class)
   ApplicazioniRepository applicazioniRepository;

}