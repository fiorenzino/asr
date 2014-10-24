package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaPrescrizione
{
   S ("S", "suggerita"),
   A ("A", "altro");

   private String value;
   private String description;

   TipologiaPrescrizione(String value, String description)
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
