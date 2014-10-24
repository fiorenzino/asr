package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaRegimeRicovero
{
   ORDINARIO ("1"), // ricovero ordinario
   DIURNO ("2"); // ricovero diurno

   private String regimeRicovero;

   TipologiaRegimeRicovero(String regimeRicovero)
   {
      this.regimeRicovero = regimeRicovero;
   }
}
