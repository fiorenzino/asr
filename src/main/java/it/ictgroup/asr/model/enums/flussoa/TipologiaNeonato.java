package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaNeonato
{
   NON_NEONATO ("0"), // non value
   NEONATO_SANO ("1"), // value sano
   NEONATO_NON_SANO ("2"), // value non sano
   NEONATO_ALTRO_ISTITUTO ("3"); // value proveniente da altro Istituto di ricovero e cura

   private String value;

   TipologiaNeonato(String value)
   {
      this.value = value;
   }

   public String getValue()
   {
      return value;
   }
}
