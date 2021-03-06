package it.ictgroup.asr.model;

import java.util.Date;

import it.ictgroup.asr.model.enums.flussoc.TipologiaERR01FlussoC;
import it.ictgroup.asr.model.enums.flussoc.TipologiaERR02FlussoC;
import it.ictgroup.asr.model.enums.flussoc.TipologiaERR03FlussoC;
import it.ictgroup.asr.model.enums.flussoc.TipologiaERR04FlussoC;
import it.ictgroup.asr.model.enums.flussoc.TipologiaERR05FlussoC;
import it.ictgroup.asr.model.enums.flussoc.TipologiaERR06FlussoC;
import it.ictgroup.asr.model.enums.flussoc.TipologiaERR07FlussoC;
import it.ictgroup.asr.model.enums.flussoc.TipologiaERR08FlussoC;
import it.ictgroup.asr.model.enums.flussoc.TipologiaERR10FlussoC;
import it.ictgroup.asr.util.annotations.FieldDatePattern;
import it.ictgroup.asr.util.annotations.FieldFixedLength;
import it.ictgroup.asr.util.annotations.FieldIgnored;
import it.ictgroup.asr.util.annotations.FixedLengthRecord;
import it.ictgroup.asr.util.enums.FixedMode;

import javax.persistence.Entity;
import javax.persistence.Table;

@FixedLengthRecord(fixedMode = FixedMode.AllowVariableLength)
@Entity
@Table(name = Flussoc2r.TABLE_NAME)
public class Flussoc2r extends BaseFlusso
{
   // 16122013 => ddMMyyyy
   // datacompilazionericetta, dataerogazioneprestazioni, datapac, dataprenotazione, dataprimadisponibilitaerogazione,
   // datarefertazione

   @FieldIgnored
   private static final long serialVersionUID = 1L;
   public static final String TABLE_NAME = "flussoc2r";

   // 1-3 Regione addebitante
   @FieldFixedLength(3)
   public String regioneAddebitante;

   // 4-6 Zona Territoriale/Azienda Ospedaliera inviante
   @FieldFixedLength(3)
   public String zonaTerritoriale;

   // 7-12 Codice struttura accettante / richiedente
   @FieldFixedLength(6)
   public String codiceStrutturaAccettante;

   // 13-18 Codice struttura erogante la prestazione
   @FieldFixedLength(6)
   public String codiceStrutturaErogante;

   // 19-28 Codice centro di costo
   @FieldFixedLength(10)
   public String codiceCentroDiCosto;

   // 29-44 Numero ricetta
   @FieldFixedLength(16)
   public String numeroRicetta;

   // 45 Priorità per l’accesso alle prestazioni
   @FieldFixedLength(1)
   public String prioritaAccessoPrestazioni;

   // 46 Effettiva priorità riscontrata al momento dell’esecuzione delle prestazioni
   @FieldFixedLength(1)
   public String effettivaPrioritaRiscontrata;

   // 47 Tipologia di prescrizione
   @FieldFixedLength(1)
   public String tipologiaPrescrizione;

   // 48-49 Tipo ricetta
   @FieldFixedLength(2)
   public String tipoRicetta;

   // 50 Attività richiesta dal pronto soccorso
   @FieldFixedLength(1)
   public String attivitaProntoSoccorso;

   // 51 Prestazione ambulatoriale complessa (PAC)
   @FieldFixedLength(1)
   public String prestazioneAmbulatorialeComplessa;

   // 52 Ciclo di prestazioni
   @FieldFixedLength(1)
   public String cicloPrestazioni;

   // 53-54 Progressivo riga per ricetta
   @FieldFixedLength(2)
   public String progressivoRigaPerRicetta;

   // 55-62 Data di compilazione della ricetta
   @FieldFixedLength(8)
   @FieldDatePattern("ddMMyyyy")
   public Date dataCompilazioneRicetta;

   // 63-70 Data di prima disponibilità di erogazione
   @FieldFixedLength(8)
   @FieldDatePattern("ddMMyyyy")
   public Date dataPrimaDisponibilitaErogazione;

   // 71-78 Data di prenotazione
   @FieldFixedLength(8)
   @FieldDatePattern("ddMMyyyy")
   public Date dataPrenotazione;

