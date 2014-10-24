package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaTipoRicoveroDiurno
{
   PRIMO_CICLO ("1", "primo ciclo per la specifica diagnosi"),
   CICLO_SUCCESSIVO ("2", "ciclo successivo per la stessa diagnosi");

   private String value;
   private String description;

   TipologiaTipoRicoveroDiurno(String value, String description)
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
