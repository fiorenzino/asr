package it.ictgroup.asr.flussoc.model;

import org.coury.jfilehelpers.annotations.FieldFixedLength;
import org.coury.jfilehelpers.annotations.FieldOptional;
import org.coury.jfilehelpers.annotations.FixedLengthRecord;
import org.coury.jfilehelpers.enums.FixedMode;

@FixedLengthRecord(fixedMode = FixedMode.AllowVariableLength)
public class Flussoc1
{

   @FieldFixedLength(2)
   @FieldOptional
   // 1-3 Regione addebitante
   private String regioneAddebitante;

   // 4-6 Zona territoriale / Azienda Ospedaliera inviante
   @FieldFixedLength(5)
   private String zonaTerritoriale;

   // 7-12 Codice struttura accettante / richiedente
   @FieldFixedLength(11)
   private String codiceStrutturaAccettante;

   // 13-18 Codice struttura erogante la prestazione
   @FieldFixedLength(17)
   private String codiceStrutturaErogante;

   // 19 Tipologia del medico prescrittore
   @FieldFixedLength(18)
   private String tipologiaMedicoPrescrittore;
   // 20-35 Codice fiscale medico prescrittore
   @FieldFixedLength(34)
   private String codiceFiscalemedicoErogantePrescrittore;
   // 36-51 Codice fiscale del medico che eroga la prestazione
   @FieldFixedLength(50)
   @FieldOptional
   private String codiceFiscalemedicoErogantePrestazione;
   // 52-81 Cognome dell’utente
   @FieldFixedLength(80)
   private String cognomeUtente;
   // 82-101 Nome dell’utente
   @FieldFixedLength(100)
   private String nomeUtente;
   // 102 Sesso dell’utente
   @FieldFixedLength(119)
   @FieldOptional
   private String sesso;
   // 103-110 Data di nascita dell’utente
   @FieldFixedLength(109)
   @FieldOptional
   private String dataNascitaUtente;
   // 111-126 Codice fiscale dell’utente
   @FieldFixedLength(125)
   @FieldOptional
   private String codiceFiscaleUtente;
   // 127-132 Comune di residenza dell’utente
   @FieldFixedLength(131)
   @FieldOptional
   private String comuneResidenzaUtente;
   // 133-135 Regione di residenza dell’utente
   @FieldFixedLength(134)
   @FieldOptional
   private String regioneResidenzaUtente;
   // 136-138 Zona Territoriale/azienda U.S.L. di residenza dell’utente
   @FieldFixedLength(137)
   @FieldOptional
   private String zonaTerritorialeDiResidenza;
   // 139-140 Stato estero risultante nella TEAM
   @FieldFixedLength(139)
   @FieldOptional
   private String statoEstero;
   // 141-168 Istituzione competente
   @FieldFixedLength(167)
   @FieldOptional
   private String istituzioneCompetente;

   // (soggetti assicurati da istituzione estera)
   // Campo 7 della TEAM
   // 169-188 Numero identificazione personale
   @FieldFixedLength(187)
   @FieldOptional
   private String numeroIdentificazionePersonale;
   // (soggetti assicurati da istituzione estera)
   // Campo 6 della TEAM
   // 189-208 Numero identificativo tessera
   @FieldFixedLength(207)
   @FieldOptional
   private String numeroIdentificativoTessera;
   // (soggetti assicurati da istituzione estera)
   // Campo 8 della TEAM
   // 209-216 Scadenza della tessera
   @FieldFixedLength(215)
   @FieldOptional
   private String scadenzaDellaTessera;
   // Campo 9 della TEAM
   // 217-232 Numero ricetta
   @FieldFixedLength(231)
   @FieldOptional
   private String numeroRicetta;
   // 233-234 Progressivo riga per ricetta
   @FieldOptional
   @FieldFixedLength(232)
   private String progressivoPeRigaPerRicetta;
   // 235 Posizione contabile
   @FieldFixedLength(234)
   @FieldOptional
   private String posizioneContabile;
   // 236 Modalità di compilazione ricetta
   @FieldFixedLength(235)
   @FieldOptional
   private String modalitaCompilazioneRicetta;
   // 237 Modalità di rilevazione del codice fiscale
   @FieldFixedLength(236)
   @FieldOptional
   private String modalitaRilevazioneCodiceFiscale;
   // 238 Onere della prestazione
   @FieldFixedLength(237)
   @FieldOptional
   private String onereDellaPrestazione;
   // 239-258 ID
   @FieldFixedLength(257)
   @FieldOptional
   private String id;

   public Flussoc1()
   {
   }

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

   public String getProgressivoPeRigaPerRicetta()
   {
      return progressivoPeRigaPerRicetta;
   }

   public void setProgressivoPeRigaPerRicetta(String progressivoPeRigaPerRicetta)
   {
      this.progressivoPeRigaPerRicetta = progressivoPeRigaPerRicetta;
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
               + (progressivoPeRigaPerRicetta != null ? "progressivoPeRigaPerRicetta=" + progressivoPeRigaPerRicetta
                        + ", " : "")
               + (posizioneContabile != null ? "posizioneContabile=" + posizioneContabile + ", " : "")
               + (modalitaCompilazioneRicetta != null ? "modalitaCompilazioneRicetta=" + modalitaCompilazioneRicetta
                        + ", " : "")
               + (modalitaRilevazioneCodiceFiscale != null ? "modalitaRilevazioneCodiceFiscale="
                        + modalitaRilevazioneCodiceFiscale + ", " : "")
               + (onereDellaPrestazione != null ? "onereDellaPrestazione=" + onereDellaPrestazione + ", " : "")
               + (id != null ? "id=" + id : "") + "]";
   }

}
