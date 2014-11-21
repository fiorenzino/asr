package it.ictgroup.asr.model;

import it.ictgroup.asr.model.enums.StatoInvio;
import it.ictgroup.asr.model.enums.TipologiaInvio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = Invio.TABLE_NAME)
public class Invio implements Serializable
{

   private static final long serialVersionUID = 1L;
   public static final String TABLE_NAME = "invio";
   private Long id;
   private TipologiaInvio tipologiaInvio;
   private Applicazione applicazione;
   private String sigla;
   private Date periodoDa;
   private Date periodoA;
   private String errori;
   private Elaborazione file1;
   private Elaborazione file2;
   private Elaborazione fileRitorno;
   private StatoInvio statoInvio;

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
   public Applicazione getApplicazione()
   {
      return applicazione;
   }

   public void setApplicazione(Applicazione applicazione)
   {
      this.applicazione = applicazione;
   }

   public Date getPeriodoDa()
   {
      return periodoDa;
   }

   public void setPeriodoDa(Date periodoDa)
   {
      this.periodoDa = periodoDa;
   }

   public Date getPeriodoA()
   {
      return periodoA;
   }

   public void setPeriodoA(Date periodoA)
   {
      this.periodoA = periodoA;
   }

   @Column(length = 1024)
   public String getErrori()
   {
      return errori;
   }

   public void setErrori(String errori)
   {
      this.errori = errori;
   }

   @OneToOne
   public Elaborazione getFile1()
   {
      return file1;
   }

   public void setFile1(Elaborazione file1)
   {
      this.file1 = file1;
   }

   @OneToOne
   public Elaborazione getFile2()
   {
      return file2;
   }

   public void setFile2(Elaborazione file2)
   {
      this.file2 = file2;
   }

   @OneToOne
   public Elaborazione getFileRitorno()
   {
      return fileRitorno;
   }

   public void setFileRitorno(Elaborazione fileRitorno)
   {
      this.fileRitorno = fileRitorno;
   }

   @Enumerated(EnumType.STRING)
   public StatoInvio getStatoInvio()
   {
      return statoInvio;
   }

   public void setStatoInvio(StatoInvio statoInvio)
   {
      this.statoInvio = statoInvio;
   }

   @Enumerated(EnumType.STRING)
   public TipologiaInvio getTipologiaInvio()
   {
      return tipologiaInvio;
   }

   public void setTipologiaInvio(TipologiaInvio tipologiaInvio)
   {
      this.tipologiaInvio = tipologiaInvio;
   }

   public String getSigla()
   {
      return sigla;
   }

   public void setSigla(String sigla)
   {
      this.sigla = sigla;
   }

}
