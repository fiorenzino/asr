package it.ictgroup.asr.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.coury.jfilehelpers.annotations.FieldFixedLength;
import org.coury.jfilehelpers.annotations.FieldIgnored;
import org.coury.jfilehelpers.annotations.FixedLengthRecord;

@FixedLengthRecord
@Entity
public class Flussoc1 implements Serializable
{
   @FieldIgnored
   private static final long serialVersionUID = 1L;

   @FieldIgnored
   private Long uid;

   @FieldFixedLength(3)
   // 1-3 Regione addebitante 3
   private String regioneAddebitante;

   // 4-6 Zona territoriale / Azienda Ospedaliera inviante 3
   @FieldFixedLength(3)
   private String zonaTerritoriale;

   // 7-12 Codice struttura accettante / richiedente 6
   @FieldFixedLength(6)
   private String codiceStrutturaAccettante;

   // 13-18 Codice struttura erogante la prestazione 6
   @FieldFixedLength(6)
   private String codiceStrutturaErogante;

   // 19 Tipologia del medico prescrittore 1
   @FieldFixedLength(1)
   private String tipologiaMedicoPrescrittore;

   // 20-35 Codice fiscale medico prescrittore
   @FieldFixedLength(16)
   private String codiceFiscalemedicoErogantePrescrittore;

   // 36-51 Codice fiscale del medico che eroga la prestazione 16
   @FieldFixedLength(16)
   private String codiceFiscalemedicoErogantePrestazione;

   // 52-81 Cognome dell’utente 30
   @FieldFixedLength(30)
   private String cognomeUtente;

   // 82-101 Nome dell’utente 20
   @FieldFixedLength(20)
   private String nomeUtente;

   // 102 Sesso dell’utente 1
   @FieldFixedLength(1)
   private String sesso;

   // 103-110 Data di nascita dell’utente 8
   @FieldFixedLength(8)
   private String dataNascitaUtente;

   // 111-126 Codice fiscale dell’utente 16
   @FieldFixedLength(16)
   private String codiceFiscaleUtente;

   // 127-132 Comune di residenza dell’utente 3
   @FieldFixedLength(6)
   private String comuneResidenzaUtente;

   // 133-135 Regione di residenza dell’utente 3
   @FieldFixedLength(3)
   private String regioneResidenzaUtente;

   // 136-138 Zona Territoriale/azienda U.S.L. di residenza dell’utente 3
   @FieldFixedLength(3)
   private String zonaTerritorialeDiResidenza;

   // 139-140 Stato estero risultante nella TEAM 2
   @FieldFixedLength(2)
   private String statoEstero;

   // 141-168 Istituzione competente
   // (soggetti assicurati da istituzione estera)
   // Campo 7 della TEAM 28
   @FieldFixedLength(28)
   private String istituzioneCompetente;

   // 169-188 Numero identificazione personale
   // (soggetti assicurati da istituzione estera)
   // Campo 6 della TEAM 20
   @FieldFixedLength(20)
   private String numeroIdentificazionePersonale;

   // 189-208 Numero identificativo tessera
   // (soggetti assicurati da istituzione estera)
   // Campo 8 della TEAM 20
   @FieldFixedLength(20)
   private String numeroIdentificativoTessera;

   // 209-216 Scadenza della tessera
   // Campo 9 della TEAM 8
   @FieldFixedLength(8)
   private String scadenzaDellaTessera;

   // 217-232 Numero ricetta 16
   @FieldFixedLength(16)
   private String numeroRicetta;

   // 233-234 Progressivo riga per ricetta 2
   @FieldFixedLength(2)
   private String progressivoRigaPerRicetta;

   // 235 Posizione contabile 1
   @FieldFixedLength(1)
   private String posizioneContabile;

   // 236 Modalità di compilazione ricetta 1
   @FieldFixedLength(1)
   private String modalitaCompilazioneRicetta;

   // 237 Modalità di rilevazione del codice fiscale 1
   @FieldFixedLength(1)
   private String modalitaRilevazioneCodiceFiscale;

   // 238 Onere della prestazione 1
   @FieldFixedLength(1)
   private String onereDellaPrestazione;

   // 239-258 ID 20
   @FieldFixedLength(20)
   private String id;

   @FieldIgnored
   private String nomeFile;
   @FieldIgnored
   private Elaborazione elaborazione;

   public String getRegioneAddebitante()
   {
      return regioneAddebitante;
   }

   public void setRegioneAddebitante(String regioneAddebitante)
   {
      this.regioneAddebitante = regioneAddebitante;
   }

   public String getZonaTerritoriale()
   {
      return zonaTerritoriale;
   }

   public void setZonaTerritoriale(String zonaTerritoriale)
   {
      this.zonaTerritoriale = zonaTerritoriale;
   }

   public String getCodiceStrutturaAccettante()
   {
      return codiceStrutturaAccettante;
   }

   public void setCodiceStrutturaAccettante(String codiceStrutturaAccettante)
   {
      this.codiceStrutturaAccettante = codiceStrutturaAccettante;
   }

