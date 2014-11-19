package it.ictgroup.asr.model;

import it.ictgroup.asr.model.enums.flussoa.TipologiaERR01FlussoA;
import it.ictgroup.asr.model.enums.flussoa.TipologiaERR02FlussoA;
import it.ictgroup.asr.model.enums.flussoa.TipologiaERR03FlussoA;
import it.ictgroup.asr.model.enums.flussoa.TipologiaERR04FlussoA;
import it.ictgroup.asr.model.enums.flussoa.TipologiaERR05FlussoA;
import it.ictgroup.asr.model.enums.flussoa.TipologiaERR06FlussoA;
import it.ictgroup.asr.model.enums.flussoa.TipologiaERR07FlussoA;
import it.ictgroup.asr.model.enums.flussoa.TipologiaERR08FlussoA;
import it.ictgroup.asr.model.enums.flussoa.TipologiaERR09FlussoA;
import it.ictgroup.asr.model.enums.flussoa.TipologiaERR10FlussoA;
import it.ictgroup.asr.util.annotations.FieldFixedLength;
import it.ictgroup.asr.util.annotations.FieldIgnored;
import it.ictgroup.asr.util.annotations.FixedLengthRecord;
import it.ictgroup.asr.util.enums.FixedMode;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@FixedLengthRecord(fixedMode = FixedMode.AllowVariableLength)
@Entity
public class Flussoa2 implements Serializable
{

   @FieldIgnored
   private static final long serialVersionUID = 1L;

   @FieldIgnored
   private Long uid;

