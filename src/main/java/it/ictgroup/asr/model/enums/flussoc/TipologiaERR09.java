package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaERR09
{
   // Segnalazioni di errore nell’ambito dei controlli regionali:
   A ("A", "nessun errore"),
   B ("B", "“tipo esenzione” assente o errato"),
   C ("C", "“codice esenzione” assente o errato se il campo “tipo esenzione” assume valori diversi da 1"),
   D ("D", "“tipo esenzione” non univoco nello stesso gruppo ricetta");
   
   private String value;
   private String description;

   TipologiaERR09(String value, String description)
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
