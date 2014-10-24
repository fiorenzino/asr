package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaTrasmissioneInRegione
{
   PRIMO_INVIO ("1"), // primo invio => scheda appartenente al trimestre di competenza
   INTEGRAZIONE ("2"), // integrazione => scheda relativa ai trimestri precedenti mai trasmessa
   SOSTITUZIONA ("3"), // sostituzione  => scheda modificata dall’Azienda sanitaria
   CORREZIONE ("4"), // correzione => scheda corretta sulla base degli errori segnalati nel file A3 relativo alla scheda non acquisita nel database regionale (campo posizione contabile"), // 4)
   ELIMINAZIONE ("5"); // eliminazione => scheda eliminata definitivamente

   private String value;

   TipologiaTrasmissioneInRegione(String value)
   {
      this.value = value;
   }

   public String getValue()
   {
      return value;
   }
}