   // 1-8
   // codice istituto
   // AN
   // 8
   @FieldFixedLength(8)
   public String codiceIstituto;
   // 9-16
   // numero della scheda
   // AN
   // 8
   @FieldFixedLength(8)
   public String numeroDellaScheda;
   // 17-19
   // Regione addebitante
   // AN
   // 3
   @FieldFixedLength(3)
   public String regioneAddebitante;
   // 20
   // regime di ricovero
   // AN
   // 1
   @FieldFixedLength(1)
   public String regimeDiRicovero;
   // 21-28
   // data di ricovero
   // data
   // 8
   @FieldFixedLength(8)
   public String dataDiRicovero;
   // 29-36
   // data di prenotazione
   // data
   // 8
   @FieldFixedLength(8)
   public String dataDiPrenotazione;
   // 37-40
   // unità operativa di ammissione
   // AN
   // 4
   @FieldFixedLength(4)
   public String unitaOperativaDiAmmissione;
   // 41
   // onere della degenza
   // AN
   // 1
   @FieldFixedLength(1)
   public String onereDellaDegenza;
   // 42
   // provenienza del paziente
   // AN
   // 1
   @FieldFixedLength(1)
   public String provenienzaDelPaziente;
   // 43
   // tipo di ricovero ordinario
   // AN
   // 1
   @FieldFixedLength(1)
   public String tipoDiRicoveroOrdinario;
   // 44
   // motivo del ricovero ordinario
   // AN
   // 1
   @FieldFixedLength(1)
   public String motivoDelRicoveroOrdinario;
   // 45
   // traumatismi o intossicazioni
   // AN
   // 1
   @FieldFixedLength(1)
   public String traumatismioIntossicazioni;
   // 46-53
   // data 1° trasferimento interno
   // data
   // 8
   @FieldFixedLength(8)
   public String data1TrasferimentoInterno;
   // 54-57
   // unità operativa 1° trasferimento interno
   // AN
   // 4
   @FieldFixedLength(4)
   public String unitaOperativa1TrasferimentoInterno;
   // 58-60
   // giornate di degenza nell’unità operativa di 1° trasferimento
   // N
   // 3
   @FieldFixedLength(3)
   public String giornateDiDegenzaNellUnitaOperativaDi1Trasferimento;
   // 61-68
   // data 2° trasferimento interno
   // Data
   // 8
   @FieldFixedLength(8)
   public String data2TrasferimentoInterno;
   // 69-72
   // unità operativa 2° trasferimento interno
   // AN
   // 4
   @FieldFixedLength(4)
   public String unitaOperativa2TrasferimentoInterno;
   // 73-75
   // giornate di degenza nell’unità operativa di 2° trasferimento
   // N
   // 3
   @FieldFixedLength(3)
   public String giornateDiDegenzaNellUnitaOperativaDi2Trasferimento;
   // 76-83
   // data 3° trasferimento interno
   // data
   // 8
   @FieldFixedLength(8)
   public String data3TrasferimentoInterno;
   // 84-87
   // unità operativa 3° trasferimento interno
   // AN
   // 4
   @FieldFixedLength(4)
   public String unitaOperativa3TrasferimentoInterno;
   // 88-90
   // giornate di degenza nell’unità operativa di 3° trasferimento
   // N
   // 3
   @FieldFixedLength(3)
   public String giornateDiDegenzaNellUnitaOperativaDi3Trasferimento;
   // 91
   // altra attività effettuata nell'ambito del ricovero
   // AN
   // 1
   @FieldFixedLength(1)
   public String altraAttivitaEffettuataNellAmbitoDelRicovero;
   // 92
   // Numero di organi espiantati da cadavere
   // N
   // 1
   @FieldFixedLength(1)
   public String numeroDiOrganiEspiantatiDaCadavere;
   // 93-96
   // unità operativa di dimissione
   // AN
   // 4
   @FieldFixedLength(4)
   public String unitaOperativaDiDimissione;
   // 97-104
   // data di dimissione o di morte
   // data
   // 8
   @FieldFixedLength(8)
   public String dataDiDimissioneoDiMorte;
   // 105
   // modalità di dimissione
   // AN
   // 1
   @FieldFixedLength(1)
   public String modalitaDiDimissione;
   // 106-113
   // Istituto di trasferimento
   // AN
   // 8
   @FieldFixedLength(8)
   public String istitutoDiTrasferimento;
   // 114
   // riscontro autoptico
   // AN
   // 1
   @FieldFixedLength(1)
   public String riscontroAutoptico;
   // 115-117
   // giornate di degenza ricoveri ordinari
   // N
   // 3
   @FieldFixedLength(3)
   public String giornateDiDegenzaRicoveriOrdinari;
   // 118
   // autorizzazione proroga
   // AN
   // 1
   @FieldFixedLength(1)
   public String autorizzazioneProroga;
   // 119
   // motivo del ricovero in regime diurno
   // AN
   // 1
   @FieldFixedLength(1)
   public String motivoDelRicoveroInRegimeDiurno;
   // 120
   // Tipo di ricovero in regime diurno
   // AN
   // 1
   @FieldFixedLength(1)
   public String tipoDiRicoveroInRegimeDiurno;
   // 121-123
   // numero di giornate di presenza in ricovero diurno
   // N
   // 3
   @FieldFixedLength(3)
   public String numeroDiGiornateDiPresenzaInRicoveroDiurno;
   // 124
   // neonato
   // AN
   // 1
   @FieldFixedLength(1)
   public String neonato;
   // 125-132
   // numero scheda della madre
   // AN
   // 8
   @FieldFixedLength(8)
   public String numeroSchedaDellaMadre;
   // 133-136
   // peso alla nascita
   // AN
   // 4
   @FieldFixedLength(4)
   public String pesoAllaNascita;
   // 137
   // Sistema codifica diagnosi
   // AN
   // 1
   @FieldFixedLength(1)
   public String sistemaCodificaDiagnosi;
   // 138-142
   // Diagnosi principale di dimissione
   // AN
   // 5
   @FieldFixedLength(5)
   public String diagnosiPrincipaleDiDimissione;
   // 143-147
   // Diagnosi concomitante - complicante 1
   // AN
   // 5
   @FieldFixedLength(5)
   public String diagnosiConcomitanteComplicante1;
   // 148-152
   // Diagnosi concomitante - complicante 2
   // AN
   // 5
   @FieldFixedLength(5)
   public String diagnosiConcomitanteComplicante2;
   // 153-157
   // Diagnosi concomitante - complicante 3
   // AN
   // 5
   @FieldFixedLength(5)
   public String diagnosiConcomitanteComplicante3;
   // 158-162
   // Diagnosi concomitante - complicante 4
   // AN
   // 5
   @FieldFixedLength(5)
   public String diagnosiConcomitanteComplicante4;
   // 163-167
   // Diagnosi concomitante - complicante 5
   // AN
   // 5
   @FieldFixedLength(5)
   public String diagnosiConcomitanteComplicante5;
   // 168-175
   // Data intervento chirurgico principale o parto
   // data
   // 8
   @FieldFixedLength(8)
   public String dataInterventoChirurgicoPrincipaleParto;
   // 176-179
   // intervento chirurgico principale o parto
   // AN
   // 4
   @FieldFixedLength(4)
   public String interventoChirurgicoPrincipaleParto;
   // 180-183
   // Altro intervento o procedura 1
   // AN
   // 4
   @FieldFixedLength(4)
   public String altroInterventoProcedura1;
   // 184-187
   // Altro intervento o procedura 2
   // AN
   // 4
   @FieldFixedLength(4)
   public String altroInterventoProcedura2;
   // 188-191
   // Altro intervento o procedura 3
   // AN
   // 4
   @FieldFixedLength(4)
   public String altroInterventoProcedura3;
   // 192-195
   // Altro intervento o procedura 4
   // AN
   // 4
   @FieldFixedLength(4)
   public String altroInterventoProcedura4;
   // 196-199
   // Altro intervento o procedura 5
   // AN
   // 4
   @FieldFixedLength(4)
   public String altroInterventoProcedura5;
   // 200-202
   // DRG assegnato dall’Azienda sanitaria erogatrice
   // AN
   // 3
   @FieldFixedLength(3)
   public String drgAssegnatoDallAziendaSanitariaErogatrice;
   // 203-211
   // Tariffa DRG
   // N
   // 9
   @FieldFixedLength(9)
   public String tariffaDrg;
   // 212-220
   // Tariffa aggiuntiva riconosciuta
   // N
   // 9
   @FieldFixedLength(9)
   public String tariffaAggiuntivaRiconosciuta;
   // 221-229
   // Quota a carico dell’utente
   // N
   // 9
   @FieldFixedLength(9)
   public String quotaCaricoDellUtente;
   // 230-231
   // Posizione dell’utente nei confronti del ticket
   // AN
   // 2
   @FieldFixedLength(2)
   public String posizioneDellUtenteNeiConfrontiDelTicket;
   // 232-240
   // Importo ticket
   // N
   // 9
   @FieldFixedLength(9)
   public String importoTicket;
   // 241-249
   // Importo degenza a carico del S.S.N.
   // N
   // 9
   @FieldFixedLength(9)
   public String importoDegenzaCaricoDelSsn;
   // 250
   // Posizione contabile
   // AN
   // 1
   @FieldFixedLength(1)
   public String posizioneContabile;
   // 251
   // trasmissione in Regione
   // AN
   // 1
   @FieldFixedLength(1)
   public String trasmissioneInRegione;
   // 252
   // ERR01 - Errori anagrafici
   // AN
   // 1
   @FieldFixedLength(1)
   public String Err01;
   // 253
   // ERR02 – Errori sulla residenza
   // AN
   // 1
   @FieldFixedLength(1)
   public String Err02;
   // 254
   // ERR03 - Errori sulla prestazione
   // AN
   // 1
   @FieldFixedLength(1)
   public String Err03;
   // 255
   // ERR04 - Caratteristiche del ricovero
   // AN
   // 1
   @FieldFixedLength(1)
   public String Err04;
   // 256
   // ERR05 - errori sulla chiave del record
   // AN
   // 1
   @FieldFixedLength(1)
   public String Err05;
   // 257
   // ERR06 - Errori sull’importo e sulla sua
   // determinabilità
   // AN
   // 1
   @FieldFixedLength(1)
   public String Err06;
   // 258
   // ERR07 - Ricoveri ripetuti
   // AN
   // 1
   @FieldFixedLength(1)
   public String Err07;
   // 259
   // ERR08 - Errori sulla data della
   // prestazione
   // AN
   // 1
   @FieldFixedLength(1)
   public String Err08;
   // 260
   // ERR09 - Errore onere della degenza
   // AN
   // 1
   @FieldFixedLength(1)
   public String Err09;
   // 261
   // ERR10 - Errore sulla Regione/Azienda
   // USL iniziale di addebito
   // AN
   // 1
   @FieldFixedLength(1)
   public String Err10;
   // 262-264
   // Regione/Azienda iniziale di addebito
   // AN
   // 3
   @FieldFixedLength(3)
   public String RegioneAziendaInizialeDiAddebito;
   // 265-270
   // Ripetizione
   // AN
   // 6
   @FieldFixedLength(6)
   public String ripetizione;