   // 79-86 Data inizio Prestazione Ambulatoriale Complessa (PAC) / data inizio ciclo di prestazioni
   @FieldFixedLength(8)
   @FieldDatePattern("ddMMyyyy")
   public Date dataPAC;

   // 87-94 Data di erogazione delle prestazioni
   @FieldFixedLength(8)
   @FieldDatePattern("ddMMyyyy")
   public Date dataErogazionePrestazioni;

   // 95-102 Data di refertazione
   @FieldFixedLength(8)
   @FieldDatePattern("ddMMyyyy")
   public Date dataRefertazione;

   // 103-104 Modalità di accesso alle prestazioni
   @FieldFixedLength(2)
   public String modalitaAccessoPrestazioni;

   // 105 Tipo di accesso
   @FieldFixedLength(1)
   public String tipoAccesso;

   // 106-112 Codice diagnosi/quesito diagnostico
   @FieldFixedLength(7)
   public String codiceDiagnosi;

   // 113 Verifica dell’effettiva presenza del quesito diagnostico
   @FieldFixedLength(1)
   public String verificaPresenzaQuesitoDiagnostico;

   // 114 Codifica nomenclatore
   @FieldFixedLength(1)
   public String codificaNomenclatore;

   // 115-117 Codice branca specialistica della prestazione erogata
   @FieldFixedLength(3)
   public String codiceBrancaSpecialistica;

   // 118-122 Codice specialità della prestazione erogata
   @FieldFixedLength(5)
   public String codiceSpecialitaPrestazione;

   // 123-130 Codice della prestazione erogata
   @FieldFixedLength(8)
   public String codicePrestazione;

   // 131-133 Numero delle prestazioni
   @FieldFixedLength(3)
   public String numeroPrestazioni;

   // 134-141 Tariffa della prestazione erogata
   @FieldFixedLength(8)
   public String tariffaPrestazione;

   // 142-143 Percentuale di sconto da applicare
   @FieldFixedLength(2)
   public String percentualeSconto;

   // 144-151 Importo sconto
   @FieldFixedLength(8)
   public String importoSconto;

   // 152 Tipo esenzione
   @FieldFixedLength(1)
   public String tipoEsenzione;

   // 153-158 Codice esenzione
   @FieldFixedLength(6)
   public String codiceEsenzione;

   // 159 Quota fissa per ricetta
   @FieldFixedLength(1)
   public String quotaFissaRicetta;

   // 160-167 Ticket pagato dall’assistito
   @FieldFixedLength(8)
   public String ticketPagatoDaAssistito;

   // 168-175 Quota fissa pagata dall’assistito
   @FieldFixedLength(8)
   public String quotaFissaPagata;

   // 176-183 Importo totale
   @FieldFixedLength(8)
   public String importoTotale;

   // 184 Posizione contabile
   @FieldFixedLength(1)
   public String posizioneContabile;

   // 185 Trasmissione in Regione
   @FieldFixedLength(1)
   public String trasmissioneInRegione;

   // 186 ERR01 - Errori anagrafici
   @FieldFixedLength(1)
   public String err01;

   // 187 ERR02 - Errori sulla residenza
   @FieldFixedLength(1)
   public String err02;

   // 188 ERR03 - Errori sulla prestazione
   @FieldFixedLength(1)
   public String err03;

   // 189 ERR04 - Errori sull’identificativo della struttura
   @FieldFixedLength(1)
   public String err04;

   // 190 ERR05 – Errori del record
   @FieldFixedLength(1)
   public String err05;

   // 191 ERR06 - Errori sull’importo
   @FieldFixedLength(1)
   public String err06;

   // 192 ERR07 – Errori sul numero delle prestazioni
   @FieldFixedLength(1)
   public String err07;

   // 193 ERR08 - Errori sulla data della prestazione
   @FieldFixedLength(1)
   public String err08;

   // 194 ERR09 - Errori sulle esenzioni
   @FieldFixedLength(1)
   public String err09;

   // 195 ERR10 - Errore sulla Regione/Zona territoriale iniziale di addebito
   @FieldFixedLength(1)
   public String err10;

   // 196-217 Prestazione erogata in concomitanza di ricovero ospedaliero
   @FieldFixedLength(22)
   public String prestazioneErogataInConcomitanzaRicovero;

   // 218-237 ID
   @FieldFixedLength(20)
   public String id;

   // 238-240 Regione/Azienda iniziale di addebito
   @FieldFixedLength(3)
   public String regioneInizialeAddebito;

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

