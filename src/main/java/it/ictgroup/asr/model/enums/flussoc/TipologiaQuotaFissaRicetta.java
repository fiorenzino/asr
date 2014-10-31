package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaQuotaFissaRicetta
{
   Z ("Z", "no quota fissa"),
   A ("A", "quota fissa per prestazioni specialistiche"),
   B ("B", "quota fissa per prestazioni di pronto soccorso non seguite da ricovero");

   private String value;
   private String description;

   TipologiaQuotaFissaRicetta(String value, String description)
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