   @FieldIgnored
   private String nomeFile;
   @FieldIgnored
   private Elaborazione elaborazione;

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

   public String getCodiceIstituto()
   {
      return codiceIstituto;
   }

   public void setCodiceIstituto(String codiceIstituto)
   {
      this.codiceIstituto = codiceIstituto;
   }

   public String getNumeroDellaScheda()
   {
      return numeroDellaScheda;
   }

   public void setNumeroDellaScheda(String numeroDellaScheda)
   {
      this.numeroDellaScheda = numeroDellaScheda;
   }

   public String getRegioneAddebitante()
   {
      return regioneAddebitante;
   }

   public void setRegioneAddebitante(String regioneAddebitante)
   {
      this.regioneAddebitante = regioneAddebitante;
   }

   public String getRegimeDiRicovero()
   {
      return regimeDiRicovero;
   }

   public void setRegimeDiRicovero(String regimeDiRicovero)
   {
      this.regimeDiRicovero = regimeDiRicovero;
   }

   public String getDataDiRicovero()
   {
      return dataDiRicovero;
   }

   public void setDataDiRicovero(String dataDiRicovero)
   {
      this.dataDiRicovero = dataDiRicovero;
   }

   public String getDataDiPrenotazione()
   {
      return dataDiPrenotazione;
   }

   public void setDataDiPrenotazione(String dataDiPrenotazione)
   {
      this.dataDiPrenotazione = dataDiPrenotazione;
   }

   public String getUnitaOperativaDiAmmissione()
   {
      return unitaOperativaDiAmmissione;
   }

   public void setUnitaOperativaDiAmmissione(String unitaOperativaDiAmmissione)
   {
      this.unitaOperativaDiAmmissione = unitaOperativaDiAmmissione;
   }

   public String getOnereDellaDegenza()
   {
      return onereDellaDegenza;
   }

   public void setOnereDellaDegenza(String onereDellaDegenza)
   {
      this.onereDellaDegenza = onereDellaDegenza;
   }

   public String getProvenienzaDelPaziente()
   {
      return provenienzaDelPaziente;
   }

   public void setProvenienzaDelPaziente(String provenienzaDelPaziente)
   {
      this.provenienzaDelPaziente = provenienzaDelPaziente;
   }

   public String getTipoDiRicoveroOrdinario()
   {
      return tipoDiRicoveroOrdinario;
   }

   public void setTipoDiRicoveroOrdinario(String tipoDiRicoveroOrdinario)
   {
      this.tipoDiRicoveroOrdinario = tipoDiRicoveroOrdinario;
   }

   public String getMotivoDelRicoveroOrdinario()
   {
      return motivoDelRicoveroOrdinario;
   }

   public void setMotivoDelRicoveroOrdinario(String motivoDelRicoveroOrdinario)
   {
      this.motivoDelRicoveroOrdinario = motivoDelRicoveroOrdinario;
   }

   public String getTraumatismioIntossicazioni()
   {
      return traumatismioIntossicazioni;
   }

   public void setTraumatismioIntossicazioni(String traumatismioIntossicazioni)
   {
      this.traumatismioIntossicazioni = traumatismioIntossicazioni;
   }

   public String getData1TrasferimentoInterno()
   {
      return data1TrasferimentoInterno;
   }

   public void setData1TrasferimentoInterno(String data1TrasferimentoInterno)
   {
      this.data1TrasferimentoInterno = data1TrasferimentoInterno;
   }

   public String getUnitaOperativa1TrasferimentoInterno()
   {
      return unitaOperativa1TrasferimentoInterno;
   }

   public void setUnitaOperativa1TrasferimentoInterno(String unitaOperativa1TrasferimentoInterno)
   {
      this.unitaOperativa1TrasferimentoInterno = unitaOperativa1TrasferimentoInterno;
   }

   public String getGiornateDiDegenzaNellUnitaOperativaDi1Trasferimento()
   {
      return giornateDiDegenzaNellUnitaOperativaDi1Trasferimento;
   }

   public void setGiornateDiDegenzaNellUnitaOperativaDi1Trasferimento(
            String giornateDiDegenzaNellUnitaOperativaDi1Trasferimento)
   {
      this.giornateDiDegenzaNellUnitaOperativaDi1Trasferimento = giornateDiDegenzaNellUnitaOperativaDi1Trasferimento;
   }

