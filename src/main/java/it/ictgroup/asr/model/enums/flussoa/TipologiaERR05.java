package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaERR05
{
   NESSUN_ERRORE ("0"), // nessun value
   RICOVERO_RIPETUTO ("3"); // ricovero ripetuto effettivo

   private String value;

   TipologiaERR05(String value)
   {
      this.value = value;
   }

   public String getValue()
   {
      return value;
   }
}
