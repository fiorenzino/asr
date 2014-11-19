package it.ictgroup.asr.model;

import it.ictgroup.asr.util.annotations.FieldIgnored;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseFlusso implements Serializable
{
   private static final long serialVersionUID = 1L;

   @FieldIgnored
   private Long uid;

   @FieldIgnored
   private Elaborazione elaborazione;

   @FieldIgnored
   private String nomeFile;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public Long getUid()
   {
      return uid;
   }

   public void setUid(Long uid)
   {
      this.uid = uid;
   }

   @ManyToOne
   public Elaborazione getElaborazione()
   {
      if (this.elaborazione == null)
         this.elaborazione = new Elaborazione();
      return elaborazione;
   }

   public void setElaborazione(Elaborazione elaborazione)
   {
      this.elaborazione = elaborazione;
   }

   public String getNomeFile()
   {
      return nomeFile;
   }

   public void setNomeFile(String nomeFile)
   {
      this.nomeFile = nomeFile;
   }
}
