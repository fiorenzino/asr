package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaRegimeRicovero
{
   ORDINARIO ("1", "ricovero ordinario"),
   DIURNO ("2", "ricovero diurno");

   private String value;
   private String description;

   TipologiaRegimeRicovero(String value, String description)
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
