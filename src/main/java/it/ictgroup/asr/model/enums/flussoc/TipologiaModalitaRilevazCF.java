package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaModalitaRilevazCF
{
   D ("D", "da ricetta");

   private String value;
   private String description;

   TipologiaModalitaRilevazCF(String value, String description)
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
