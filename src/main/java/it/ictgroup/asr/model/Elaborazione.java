package it.ictgroup.asr.model;

import it.ictgroup.asr.model.enums.StatoElaborazione;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Elaborazione implements Serializable
{
   private static final long serialVersionUID = 1L;
   private Long id;
   private Configurazione configurazione;
   private Date dataCreazione;
   private Date dataStart;
   private Date dataEnd;
   private String fileName;
   private StatoElaborazione statoElaborazione;

   public Elaborazione()
   {
   }

   public Elaborazione(
            Configurazione configurazione,
            Date dataCreazione,
            String fileName)
   {
      this.configurazione = configurazione;
      this.dataCreazione = dataCreazione;
      this.fileName = fileName;
      this.statoElaborazione = StatoElaborazione.PIANIFICATO;
   }

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public Long getId()
   {
      return id;
   }

   public void setId(Long id)
   {
      this.id = id;
   }

   @ManyToOne(fetch = FetchType.EAGER)
   public Configurazione getConfigurazione()
   {
      if (this.configurazione == null)
         this.configurazione = new Configurazione();
      return configurazione;
   }

   public void setConfigurazione(Configurazione configurazione)
   {
      this.configurazione = configurazione;
   }

   public String getFileName()
   {
      return fileName;
   }

   public void setFileName(String fileName)
   {
      this.fileName = fileName;
   }

   @Enumerated(EnumType.STRING)
   public StatoElaborazione getStatoElaborazione()
   {
      return statoElaborazione;
   }

   public void setStatoElaborazione(StatoElaborazione statoElaborazione)
   {
      this.statoElaborazione = statoElaborazione;
   }

   public Date getDataStart()
   {
      return dataStart;
   }

   public void setDataStart(Date dataStart)
   {
      this.dataStart = dataStart;
   }

   public Date getDataEnd()
   {
      return dataEnd;
   }

   public void setDataEnd(Date dataEnd)
   {
      this.dataEnd = dataEnd;
   }

   public Date getDataCreazione()
   {
      return dataCreazione;
   }

   public void setDataCreazione(Date dataCreazione)
   {
      this.dataCreazione = dataCreazione;
   }
}
