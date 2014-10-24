package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaQuotaFissaRicetta
{
   Z, // no quota fissa
   A, // quota fissa per prestazioni specialistiche
   B; // quota fissa per prestazioni di pronto soccorso non seguite da ricovero

   public String getValue()
   {
      return this.name();
   }
}