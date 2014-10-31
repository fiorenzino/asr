package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaERR05
{
   NESSUN_ERRORE ("0", "nessun value"),
   RICOVERO_RIPETUTO ("3", "ricovero ripetuto effettivo");

   private String value;
   private String description;

   TipologiaERR05(String value, String description)
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