   public String getData2TrasferimentoInterno()
   {
      return data2TrasferimentoInterno;
   }

   public void setData2TrasferimentoInterno(String data2TrasferimentoInterno)
   {
      this.data2TrasferimentoInterno = data2TrasferimentoInterno;
   }

   public String getUnitaOperativa2TrasferimentoInterno()
   {
      return unitaOperativa2TrasferimentoInterno;
   }

   public void setUnitaOperativa2TrasferimentoInterno(String unitaOperativa2TrasferimentoInterno)
   {
      this.unitaOperativa2TrasferimentoInterno = unitaOperativa2TrasferimentoInterno;
   }

   public String getGiornateDiDegenzaNellUnitaOperativaDi2Trasferimento()
   {
      return giornateDiDegenzaNellUnitaOperativaDi2Trasferimento;
   }

   public void setGiornateDiDegenzaNellUnitaOperativaDi2Trasferimento(
            String giornateDiDegenzaNellUnitaOperativaDi2Trasferimento)
   {
      this.giornateDiDegenzaNellUnitaOperativaDi2Trasferimento = giornateDiDegenzaNellUnitaOperativaDi2Trasferimento;
   }

   public String getData3TrasferimentoInterno()
   {
      return data3TrasferimentoInterno;
   }

   public void setData3TrasferimentoInterno(String data3TrasferimentoInterno)
   {
      this.data3TrasferimentoInterno = data3TrasferimentoInterno;
   }

   public String getUnitaOperativa3TrasferimentoInterno()
   {
      return unitaOperativa3TrasferimentoInterno;
   }

   public void setUnitaOperativa3TrasferimentoInterno(String unitaOperativa3TrasferimentoInterno)
   {
      this.unitaOperativa3TrasferimentoInterno = unitaOperativa3TrasferimentoInterno;
   }

   public String getGiornateDiDegenzaNellUnitaOperativaDi3Trasferimento()
   {
      return giornateDiDegenzaNellUnitaOperativaDi3Trasferimento;
   }

   public void setGiornateDiDegenzaNellUnitaOperativaDi3Trasferimento(
            String giornateDiDegenzaNellUnitaOperativaDi3Trasferimento)
   {
      this.giornateDiDegenzaNellUnitaOperativaDi3Trasferimento = giornateDiDegenzaNellUnitaOperativaDi3Trasferimento;
   }

   public String getAltraAttivitaEffettuataNellAmbitoDelRicovero()
   {
      return altraAttivitaEffettuataNellAmbitoDelRicovero;
   }

   public void setAltraAttivitaEffettuataNellAmbitoDelRicovero(String altraAttivitaEffettuataNellAmbitoDelRicovero)
   {
      this.altraAttivitaEffettuataNellAmbitoDelRicovero = altraAttivitaEffettuataNellAmbitoDelRicovero;
   }

   public String getNumeroDiOrganiEspiantatiDaCadavere()
   {
      return numeroDiOrganiEspiantatiDaCadavere;
   }

   public void setNumeroDiOrganiEspiantatiDaCadavere(String numeroDiOrganiEspiantatiDaCadavere)
   {
      this.numeroDiOrganiEspiantatiDaCadavere = numeroDiOrganiEspiantatiDaCadavere;
   }

   public String getUnitaOperativaDiDimissione()
   {
      return unitaOperativaDiDimissione;
   }

   public void setUnitaOperativaDiDimissione(String unitaOperativaDiDimissione)
   {
      this.unitaOperativaDiDimissione = unitaOperativaDiDimissione;
   }

   public String getDataDiDimissioneoDiMorte()
   {
      return dataDiDimissioneoDiMorte;
   }

   public void setDataDiDimissioneoDiMorte(String dataDiDimissioneoDiMorte)
   {
      this.dataDiDimissioneoDiMorte = dataDiDimissioneoDiMorte;
   }

   public String getModalitaDiDimissione()
   {
      return modalitaDiDimissione;
   }

   public void setModalitaDiDimissione(String modalitaDiDimissione)
   {
      this.modalitaDiDimissione = modalitaDiDimissione;
   }

   public String getIstitutoDiTrasferimento()
   {
      return istitutoDiTrasferimento;
   }

   public void setIstitutoDiTrasferimento(String istitutoDiTrasferimento)
   {
      this.istitutoDiTrasferimento = istitutoDiTrasferimento;
   }

   public String getRiscontroAutoptico()
   {
      return riscontroAutoptico;
   }

   public void setRiscontroAutoptico(String riscontroAutoptico)
   {
      this.riscontroAutoptico = riscontroAutoptico;
   }

   public String getGiornateDiDegenzaRicoveriOrdinari()
   {
      return giornateDiDegenzaRicoveriOrdinari;
   }

   public void setGiornateDiDegenzaRicoveriOrdinari(String giornateDiDegenzaRicoveriOrdinari)
   {
      this.giornateDiDegenzaRicoveriOrdinari = giornateDiDegenzaRicoveriOrdinari;
   }

   public String getAutorizzazioneProroga()
   {
      return autorizzazioneProroga;
   }

   public void setAutorizzazioneProroga(String autorizzazioneProroga)
   {
      this.autorizzazioneProroga = autorizzazioneProroga;
   }

   public String getMotivoDelRicoveroInRegimeDiurno()
   {
      return motivoDelRicoveroInRegimeDiurno;
   }

   public void setMotivoDelRicoveroInRegimeDiurno(String motivoDelRicoveroInRegimeDiurno)
   {
      this.motivoDelRicoveroInRegimeDiurno = motivoDelRicoveroInRegimeDiurno;
   }

