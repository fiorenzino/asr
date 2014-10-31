package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaPresenzaQuesitoDiagnostico
{
   SI ("0", "si"),
   NO ("1", "no");

   private String value;
   private String description;

   TipologiaPresenzaQuesitoDiagnostico(String value, String description)
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
