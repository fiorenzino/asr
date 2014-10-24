package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaERR04
{
   // Segnalazioni di value nell’ambito dei controlli regionali:
   NESSUN_ERRORE ("A"), // nessun value
   REGION_ASSENTE ("B"), // “Regione addebitante” assente o errata
   ZONA_ASSENTE ("C"), // “Zona territoriale/Azienda Ospedaliera inviante” assente o errata
   COD_STRUTTURA_ACCETTANTE_ASSENTE ("D"), // “Codice struttura accettante/richiedente” assente o errato
   COD_STRUTTURA_EROGANTE_ASSENTE ("E"); // “Codice struttura erogante la prestazione” assente o errato

   private String value;

   TipologiaERR04(String value)
   {
      this.value = value;
   }

   public String getValue()
   {
      return value;
   }
}
