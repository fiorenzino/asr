package it.ictgroup.asr.model.enums.commons;

public enum TipologiaSesso
{
   MASCHIO ("1", "maschio"),
   FEMMINA ("2", "femmina");

   private String value;
   private String description;

   TipologiaSesso(String value, String description)
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
