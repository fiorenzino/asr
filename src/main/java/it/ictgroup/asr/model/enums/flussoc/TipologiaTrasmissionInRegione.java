package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaTrasmissionInRegione
{
   PRIMO_INVIO ("1"), // primo invio: gruppi ricetta appartenenti al mese di competenza
   VARIAZIONE ("3"), // variazione: gruppi ricetta modificati dalla Zona territoriale, Azienda Ospedaliera, INRCA
   CANCELLAZIONE ("5"), // cancellazione: gruppi ricetta eliminati definitivamente
   ALTRO ("7"); // altro: da utilizzare unicamente per indicare la tardività nell’invio – quando le ricette di un mese non vengono trasmesse entro la scadenza prevista (il 7 del mese successivo) ma successivamente

   private String trasmissione;

   TipologiaTrasmissionInRegione(String trasmissione)
   {
      this.trasmissione = trasmissione;
   }
}
