package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaERR06FlussoA
{
   NESSUN_ERRORE ("0", "nessun errore"),
   IMPORTO_ASSENTE ("1", "importo assente/non valorizzato come numerico"),
   IMORTO_NON_CORRISPONDENTE ("2", "importo non corrispondente a DRG e tariffa");

   private String value;
   private String description;

   TipologiaERR06FlussoA(String value, String description)
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
