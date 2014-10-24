package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaTipoRicetta
{
   EE ("E", "assicurati extraeuropei in temporaneo soggiorno"),
   UE ("E", "assicurati europei in temporaneo soggiorno"),
   NA ("A", "assistiti SASN con visita ambulatoriale"),
   ND ("D", "assistiti SASN con visita domiciliare"),
   NE ("E", "assistiti da Istituzioni estere"),
   NX ("X", "assistito SASN extraeuropeo"),
   ST ("T", "straniero in temporaneo soggiorno"),
   AD ("D", "pazienti in assistenza domiciliare integrata");

   private String value;
   private String description;

   TipologiaTipoRicetta(String value, String description)
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
