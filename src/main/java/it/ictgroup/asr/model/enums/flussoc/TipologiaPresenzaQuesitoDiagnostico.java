package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaPresenzaQuesitoDiagnostico
{
   SI ("0"), // si
   NO ("1"); // no

   private String value;

   TipologiaPresenzaQuesitoDiagnostico(String value)
   {
      this.value = value;
   }

   public String getValue()
   {
      return value;
   }
}
