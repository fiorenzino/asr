package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaPosizioneContabile
{
   PRIMO_INVIO ("1"), // primo invio (da usare nelle varie fasi di “Trasmissione in Regione”)
   PREST_ADD_RITARDO ("3"), // prestazione addebitata in ritardo a seguito di storno ad altri
   PREST_NON_ACQUISITA ("4"), // prestazione non acquisita nel data base regionale
   PREST_CONTESTATA ("5"), // prestazione contestata (da usare solo nella fase delle contestazioni)
   // Valori da usare solo nella fase delle controdeduzioni:
   CONTEST_NON_ACCETTATA ("A"), //contestazione non accettata,  conferma della prestazione
   CONTEST_ACCETTATA_CORREZ ("B"), //contestazione accettata,  con correzione degli errori segnalati nella prestazione
   CONTEST_ACCETTATA ("C"); //contestazione accettata

   private String posizioneContabile;

   TipologiaPosizioneContabile(String posizioneContabile)
   {
      this.posizioneContabile = posizioneContabile;
   }
}
