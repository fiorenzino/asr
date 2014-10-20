package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaERR07
{
   NESSUN_ERRORE ("0"), // nessun errore
   QUANTITA_NON_VALIDA ("1"), // quantità non valorizzata o non numerico (solo sulle righe zn)

   // Segnalazioni di errore nell’ambito dei controlli regionali:
   CR_NESSUN_ERRORE ("A"), // nessun errore
   CR_NUM_PREST_ASSENTE ("B"); // “numero delle prestazioni” assente o errato

   private String errore;

   TipologiaERR07(String errore)
   {
      this.errore = errore;
   }
   }
