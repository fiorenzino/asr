package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaTipoAccesso
{
   NON_CLASSIFICATO ("0", "non classificato"),
   PRMO_ACCESSO ("1", "primo value"),
   SECONDO_ACCESSO ("2", "secondo value (per approfondimento, controlli, ecc)");

   private String value;
   private String description;

   TipologiaTipoAccesso(String value, String description)
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
