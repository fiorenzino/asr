package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaTipoRicoveroDiurno
{
   PRIMO_CICLO ("1"), // primo ciclo per la specifica diagnosi
   CICLO_SUCCESSIVO ("2"); // ciclo successivo per la stessa diagnosi

   private String value;

   TipologiaTipoRicoveroDiurno(String value)
   {
      this.value = value;
   }

   public String getValue()
   {
      return value;
   }
}
