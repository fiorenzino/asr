package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaERR06
{
   NESSUN_ERRORE ("0"), // nessun value
   IMPORTO_ASSENTE ("1"), // importo assente/non valorizzato come numerico
   IMORTO_NON_CORRISPONDENTE ("2"); // importo non corrispondente a DRG e tariffa

   private String value;

   TipologiaERR06(String value)
   {
      this.value = value;
   }

   public String getValue()
   {
      return value;
   }
}
