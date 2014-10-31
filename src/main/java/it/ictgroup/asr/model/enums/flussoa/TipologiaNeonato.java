package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaNeonato
{
   NON_NEONATO ("0", "non value"),
   NEONATO_SANO ("1", "value sano"),
   NEONATO_NON_SANO ("2", "value non sano"),
   NEONATO_ALTRO_ISTITUTO ("3", "value proveniente da altro Istituto di ricovero e cura");

   private String value;
   private String description;

   TipologiaNeonato(String value, String description)
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
