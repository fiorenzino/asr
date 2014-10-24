package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaNeonato
{
   NON_NEONATO ("0"), // non neonato
   NEONATO_SANO ("1"), // neonato sano
   NEONATO_NON_SANO ("2"), // neonato non sano
   NEONATO_ALTRO_ISTITUTO ("3"); // neonato proveniente da altro Istituto di ricovero e cura

   private String neonato;

   TipologiaNeonato(String neonato)
   {
      this.neonato = neonato;
   }
}
