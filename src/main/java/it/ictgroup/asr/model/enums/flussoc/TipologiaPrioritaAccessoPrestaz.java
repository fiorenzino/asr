package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaPrioritaAccessoPrestaz
{
   Z ("Z", "non classificato"),
   U ("U", "casella contrassegnata dalla lettera “U” per urgente;"),
   B ("B", "casella contrassegnata dalla lettera “B” per breve;"),
   D ("D", "casella contrassegnata dalla lettera “D” per differita;"),
   P ("P", "casella contrassegnata dalla lettera “P” per programmata;");

   private String value;
   private String description;

   TipologiaPrioritaAccessoPrestaz(String value, String description)
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
