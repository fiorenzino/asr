package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaEsenzione
{
   ALTRO ("0"), // altro (voce residuale, che riguarda comunque assistiti esenti)
   NON_ESENTE ("1"), // non esente (assistito soggetto al pagamento del ticket)
   ESENTE_PER_CONDIZIONE ("2"), // esente per condizione
   ESENTE_PER_PATOLOGIA ("3"), // esente per patologia
   ESENTE_PER_REDDITO ("6"), // esente per reddito (autocertificazione)
   ESENTE_PER_ALTRA_ESENZIONE ("7"), // esente per reddito e presenza di altra esenzione
   PAGANTE_IN_PROPRIO ("A"); // utente pagante in proprio (libera professione, prestazioni fuori L.E.A.)

   private String sesso;

   TipologiaEsenzione(String sesso)
   {
      this.sesso = sesso;
   }
}
