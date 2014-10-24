package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaAttivitaPS
{
   NO_PS("0", "no pronto soccorso"),
   SI_PS("1", "si pronto soccorso");

   private String value;
   private String description;

   TipologiaAttivitaPS(String value, String description)
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
