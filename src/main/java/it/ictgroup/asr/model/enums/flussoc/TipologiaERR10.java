package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaERR10
{
   NESSUN_ERRORE ("0"), // nessun errore
   COD_REGIONE_ASSENTE ("1"); // codice Regione/Azienda U.S.L. assente o errato

   private String errore;

   TipologiaERR10(String errore)
   {
      this.errore = errore;
   }
}
