-- Script di gnerazione
SELECT concat('DROP TABLE IF EXISTS ', table_name, ';')
FROM information_schema.tables
WHERE table_schema = 'asr';


-- Tabelle enums
DROP TABLE IF EXISTS StatoElaborazione;                   
DROP TABLE IF EXISTS TipologiaAltraAttivitaRicovero;
DROP TABLE IF EXISTS TipologiaAttivitaPS;
DROP TABLE IF EXISTS TipologiaAutorizzazioneProroga;
DROP TABLE IF EXISTS TipologiaCicloPrestazioni;
DROP TABLE IF EXISTS TipologiaERR01FlussoA;
DROP TABLE IF EXISTS TipologiaERR01FlussoC;
DROP TABLE IF EXISTS TipologiaERR02FlussoA;
DROP TABLE IF EXISTS TipologiaERR02FlussoC;
DROP TABLE IF EXISTS TipologiaERR03FlussoA;
DROP TABLE IF EXISTS TipologiaERR03FlussoC;
DROP TABLE IF EXISTS TipologiaERR04FlussoA;
DROP TABLE IF EXISTS TipologiaERR04FlussoC;
DROP TABLE IF EXISTS TipologiaERR05FlussoA;
DROP TABLE IF EXISTS TipologiaERR05FlussoC;
DROP TABLE IF EXISTS TipologiaERR06FlussoA;
DROP TABLE IF EXISTS TipologiaERR06FlussoC;
DROP TABLE IF EXISTS TipologiaERR07FlussoA;
DROP TABLE IF EXISTS TipologiaERR07FlussoC;
DROP TABLE IF EXISTS TipologiaERR08FlussoA;
DROP TABLE IF EXISTS TipologiaERR08FlussoC;
DROP TABLE IF EXISTS TipologiaERR09FlussoA;
DROP TABLE IF EXISTS TipologiaERR09FlussoC;
DROP TABLE IF EXISTS TipologiaERR10FlussoA;
DROP TABLE IF EXISTS TipologiaERR10FlussoC;
DROP TABLE IF EXISTS TipologiaEsenzione;
DROP TABLE IF EXISTS TipologiaFlusso;
DROP TABLE IF EXISTS TipologiaMedicoPrescrittore;
DROP TABLE IF EXISTS TipologiaModalitaAccessoPrestazioni;
DROP TABLE IF EXISTS TipologiaModalitaCompilazRicetta;
DROP TABLE IF EXISTS TipologiaModalitaDimissione;
DROP TABLE IF EXISTS TipologiaModalitaRilevazCF;
DROP TABLE IF EXISTS TipologiaMotivoRicoveroDiurno;
DROP TABLE IF EXISTS TipologiaMotivoRicoveroOrdinario;
DROP TABLE IF EXISTS TipologiaNeonato;
DROP TABLE IF EXISTS TipologiaOnereDegenza;
DROP TABLE IF EXISTS TipologiaOnerePrestazione;
DROP TABLE IF EXISTS TipologiaPAC;
DROP TABLE IF EXISTS TipologiaPosizioneContabile;
DROP TABLE IF EXISTS TipologiaPosizioneTicket;
DROP TABLE IF EXISTS TipologiaPrescrizione;
DROP TABLE IF EXISTS TipologiaPresenzaQuesitoDiagnostico;
DROP TABLE IF EXISTS TipologiaPrioritaAccessoPrestaz;
DROP TABLE IF EXISTS TipologiaProvenienzaPaziente;
DROP TABLE IF EXISTS TipologiaQuotaFissaRicetta;
DROP TABLE IF EXISTS TipologiaRegimeRicovero;
DROP TABLE IF EXISTS TipologiaRicoveroOrdinario;
DROP TABLE IF EXISTS TipologiaSesso;
DROP TABLE IF EXISTS TipologiaStatoCivile;
DROP TABLE IF EXISTS TipologiaTipoAccesso;
DROP TABLE IF EXISTS TipologiaTipoRicetta;
DROP TABLE IF EXISTS TipologiaTipoRicoveroDiurno;
DROP TABLE IF EXISTS TipologiaTitoloStudio;
DROP TABLE IF EXISTS TipologiaTrasmissionInRegione;
DROP TABLE IF EXISTS TipologiaTrasmissioneInRegione;
DROP TABLE IF EXISTS TipologiaTraumativi;