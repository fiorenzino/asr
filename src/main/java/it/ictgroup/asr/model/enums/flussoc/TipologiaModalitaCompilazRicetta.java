package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaModalitaCompilazRicetta
{

   COMPIL_MANUALMENTE ("1", "ricetta compilata manualmente"),
   INFORMATIZZATA_NO_CF ("2", "ricetta informatizzata con presenza della biffatura “Stampa PC”, ma assenza del codice fiscale in modalità barcode"),
   INFORMATIZZATA_CON_CF ("3", "ricetta informatizzata con presenza della biffatura “Stampa PC” e del codice fiscale in modalità barcode");

   private String value;
   private String description;

   TipologiaModalitaCompilazRicetta(String value, String description)
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