   public String getCodiceStrutturaErogante()
   {
      return codiceStrutturaErogante;
   }

   public void setCodiceStrutturaErogante(String codiceStrutturaErogante)
   {
      this.codiceStrutturaErogante = codiceStrutturaErogante;
   }

   public String getTipologiaMedicoPrescrittore()
   {
      return tipologiaMedicoPrescrittore;
   }

   public void setTipologiaMedicoPrescrittore(String tipologiaMedicoPrescrittore)
   {
      this.tipologiaMedicoPrescrittore = tipologiaMedicoPrescrittore;
   }

   public String getCodiceFiscalemedicoErogantePrescrittore()
   {
      return codiceFiscalemedicoErogantePrescrittore;
   }

   public void setCodiceFiscalemedicoErogantePrescrittore(String codiceFiscalemedicoErogantePrescrittore)
   {
      this.codiceFiscalemedicoErogantePrescrittore = codiceFiscalemedicoErogantePrescrittore;
   }

   public String getCodiceFiscalemedicoErogantePrestazione()
   {
      return codiceFiscalemedicoErogantePrestazione;
   }

   public void setCodiceFiscalemedicoErogantePrestazione(String codiceFiscalemedicoErogantePrestazione)
   {
      this.codiceFiscalemedicoErogantePrestazione = codiceFiscalemedicoErogantePrestazione;
   }

   public String getCognomeUtente()
   {
      return cognomeUtente;
   }

   public void setCognomeUtente(String cognomeUtente)
   {
      this.cognomeUtente = cognomeUtente;
   }

   public String getNomeUtente()
   {
      return nomeUtente;
   }

   public void setNomeUtente(String nomeUtente)
   {
      this.nomeUtente = nomeUtente;
   }

   public String getSesso()
   {
      return sesso;
   }

   public void setSesso(String sesso)
   {
      this.sesso = sesso;
   }

   public String getDataNascitaUtente()
   {
      return dataNascitaUtente;
   }

   public void setDataNascitaUtente(String dataNascitaUtente)
   {
      this.dataNascitaUtente = dataNascitaUtente;
   }

   public String getCodiceFiscaleUtente()
   {
      return codiceFiscaleUtente;
   }

   public void setCodiceFiscaleUtente(String codiceFiscaleUtente)
   {
      this.codiceFiscaleUtente = codiceFiscaleUtente;
   }

   public String getComuneResidenzaUtente()
   {
      return comuneResidenzaUtente;
   }

   public void setComuneResidenzaUtente(String comuneResidenzaUtente)
   {
      this.comuneResidenzaUtente = comuneResidenzaUtente;
   }

   public String getRegioneResidenzaUtente()
   {
      return regioneResidenzaUtente;
   }

   public void setRegioneResidenzaUtente(String regioneResidenzaUtente)
   {
      this.regioneResidenzaUtente = regioneResidenzaUtente;
   }

   public String getZonaTerritorialeDiResidenza()
   {
      return zonaTerritorialeDiResidenza;
   }

   public void setZonaTerritorialeDiResidenza(String zonaTerritorialeDiResidenza)
   {
      this.zonaTerritorialeDiResidenza = zonaTerritorialeDiResidenza;
   }

   public String getStatoEstero()
   {
      return statoEstero;
   }

   public void setStatoEstero(String statoEstero)
   {
      this.statoEstero = statoEstero;
   }

   public String getIstituzioneCompetente()
   {
      return istituzioneCompetente;
   }

   public void setIstituzioneCompetente(String istituzioneCompetente)
   {
      this.istituzioneCompetente = istituzioneCompetente;
   }

   public String getNumeroIdentificazionePersonale()
   {
      return numeroIdentificazionePersonale;
   }

   public void setNumeroIdentificazionePersonale(String numeroIdentificazionePersonale)
   {
      this.numeroIdentificazionePersonale = numeroIdentificazionePersonale;
   }

   public String getNumeroIdentificativoTessera()
   {
      return numeroIdentificativoTessera;
   }

   public void setNumeroIdentificativoTessera(String numeroIdentificativoTessera)
   {
      this.numeroIdentificativoTessera = numeroIdentificativoTessera;
   }

   public String getScadenzaDellaTessera()
   {
      return scadenzaDellaTessera;
   }

   public void setScadenzaDellaTessera(String scadenzaDellaTessera)
   {
      this.scadenzaDellaTessera = scadenzaDellaTessera;
   }

   public String getNumeroRicetta()
   {
      return numeroRicetta;
   }

   public void setNumeroRicetta(String numeroRicetta)
   {
      this.numeroRicetta = numeroRicetta;
   }

   public String getProgressivoRigaPerRicetta()
   {
      return progressivoRigaPerRicetta;
   }

   public void setProgressivoRigaPerRicetta(String progressivoPeRigaPerRicetta)
   {
      this.progressivoRigaPerRicetta = progressivoPeRigaPerRicetta;
   }

