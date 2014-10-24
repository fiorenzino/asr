package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaRegimeRicovero
{
   ORDINARIO ("1"), // ricovero ordinario
   DIURNO ("2"); // ricovero diurno

   private String value;

   TipologiaRegimeRicovero(String value)
   {
      this.value = value;
   }

   public String getValue()
   {
      return value;
   }
}
