package it.ictgroup.asr.flussoc.model;

import org.coury.jfilehelpers.annotations.FieldFixedLength;
import org.coury.jfilehelpers.annotations.FixedLengthRecord;

/**
 * Created by stefano on 22/09/14.
 */

@FixedLengthRecord
public class FlussoC2
{
   // 1-3   Regione addebitante
   @FieldFixedLength(3)
   public String regioneAddebitante;

   // 4-6   Zona Territoriale/Azienda  Ospedaliera  inviante
   @FieldFixedLength(3)
   public String zonaTerritoriale;

   // 7-12   Codice struttura accettante / richiedente
   @FieldFixedLength(6)
   public String codiceStrutturaAccettante;

   // 13-18   Codice struttura erogante la prestazione
   @FieldFixedLength(6)
   public String getCodiceStrutturaErogante;

   // 19-28   Codice centro di costo
   @FieldFixedLength(10)
   public String codiceCentroDiCosto;

   // 29-44   Numero ricetta
   @FieldFixedLength(16)
   public String numeroRicetta;

   // 45   Priorità per l’accesso alle prestazioni
   @FieldFixedLength(1)
   public String prioritaAccessoPrestazioni;

   // 46   Effettiva priorità riscontrata al momento dell’esecuzione delle prestazioni
   @FieldFixedLength(1)
   public String effettivaPrioritaRiscontrata;

   // 47   Tipologia di prescrizione
   @FieldFixedLength(1)
   public String tipologiaPrescrizione;

   // 48-49   Tipo ricetta
   @FieldFixedLength(2)
   public String tipoRicetta;

   // 50   Attività richiesta dal pronto soccorso
   @FieldFixedLength(1)
   public String attivitaProntoSoccorso;

   // 51   Prestazione ambulatoriale complessa (PAC)
   @FieldFixedLength(1)
   public String prestazioneAmbulatorialeComplessa;

   // 52   Ciclo di prestazioni
   @FieldFixedLength(1)
   public String cicloPrestazioni;

   // 53-54   Progressivo riga per ricetta
   @FieldFixedLength(2)
   public String progressivoRigaPerRicetta;

   // 55-62   Data di compilazione della ricetta
   @FieldFixedLength(8)
   public String dataCompilazioneRicetta;

   // 63-70   Data di prima disponibilità di erogazione
   @FieldFixedLength(8)
   public String dataPrimaDisponibilitaErogazione;

   // 71-78   Data di prenotazione
   @FieldFixedLength(8)
   public String dataPrenotazione;

   // 79-86   Data inizio Prestazione Ambulatoriale Complessa (PAC) / data inizio ciclo di prestazioni
   @FieldFixedLength(8)
   public String dataPAC;

   // 87-94   Data di erogazione delle prestazioni
   @FieldFixedLength(8)
   public String dataErogazionePrestazioni;

   // 95-102   Data di refertazione
   @FieldFixedLength(8)
   public String dataRefertazione;

   // 103-104   Modalità di accesso alle prestazioni
   @FieldFixedLength(2)
   public String modalitaAccessoPrestazioni;

   // 105   Tipo di accesso
   @FieldFixedLength(1)
   public String tipoAccesso;

   // 106-112   Codice diagnosi/quesito diagnostico
   @FieldFixedLength(7)
   public String codiceDiagnosi;

   // 113   Verifica dell’effettiva presenza del quesito diagnostico
   @FieldFixedLength(1)
   public String verificaPresenzaQuesitoDiagnostico;

   // 114   Codifica nomenclatore
   @FieldFixedLength(1)
   public String codificaNomenclatore;

   // 115-117   Codice branca specialistica della prestazione erogata
   @FieldFixedLength(3)
   public String codiceBrancaSpecialistica;

   // 118-122   Codice specialità della prestazione erogata
   @FieldFixedLength(5)
   public String codiceSpecialitaPrestazione;

   // 123-130   Codice della prestazione erogata
   @FieldFixedLength(8)
   public String codicePrestazione;

   // 131-133   Numero delle prestazioni
   @FieldFixedLength(3)
   public String numeroPrestazioni;

   // 134-141   Tariffa della prestazione erogata
   @FieldFixedLength(8)
   public String tariffaPrestazione;

   // 142-143   Percentuale di sconto da applicare
   @FieldFixedLength(2)
   public String percentualeSconto;

   // 144-151   Importo sconto
   @FieldFixedLength(8)
   public String importoSconto;

   // 152   Tipo esenzione
   @FieldFixedLength(1)
   public String tipoEsenzione;

   // 153-158   Codice esenzione
   @FieldFixedLength(6)
   public String codiceEsenzione;

   // 159   Quota fissa per ricetta
   @FieldFixedLength(1)
   public String quotaFissaRicetta;

   // 160-167   Ticket pagato dall’assistito
   @FieldFixedLength(8)
   public String ticketPagatoDaAssistito;

   // 168-175    Quota fissa pagata dall’assistito
   @FieldFixedLength(8)
   public String quotaFissaPagata;

   // 176-183   Importo totale
   @FieldFixedLength(8)
   public String importoTotale;

   // 184   Posizione contabile
   @FieldFixedLength(1)
   public String posizioneContabile;

   // 185   Trasmissione in Regione
   @FieldFixedLength(1)
   public String trasmissioneInRegione;

   // 186   ERR01 - Errori anagrafici
   @FieldFixedLength(1)
   public String erroriAnagrafici;

   // 187   ERR02 - Errori sulla residenza
   @FieldFixedLength(1)
   public String erroriResidenza;

   // 188   ERR03 - Errori sulla prestazione
   @FieldFixedLength(1)
   public String erroriPrestazione;

   // 189   ERR04 - Errori sull’identificativo della struttura
   @FieldFixedLength(1)
   public String erroriIdentificativoStruttura;

   // 190   ERR05 – Errori del record
   @FieldFixedLength(1)
   public String erroriRecord;

   // 191   ERR06 -  Errori sull’importo
   @FieldFixedLength(1)
   public String erroriImporto;

   // 192   ERR07 – Errori sul numero delle prestazioni
   @FieldFixedLength(1)
   public String erroriNumeroPrestazioni;

   // 193   ERR08 - Errori sulla data della prestazione
   @FieldFixedLength(1)
   public String erroriDataPrestazione;

   // 194   ERR09 - Errori sulle esenzioni
   @FieldFixedLength(1)
   public String erroriEsenzioni;

   // 195   ERR10 - Errore sulla Regione/Zona territoriale iniziale di addebito
   @FieldFixedLength(1)
   public String erroreRegioneZonaAddebito;

   // 196-217   Prestazione erogata in concomitanza di ricovero ospedaliero
   @FieldFixedLength(22)
   public String prestazioneErogataInConcomitanzaRicovero;

   // 218-237   ID
   @FieldFixedLength(20)
   public String id;

   // 238-240   Regione/Azienda iniziale di addebito
   @FieldFixedLength(3)
   public String regioneInizialeAddebito;
}