   public String getCodiceCentroDiCosto()
   {
      return codiceCentroDiCosto;
   }

   public void setCodiceCentroDiCosto(String codiceCentroDiCosto)
   {
      this.codiceCentroDiCosto = codiceCentroDiCosto;
   }

   public String getNumeroRicetta()
   {
      return numeroRicetta;
   }

   public void setNumeroRicetta(String numeroRicetta)
   {
      this.numeroRicetta = numeroRicetta;
   }

   public String getPrioritaAccessoPrestazioni()
   {
      return prioritaAccessoPrestazioni;
   }

   public void setPrioritaAccessoPrestazioni(String prioritaAccessoPrestazioni)
   {
      this.prioritaAccessoPrestazioni = prioritaAccessoPrestazioni;
   }

   public String getEffettivaPrioritaRiscontrata()
   {
      return effettivaPrioritaRiscontrata;
   }

   public void setEffettivaPrioritaRiscontrata(String effettivaPrioritaRiscontrata)
   {
      this.effettivaPrioritaRiscontrata = effettivaPrioritaRiscontrata;
   }

   public String getTipologiaPrescrizione()
   {
      return tipologiaPrescrizione;
   }

   public void setTipologiaPrescrizione(String tipologiaPrescrizione)
   {
      this.tipologiaPrescrizione = tipologiaPrescrizione;
   }

   public String getTipoRicetta()
   {
      return tipoRicetta;
   }

   public void setTipoRicetta(String tipoRicetta)
   {
      this.tipoRicetta = tipoRicetta;
   }

   public String getAttivitaProntoSoccorso()
   {
      return attivitaProntoSoccorso;
   }

   public void setAttivitaProntoSoccorso(String attivitaProntoSoccorso)
   {
      this.attivitaProntoSoccorso = attivitaProntoSoccorso;
   }

   public String getPrestazioneAmbulatorialeComplessa()
   {
      return prestazioneAmbulatorialeComplessa;
   }

   public void setPrestazioneAmbulatorialeComplessa(String prestazioneAmbulatorialeComplessa)
   {
      this.prestazioneAmbulatorialeComplessa = prestazioneAmbulatorialeComplessa;
   }

   public String getCicloPrestazioni()
   {
      return cicloPrestazioni;
   }

   public void setCicloPrestazioni(String cicloPrestazioni)
   {
      this.cicloPrestazioni = cicloPrestazioni;
   }

   public String getProgressivoRigaPerRicetta()
   {
      return progressivoRigaPerRicetta;
   }

   public void setProgressivoRigaPerRicetta(String progressivoRigaPerRicetta)
   {
      this.progressivoRigaPerRicetta = progressivoRigaPerRicetta;
   }

   public Date getDataCompilazioneRicetta()
   {
      return dataCompilazioneRicetta;
   }

   public void setDataCompilazioneRicetta(Date dataCompilazioneRicetta)
   {
      this.dataCompilazioneRicetta = dataCompilazioneRicetta;
   }

   public Date getDataPrimaDisponibilitaErogazione()
   {
      return dataPrimaDisponibilitaErogazione;
   }

   public void setDataPrimaDisponibilitaErogazione(Date dataPrimaDisponibilitaErogazione)
   {
      this.dataPrimaDisponibilitaErogazione = dataPrimaDisponibilitaErogazione;
   }

   public Date getDataPrenotazione()
   {
      return dataPrenotazione;
   }

   public void setDataPrenotazione(Date dataPrenotazione)
   {
      this.dataPrenotazione = dataPrenotazione;
   }

   public Date getDataPAC()
   {
      return dataPAC;
   }

   public void setDataPAC(Date dataPAC)
   {
      this.dataPAC = dataPAC;
   }

   public Date getDataErogazionePrestazioni()
   {
      return dataErogazionePrestazioni;
   }

   public void setDataErogazionePrestazioni(Date dataErogazionePrestazioni)
   {
      this.dataErogazionePrestazioni = dataErogazionePrestazioni;
   }

   public Date getDataRefertazione()
   {
      return dataRefertazione;
   }

   public void setDataRefertazione(Date dataRefertazione)
   {
      this.dataRefertazione = dataRefertazione;
   }

   public String getModalitaAccessoPrestazioni()
   {
      return modalitaAccessoPrestazioni;
   }

