
//------------------- TipologiaPosizioneContabile -------------------
CREATE TABLE TipologiaPosizioneContabile (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaPosizioneContabile VALUES ('PRIMO_INVIO', '1', 'primo invio (da usare nelle varie fasi di “Trasmissione in Regione”)')
INSERT INTO TipologiaPosizioneContabile VALUES ('PREST_ADD_RITARDO', '3', 'prestazione addebitata in ritardo a seguito di storno ad altri')
INSERT INTO TipologiaPosizioneContabile VALUES ('PREST_NON_ACQUISITA', '4', 'prestazione non acquisita nel data base regionale')
INSERT INTO TipologiaPosizioneContabile VALUES ('PREST_CONTESTATA', '5', 'prestazione contestata (da usare solo nella fase delle contestazioni)')
INSERT INTO TipologiaPosizioneContabile VALUES ('CONTEST_NON_ACCETTATA', 'A', 'contestazione non accettata,  conferma della prestazione')
INSERT INTO TipologiaPosizioneContabile VALUES ('CONTEST_ACCETTATA_CORREZ', 'B', 'contestazione accettata,  con correzione degli errori segnalati nella prestazione')
INSERT INTO TipologiaPosizioneContabile VALUES ('CONTEST_ACCETTATA', 'C', 'contestazione accettata')

//------------------- TipologiaSesso -------------------
CREATE TABLE TipologiaSesso (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaSesso VALUES ('MASCHIO', '1', 'maschio')
INSERT INTO TipologiaSesso VALUES ('FEMMINA', '2', 'femmina')

//------------------- TipologiaAltraAttivitaRicovero -------------------
CREATE TABLE TipologiaAltraAttivitaRicovero (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaAltraAttivitaRicovero VALUES ('ESPIANTO', '1', 'espianto di organo da cadavere per trapianto')
INSERT INTO TipologiaAltraAttivitaRicovero VALUES ('IMPIANTO_CUORE', '2', 'impianto di cuore artificiale')
INSERT INTO TipologiaAltraAttivitaRicovero VALUES ('ASSISTENZA_ALBERGHIERA', '3', 'assistenza alberghiera per il genitore che assiste il bambino ricoverato')
INSERT INTO TipologiaAltraAttivitaRicovero VALUES ('IMPIANTO_PROTESI', '4', 'impianto di protesi (Allegato 3 D.G.R. n. 1621 del 10.09.2002')

//------------------- TipologiaAutorizzazioneProroga -------------------
CREATE TABLE TipologiaAutorizzazioneProroga (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaAutorizzazioneProroga VALUES ('NESSUNA_AUTORIZZAZ', '0', 'nessuna value')
INSERT INTO TipologiaAutorizzazioneProroga VALUES ('AUTORIZZAZ_SUPERAMENTO_DEGENZA', '1', 'value per il superamento della degenza limite (relativamente alla disciplina 56 Riabilitazione e 60 Lungodenza)')
INSERT INTO TipologiaAutorizzazioneProroga VALUES ('ACCORDI_ISTIT_S_STEFANO', '2', 'acconti Istituto Santo Stefano')

//------------------- TipologiaERR01 -------------------
CREATE TABLE TipologiaERR01 (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaERR01 VALUES ('NESSUN_ERRORE', '0', 'nessun errore')
INSERT INTO TipologiaERR01 VALUES ('ID_UTENTE_ERR', '1', 'identificativo utente assente/errato')
INSERT INTO TipologiaERR01 VALUES ('UTENTE_NON_IN_ANAGRAFICA', '2', 'utente assente da anagrafe residenti')

//------------------- TipologiaERR02 -------------------
CREATE TABLE TipologiaERR02 (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaERR02 VALUES ('NESSUN_ERRORE', '0', 'nessun value')
INSERT INTO TipologiaERR02 VALUES ('COD_COMUNE_RESIDENZA_ASSENTE', '1', 'codice comune di residenza assente/errato')
INSERT INTO TipologiaERR02 VALUES ('COMUNE_RESIDENZA_NO_REGIONE', '2', 'comune di residenza non appartenente alla regione (per utenti residenti fuori regione) alla Zona Territoriale (per  utenti residenti nelle Marche) che riceve l’addebito')

//------------------- TipologiaERR03 -------------------
CREATE TABLE TipologiaERR03 (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaERR03 VALUES ('NESSUN_ERRORE', '0', 'nessun value')
INSERT INTO TipologiaERR03 VALUES ('DRG_NON_VALORIZZATO', '1', 'DRG non valorizzato o non appartenente alla tabella in vigore')
INSERT INTO TipologiaERR03 VALUES ('DRG_DIVERSO', '2', 'DRG diverso da quello determinato dalla Regione/Azienda che riceve l’addebito')
INSERT INTO TipologiaERR03 VALUES ('COD_DIAGNOSI_PRINCIPALE', '3', 'codice diagnosi principale non valorizzato o non appartenente alla tabella in vigore')

//------------------- TipologiaERR04 -------------------
CREATE TABLE TipologiaERR04 (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaERR04 VALUES ('NESSUN_ERRORE', '0', 'nessun value')
INSERT INTO TipologiaERR04 VALUES ('REGIME_ASSENTE', '1', 'regime di ricovero assente/errato')
INSERT INTO TipologiaERR04 VALUES ('REPARTO_DIMISSIONE_ASSENTE', '2', 'reparto di dimissione assente e/o i primi due caratteri del reparto dimissione non nel dominio (da flussi ministeriali per l’anno di riferimento)')
INSERT INTO TipologiaERR04 VALUES ('MODALITA_DIMISSIONE_ASSENTE', '3', 'modalità di dimissione assente/errata (non esistente nel dominio)')
INSERT INTO TipologiaERR04 VALUES ('TIPO_RICOVERO_NON_VALIDO', '4', 'tipo di ricovero non valorizzato o non esistente nel dominio')
INSERT INTO TipologiaERR04 VALUES ('PIU_ERRORI', '5', 'più errori concomitanti per questa tipologia di value')

//------------------- TipologiaERR05 -------------------
CREATE TABLE TipologiaERR05 (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaERR05 VALUES ('NESSUN_ERRORE', '0', 'nessun value')
INSERT INTO TipologiaERR05 VALUES ('RICOVERO_RIPETUTO', '3', 'ricovero ripetuto effettivo')

//------------------- TipologiaERR06 -------------------
CREATE TABLE TipologiaERR06 (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaERR06 VALUES ('NESSUN_ERRORE', '0', 'nessun value')
INSERT INTO TipologiaERR06 VALUES ('IMPORTO_ASSENTE', '1', 'importo assente/non valorizzato come numerico')
INSERT INTO TipologiaERR06 VALUES ('IMORTO_NON_CORRISPONDENTE', '2', 'importo non corrispondente a DRG e tariffa')

//------------------- TipologiaERR07 -------------------
CREATE TABLE TipologiaERR07 (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaERR07 VALUES ('NESSUN_ERRORE', '0', 'nessun value')
INSERT INTO TipologiaERR07 VALUES ('DIFF_DATA_DIMISSIONE_DATA_RICOVERO_PREC', '1', 'ricovero ripetuto con differenza tra la “data di dimissione” del ricovero precedente e la “data di ricovero” del ricovero successivo inferiore a  4 giorni')
INSERT INTO TipologiaERR07 VALUES ('DIFF_DATA_DIMISSIONE_DATA_RICOVERO_SUCC', '2', 'ricovero ripetuto con differenza tra la “data di dimissione” del ricovero precedente e la “data di ricovero” del ricovero successivo compresa tra  4 e 30 giorni')

//------------------- TipologiaERR08 -------------------
CREATE TABLE TipologiaERR08 (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaERR08 VALUES ('NESSUN_ERRORE', '0', 'nessun value')
INSERT INTO TipologiaERR08 VALUES ('DATA_RICOVERO_ASSENTE', '1', 'data di ricovero assente o formalmente scorretta')
INSERT INTO TipologiaERR08 VALUES ('DATA_DIMISS_ASSENTE', '2', 'data di dimissione assente o formalmente scorretta o relativa ad un anno diverso da quello di competenza')
INSERT INTO TipologiaERR08 VALUES ('DATA_DIMISS_INFERIORE', '3', 'data di dimissione inferiore alla data di ricovero')
INSERT INTO TipologiaERR08 VALUES ('NUM_GG_RICOVERO_NON_VALORIZZATO', '4', 'in caso di ricovero diurno: “numero giornate di presenza in ricovero diurno” non valorizzato come numerico o uguale a 0 oppure differenza in giorni tra data di dimissione e data di ricovero + 1 minore del campo “numero giornate di presenza in ricovero diurno”')
INSERT INTO TipologiaERR08 VALUES ('EVENTI_SENTINELLA', '5', 'ricovero di 2/3 giorni “eventi sentinella”')

//------------------- TipologiaERR09 -------------------
CREATE TABLE TipologiaERR09 (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaERR09 VALUES ('NESSUN_ERRORE', '0', 'nessun value')
INSERT INTO TipologiaERR09 VALUES ('IMPORTO_DIVERSO', '1', 'importo diverso da zero per onere della degenza non compensabile (codici onere 3, 4, 9)')
INSERT INTO TipologiaERR09 VALUES ('ONERE_DEGENZA', '2', 'onere della degenza assente/errato')

//------------------- TipologiaERR10 -------------------
CREATE TABLE TipologiaERR10 (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaERR10 VALUES ('NESSUN_ERRORE', '0', 'nessun value')
INSERT INTO TipologiaERR10 VALUES ('COD_REGIONE_ASSENTE', '1', 'codice Regione/Azienda U.S.L. assente o errato')

//------------------- TipologiaModalitaDimissione -------------------
CREATE TABLE TipologiaModalitaDimissione (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaModalitaDimissione VALUES ('DECEDUTO', '1', 'paziente deceduto')
INSERT INTO TipologiaModalitaDimissione VALUES ('DIMISS_ORDINARIA_DOMICILIO', '2', 'dimissione ordinaria al domicilio del paziente')
INSERT INTO TipologiaModalitaDimissione VALUES ('DIMISS_ORDINARIA_RESIDENZA_SANITARIA', '3', 'dimissione ordinaria presso una residenza sanitaria assistenziale (RSA) o Istituto di lungodegenza')
INSERT INTO TipologiaModalitaDimissione VALUES ('DIMISS_DOMICILIO', '4', 'dimissione al domicilio del paziente con attivazione di ospedalizzazione domiciliare')
INSERT INTO TipologiaModalitaDimissione VALUES ('DIMISS_VOLONTARIA', '5', 'dimissione volontaria (da usare anche nei casi in cui il paziente – in ciclo di trattamento diurno non si sia presentato durante il ciclo programmato)')
INSERT INTO TipologiaModalitaDimissione VALUES ('TRASFER_ALTRO_ISTITUTO_ACUTI', '6', 'trasferimento ad un altro Istituto di ricovero e cura, pubblico o privato, per acuti')
INSERT INTO TipologiaModalitaDimissione VALUES ('TRASFER_ALTRO_REGIME', '7', 'trasferimento ad altro regime di ricovero o ad altro tipo di attività di ricovero nell’ambito dello stesso Istituto')
INSERT INTO TipologiaModalitaDimissione VALUES ('TRASFER_ALTRO_ISTITUTO_RIABILITAZ', '8', 'trasferimento ad un Istituto pubblico o privato di riabilitazione')
INSERT INTO TipologiaModalitaDimissione VALUES ('DIMISS_ORDINARIA_ASSISTENZA', '9', 'dimissione ordinaria con attivazione di assistenza domiciliare integrata (ADI)')

//------------------- TipologiaMotivoRicoveroDiurno -------------------
CREATE TABLE TipologiaMotivoRicoveroDiurno (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaMotivoRicoveroDiurno VALUES ('DIAGNOSTICO', '1', 'ricovero diurno diagnostico (ivi compreso il follow up)')
INSERT INTO TipologiaMotivoRicoveroDiurno VALUES ('CHIRURGICO', '2', 'ricovero diurno chirurgico (day surgery)')
INSERT INTO TipologiaMotivoRicoveroDiurno VALUES ('TERAPEUTICO', '3', 'ricovero diurno terapeutico')
INSERT INTO TipologiaMotivoRicoveroDiurno VALUES ('RIABILITATIVO', '4', 'ricovero diurno riabilitativo')

//------------------- TipologiaMotivoRicoveroOrdinario -------------------
CREATE TABLE TipologiaMotivoRicoveroOrdinario (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaMotivoRicoveroOrdinario VALUES ('RICOVERO_ELETTIVO', '1', 'ricovero elettivo per intervento chirurgico')
INSERT INTO TipologiaMotivoRicoveroOrdinario VALUES ('PRIMO_RICOVERO', '2', 'primo ricovero effettuato per la specifica diagnosi')
INSERT INTO TipologiaMotivoRicoveroOrdinario VALUES ('RICOVERO_SUCCESSIVO', '3', 'ricovero successivo per la stessa diagnosi')
INSERT INTO TipologiaMotivoRicoveroOrdinario VALUES ('ALTRO', '9', 'altro')

//------------------- TipologiaNeonato -------------------
CREATE TABLE TipologiaNeonato (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaNeonato VALUES ('NON_NEONATO', '0', 'non value')
INSERT INTO TipologiaNeonato VALUES ('NEONATO_SANO', '1', 'value sano')
INSERT INTO TipologiaNeonato VALUES ('NEONATO_NON_SANO', '2', 'value non sano')
INSERT INTO TipologiaNeonato VALUES ('NEONATO_ALTRO_ISTITUTO', '3', 'value proveniente da altro Istituto di ricovero e cura')

//------------------- TipologiaOnereDegenza -------------------
CREATE TABLE TipologiaOnereDegenza (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaOnereDegenza VALUES ('RESPONSABILITA_TERZI', '0', 'presunta responsabilità terzi')
INSERT INTO TipologiaOnereDegenza VALUES ('TOT_CARICO_SSN', '1', 'ricovero a totale carico del SSN')
INSERT INTO TipologiaOnereDegenza VALUES ('PREVALENTE_CARICO_SSN_DIFF_ALBERGHIERA', '2', 'ricovero a prevalente carico SSN, con parte delle spese a carico  paziente (differenza alberghiera)')
INSERT INTO TipologiaOnereDegenza VALUES ('RIMBORSO', '3', 'ricovero con successivo rimborso (totale o parziale) a carico del SSN')
INSERT INTO TipologiaOnereDegenza VALUES ('SENZA_ONERI', '4', 'ricovero senza oneri per il SSN')
INSERT INTO TipologiaOnereDegenza VALUES ('PREVALENTE_CARICO_SSN_LIBERA_PROF', '5', 'ricovero a prevalente carico SSN, con parte delle spese a carico  paziente  (libera professione)')
INSERT INTO TipologiaOnereDegenza VALUES ('PREVALENTE_CARICO_SSN_DIFF_ALBERGHIERA_PROF', '6', 'ricovero a prevalente carico SSN, con parte delle spese a carico paziente (differenza alberghiera + libera professione)')
INSERT INTO TipologiaOnereDegenza VALUES ('CARICO_SSN_STRANIERI_CONVENZ', '7', 'ricovero a carico del SSN di paziente stranieri provenienti da paesi convenzionati con il SSN')
INSERT INTO TipologiaOnereDegenza VALUES ('CARICO_SSN_STRANIERI_INDIGENZA', '8', 'ricovero a carico del SSN di pazienti stranieri con dichiarazione di indigenza (minori e gravidanza/maternità)')
INSERT INTO TipologiaOnereDegenza VALUES ('CARICO_MINISTERO', 'A', 'ricovero a carico del Ministero dell’Interno di pazienti stranieri con dichiarazione di indigenza')
INSERT INTO TipologiaOnereDegenza VALUES ('CARICO_SSN_STRANIERI_TRASFERITI', 'B', 'ricovero a carico del SSN di pazienti stranieri trasferiti in Italia per cure (programmi Umanitari ex art. 12 comma 2 lett. c del D. Lgs. 502/92)')
INSERT INTO TipologiaOnereDegenza VALUES ('ALTRO', '9', 'altro')

//------------------- TipologiaPosizioneTicket -------------------
CREATE TABLE TipologiaPosizioneTicket (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaPosizioneTicket VALUES ('ESENTE_TOT', '1', 'esente totale')
INSERT INTO TipologiaPosizioneTicket VALUES ('NON_ESENTE', '2', 'non esente')
INSERT INTO TipologiaPosizioneTicket VALUES ('QUOTA_RICETTA', '3', 'pagamento quota ricetta')

//------------------- TipologiaProvenienzaPaziente -------------------
CREATE TABLE TipologiaProvenienzaPaziente (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaProvenienzaPaziente VALUES ('SENZA_PROPOSTA_RICOVERO', '1', 'paziente che acceda all’istituto di cura senza proposta di ricovero formulata da un medico')
INSERT INTO TipologiaProvenienzaPaziente VALUES ('CON_PROPOSTA_RICOVERO', '2', 'paziente inviato all’istituto di cura con proposta del medico di base')
INSERT INTO TipologiaProvenienzaPaziente VALUES ('RICOVERO_PROGRAMMATO', '3', 'ricovero precedentemente programmato dallo stesso istituto di cura')
INSERT INTO TipologiaProvenienzaPaziente VALUES ('PAZIENTE_TRASFERITO_STESSO_ISTIT', '4', 'paziente trasferito da un istituto di cura pubblico')
INSERT INTO TipologiaProvenienzaPaziente VALUES ('PAZIENTE_TRASFERITO_ALTRO_ISTIT', '5', 'paziente trasferito da un istituto di cura privato accreditato')
INSERT INTO TipologiaProvenienzaPaziente VALUES ('PAZIENTE_TRASFERITO_ISTIT_PRIVATO', '6', 'paziente trasferito da un istituto di cura privato non accreditato')
INSERT INTO TipologiaProvenienzaPaziente VALUES ('PAZIENTE_TRASFERITO_ALTRO', '7', 'paziente trasferito da altro tipo di attività di ricovero (acuti, riabilitazione, lungodegenza) o da altro regime di ricovero (ricovero diurno ò ordinario) nello stesso Istituto')
INSERT INTO TipologiaProvenienzaPaziente VALUES ('GUARDIA_MDICA', '8', 'guardia medica')
INSERT INTO TipologiaProvenienzaPaziente VALUES ('ALTRO', '9', 'altro')

//------------------- TipologiaRegimeRicovero -------------------
CREATE TABLE TipologiaRegimeRicovero (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaRegimeRicovero VALUES ('ORDINARIO', '1', 'ricovero ordinario')
INSERT INTO TipologiaRegimeRicovero VALUES ('DIURNO', '2', 'ricovero diurno')

//------------------- TipologiaRicoveroOrdinario -------------------
CREATE TABLE TipologiaRicoveroOrdinario (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaRicoveroOrdinario VALUES ('PROGRAMMATO_URGENTE', '1', 'value programmato, non urgente')
INSERT INTO TipologiaRicoveroOrdinario VALUES ('URGENTE', '2', 'value urgente')
INSERT INTO TipologiaRicoveroOrdinario VALUES ('OBBLIGATORIO', '3', 'value per trattamento sanitario obbligatorio (TSO)')
INSERT INTO TipologiaRicoveroOrdinario VALUES ('PREOSPEDALIZZAZIONE', '4', 'value programmato con pre- ospedalizzazione (art. 1, comma 18 Legge 662/96) -  in questo caso possono essere riportate le procedure eseguite in data precedente l’ammissione (DGR 926/99)')
INSERT INTO TipologiaRicoveroOrdinario VALUES ('VOLONTARIO', '5', 'value per trattamento sanitario volontario (TSV)')

//------------------- TipologiaStatoCivile -------------------
CREATE TABLE TipologiaStatoCivile (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaStatoCivile VALUES ('CELIBE', '1', 'celibe/nubile')
INSERT INTO TipologiaStatoCivile VALUES ('CONIUGATO', '2', 'coniugato/a')
INSERT INTO TipologiaStatoCivile VALUES ('SEPARATO', '3', 'separato/a')
INSERT INTO TipologiaStatoCivile VALUES ('DIVORZIATO', '4', 'divorziato/a')
INSERT INTO TipologiaStatoCivile VALUES ('VEDOVO', '5', 'vedovo/a')
INSERT INTO TipologiaStatoCivile VALUES ('NON_DICHIRATO', '6', 'non dichiarato')

//------------------- TipologiaTipoRicoveroDiurno -------------------
CREATE TABLE TipologiaTipoRicoveroDiurno (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaTipoRicoveroDiurno VALUES ('PRIMO_CICLO', '1', 'primo ciclo per la specifica diagnosi')
INSERT INTO TipologiaTipoRicoveroDiurno VALUES ('CICLO_SUCCESSIVO', '2', 'ciclo successivo per la stessa diagnosi')

//------------------- TipologiaTitoloStudio -------------------
CREATE TABLE TipologiaTitoloStudio (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaTitoloStudio VALUES ('NESSUN_TITOLO', '0', 'nessun titolo')
INSERT INTO TipologiaTitoloStudio VALUES ('ELEMENTARE', '1', 'licenza scuola elementare')
INSERT INTO TipologiaTitoloStudio VALUES ('MEDIA', '2', 'licenza scuola media inferiore o avviamento professionale')
INSERT INTO TipologiaTitoloStudio VALUES ('DIPLOMA_PROFESSIONALE', '3', 'diploma di qualifica professionale (corso di 2/3 anni che non permette l'accesso all'Università)')
INSERT INTO TipologiaTitoloStudio VALUES ('DIPLOMA_MATURITA', '4', 'diploma di maturità')
INSERT INTO TipologiaTitoloStudio VALUES ('LAUREA', '5', 'diploma universitario, laurea')

//------------------- TipologiaTrasmissioneInRegione -------------------
CREATE TABLE TipologiaTrasmissioneInRegione (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaTrasmissioneInRegione VALUES ('PRIMO_INVIO', '1', 'primo invio => scheda appartenente al trimestre di competenza')
INSERT INTO TipologiaTrasmissioneInRegione VALUES ('INTEGRAZIONE', '2', 'integrazione => scheda relativa ai trimestri precedenti mai trasmessa')
INSERT INTO TipologiaTrasmissioneInRegione VALUES ('SOSTITUZIONA', '3', 'sostituzione  => scheda modificata dall’Azienda sanitaria')
INSERT INTO TipologiaTrasmissioneInRegione VALUES ('CORREZIONE', '4', 'correzione => scheda corretta sulla base degli errori segnalati nel file A3 relativo alla scheda non acquisita nel database regionale (campo posizione contabile)')
INSERT INTO TipologiaTrasmissioneInRegione VALUES ('ELIMINAZIONE', '5', 'eliminazione => scheda eliminata definitivamente')

//------------------- TipologiaTraumativi -------------------
CREATE TABLE TipologiaTraumativi (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaTraumativi VALUES ('INFORTUNIO_LAVORO', '1', 'infortunio sul lavoro')
INSERT INTO TipologiaTraumativi VALUES ('INFORTUNIO_DOMESTICO', '2', 'infortunio in ambiente domestico')
INSERT INTO TipologiaTraumativi VALUES ('INCIDENTE_STRADALE', '3', 'incidente stradale')
INSERT INTO TipologiaTraumativi VALUES ('VIOLENZA_ALTRUI', '4', 'violenza altrui (indipendentemente dal luogo dove è avvenuta)')
INSERT INTO TipologiaTraumativi VALUES ('AUTOLESIONE', '5', 'autolesione o tentativo di suicidio (indipendentemente dal luogo dove è avvenuto)')
INSERT INTO TipologiaTraumativi VALUES ('MORSO_ANIMALE', '6', 'morso animale/insetto')
INSERT INTO TipologiaTraumativi VALUES ('INCIDENTE_SPORTIVO', '7', 'incidente sportivo')
INSERT INTO TipologiaTraumativi VALUES ('ALTRO', '9', 'altro tipo di incidente o di intossicazione')

//------------------- TipologiaAttivitaPS -------------------
CREATE TABLE TipologiaAttivitaPS (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaAttivitaPS VALUES ('NO_PS', '0', 'no pronto soccorso')
INSERT INTO TipologiaAttivitaPS VALUES ('SI_PS', '1', 'si pronto soccorso')

//------------------- TipologiaCicloPrestazioni -------------------
CREATE TABLE TipologiaCicloPrestazioni (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaCicloPrestazioni VALUES ('NO', '0', 'no prestazione a ciclo')
INSERT INTO TipologiaCicloPrestazioni VALUES ('SI', '1', 'si prestazione a ciclo')

//------------------- TipologiaERR01 -------------------
CREATE TABLE TipologiaERR01 (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaERR01 VALUES ('NESSUN_ERRORE', '0', 'nessun value')
INSERT INTO TipologiaERR01 VALUES ('ID_UTENTE_ERR', '1', 'identificativo utente assente/errato')
INSERT INTO TipologiaERR01 VALUES ('UTENTE_NON_IN_ANAGRAFICA', '2', 'utente assente da anagrafe residenti')
INSERT INTO TipologiaERR01 VALUES ('CR_NESSUN_ERRORE', 'A', 'nessun value')
INSERT INTO TipologiaERR01 VALUES ('CR_CF_ASSENTE', 'B', '“codice fiscale dell’utente” assente o errato')
INSERT INTO TipologiaERR01 VALUES ('IE_DATA_NASCITA_ASSENTE', 'C', '“data di nascita dell’utente” assente o errata')
INSERT INTO TipologiaERR01 VALUES ('IE_STATO_ESTERO_ASSENTE', 'D', '“stato estero risultante nella TEAM” assente')
INSERT INTO TipologiaERR01 VALUES ('IE_ISTITUZ_COMPETENTE_ASSENTE', 'E', '“Istituzione competente” assente')
INSERT INTO TipologiaERR01 VALUES ('IE_ID_PERSONALE_ASSENTE', 'F', '“Numero identificazione personale” assente')
INSERT INTO TipologiaERR01 VALUES ('IE_ID_TESSERA_ASSENTE', 'G', '“Numero Identificativo Tessera” assente')
INSERT INTO TipologiaERR01 VALUES ('IE_SCADENZA_TESSERA_ASSENTE', 'H', '“Scadenza Tessera” assente')

//------------------- TipologiaERR02 -------------------
CREATE TABLE TipologiaERR02 (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaERR02 VALUES ('NESSUN_ERRORE', '0', 'nessun value')
INSERT INTO TipologiaERR02 VALUES ('COD_COMUNE_RESIDENZA_ASSENTE', '1', 'codice comune di residenza assente/errato')
INSERT INTO TipologiaERR02 VALUES ('COMUNE_RESIDENZA_NO_REGIONE', '2', 'comune di residenza non appartenente alla regione (per utenti residenti fuori regione) alla Zona Territoriale (per  utenti residenti nelle Marche) che riceve l’addebito')
INSERT INTO TipologiaERR02 VALUES ('CR_NESSUN_ERRORE', 'A', 'nessun value')
INSERT INTO TipologiaERR02 VALUES ('CR_COMUNE_RESIDENZA_ASSENTE', 'B', '“comune di residenza dell’utente” assente o errato')
INSERT INTO TipologiaERR02 VALUES ('CR_REGIONE_RESIDENZA_ASSENTE', 'C', '“regione di residenza dell’utente” assente o errato')
INSERT INTO TipologiaERR02 VALUES ('CR_ZONA_TERRITORIALE_ASSENTE', 'D', '“zona territoriale/azienda USL di residenza dell’utente” assente o errata')
INSERT INTO TipologiaERR02 VALUES ('CR_COMUNE_RESIDENZA_INCONGRUENTE', 'E', '“comune di residenza dell’utente” incongruente con “regione di residenza dell’utente”')
INSERT INTO TipologiaERR02 VALUES ('CR_ZONA_TERRITORIALE_INCONGRUENTE', 'F', '“zona territoriale/azienda USL di residenza dell’utente” incongruente con “comune residenza utente”')

//------------------- TipologiaERR03 -------------------
CREATE TABLE TipologiaERR03 (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaERR03 VALUES ('NESSUN_ERRORE', '0', 'nessun value')
INSERT INTO TipologiaERR03 VALUES ('COD_NOMENCLATORE_ASSENTE', '1', 'codice nomenclatore assente o non previsto nel dominio (solo sulle righe zn)')
INSERT INTO TipologiaERR03 VALUES ('COD_PRESTAZIONE_ASSENTE', '2', 'codice prestazione assente o non previsto nel dominio (solo sulle righe zn)')
INSERT INTO TipologiaERR03 VALUES ('CR_NESSUN_ERRORE', 'A', 'nessun value')
INSERT INTO TipologiaERR03 VALUES ('CR_COD_NOMENCLATORE_ASSENTE', 'B', '“codifica nomenclatore” assente o errata')
INSERT INTO TipologiaERR03 VALUES ('CR_COD_PRESTAZIONE_ASSENTE', 'C', '“codice della prestazione erogata” assente o errato')
INSERT INTO TipologiaERR03 VALUES ('CR_COD_BRANCA_ASSENTE', 'D', '“codice branca specialistica della prestazione erogata” assente o errato')
INSERT INTO TipologiaERR03 VALUES ('CR_COD_SPECIALITA_ASSENTE', 'E', '“codice specialità della prestazione erogata” assente o errata')
INSERT INTO TipologiaERR03 VALUES ('CR_TARIFFA_ASSENTE', 'F', '“tariffa della prestazione erogata” assente o errata')
INSERT INTO TipologiaERR03 VALUES ('RIC_ACCESSO_PRESTAZIONI_ASSENTE', 'G', '“modalità di accesso alle prestazioni” assente o errato')
INSERT INTO TipologiaERR03 VALUES ('RIC_ONERE_ASSENTE', 'H', '“onere della prestazione” assente o errato')

//------------------- TipologiaERR04 -------------------
CREATE TABLE TipologiaERR04 (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaERR04 VALUES ('NESSUN_ERRORE', 'A', 'nessun value')
INSERT INTO TipologiaERR04 VALUES ('REGION_ASSENTE', 'B', '“Regione addebitante” assente o errata')
INSERT INTO TipologiaERR04 VALUES ('ZONA_ASSENTE', 'C', '“Zona territoriale/Azienda Ospedaliera inviante” assente o errata')
INSERT INTO TipologiaERR04 VALUES ('COD_STRUTTURA_ACCETTANTE_ASSENTE', 'D', '“Codice struttura accettante/richiedente” assente o errato')
INSERT INTO TipologiaERR04 VALUES ('COD_STRUTTURA_EROGANTE_ASSENTE', 'E', '“Codice struttura erogante la prestazione” assente o errato')

//------------------- TipologiaERR05 -------------------
CREATE TABLE TipologiaERR05 (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaERR05 VALUES ('NESSUN_ERRORE', '0', 'nessun value')
INSERT INTO TipologiaERR05 VALUES ('RIGHE_DETTAGLIO_ASSENTI', '3', 'mancanza righe di dettaglio (righe zn  da 01 a 98) - da segnalare sulla riga 99')
INSERT INTO TipologiaERR05 VALUES ('RIGA_TOTALE_ASSENTE', '4', 'mancanza di riga totale (riga 99) riga zn senza riga 99')
INSERT INTO TipologiaERR05 VALUES ('CR_NESSUN_ERRORE', 'A', 'nessun value')
INSERT INTO TipologiaERR05 VALUES ('CR_NUM_RICETTA_ASSENTE', 'B', '“numero ricetta” assente o errato')
INSERT INTO TipologiaERR05 VALUES ('CR_PROGRESSIVO_RIGA_ASSENTE', 'C', '“progressivo riga per ricetta” assente o errato')
INSERT INTO TipologiaERR05 VALUES ('CR_POSIZ_CONTABILE_ASSENTE', 'D', '“posizione contabile” assente o errata')
INSERT INTO TipologiaERR05 VALUES ('CR_ID_ASSENTE', 'E', '“ID” assente o errato')
INSERT INTO TipologiaERR05 VALUES ('CR_RECORD_DOPPIO', 'F', 'record doppio')
INSERT INTO TipologiaERR05 VALUES ('CR_TRASMISS_REGIONE_ASSENTE', 'G', '“trasmissione in regione” assente o errata')
INSERT INTO TipologiaERR05 VALUES ('CR_RIGHE_DETTAGLIO_ASSENTI', 'H', 'mancanza righe di dettaglio (righe zn  da 01 a 98) - da segnalare sulla riga 99')
INSERT INTO TipologiaERR05 VALUES ('CR_RIGA_TOTALE_aSSENTE', 'I', 'mancanza di riga totale (riga 99) righe zn senza riga 99 da segnalare su tutte le righe zn')

//------------------- TipologiaERR06 -------------------
CREATE TABLE TipologiaERR06 (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaERR06 VALUES ('NESSUN_ERRORE', '0', 'nessun value')
INSERT INTO TipologiaERR06 VALUES ('IMPORTO_RIGA_NON_VALIDO', '1', 'importo riga non valorizzato come numerico')
INSERT INTO TipologiaERR06 VALUES ('R99_IMPORTO_TICKET_NON_VALIDO', '2', 'importo ticket riga 99 non valorizzato come numerico')
INSERT INTO TipologiaERR06 VALUES ('R99_RIGA99_NON_VALIDO', '3', 'importo totale riga 99 non valorizzato come numerico e importo ticket riga 99 non valorizzato come numerico')
INSERT INTO TipologiaERR06 VALUES ('R99_RIGA99_MAGGIORE_SOMMA', '4', 'importo totale della riga 99 maggiore della somma dell’importo delle righe zn meno il ticket della riga 99')
INSERT INTO TipologiaERR06 VALUES ('R99_IMPORTO_SUPERIORE', '5', 'importo superiore all’importo calcolato da quantità e tariffa del nomenclatore regionale solo sulle righe zn')
INSERT INTO TipologiaERR06 VALUES ('CR_NESSUN_ERRORE', 'A', 'nessun value')
INSERT INTO TipologiaERR06 VALUES ('CR_TICKET_aSSISTITO_NON_VALIDO', 'B', 'campo “ticket pagato dall’assistito” non valorizzato oppure maggiore di € 36,20 quando il campo “tipo esenzione” assume valore 1')
INSERT INTO TipologiaERR06 VALUES ('CR_QUOTA_FISSA_NON_VALIDO', 'C', 'campo “quota fissa pagata dall’assistito” assente o errata quando il campo “quota fissa per ricetta” assume i valori A o B')
INSERT INTO TipologiaERR06 VALUES ('CR_TOT_99_NON_VALIDO', 'D', 'importo totale della riga 99 diverso della somma dell’importo delle righe zn meno il “ticket pagato dall’assistito” e della “quota fissa pagata dall’assistito” della riga 99 o non valorizzato come numerico')
INSERT INTO TipologiaERR06 VALUES ('CR_TOT_NON_VALIDO', 'E', '“importo totale” delle righe da 1 a 98 diverso dall’importo calcolato come prodotta tra “numero delle prestazioni” per [“tariffa della prestazione erogata”  meno “importo Sconto”] per “tariffa prestazione erogata” meno “importo sconto” o non valorizzato come numerico')
INSERT INTO TipologiaERR06 VALUES ('CR_SCONOT_NON_VALIDO', 'F', '“percentuale sconto da applicare” non numerico')
INSERT INTO TipologiaERR06 VALUES ('CR_SCONT_ASSENTE', 'G', '“importo sconto” assente o errato quando il valore del campo “percentuale di sconto da Applicare” è diversa da 00')
INSERT INTO TipologiaERR06 VALUES ('CR_QUOTA_FISSA_ASSENTE', 'H', '“quota fissa per ricetta” assente o errata')

//------------------- TipologiaERR07 -------------------
CREATE TABLE TipologiaERR07 (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaERR07 VALUES ('NESSUN_ERRORE', '0', 'nessun value')
INSERT INTO TipologiaERR07 VALUES ('QUANTITA_NON_VALIDA', '1', 'quantità non valorizzata o non numerico (solo sulle righe zn)')
INSERT INTO TipologiaERR07 VALUES ('CR_NESSUN_ERRORE', 'A', 'nessun value')
INSERT INTO TipologiaERR07 VALUES ('CR_NUM_PREST_ASSENTE', 'B', '“numero delle prestazioni” assente o errato')

//------------------- TipologiaERR08 -------------------
CREATE TABLE TipologiaERR08 (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaERR08 VALUES ('NESSUN_ERRORE', '0', 'nessun value')
INSERT INTO TipologiaERR08 VALUES ('DATA_EROGAZIONE_ERRATA', '1', 'la data di erogazione o di fine ciclo è assente/errata o non appartenente all’anno di competenza sulla riga zn (nel caso di data non appartenente all’anno di competenza sarà da segnalare l’value solo se tutte le righe non appartengono all’anno di competenza)')
INSERT INTO TipologiaERR08 VALUES ('CR_NESSUN_ERRORE', 'A', 'nessun value')
INSERT INTO TipologiaERR08 VALUES ('CR_DATA_RICETTA_ASSENTE', 'B', '“data ricetta” assente o errata')
INSERT INTO TipologiaERR08 VALUES ('CR_DATA_PRENOTAZIONE_ASSENTE', 'C', '“data di prenotazione” assente o errata')
INSERT INTO TipologiaERR08 VALUES ('CR_DATA_EROGAZIONE_ASSENTE', 'D', '“data di erogazione delle prestazioni” assente o errata')
INSERT INTO TipologiaERR08 VALUES ('CR_DATA_PAC_ASSENTE', 'E', 'data inizio P.A.C./inizio ciclo di prestazioni assente o errata se i campi “P.A.C.” e “ciclo di  prestazioni” assumono valore 1')

//------------------- TipologiaERR09 -------------------
CREATE TABLE TipologiaERR09 (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaERR09 VALUES ('A', 'A', 'nessun errore')
INSERT INTO TipologiaERR09 VALUES ('B', 'B', '“tipo esenzione” assente o errato')
INSERT INTO TipologiaERR09 VALUES ('C', 'C', '“codice esenzione” assente o errato se il campo “tipo esenzione” assume valori diversi da 1')
INSERT INTO TipologiaERR09 VALUES ('D', 'D', '“tipo esenzione” non univoco nello stesso gruppo ricetta')

//------------------- TipologiaERR10 -------------------
CREATE TABLE TipologiaERR10 (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaERR10 VALUES ('NESSUN_ERRORE', '0', 'nessun value')
INSERT INTO TipologiaERR10 VALUES ('COD_REGIONE_ASSENTE', '1', 'codice Regione/Azienda U.S.L. assente o errato')

//------------------- TipologiaEsenzione -------------------
CREATE TABLE TipologiaEsenzione (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaEsenzione VALUES ('ALTRO', '0', 'altro (voce residuale, che riguarda comunque assistiti esenti)')
INSERT INTO TipologiaEsenzione VALUES ('NON_ESENTE', '1', 'non esente (assistito soggetto al pagamento del ticket)')
INSERT INTO TipologiaEsenzione VALUES ('ESENTE_PER_CONDIZIONE', '2', 'esente per condizione')
INSERT INTO TipologiaEsenzione VALUES ('ESENTE_PER_PATOLOGIA', '3', 'esente per patologia')
INSERT INTO TipologiaEsenzione VALUES ('ESENTE_PER_REDDITO', '6', 'esente per reddito (autocertificazione)')
INSERT INTO TipologiaEsenzione VALUES ('ESENTE_PER_ALTRA_ESENZIONE', '7', 'esente per reddito e presenza di altra esenzione')
INSERT INTO TipologiaEsenzione VALUES ('PAGANTE_IN_PROPRIO', 'A', 'utente pagante in proprio (libera professione, prestazioni fuori L.E.A.)')

//------------------- TipologiaMedicoPrescrittore -------------------
CREATE TABLE TipologiaMedicoPrescrittore (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaMedicoPrescrittore VALUES ('F', 'F', 'medico di medicina generale')
INSERT INTO TipologiaMedicoPrescrittore VALUES ('P', 'P', 'pediatra di libera scelta')
INSERT INTO TipologiaMedicoPrescrittore VALUES ('H', 'H', 'ospedaliero')
INSERT INTO TipologiaMedicoPrescrittore VALUES ('A', 'A', 'specialista ambulatoriale (ex SUMAI)')
INSERT INTO TipologiaMedicoPrescrittore VALUES ('G', 'G', 'guardia medica')
INSERT INTO TipologiaMedicoPrescrittore VALUES ('T', 'T', 'guardia medica turistica')
INSERT INTO TipologiaMedicoPrescrittore VALUES ('C', 'C', 'specialista di struttura privata accreditata')
INSERT INTO TipologiaMedicoPrescrittore VALUES ('U', 'U', 'medico di azienda ospedaliero-universitaria')
INSERT INTO TipologiaMedicoPrescrittore VALUES ('D', 'D', 'dipendente dei servizi territoriali ASL/ASUR')
INSERT INTO TipologiaMedicoPrescrittore VALUES ('Z', 'Z', 'altra specializzazione')
INSERT INTO TipologiaMedicoPrescrittore VALUES ('W', 'W', 'medico di altra regione')
INSERT INTO TipologiaMedicoPrescrittore VALUES ('X', 'X', 'medico pronto soccorso')
INSERT INTO TipologiaMedicoPrescrittore VALUES ('Y', 'Y', 'medico SERT')

//------------------- TipologiaModalitaAccessoPrestazioni -------------------
CREATE TABLE TipologiaModalitaAccessoPrestazioni (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaModalitaAccessoPrestazioni VALUES ('SPECIALISTICA_AMBUL', '10', 'prestazione specialistica ambulatoriale prescritta su ricettario S.S.N.')
INSERT INTO TipologiaModalitaAccessoPrestazioni VALUES ('AGGIUNTIVA', '11', 'prestazione aggiuntiva qualora il medico specialista ritenga necessario effettuare  ulteriori prestazioni rispetto a quelle inizialmente prescritte dal medico di fiducia del paziente, deve procedere alla compilazione di una nuova ricetta')
INSERT INTO TipologiaModalitaAccessoPrestazioni VALUES ('SPECIALISTICA_INVITO', '12', 'prestazione specialistica su invito  ("relativa agli screening")')
INSERT INTO TipologiaModalitaAccessoPrestazioni VALUES ('EX_ART_26', '13', 'prestazione ex art. 26 Legge 833/1978')
INSERT INTO TipologiaModalitaAccessoPrestazioni VALUES ('DOMICILIO', '14', 'prestazione erogata presso il domicilio del paziente')
INSERT INTO TipologiaModalitaAccessoPrestazioni VALUES ('RIDUZ_LISTE_ATTESA', '15', 'Libera professione prestazione rientrante tra le attività aziendali aggiuntive  ("ex art. 55, comma 2 CCNL 1998/2001") finalizzate alla riduzione delle liste d’attesa')
INSERT INTO TipologiaModalitaAccessoPrestazioni VALUES ('CERTIFICAZ_MEDICA', '16', 'prestazione erogata al fine del rilascio della certificazione medico – sportiva')
INSERT INTO TipologiaModalitaAccessoPrestazioni VALUES ('CENTRO_ANTIDIABETICO', '17', 'prestazione Centro Antidiabetico')
INSERT INTO TipologiaModalitaAccessoPrestazioni VALUES ('RADIOTERAPIA', '18', 'prestazione di Radioterapia')
INSERT INTO TipologiaModalitaAccessoPrestazioni VALUES ('DIALISI', '19', 'prestazione di Dialisi')
INSERT INTO TipologiaModalitaAccessoPrestazioni VALUES ('LIBERO_ACCESSO', '20', 'prestazione a libero accesso')
INSERT INTO TipologiaModalitaAccessoPrestazioni VALUES ('LIBERA_PROFESSIONE', '21', 'prestazione erogata in regime di libera professione')
INSERT INTO TipologiaModalitaAccessoPrestazioni VALUES ('SERT', '22', 'prestazione erogata dai SERT')
INSERT INTO TipologiaModalitaAccessoPrestazioni VALUES ('LEA', '23', 'prestazione non rientrante nei LEA')
INSERT INTO TipologiaModalitaAccessoPrestazioni VALUES ('PS_NON_CLASSIFICATA', '30', 'prestazione di pronto soccorso ("non seguito da ricovero") non classificata')
INSERT INTO TipologiaModalitaAccessoPrestazioni VALUES ('PS_COD_BIANCO', '31', 'prestazione di pronto soccorso  ("non seguito da ricovero") classificata codice bianco')
INSERT INTO TipologiaModalitaAccessoPrestazioni VALUES ('PS_COD_VERDE', '32', 'prestazione di pronto soccorso  ("non seguito da ricovero") classificata codice verde')
INSERT INTO TipologiaModalitaAccessoPrestazioni VALUES ('PS_COD_GIALLO', '33', 'prestazione di pronto soccorso  ("non seguito da ricovero") classificata codice giallo')
INSERT INTO TipologiaModalitaAccessoPrestazioni VALUES ('OSSERVAZ_BREVE_INTENSIVA', '34', 'prestazione di Osservazione Breve Intensiva  ("O.B.I.")')
INSERT INTO TipologiaModalitaAccessoPrestazioni VALUES ('PS_COD_ROSSO', '35', 'prestazione di pronto soccorso  ("non seguito da ricovero") classificata codice rosso')
INSERT INTO TipologiaModalitaAccessoPrestazioni VALUES ('RICHIESTA_IN_REGIME', '50', 'prestazione richiesta in regime di cessione di servizi')
INSERT INTO TipologiaModalitaAccessoPrestazioni VALUES ('SPECIALISTICA_INTERNA', '99', 'ricetta specialistica interna')

//------------------- TipologiaModalitaCompilazRicetta -------------------
CREATE TABLE TipologiaModalitaCompilazRicetta (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaModalitaCompilazRicetta VALUES ('COMPIL_MANUALMENTE', '1', 'ricetta compilata manualmente')
INSERT INTO TipologiaModalitaCompilazRicetta VALUES ('INFORMATIZZATA_NO_CF', '2', 'ricetta informatizzata con presenza della biffatura “Stampa PC”, ma assenza del codice fiscale in modalità barcode')
INSERT INTO TipologiaModalitaCompilazRicetta VALUES ('INFORMATIZZATA_CON_CF', '3', 'ricetta informatizzata con presenza della biffatura “Stampa PC” e del codice fiscale in modalità barcode')

//------------------- TipologiaModalitaRilevazCF -------------------
CREATE TABLE TipologiaModalitaRilevazCF (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaModalitaRilevazCF VALUES ('D', 'D', 'da ricetta')

//------------------- TipologiaOnerePrestazione -------------------
CREATE TABLE TipologiaOnerePrestazione (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaOnerePrestazione VALUES ('SSN', '1', 'SSN')
INSERT INTO TipologiaOnerePrestazione VALUES ('MINIST_SALUTE', '2', 'Ministero della Salute per personale navigante, marittimo e dell’aviazione civile')
INSERT INTO TipologiaOnerePrestazione VALUES ('ISTITUZ_ESTERE', '3', 'Istituzioni estere in base a norme comunitarie o Accordi bilaterali di sicurezza Sociale')
INSERT INTO TipologiaOnerePrestazione VALUES ('PAGANTI', '4', 'Paganti in proprio (libera professione, prestazioni fuori LEA)')

//------------------- TipologiaPAC -------------------
CREATE TABLE TipologiaPAC (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaPAC VALUES ('NO_PAC', '0', 'no PAC')
INSERT INTO TipologiaPAC VALUES ('SI_PAC', '1', 'si PAC')

//------------------- TipologiaPrescrizione -------------------
CREATE TABLE TipologiaPrescrizione (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaPrescrizione VALUES ('S', 'S', 'suggerita')
INSERT INTO TipologiaPrescrizione VALUES ('A', 'A', 'altro')

//------------------- TipologiaPresenzaQuesitoDiagnostico -------------------
CREATE TABLE TipologiaPresenzaQuesitoDiagnostico (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaPresenzaQuesitoDiagnostico VALUES ('SI', '0', 'si')
INSERT INTO TipologiaPresenzaQuesitoDiagnostico VALUES ('NO', '1', 'no')

//------------------- TipologiaPrioritaAccessoPrestaz -------------------
CREATE TABLE TipologiaPrioritaAccessoPrestaz (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaPrioritaAccessoPrestaz VALUES ('Z', 'Z', 'non classificato')
INSERT INTO TipologiaPrioritaAccessoPrestaz VALUES ('U', 'U', 'casella contrassegnata dalla lettera “U” per urgente;')
INSERT INTO TipologiaPrioritaAccessoPrestaz VALUES ('B', 'B', 'casella contrassegnata dalla lettera “B” per breve;')
INSERT INTO TipologiaPrioritaAccessoPrestaz VALUES ('D', 'D', 'casella contrassegnata dalla lettera “D” per differita;')
INSERT INTO TipologiaPrioritaAccessoPrestaz VALUES ('P', 'P', 'casella contrassegnata dalla lettera “P” per programmata;')

//------------------- TipologiaQuotaFissaRicetta -------------------
CREATE TABLE TipologiaQuotaFissaRicetta (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaQuotaFissaRicetta VALUES ('Z', 'Z', 'no quota fissa')
INSERT INTO TipologiaQuotaFissaRicetta VALUES ('A', 'A', 'quota fissa per prestazioni specialistiche')
INSERT INTO TipologiaQuotaFissaRicetta VALUES ('B', 'B', 'quota fissa per prestazioni di pronto soccorso non seguite da ricovero')

//------------------- TipologiaTipoAccesso -------------------
CREATE TABLE TipologiaTipoAccesso (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaTipoAccesso VALUES ('NON_CLASSIFICATO', '0', 'non classificato')
INSERT INTO TipologiaTipoAccesso VALUES ('PRMO_ACCESSO', '1', 'primo value')
INSERT INTO TipologiaTipoAccesso VALUES ('SECONDO_ACCESSO', '2', 'secondo value (per approfondimento, controlli, ecc)')

//------------------- TipologiaTipoRicetta -------------------
CREATE TABLE TipologiaTipoRicetta (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaTipoRicetta VALUES ('EE', 'E', 'assicurati extraeuropei in temporaneo soggiorno')
INSERT INTO TipologiaTipoRicetta VALUES ('UE', 'E', 'assicurati europei in temporaneo soggiorno')
INSERT INTO TipologiaTipoRicetta VALUES ('NA', 'A', 'assistiti SASN con visita ambulatoriale')
INSERT INTO TipologiaTipoRicetta VALUES ('ND', 'D', 'assistiti SASN con visita domiciliare')
INSERT INTO TipologiaTipoRicetta VALUES ('NE', 'E', 'assistiti da Istituzioni estere')
INSERT INTO TipologiaTipoRicetta VALUES ('NX', 'X', 'assistito SASN extraeuropeo')
INSERT INTO TipologiaTipoRicetta VALUES ('ST', 'T', 'straniero in temporaneo soggiorno')
INSERT INTO TipologiaTipoRicetta VALUES ('AD', 'D', 'pazienti in assistenza domiciliare integrata')

//------------------- TipologiaTrasmissionInRegione -------------------
CREATE TABLE TipologiaTrasmissionInRegione (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaTrasmissionInRegione VALUES ('PRIMO_INVIO', '1', 'primo invio: gruppi ricetta appartenenti al mese di competenza')
INSERT INTO TipologiaTrasmissionInRegione VALUES ('VARIAZIONE', '3', 'variazione: gruppi ricetta modificati dalla Zona territoriale, Azienda Ospedaliera, INRCA')
INSERT INTO TipologiaTrasmissionInRegione VALUES ('CANCELLAZIONE', '5', 'cancellazione: gruppi ricetta eliminati definitivamente')
INSERT INTO TipologiaTrasmissionInRegione VALUES ('ALTRO', '7', 'altro: da utilizzare unicamente per indicare la tardività nell’invio – quando le ricette di un mese non vengono trasmesse entro la scadenza prevista (il 7 del mese successivo) ma successivamente')

//------------------- StatoElaborazione -------------------
CREATE TABLE StatoElaborazione (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO StatoElaborazione VALUES ('PIANIFICATO', null, null)
INSERT INTO StatoElaborazione VALUES ('ESEGUITO', null, null)
INSERT INTO StatoElaborazione VALUES ('ERRORE', null, null)

//------------------- TipologiaFlusso -------------------
CREATE TABLE TipologiaFlusso (name varchar(255), value varchar(255), description varchar(255));
INSERT INTO TipologiaFlusso VALUES ('A1', 'A1', null)
INSERT INTO TipologiaFlusso VALUES ('A2', 'A2', null)
INSERT INTO TipologiaFlusso VALUES ('B', 'B', null)
INSERT INTO TipologiaFlusso VALUES ('C1', 'C1', null)
INSERT INTO TipologiaFlusso VALUES ('C2', 'C2', null)
INSERT INTO TipologiaFlusso VALUES ('D', 'D', null)
INSERT INTO TipologiaFlusso VALUES ('E', 'E', null)
INSERT INTO TipologiaFlusso VALUES ('F', 'F', null)
INSERT INTO TipologiaFlusso VALUES ('G', 'G', null)
