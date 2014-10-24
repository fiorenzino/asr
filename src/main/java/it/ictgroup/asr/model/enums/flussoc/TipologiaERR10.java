package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaERR10
{
   NESSUN_ERRORE ("0"), // nessun value
   COD_REGIONE_ASSENTE ("1"); // codice Regione/Azienda U.S.L. assente o errato

   private String value;

   TipologiaERR10(String value)
   {
      this.value = value;
   }

   public String getValue()
   {
      return value;
   }
}