   public void setModalitaAccessoPrestazioni(String modalitaAccessoPrestazioni)
   {
      this.modalitaAccessoPrestazioni = modalitaAccessoPrestazioni;
   }

   public String getTipoAccesso()
   {
      return tipoAccesso;
   }

   public void setTipoAccesso(String tipoAccesso)
   {
      this.tipoAccesso = tipoAccesso;
   }

   public String getCodiceDiagnosi()
   {
      return codiceDiagnosi;
   }

   public void setCodiceDiagnosi(String codiceDiagnosi)
   {
      this.codiceDiagnosi = codiceDiagnosi;
   }

   public String getVerificaPresenzaQuesitoDiagnostico()
   {
      return verificaPresenzaQuesitoDiagnostico;
   }

   public void setVerificaPresenzaQuesitoDiagnostico(String verificaPresenzaQuesitoDiagnostico)
   {
      this.verificaPresenzaQuesitoDiagnostico = verificaPresenzaQuesitoDiagnostico;
   }

   public String getCodificaNomenclatore()
   {
      return codificaNomenclatore;
   }

   public void setCodificaNomenclatore(String codificaNomenclatore)
   {
      this.codificaNomenclatore = codificaNomenclatore;
   }

   public String getCodiceBrancaSpecialistica()
   {
      return codiceBrancaSpecialistica;
   }

   public void setCodiceBrancaSpecialistica(String codiceBrancaSpecialistica)
   {
      this.codiceBrancaSpecialistica = codiceBrancaSpecialistica;
   }

   public String getCodiceSpecialitaPrestazione()
   {
      return codiceSpecialitaPrestazione;
   }

   public void setCodiceSpecialitaPrestazione(String codiceSpecialitaPrestazione)
   {
      this.codiceSpecialitaPrestazione = codiceSpecialitaPrestazione;
   }

   public String getCodicePrestazione()
   {
      return codicePrestazione;
   }

   public void setCodicePrestazione(String codicePrestazione)
   {
      this.codicePrestazione = codicePrestazione;
   }

   public String getNumeroPrestazioni()
   {
      return numeroPrestazioni;
   }

   public void setNumeroPrestazioni(String numeroPrestazioni)
   {
      this.numeroPrestazioni = numeroPrestazioni;
   }

   public String getTariffaPrestazione()
   {
      return tariffaPrestazione;
   }

   public void setTariffaPrestazione(String tariffaPrestazione)
   {
      this.tariffaPrestazione = tariffaPrestazione;
   }

   public String getPercentualeSconto()
   {
      return percentualeSconto;
   }

   public void setPercentualeSconto(String percentualeSconto)
   {
      this.percentualeSconto = percentualeSconto;
   }

   public String getImportoSconto()
   {
      return importoSconto;
   }

   public void setImportoSconto(String importoSconto)
   {
      this.importoSconto = importoSconto;
   }

   public String getTipoEsenzione()
   {
      return tipoEsenzione;
   }

   public void setTipoEsenzione(String tipoEsenzione)
   {
      this.tipoEsenzione = tipoEsenzione;
   }

   public String getCodiceEsenzione()
   {
      return codiceEsenzione;
   }

   public void setCodiceEsenzione(String codiceEsenzione)
   {
      this.codiceEsenzione = codiceEsenzione;
   }

   public String getQuotaFissaRicetta()
   {
      return quotaFissaRicetta;
   }

   public void setQuotaFissaRicetta(String quotaFissaRicetta)
   {
      this.quotaFissaRicetta = quotaFissaRicetta;
   }

   public String getTicketPagatoDaAssistito()
   {
      return ticketPagatoDaAssistito;
   }

   public void setTicketPagatoDaAssistito(String ticketPagatoDaAssistito)
   {
      this.ticketPagatoDaAssistito = ticketPagatoDaAssistito;
   }

   public String getQuotaFissaPagata()
   {
      return quotaFissaPagata;
   }

   public void setQuotaFissaPagata(String quotaFissaPagata)
   {
      this.quotaFissaPagata = quotaFissaPagata;
   }

   public String getImportoTotale()
   {
      return importoTotale;
   }

   public void setImportoTotale(String importoTotale)
   {
      this.importoTotale = importoTotale;
   }

   public String getPosizioneContabile()
   {
      return posizioneContabile;
   }

