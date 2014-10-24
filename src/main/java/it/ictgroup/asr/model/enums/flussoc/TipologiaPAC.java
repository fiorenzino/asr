package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaPAC
{
   NO_PAC ("0", "no PAC"),
   SI_PAC("1", "si PAC");

   private String value;
   private String description;

   TipologiaPAC(String value, String description)
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
