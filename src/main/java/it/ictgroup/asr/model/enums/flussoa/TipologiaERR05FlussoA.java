package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaERR05FlussoA
{
   NESSUN_ERRORE ("0", "nessun errore"),
   RICOVERO_RIPETUTO ("3", "ricovero ripetuto effettivo");

   private String value;
   private String description;

   TipologiaERR05FlussoA(String value, String description)
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
