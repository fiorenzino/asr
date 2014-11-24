package it.ictgroup.asr.controller;

import it.ictgroup.asr.model.Applicazione;
import it.ictgroup.asr.model.Configurazione;
import it.ictgroup.asr.model.Elaborazione;
import it.ictgroup.asr.repository.ApplicazioniRepository;
import it.ictgroup.asr.repository.ConfigurazioniRepository;
import it.ictgroup.asr.repository.ElaborazioniRepository;
import it.ictgroup.asr.service.FolderService;
import it.ictgroup.asr.util.SiglaUtils;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

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
public class ElaborazioniController extends AbstractLazyController<Elaborazione>
         implements Serializable
{

   private static final long serialVersionUID = 1L;

   @EditPage
   protected static final String EDIT_PAGE = "/elaborazioni/edit.xhtml";

   @ViewPage
   protected static final String VIEW_PAGE = "/elaborazioni/view.xhtml";

   @ListPage
   protected static final String LIST_PAGE = "/elaborazioni/list.xhtml";

   @Inject
   @OwnRepository(ElaborazioniRepository.class)
   ElaborazioniRepository elaborazioniRepository;

   @Inject
   ConfigurazioniRepository configurazioniRepository;

   @Inject
   FolderService folderService;

   @Inject
   ApplicazioniRepository applicazioniRepository;

   private UploadedFile file1;
   private Configurazione configurazione;
   private Applicazione applicazione;
   private Date dataPeriodoDa;
   private Date dataPeriodoA;

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

   public UploadedFile getFile1()
   {
      return file1;
   }

   public void setFile1(UploadedFile file1)
   {
      this.file1 = file1;
   }

   public Applicazione getApplicazione()
   {
      if (this.applicazione == null)
         this.applicazione = new Applicazione();
      return applicazione;
   }

   public void setApplicazione(Applicazione applicazione)
   {
      this.applicazione = applicazione;
   }

   public Date getDataPeriodoDa()
   {
      return dataPeriodoDa;
   }

   public void setDataPeriodoDa(Date dataPeriodoDa)
   {
      this.dataPeriodoDa = dataPeriodoDa;
   }

   public Date getDataPeriodoA()
   {
      return dataPeriodoA;
   }

   public void setDataPeriodoA(Date dataPeriodoA)
   {
      this.dataPeriodoA = dataPeriodoA;
   }

   public String caricaFile()
   {
      setFile1(null);
      setConfigurazione(null);
      setApplicazione(null);
      return editPage();
   }

   public String salvaFile()
   {
      if (file1 == null)
      {
         FacesMessageUtils.addFacesMessage("file nullo");
         return null;

      }
      if (getConfigurazione().getId() == null)
      {
         FacesMessageUtils.addFacesMessage("configurazione non selezionata");
         return null;
      }
      if (getApplicazione().getId() == null)
      {
         FacesMessageUtils.addFacesMessage("applicazione non selezionata");
         return null;
      }
      this.configurazione = configurazioniRepository.find(getConfigurazione().getId());
      this.applicazione = applicazioniRepository.find(getApplicazione().getId());
      String nomeFile = null;
      try
      {
         nomeFile = getConfigurazione().getFolder() + getApplicazione().getSigla() + "-"
                  + SiglaUtils.getPeriodoString(dataPeriodoA) + "-" + SiglaUtils.getPeriodoString(dataPeriodoDa)
                  + getConfigurazione().getPostfisso().replace("*", "");
         logger.info("carico il file: " + nomeFile);
      }
      catch (Exception e)
      {
         FacesMessageUtils.addFacesMessage("Errore nella creazione del nome file");
         return null;
      }
      File file = new File(nomeFile);
      if (file.exists())
      {
         FacesMessageUtils.addFacesMessage("Il file " + nomeFile + " esiste gia'! Non posso sovrascriverlo!");
         return null;
      }
      try
      {
         byte[] bites = IOUtils.toByteArray(file1.getInputstream());
         System.out
                  .println("bytes: " + (bites != null ? bites.length : 0));

         FileUtils.writeByteArrayToFile(file, bites);
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }

      return listPage();
   }

   @Override
   public String view(Object key)
   {
      setElement(getRepository().fetch(key));

      // impostazioni locali
      // da specializzare in sottoclassi
      // settaggi nel super handler
      setEditMode(false);
      setReadOnlyMode(true);
      // vista di destinazione
      return viewPage();
   }

   public String edit(Object key)
   {
      setElement(getRepository().fetch(key));

      // impostazioni locali
      // da specializzare in sottoclassi
      // settaggi nel super handler
      setEditMode(true);
      setReadOnlyMode(false);
      // vista di destinazione
      return editPage();
   }

   public String cercaPerSigla(String sigla)
   {
      reset();
      getSearch().getObj().setFileName(sigla);
      super.refreshModel();
      return listPage();
   }

   @Override
   public String delete()
   {
      Elaborazione elaborazione = (Elaborazione) getModel().getRowData();
      try
      {
         elaborazioniRepository.eliminaConRigheFlusso(elaborazione.getId());
      }
      catch (Exception e)
      {
         e.printStackTrace();
         FacesMessageUtils.addFacesMessage("Errore durante eliminazione!");
         return null;
      }
      return listPage();
   }

   public String restart()
   {
      Elaborazione elaborazione = (Elaborazione) getModel().getRowData();
      try
      {
         elaborazioniRepository.eliminaConRigheFlusso(elaborazione.getId());
      }
      catch (Exception e)
      {
         e.printStackTrace();
         FacesMessageUtils.addFacesMessage("Errore durante eliminazione!");
         return null;
      }

      try
      {
         folderService.lancia(elaborazione.getFileName(), elaborazione.getConfigurazione());
      }
      catch (Exception e)
      {
         e.printStackTrace();
         FacesMessageUtils.addFacesMessage("Errore durante lancio elaborazione!");
         return null;
      }
      return listPage();
   }

   public String elabora()
   {
      try
      {
         folderService.verifica();
         FacesMessageUtils
                  .addFacesMessage("Lancio elaborazione effettuata con successo. Attenzione: il processo puo' durare diversi minuti.");
      }
      catch (Exception e)
      {
         FacesMessageUtils.addFacesMessage("Eccezione durante il lancio!");
      }
      return null;
   }

}