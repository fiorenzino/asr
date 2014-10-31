package it.ictgroup.asr.model;

import it.ictgroup.asr.model.enums.StatoElaborazione;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
   private Date data;
   private String fileName;
   private StatoElaborazione statoElaborazione;

   public Elaborazione()
   {
   }

   public Elaborazione(
            Configurazione configurazione,
            Date data,
            String fileName)
   {
      this.configurazione = configurazione;
      this.data = data;
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

   @ManyToOne
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

   public Date getData()
   {
      return data;
   }

   public void setData(Date data)
   {
      this.data = data;
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
}