   public String getTipoDiRicoveroInRegimeDiurno()
   {
      return tipoDiRicoveroInRegimeDiurno;
   }

   public void setTipoDiRicoveroInRegimeDiurno(String tipoDiRicoveroInRegimeDiurno)
   {
      this.tipoDiRicoveroInRegimeDiurno = tipoDiRicoveroInRegimeDiurno;
   }

   public String getNumeroDiGiornateDiPresenzaInRicoveroDiurno()
   {
      return numeroDiGiornateDiPresenzaInRicoveroDiurno;
   }

   public void setNumeroDiGiornateDiPresenzaInRicoveroDiurno(String numeroDiGiornateDiPresenzaInRicoveroDiurno)
   {
      this.numeroDiGiornateDiPresenzaInRicoveroDiurno = numeroDiGiornateDiPresenzaInRicoveroDiurno;
   }

   public String getNeonato()
   {
      return neonato;
   }

   public void setNeonato(String neonato)
   {
      this.neonato = neonato;
   }

   public String getNumeroSchedaDellaMadre()
   {
      return numeroSchedaDellaMadre;
   }

   public void setNumeroSchedaDellaMadre(String numeroSchedaDellaMadre)
   {
      this.numeroSchedaDellaMadre = numeroSchedaDellaMadre;
   }

   public String getPesoAllaNascita()
   {
      return pesoAllaNascita;
   }

   public void setPesoAllaNascita(String pesoAllaNascita)
   {
      this.pesoAllaNascita = pesoAllaNascita;
   }

   public String getSistemaCodificaDiagnosi()
   {
      return sistemaCodificaDiagnosi;
   }

   public void setSistemaCodificaDiagnosi(String sistemaCodificaDiagnosi)
   {
      this.sistemaCodificaDiagnosi = sistemaCodificaDiagnosi;
   }

   public String getDiagnosiPrincipaleDiDimissione()
   {
      return diagnosiPrincipaleDiDimissione;
   }

   public void setDiagnosiPrincipaleDiDimissione(String diagnosiPrincipaleDiDimissione)
   {
      this.diagnosiPrincipaleDiDimissione = diagnosiPrincipaleDiDimissione;
   }

   public String getDiagnosiConcomitanteComplicante1()
   {
      return diagnosiConcomitanteComplicante1;
   }

   public void setDiagnosiConcomitanteComplicante1(String diagnosiConcomitanteComplicante1)
   {
      this.diagnosiConcomitanteComplicante1 = diagnosiConcomitanteComplicante1;
   }

   public String getDiagnosiConcomitanteComplicante2()
   {
      return diagnosiConcomitanteComplicante2;
   }

   public void setDiagnosiConcomitanteComplicante2(String diagnosiConcomitanteComplicante2)
   {
      this.diagnosiConcomitanteComplicante2 = diagnosiConcomitanteComplicante2;
   }

   public String getDiagnosiConcomitanteComplicante3()
   {
      return diagnosiConcomitanteComplicante3;
   }

   public void setDiagnosiConcomitanteComplicante3(String diagnosiConcomitanteComplicante3)
   {
      this.diagnosiConcomitanteComplicante3 = diagnosiConcomitanteComplicante3;
   }

   public String getDiagnosiConcomitanteComplicante4()
   {
      return diagnosiConcomitanteComplicante4;
   }

   public void setDiagnosiConcomitanteComplicante4(String diagnosiConcomitanteComplicante4)
   {
      this.diagnosiConcomitanteComplicante4 = diagnosiConcomitanteComplicante4;
   }

   public String getDiagnosiConcomitanteComplicante5()
   {
      return diagnosiConcomitanteComplicante5;
   }

   public void setDiagnosiConcomitanteComplicante5(String diagnosiConcomitanteComplicante5)
   {
      this.diagnosiConcomitanteComplicante5 = diagnosiConcomitanteComplicante5;
   }

   public String getDataInterventoChirurgicoPrincipaleParto()
   {
      return dataInterventoChirurgicoPrincipaleParto;
   }

   public void setDataInterventoChirurgicoPrincipaleParto(String dataInterventoChirurgicoPrincipaleParto)
   {
      this.dataInterventoChirurgicoPrincipaleParto = dataInterventoChirurgicoPrincipaleParto;
   }

   public String getInterventoChirurgicoPrincipaleParto()
   {
      return interventoChirurgicoPrincipaleParto;
   }

   public void setInterventoChirurgicoPrincipaleParto(String interventoChirurgicoPrincipaleParto)
   {
      this.interventoChirurgicoPrincipaleParto = interventoChirurgicoPrincipaleParto;
   }

   public String getAltroInterventoProcedura1()
   {
      return altroInterventoProcedura1;
   }

   public void setAltroInterventoProcedura1(String altroInterventoProcedura1)
   {
      this.altroInterventoProcedura1 = altroInterventoProcedura1;
   }

   public String getAltroInterventoProcedura2()
   {
      return altroInterventoProcedura2;
   }

   public void setAltroInterventoProcedura2(String altroInterventoProcedura2)
   {
      this.altroInterventoProcedura2 = altroInterventoProcedura2;
   }

   public String getAltroInterventoProcedura3()
   {
      return altroInterventoProcedura3;
   }

   public void setAltroInterventoProcedura3(String altroInterventoProcedura3)
   {
      this.altroInterventoProcedura3 = altroInterventoProcedura3;
   }

   public String getAltroInterventoProcedura4()
   {
      return altroInterventoProcedura4;
   }

   public void setAltroInterventoProcedura4(String altroInterventoProcedura4)
   {
      this.altroInterventoProcedura4 = altroInterventoProcedura4;
   }

