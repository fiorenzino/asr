package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaERR09
{
   // Segnalazioni di errore nell’ambito dei controlli regionali:
   A, // nessun errore
   B, // “tipo esenzione” assente o errato
   C, // “codice esenzione” assente o errato se il campo “tipo esenzione” assume valori diversi da 1
   D; // “tipo esenzione” non univoco nello stesso gruppo ricetta
}
