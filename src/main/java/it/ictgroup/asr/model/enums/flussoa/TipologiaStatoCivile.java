package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaStatoCivile
{
   CELIBE ("1", "celibe/nubile"),
   CONIUGATO ("2", "coniugato/a"),
   SEPARATO ("3", "separato/a"),
   DIVORZIATO ("4", "divorziato/a"),
   VEDOVO ("5", "vedovo/a"),
   NON_DICHIRATO ("6", "non dichiarato");

   private String value;
   private String description;

   TipologiaStatoCivile(String value, String description)
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
