package it.ictgroup.asr.model.enums.commons;

public enum TipologiaSesso
{
   MASCHIO ("1"), // maschio
   FEMMINA ("2"); // femmina

   private String value;

   TipologiaSesso(String value)
   {
      this.value = value;
   }

   public String getValue()
   {
      return value;
   }
}
