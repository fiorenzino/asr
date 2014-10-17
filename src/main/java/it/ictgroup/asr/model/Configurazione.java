package it.ictgroup.asr.model;

import it.ictgroup.asr.model.enums.flussoc.TipologiaFlusso;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Configurazione implements Serializable
{

   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   private Long id;
   private TipologiaFlusso tipologiaFlusso;
   private String folder;

   public Long getId()
   {
      return id;
   }

   public void setId(Long id)
   {
      this.id = id;
   }

   public TipologiaFlusso getTipologiaFlusso()
   {
      return tipologiaFlusso;
   }

   public void setTipologiaFlusso(TipologiaFlusso tipologiaFlusso)
   {
      this.tipologiaFlusso = tipologiaFlusso;
   }

   public String getFolder()
   {
      return folder;
   }

   public void setFolder(String folder)
   {
      this.folder = folder;
   }

}
