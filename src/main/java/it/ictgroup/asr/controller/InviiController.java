package it.ictgroup.asr.controller;

import it.ictgroup.asr.model.Configurazione;
import it.ictgroup.asr.model.Invio;
import it.ictgroup.asr.model.enums.StatoInvio;
import it.ictgroup.asr.repository.ConfigurazioniRepository;
import it.ictgroup.asr.repository.InviiRepository;
import it.ictgroup.asr.service.InviiService;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.giavacms.commons.annotation.EditPage;
import org.giavacms.commons.annotation.ListPage;
import org.giavacms.commons.annotation.OwnRepository;
import org.giavacms.commons.annotation.ViewPage;
import org.giavacms.commons.controller.AbstractLazyController;
import org.giavacms.commons.util.FacesMessageUtils;
import org.primefaces.model.UploadedFile;

@Named
@SessionScoped
public class InviiController extends AbstractLazyController<Invio>
         implements Serializable
{

   private static final long serialVersionUID = 1L;

   @EditPage
   protected static final String EDIT_PAGE = "/invii/edit.xhtml";

   @ListPage
   @ViewPage
   protected static final String LIST_PAGE = "/invii/list.xhtml";

   @Inject
   @OwnRepository(InviiRepository.class)
   InviiRepository inviiRepository;

   @Inject
   ConfigurazioniRepository configurazioniRepository;

   @Inject
   InviiService inviiService;

   private UploadedFile file;

   private Configurazione configurazione;

   public Configurazione getConfigurazione()
   {
      if (configurazione == null)
         this.configurazione = new Configurazione();
      return configurazione;
   }

   public void setConfigurazione(Configurazione configurazione)
   {
      this.configurazione = configurazione;
   }

   public UploadedFile getFile()
   {
      return file;
   }

   public void setFile(UploadedFile file)
   {
      this.file = file;
   }

   public String verificaInvii()
   {
      try
      {
         inviiService.verificaInvii_async();
         FacesMessageUtils
                  .addFacesMessage("Lancio Verifica Invii effettuata con successo. Attenzione: il processo puo' durare diversi minuti.");
      }
      catch (Exception e)
      {
         FacesMessageUtils.addFacesMessage("Eccezione durante il lancio della verifica invii!");
      }
      return null;
   }

   public String correggiErrori()
   {
      try
      {
         inviiService.correggiErrori();
         FacesMessageUtils
                  .addFacesMessage("Lancio correzione errori effettuata con successo. Attenzione: il processo puo' durare diversi minuti.");
      }
      catch (Exception e)
      {
         FacesMessageUtils.addFacesMessage("Eccezione durante il lancio della correzione errori!");
      }
      return null;
   }

   public String caricaFileRisposta()
   {
      setFile(null);
      setConfigurazione(null);
      return modElement();
   }

   public String elimina()
   {
      Invio invio = (Invio) getModel().getRowData();

      // ELIMINO TUTTE LE ELABORAZIONI COINVOLTE

      // ELIMINO INVIO
      FacesMessageUtils.addFacesMessage("Non ancora implementato");
      return null;
   }

   public String correggiSingolo()
   {
      Invio invio = (Invio) getModel().getRowData();
      inviiService.correggiSingolo(invio);
      FacesMessageUtils.addFacesMessage("Procedo con invio errori");
      return null;
   }

   public String segnaSenzaErrori()
   {
      Invio invio = getModel().getRowData();
      invio.setApplicatiErrori(true);
      invio.setStatoInvio(StatoInvio.ESITATO_SENZA_ERRORI);
      inviiRepository.update(invio);
      FacesMessageUtils.addFacesMessage("Aggiornato con successo");
      return null;
   }

   public String caricaFile()
   {
      if (file == null)
      {
         FacesMessageUtils.addFacesMessage("file nullo");
         return null;

      }
      if (getConfigurazione().getId() == null)
      {
         FacesMessageUtils.addFacesMessage("configurazione non selezionata");
         return null;
      }
      this.configurazione = configurazioniRepository.find(getConfigurazione().getId());
      String nomeFile = null;
      switch (getElement().getTipologiaInvio())
      {
      case A:
         nomeFile = getConfigurazione().getFolder() + getElement().getSigla()
                  + getConfigurazione().getPostfisso().replace("*", "");
         break;
      case C:
         nomeFile = getConfigurazione().getFolder() + getElement().getSigla()
                  + getConfigurazione().getPostfisso().replace("*", "");
         break;

      default:
         FacesMessageUtils.addFacesMessage("non so come gestire questa tipologia");
         return null;
      }
      try
      {
         byte[] content = file.getContents();
         String contentType = file.getContentType();
         byte[] bites = IOUtils.toByteArray(file.getInputstream());
         System.out
                  .println("content size: " + (content != null ? content.length : 0) + ", contentType: " + contentType
                           + (bites != null ? bites.length : 0));

         FileUtils.writeByteArrayToFile(new File(nomeFile), bites);
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }

      return listPage();
   }

}