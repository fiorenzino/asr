package it.ictgroup.asr.model;

public enum TipologiaERR04
{
   // Segnalazioni di errore nell’ambito dei controlli regionali:
   NESSUN_ERRORE ("A"), // nessun errore
   REGION_ASSENTE ("B"), // “Regione addebitante” assente o errata
   ZONA_ASSENTE ("C"), // “Zona territoriale/Azienda Ospedaliera inviante” assente o errata
   COD_STRUTTURA_ACCETTANTE_ASSENTE ("D"), // “Codice struttura accettante/richiedente” assente o errato
   COD_STRUTTURA_EROGANTE_ASSENTE ("E"); // “Codice struttura erogante la prestazione” assente o errato

   private String errore;

   TipologiaERR04(String errore)
   {
      this.errore = errore;
   }
}