   public void setPosizioneContabile(String posizioneContabile)
   {
      this.posizioneContabile = posizioneContabile;
   }

   public String getTrasmissioneInRegione()
   {
      return trasmissioneInRegione;
   }

   public void setTrasmissioneInRegione(String trasmissioneInRegione)
   {
      this.trasmissioneInRegione = trasmissioneInRegione;
   }

   public String getErr01()
   {
      return err01;
   }

   public void setErr01(String err01)
   {
      this.err01 = err01;
   }

   public String getErr02()
   {
      return err02;
   }

   public void setErr02(String err02)
   {
      this.err02 = err02;
   }

   public String getErr03()
   {
      return err03;
   }

   public void setErr03(String err03)
   {
      this.err03 = err03;
   }

   public String getErr04()
   {
      return err04;
   }

   public void setErr04(String err04)
   {
      this.err04 = err04;
   }

   public String getErr05()
   {
      return err05;
   }

   public void setErr05(String err05)
   {
      this.err05 = err05;
   }

   public String getErr06()
   {
      return err06;
   }

   public void setErr06(String err06)
   {
      this.err06 = err06;
   }

   public String getErr07()
   {
      return err07;
   }

   public void setErr07(String err07)
   {
      this.err07 = err07;
   }

   public String getErr08()
   {
      return err08;
   }

   public void setErr08(String err08)
   {
      this.err08 = err08;
   }

   public String getErr09()
   {
      return err09;
   }

   public void setErr09(String err09)
   {
      this.err09 = err09;
   }

   public String getErr10()
   {
      return err10;
   }

   public void setErr10(String err10)
   {
      this.err10 = err10;
   }

   public String getPrestazioneErogataInConcomitanzaRicovero()
   {
      return prestazioneErogataInConcomitanzaRicovero;
   }

   public void setPrestazioneErogataInConcomitanzaRicovero(String prestazioneErogataInConcomitanzaRicovero)
   {
      this.prestazioneErogataInConcomitanzaRicovero = prestazioneErogataInConcomitanzaRicovero;
   }

   public String getId()
   {
      return id;
   }

   public void setId(String id)
   {
      this.id = id;
   }

   public String getRegioneInizialeAddebito()
   {
      return regioneInizialeAddebito;
   }

   public void setRegioneInizialeAddebito(String regioneInizialeAddebito)
   {
      this.regioneInizialeAddebito = regioneInizialeAddebito;
   }