   public String getAltroInterventoProcedura5()
   {
      return altroInterventoProcedura5;
   }

   public void setAltroInterventoProcedura5(String altroInterventoProcedura5)
   {
      this.altroInterventoProcedura5 = altroInterventoProcedura5;
   }

   public String getDrgAssegnatoDallAziendaSanitariaErogatrice()
   {
      return drgAssegnatoDallAziendaSanitariaErogatrice;
   }

   public void setDrgAssegnatoDallAziendaSanitariaErogatrice(String drgAssegnatoDallAziendaSanitariaErogatrice)
   {
      this.drgAssegnatoDallAziendaSanitariaErogatrice = drgAssegnatoDallAziendaSanitariaErogatrice;
   }

   public String getTariffaDrg()
   {
      return tariffaDrg;
   }

   public void setTariffaDrg(String tariffaDrg)
   {
      this.tariffaDrg = tariffaDrg;
   }

   public String getTariffaAggiuntivaRiconosciuta()
   {
      return tariffaAggiuntivaRiconosciuta;
   }

   public void setTariffaAggiuntivaRiconosciuta(String tariffaAggiuntivaRiconosciuta)
   {
      this.tariffaAggiuntivaRiconosciuta = tariffaAggiuntivaRiconosciuta;
   }

   public String getQuotaCaricoDellUtente()
   {
      return quotaCaricoDellUtente;
   }

   public void setQuotaCaricoDellUtente(String quotaCaricoDellUtente)
   {
      this.quotaCaricoDellUtente = quotaCaricoDellUtente;
   }

   public String getPosizioneDellUtenteNeiConfrontiDelTicket()
   {
      return posizioneDellUtenteNeiConfrontiDelTicket;
   }

   public void setPosizioneDellUtenteNeiConfrontiDelTicket(String posizioneDellUtenteNeiConfrontiDelTicket)
   {
      this.posizioneDellUtenteNeiConfrontiDelTicket = posizioneDellUtenteNeiConfrontiDelTicket;
   }

   public String getImportoTicket()
   {
      return importoTicket;
   }

   public void setImportoTicket(String importoTicket)
   {
      this.importoTicket = importoTicket;
   }

   public String getImportoDegenzaCaricoDelSsn()
   {
      return importoDegenzaCaricoDelSsn;
   }

   public void setImportoDegenzaCaricoDelSsn(String importoDegenzaCaricoDelSsn)
   {
      this.importoDegenzaCaricoDelSsn = importoDegenzaCaricoDelSsn;
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
      return Err01;
   }

   public void setErr01(String err01)
   {
      Err01 = err01;
   }

   public String getErr02()
   {
      return Err02;
   }

   public void setErr02(String err02)
   {
      Err02 = err02;
   }

   public String getErr03()
   {
      return Err03;
   }

   public void setErr03(String err03)
   {
      Err03 = err03;
   }

   public String getErr04()
   {
      return Err04;
   }

   public void setErr04(String err04)
   {
      Err04 = err04;
   }

   public String getErr05()
   {
      return Err05;
   }

   public void setErr05(String err05)
   {
      Err05 = err05;
   }

   public String getErr06()
   {
      return Err06;
   }

   public void setErr06(String err06)
   {
      Err06 = err06;
   }

   public String getErr07()
   {
      return Err07;
   }

   public void setErr07(String err07)
   {
      Err07 = err07;
   }

   public String getErr08()
   {
      return Err08;
   }

   public void setErr08(String err08)
   {
      Err08 = err08;
   }

   public String getErr09()
   {
      return Err09;
   }

   public void setErr09(String err09)
   {
      Err09 = err09;
   }

   public String getErr10()
   {
      return Err10;
   }

   public void setErr10(String err10)
   {
      Err10 = err10;
   }

   public String getRegioneAziendaInizialeDiAddebito()
   {
      return RegioneAziendaInizialeDiAddebito;
   }

   public void setRegioneAziendaInizialeDiAddebito(String regioneAziendaInizialeDiAddebito)
   {
      RegioneAziendaInizialeDiAddebito = regioneAziendaInizialeDiAddebito;
   }

   public String getRipetizione()
   {
      return ripetizione;
   }

   public void setRipetizione(String ripetizione)
   {
      this.ripetizione = ripetizione;
   }

