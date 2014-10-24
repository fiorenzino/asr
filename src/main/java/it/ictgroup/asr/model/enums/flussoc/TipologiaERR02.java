package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaERR02
{
   NESSUN_ERRORE ("0"), // nessun value
   COD_COMUNE_RESIDENZA_ASSENTE ("1"), // codice comune di residenza assente/errato
   COMUNE_RESIDENZA_NO_REGIONE ("2"), // comune di residenza non appartenente alla regione (per utenti residenti fuori regione) alla Zona Territoriale (per  utenti residenti nelle Marche) che riceve l’addebito

   // Segnalazioni di value nell’ambito dei controlli regionali:
   CR_NESSUN_ERRORE ("A"), // nessun value
   CR_COMUNE_RESIDENZA_ASSENTE ("B"), // “comune di residenza dell’utente” assente o errato
   CR_REGIONE_RESIDENZA_ASSENTE ("C"), // “regione di residenza dell’utente” assente o errato
   CR_ZONA_TERRITORIALE_ASSENTE ("D"), // “zona territoriale/azienda USL di residenza dell’utente” assente o errata
   CR_COMUNE_RESIDENZA_INCONGRUENTE ("E"), // “comune di residenza dell’utente” incongruente con “regione di residenza dell’utente”
   CR_ZONA_TERRITORIALE_INCONGRUENTE ("F"); // “zona territoriale/azienda USL di residenza dell’utente” incongruente con “comune residenza utente”

   private String value;

   TipologiaERR02(String value)
   {
      this.value = value;
   }

   public String getValue()
   {
      return value;
   }
}
