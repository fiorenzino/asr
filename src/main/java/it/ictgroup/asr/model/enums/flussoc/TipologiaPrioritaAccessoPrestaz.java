package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaPrioritaAccessoPrestaz
{
   Z, // non classificato
   U, // casella contrassegnata dalla lettera “U” per urgente;
   B, // casella contrassegnata dalla lettera “B” per breve;
   D, // casella contrassegnata dalla lettera “D” per differita;
   P; // casella contrassegnata dalla lettera “P” per programmata;

   public String getValue()
   {
      return this.name();
   }
}