   @Override
   public String toString()
   {
      return "FlussoC2 [" +
               "regioneAddebitante='" + regioneAddebitante + '\'' +
               ", zonaTerritoriale='" + zonaTerritoriale + '\'' +
               ", codiceStrutturaAccettante='" + codiceStrutturaAccettante + '\'' +
               ", codiceStrutturaErogante='" + codiceStrutturaErogante + '\'' +
               ", codiceCentroDiCosto='" + codiceCentroDiCosto + '\'' +
               ", numeroRicetta='" + numeroRicetta + '\'' +
               ", prioritaAccessoPrestazioni='" + prioritaAccessoPrestazioni + '\'' +
               ", effettivaPrioritaRiscontrata='" + effettivaPrioritaRiscontrata + '\'' +
               ", tipologiaPrescrizione='" + tipologiaPrescrizione + '\'' +
               ", tipoRicetta='" + tipoRicetta + '\'' +
               ", attivitaProntoSoccorso='" + attivitaProntoSoccorso + '\'' +
               ", prestazioneAmbulatorialeComplessa='" + prestazioneAmbulatorialeComplessa + '\'' +
               ", cicloPrestazioni='" + cicloPrestazioni + '\'' +
               ", progressivoRigaPerRicetta='" + progressivoRigaPerRicetta + '\'' +
               ", dataCompilazioneRicetta='" + dataCompilazioneRicetta + '\'' +
               ", dataPrimaDisponibilitaErogazione='" + dataPrimaDisponibilitaErogazione + '\'' +
               ", dataPrenotazione='" + dataPrenotazione + '\'' +
               ", dataPAC='" + dataPAC + '\'' +
               ", dataErogazionePrestazioni='" + dataErogazionePrestazioni + '\'' +
               ", dataRefertazione='" + dataRefertazione + '\'' +
               ", modalitaAccessoPrestazioni='" + modalitaAccessoPrestazioni + '\'' +
               ", tipoAccesso='" + tipoAccesso + '\'' +
               ", codiceDiagnosi='" + codiceDiagnosi + '\'' +
               ", verificaPresenzaQuesitoDiagnostico='" + verificaPresenzaQuesitoDiagnostico + '\'' +
               ", codificaNomenclatore='" + codificaNomenclatore + '\'' +
               ", codiceBrancaSpecialistica='" + codiceBrancaSpecialistica + '\'' +
               ", codiceSpecialitaPrestazione='" + codiceSpecialitaPrestazione + '\'' +
               ", codicePrestazione='" + codicePrestazione + '\'' +
               ", numeroPrestazioni='" + numeroPrestazioni + '\'' +
               ", tariffaPrestazione='" + tariffaPrestazione + '\'' +
               ", percentualeSconto='" + percentualeSconto + '\'' +
               ", importoSconto='" + importoSconto + '\'' +
               ", tipoEsenzione='" + tipoEsenzione + '\'' +
               ", codiceEsenzione='" + codiceEsenzione + '\'' +
               ", quotaFissaRicetta='" + quotaFissaRicetta + '\'' +
               ", ticketPagatoDaAssistito='" + ticketPagatoDaAssistito + '\'' +
               ", quotaFissaPagata='" + quotaFissaPagata + '\'' +
               ", importoTotale='" + importoTotale + '\'' +
               ", posizioneContabile='" + posizioneContabile + '\'' +
               ", trasmissioneInRegione='" + trasmissioneInRegione + '\'' +
               ", err01='" + err01 + '\'' +
               ", err02='" + err02 + '\'' +
               ", err03='" + err03 + '\'' +
               ", err04='" + err04 + '\'' +
               ", err05='" + err05 + '\'' +
               ", err06='" + err06 + '\'' +
               ", err07='" + err07 + '\'' +
               ", err08='" + err08 + '\'' +
               ", err09='" + err09 + '\'' +
               ", err10='" + err10 + '\'' +
               ", prestazioneErogataInConcomitanzaRicovero='" + prestazioneErogataInConcomitanzaRicovero + '\'' +
               ", id='" + id + '\'' +
               ", regioneInizialeAddebito='" + regioneInizialeAddebito + '\'' +
               ']';
   }

   public boolean containsErrors()
   {
      if (this.getErr01() != null && !this.getErr01().trim().isEmpty()
               && this.getErr01().trim().equals(TipologiaERR01FlussoC.NESSUN_ERRORE.getValue()))
         return false;
      if (this.getErr02() != null && !this.getErr02().trim().isEmpty()
               && this.getErr02().trim().equals(TipologiaERR02FlussoC.NESSUN_ERRORE.getValue()))
         return false;
      if (this.getErr03() != null && !this.getErr03().trim().isEmpty()
               && this.getErr03().trim().equals(TipologiaERR03FlussoC.NESSUN_ERRORE.getValue()))
         return false;
      if (this.getErr04() != null && !this.getErr04().trim().isEmpty()
               && this.getErr04().trim().equals(TipologiaERR04FlussoC.NESSUN_ERRORE.getValue()))
         return false;
      if (this.getErr05() != null && !this.getErr05().trim().isEmpty()
               && this.getErr05().trim().equals(TipologiaERR05FlussoC.NESSUN_ERRORE.getValue()))
         return false;
      if (this.getErr06() != null && !this.getErr06().trim().isEmpty()
               && this.getErr06().trim().equals(TipologiaERR06FlussoC.NESSUN_ERRORE.getValue()))
         return false;
      if (this.getErr07() != null && !this.getErr07().trim().isEmpty()
               && this.getErr07().trim().equals(TipologiaERR07FlussoC.NESSUN_ERRORE.getValue()))
         return false;
      if (this.getErr08() != null && !this.getErr08().trim().isEmpty()
               && this.getErr08().trim().equals(TipologiaERR08FlussoC.NESSUN_ERRORE.getValue()))
         return false;
      if (this.getErr09() != null && !this.getErr09().trim().isEmpty()
               && this.getErr09().trim().equals(TipologiaERR01FlussoC.NESSUN_ERRORE.getValue()))
         return false;
      if (this.getErr10() != null && !this.getErr10().trim().isEmpty()
               && this.getErr10().trim().equals(TipologiaERR10FlussoC.NESSUN_ERRORE.getValue()))
         return false;
      return true;
   }
}
