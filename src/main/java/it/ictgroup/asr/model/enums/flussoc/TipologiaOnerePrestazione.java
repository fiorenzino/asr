package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaOnerePrestazione
{
   SSN ("1"), // SSN
   MINIST_SALUTE ("2"), // Ministero della Salute per personale navigante, marittimo e dell’aviazione civile
   ISTITUZ_ESTERE ("3"), // Istituzioni estere in base a norme comunitarie o Accordi bilaterali di sicurezza Sociale
   PAGANTI ("4"); // Paganti in proprio (libera professione, prestazioni fuori LEA)

   private String value;

   TipologiaOnerePrestazione(String value)
   {
      this.value = value;
   }

   public String getValue()
   {
      return value;
   }
}
