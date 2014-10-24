package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaTipoRicoveroDiurno
{
   PRIMO_CICLO ("1"), // primo ciclo per la specifica diagnosi
   CICLO_SUCCESSIVO ("2"); // ciclo successivo per la stessa diagnosi

   private String tipo;

   TipologiaTipoRicoveroDiurno(String tipo)
   {
      this.tipo = tipo;
   }
}
