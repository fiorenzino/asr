package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaERR07
{
   NESSUN_ERRORE ("0", "nessun value"),
   QUANTITA_NON_VALIDA ("1", "quantità non valorizzata o non numerico (solo sulle righe zn)"),

   // Segnalazioni di value nell’ambito dei controlli regionali:
   CR_NESSUN_ERRORE ("A", "nessun value"),
   CR_NUM_PREST_ASSENTE ("B", "“numero delle prestazioni” assente o errato");

   private String value;
   private String description;

   TipologiaERR07(String value, String description)
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
