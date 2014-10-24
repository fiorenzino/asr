package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaERR09
{
   NESSUN_ERRORE ("0"), // nessun value
   IMPORTO_DIVERSO ("1"), // importo diverso da zero per onere della degenza non compensabile (codici onere 3, 4, 9)
   ONERE_DEGENZA ("2"); // onere della degenza assente/errato

   private String value;

   TipologiaERR09(String value)
   {
      this.value = value;
   }

   public String getValue()
   {
      return value;
   }
}