   public String getPosizioneContabile()
   {
      return posizioneContabile;
   }

   public void setPosizioneContabile(String posizioneContabile)
   {
      this.posizioneContabile = posizioneContabile;
   }

   public String getModalitaCompilazioneRicetta()
   {
      return modalitaCompilazioneRicetta;
   }

   public void setModalitaCompilazioneRicetta(String modalitaCompilazioneRicetta)
   {
      this.modalitaCompilazioneRicetta = modalitaCompilazioneRicetta;
   }

   public String getModalitaRilevazioneCodiceFiscale()
   {
      return modalitaRilevazioneCodiceFiscale;
   }

   public void setModalitaRilevazioneCodiceFiscale(String modalitaRilevazioneCodiceFiscale)
   {
      this.modalitaRilevazioneCodiceFiscale = modalitaRilevazioneCodiceFiscale;
   }

   public String getOnereDellaPrestazione()
   {
      return onereDellaPrestazione;
   }

   public void setOnereDellaPrestazione(String onereDellaPrestazione)
   {
      this.onereDellaPrestazione = onereDellaPrestazione;
   }

   public String getId()
   {
      return id;
   }

   public void setId(String id)
   {
      this.id = id;
   }

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

   @Override
   public String toString()
   {
      return "Flussoc1 ["
               + (regioneAddebitante != null ? "regioneAddebitante=" + regioneAddebitante + ", " : "")
               + (zonaTerritoriale != null ? "zonaTerritoriale=" + zonaTerritoriale + ", " : "")
               + (codiceStrutturaAccettante != null ? "codiceStrutturaAccettante=" + codiceStrutturaAccettante + ", "
                        : "")
               + (codiceStrutturaErogante != null ? "codiceStrutturaErogante=" + codiceStrutturaErogante + ", " : "")
               + (tipologiaMedicoPrescrittore != null ? "tipologiaMedicoPrescrittore=" + tipologiaMedicoPrescrittore
                        + ", " : "")
               + (codiceFiscalemedicoErogantePrescrittore != null ? "codiceFiscalemedicoErogantePrescrittore="
                        + codiceFiscalemedicoErogantePrescrittore + ", " : "")
               + (codiceFiscalemedicoErogantePrestazione != null ? "codiceFiscalemedicoErogantePrestazione="
                        + codiceFiscalemedicoErogantePrestazione + ", " : "")
               + (cognomeUtente != null ? "cognomeUtente=" + cognomeUtente + ", " : "")
               + (nomeUtente != null ? "nomeUtente=" + nomeUtente + ", " : "")
               + (sesso != null ? "sesso=" + sesso + ", " : "")
               + (dataNascitaUtente != null ? "dataNascitaUtente=" + dataNascitaUtente + ", " : "")
               + (codiceFiscaleUtente != null ? "codiceFiscaleUtente=" + codiceFiscaleUtente + ", " : "")
               + (comuneResidenzaUtente != null ? "comuneResidenzaUtente=" + comuneResidenzaUtente + ", " : "")
               + (regioneResidenzaUtente != null ? "regioneResidenzaUtente=" + regioneResidenzaUtente + ", " : "")
               + (zonaTerritorialeDiResidenza != null ? "zonaTerritorialeDiResidenza=" + zonaTerritorialeDiResidenza
                        + ", " : "")
               + (statoEstero != null ? "statoEstero=" + statoEstero + ", " : "")
               + (istituzioneCompetente != null ? "istituzioneCompetente=" + istituzioneCompetente + ", " : "")
               + (numeroIdentificazionePersonale != null ? "numeroIdentificazionePersonale="
                        + numeroIdentificazionePersonale + ", " : "")
               + (numeroIdentificativoTessera != null ? "numeroIdentificativoTessera=" + numeroIdentificativoTessera
                        + ", " : "")
               + (scadenzaDellaTessera != null ? "scadenzaDellaTessera=" + scadenzaDellaTessera + ", " : "")
               + (numeroRicetta != null ? "numeroRicetta=" + numeroRicetta + ", " : "")
               + (progressivoRigaPerRicetta != null ? "progressivoPeRigaPerRicetta=" + progressivoRigaPerRicetta
                        + ", " : "")
               + (posizioneContabile != null ? "posizioneContabile=" + posizioneContabile + ", " : "")
               + (modalitaCompilazioneRicetta != null ? "modalitaCompilazioneRicetta=" + modalitaCompilazioneRicetta
                        + ", " : "")
               + (modalitaRilevazioneCodiceFiscale != null ? "modalitaRilevazioneCodiceFiscale="
                        + modalitaRilevazioneCodiceFiscale + ", " : "")
               + (onereDellaPrestazione != null ? "onereDellaPrestazione=" + onereDellaPrestazione + ", " : "")
               + (id != null ? "id=" + id : "") + "]";
   }

   public String getNomeFile()
   {
      return nomeFile;
   }

   public void setNomeFile(String nomeFile)
   {
      this.nomeFile = nomeFile;
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

}
