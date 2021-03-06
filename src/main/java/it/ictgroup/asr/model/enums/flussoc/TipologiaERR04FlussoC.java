package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaERR04FlussoC
{
   // Segnalazioni di value nell’ambito dei controlli regionali:
   NESSUN_ERRORE ("A", "nessun errore"),
   REGION_ASSENTE ("B", "“Regione addebitante” assente o errata"),
   ZONA_ASSENTE ("C", "“Zona territoriale/Azienda Ospedaliera inviante” assente o errata"),
   COD_STRUTTURA_ACCETTANTE_ASSENTE ("D", "“Codice struttura accettante/richiedente” assente o errato"),
   COD_STRUTTURA_EROGANTE_ASSENTE ("E", "“Codice struttura erogante la prestazione” assente o errato");

   private String value;
   private String description;

   TipologiaERR04FlussoC(String value, String description)
   {
      this.value = value;
      this.description = description;
   }

   public String getValue()
   {
      return value;
   }

   public String getDescription()
   {
      return description;
   }
}