   @Override
   public String toString()
   {
      return "Flussoa2 ["
               + (uid != null ? "uid=" + uid + ", " : "")
               + (codiceIstituto != null ? "codiceIstituto=" + codiceIstituto + ", " : "")
               + (numeroDellaScheda != null ? "numeroDellaScheda=" + numeroDellaScheda + ", " : "")
               + (regioneAddebitante != null ? "regioneAddebitante=" + regioneAddebitante + ", " : "")
               + (regimeDiRicovero != null ? "regimeDiRicovero=" + regimeDiRicovero + ", " : "")
               + (dataDiRicovero != null ? "dataDiRicovero=" + dataDiRicovero + ", " : "")
               + (dataDiPrenotazione != null ? "dataDiPrenotazione=" + dataDiPrenotazione + ", " : "")
               + (unitaOperativaDiAmmissione != null ? "unitaOperativaDiAmmissione=" + unitaOperativaDiAmmissione
                        + ", " : "")
               + (onereDellaDegenza != null ? "onereDellaDegenza=" + onereDellaDegenza + ", " : "")
               + (provenienzaDelPaziente != null ? "provenienzaDelPaziente=" + provenienzaDelPaziente + ", " : "")
               + (tipoDiRicoveroOrdinario != null ? "tipoDiRicoveroOrdinario=" + tipoDiRicoveroOrdinario + ", " : "")
               + (motivoDelRicoveroOrdinario != null ? "motivoDelRicoveroOrdinario=" + motivoDelRicoveroOrdinario
                        + ", " : "")
               + (traumatismioIntossicazioni != null ? "traumatismioIntossicazioni=" + traumatismioIntossicazioni
                        + ", " : "")
               + (data1TrasferimentoInterno != null ? "data1TrasferimentoInterno=" + data1TrasferimentoInterno + ", "
                        : "")
               + (unitaOperativa1TrasferimentoInterno != null ? "unitaOperativa1TrasferimentoInterno="
                        + unitaOperativa1TrasferimentoInterno + ", " : "")
               + (giornateDiDegenzaNellUnitaOperativaDi1Trasferimento != null ? "giornateDiDegenzaNellUnitaOperativaDi1Trasferimento="
                        + giornateDiDegenzaNellUnitaOperativaDi1Trasferimento + ", "
                        : "")
               + (data2TrasferimentoInterno != null ? "data2TrasferimentoInterno=" + data2TrasferimentoInterno + ", "
                        : "")
               + (unitaOperativa2TrasferimentoInterno != null ? "unitaOperativa2TrasferimentoInterno="
                        + unitaOperativa2TrasferimentoInterno + ", " : "")
               + (giornateDiDegenzaNellUnitaOperativaDi2Trasferimento != null ? "giornateDiDegenzaNellUnitaOperativaDi2Trasferimento="
                        + giornateDiDegenzaNellUnitaOperativaDi2Trasferimento + ", "
                        : "")
               + (data3TrasferimentoInterno != null ? "data3TrasferimentoInterno=" + data3TrasferimentoInterno + ", "
                        : "")
               + (unitaOperativa3TrasferimentoInterno != null ? "unitaOperativa3TrasferimentoInterno="
                        + unitaOperativa3TrasferimentoInterno + ", " : "")
               + (giornateDiDegenzaNellUnitaOperativaDi3Trasferimento != null ? "giornateDiDegenzaNellUnitaOperativaDi3Trasferimento="
                        + giornateDiDegenzaNellUnitaOperativaDi3Trasferimento + ", "
                        : "")
               + (altraAttivitaEffettuataNellAmbitoDelRicovero != null ? "altraAttivitaEffettuataNellAmbitoDelRicovero="
                        + altraAttivitaEffettuataNellAmbitoDelRicovero + ", "
                        : "")
               + (numeroDiOrganiEspiantatiDaCadavere != null ? "numeroDiOrganiEspiantatiDaCadavere="
                        + numeroDiOrganiEspiantatiDaCadavere + ", " : "")
               + (unitaOperativaDiDimissione != null ? "unitaOperativaDiDimissione=" + unitaOperativaDiDimissione
                        + ", " : "")
               + (dataDiDimissioneoDiMorte != null ? "dataDiDimissioneoDiMorte=" + dataDiDimissioneoDiMorte + ", " : "")
               + (modalitaDiDimissione != null ? "modalitaDiDimissione=" + modalitaDiDimissione + ", " : "")
               + (istitutoDiTrasferimento != null ? "istitutoDiTrasferimento=" + istitutoDiTrasferimento + ", " : "")
               + (riscontroAutoptico != null ? "riscontroAutoptico=" + riscontroAutoptico + ", " : "")
               + (giornateDiDegenzaRicoveriOrdinari != null ? "giornateDiDegenzaRicoveriOrdinari="
                        + giornateDiDegenzaRicoveriOrdinari + ", " : "")
               + (autorizzazioneProroga != null ? "autorizzazioneProroga=" + autorizzazioneProroga + ", " : "")
               + (motivoDelRicoveroInRegimeDiurno != null ? "motivoDelRicoveroInRegimeDiurno="
                        + motivoDelRicoveroInRegimeDiurno + ", " : "")
               + (tipoDiRicoveroInRegimeDiurno != null ? "tipoDiRicoveroInRegimeDiurno=" + tipoDiRicoveroInRegimeDiurno
                        + ", " : "")
               + (numeroDiGiornateDiPresenzaInRicoveroDiurno != null ? "numeroDiGiornateDiPresenzaInRicoveroDiurno="
                        + numeroDiGiornateDiPresenzaInRicoveroDiurno + ", " : "")
               + (neonato != null ? "neonato=" + neonato + ", " : "")
               + (numeroSchedaDellaMadre != null ? "numeroSchedaDellaMadre=" + numeroSchedaDellaMadre + ", " : "")
               + (pesoAllaNascita != null ? "pesoAllaNascita=" + pesoAllaNascita + ", " : "")
               + (sistemaCodificaDiagnosi != null ? "sistemaCodificaDiagnosi=" + sistemaCodificaDiagnosi + ", " : "")
               + (diagnosiPrincipaleDiDimissione != null ? "diagnosiPrincipaleDiDimissione="
                        + diagnosiPrincipaleDiDimissione + ", " : "")
               + (diagnosiConcomitanteComplicante1 != null ? "diagnosiConcomitanteComplicante1="
                        + diagnosiConcomitanteComplicante1 + ", " : "")
               + (diagnosiConcomitanteComplicante2 != null ? "diagnosiConcomitanteComplicante2="
                        + diagnosiConcomitanteComplicante2 + ", " : "")
               + (diagnosiConcomitanteComplicante3 != null ? "diagnosiConcomitanteComplicante3="
                        + diagnosiConcomitanteComplicante3 + ", " : "")
               + (diagnosiConcomitanteComplicante4 != null ? "diagnosiConcomitanteComplicante4="
                        + diagnosiConcomitanteComplicante4 + ", " : "")
               + (diagnosiConcomitanteComplicante5 != null ? "diagnosiConcomitanteComplicante5="
                        + diagnosiConcomitanteComplicante5 + ", " : "")
               + (dataInterventoChirurgicoPrincipaleParto != null ? "dataInterventoChirurgicoPrincipaleParto="
                        + dataInterventoChirurgicoPrincipaleParto + ", " : "")
               + (interventoChirurgicoPrincipaleParto != null ? "interventoChirurgicoPrincipaleParto="
                        + interventoChirurgicoPrincipaleParto + ", " : "")
               + (altroInterventoProcedura1 != null ? "altroInterventoProcedura1=" + altroInterventoProcedura1 + ", "
                        : "")
               + (altroInterventoProcedura2 != null ? "altroInterventoProcedura2=" + altroInterventoProcedura2 + ", "
                        : "")
               + (altroInterventoProcedura3 != null ? "altroInterventoProcedura3=" + altroInterventoProcedura3 + ", "
                        : "")
               + (altroInterventoProcedura4 != null ? "altroInterventoProcedura4=" + altroInterventoProcedura4 + ", "
                        : "")
               + (altroInterventoProcedura5 != null ? "altroInterventoProcedura5=" + altroInterventoProcedura5 + ", "
                        : "")
               + (drgAssegnatoDallAziendaSanitariaErogatrice != null ? "drgAssegnatoDallAziendaSanitariaErogatrice="
                        + drgAssegnatoDallAziendaSanitariaErogatrice + ", " : "")
               + (tariffaDrg != null ? "tariffaDrg=" + tariffaDrg + ", " : "")
               + (tariffaAggiuntivaRiconosciuta != null ? "tariffaAggiuntivaRiconosciuta="
                        + tariffaAggiuntivaRiconosciuta + ", " : "")
               + (quotaCaricoDellUtente != null ? "quotaCaricoDellUtente=" + quotaCaricoDellUtente + ", " : "")
               + (posizioneDellUtenteNeiConfrontiDelTicket != null ? "posizioneDellUtenteNeiConfrontiDelTicket="
                        + posizioneDellUtenteNeiConfrontiDelTicket + ", " : "")
               + (importoTicket != null ? "importoTicket=" + importoTicket + ", " : "")
               + (importoDegenzaCaricoDelSsn != null ? "importoDegenzaCaricoDelSsn=" + importoDegenzaCaricoDelSsn
                        + ", " : "")
               + (posizioneContabile != null ? "posizioneContabile=" + posizioneContabile + ", " : "")
               + (trasmissioneInRegione != null ? "trasmissioneInRegione=" + trasmissioneInRegione + ", " : "")
               + (Err01 != null ? "Err01=" + Err01 + ", " : "")
               + (Err02 != null ? "Err02=" + Err02 + ", " : "")
               + (Err03 != null ? "Err03=" + Err03 + ", " : "")
               + (Err04 != null ? "Err04=" + Err04 + ", " : "")
               + (Err05 != null ? "Err05=" + Err05 + ", " : "")
               + (Err06 != null ? "Err06=" + Err06 + ", " : "")
               + (Err07 != null ? "Err07=" + Err07 + ", " : "")
               + (Err08 != null ? "Err08=" + Err08 + ", " : "")
               + (Err09 != null ? "Err09=" + Err09 + ", " : "")
               + (Err10 != null ? "Err10=" + Err10 + ", " : "")
               + (RegioneAziendaInizialeDiAddebito != null ? "RegioneAziendaInizialeDiAddebito="
                        + RegioneAziendaInizialeDiAddebito + ", " : "")
               + (ripetizione != null ? "ripetizione=" + ripetizione : "") + "]";
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

   public boolean containsErrors()
   {
      if (this.getErr01() != null && !this.getErr01().trim().isEmpty()
               && this.getErr01().trim().equals(TipologiaERR01FlussoA.NESSUN_ERRORE.getValue()))
         return true;
      if (this.getErr02() != null && !this.getErr02().trim().isEmpty()
               && this.getErr01().trim().equals(TipologiaERR02FlussoA.NESSUN_ERRORE.getValue()))
         return true;
      if (this.getErr03() != null && !this.getErr03().trim().isEmpty()
               && this.getErr01().trim().equals(TipologiaERR03FlussoA.NESSUN_ERRORE.getValue()))
         return true;
      if (this.getErr04() != null && !this.getErr04().trim().isEmpty()
               && this.getErr01().trim().equals(TipologiaERR04FlussoA.NESSUN_ERRORE.getValue()))
         return true;
      if (this.getErr05() != null && !this.getErr05().trim().isEmpty()
               && this.getErr01().trim().equals(TipologiaERR05FlussoA.NESSUN_ERRORE.getValue()))
         return true;
      if (this.getErr06() != null && !this.getErr06().trim().isEmpty()
               && this.getErr01().trim().equals(TipologiaERR06FlussoA.NESSUN_ERRORE.getValue()))
         return true;
      if (this.getErr07() != null && !this.getErr07().trim().isEmpty()
               && this.getErr01().trim().equals(TipologiaERR07FlussoA.NESSUN_ERRORE.getValue()))
         return true;
      if (this.getErr08() != null && !this.getErr08().trim().isEmpty()
               && this.getErr01().trim().equals(TipologiaERR08FlussoA.NESSUN_ERRORE.getValue()))
         return true;
      if (this.getErr09() != null && !this.getErr09().trim().isEmpty()
               && this.getErr01().trim().equals(TipologiaERR09FlussoA.NESSUN_ERRORE.getValue()))
         return true;
      if (this.getErr10() != null && !this.getErr10().trim().isEmpty()
               && this.getErr01().trim().equals(TipologiaERR10FlussoA.NESSUN_ERRORE.getValue()))
         return true;
      return false;
   }

}
