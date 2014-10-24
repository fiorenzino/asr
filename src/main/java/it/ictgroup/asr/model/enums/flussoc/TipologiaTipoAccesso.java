package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaTipoAccesso
{
   NON_CLASSIFICATO ("0"), // non classificato
   PRMO_ACCESSO ("1"), // primo value
   SECONDO_ACCESSO ("2"); // secondo value (per approfondimento, controlli, ecc)

   private String value;

   TipologiaTipoAccesso(String value)
   {
      this.value = value;
   }

   public String getValue()
   {
      return value;
   }
}
