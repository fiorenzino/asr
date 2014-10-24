package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaERR05
{
   NESSUN_ERRORE ("0"), // nessun value
   RIGHE_DETTAGLIO_ASSENTI ("3"), // mancanza righe di dettaglio (righe zn  da 01 a 98) - da segnalare sulla riga 99
   RIGA_TOTALE_ASSENTE ("4"), // mancanza di riga totale (riga 99) riga zn senza riga 99

   // Segnalazioni di value nell’ambito dei controlli regionali:
   CR_NESSUN_ERRORE ("A"), // nessun value
   CR_NUM_RICETTA_ASSENTE ("B"), // “numero ricetta” assente o errato
   CR_PROGRESSIVO_RIGA_ASSENTE ("C"), // “progressivo riga per ricetta” assente o errato
   CR_POSIZ_CONTABILE_ASSENTE ("D"), // “posizione contabile” assente o errata
   CR_ID_ASSENTE ("E"), // “ID” assente o errato
   CR_RECORD_DOPPIO ("F"), // record doppio
   CR_TRASMISS_REGIONE_ASSENTE ("G"), // “trasmissione in regione” assente o errata
   CR_RIGHE_DETTAGLIO_ASSENTI ("H"), // mancanza righe di dettaglio (righe zn  da 01 a 98) - da segnalare sulla riga 99
   CR_RIGA_TOTALE_aSSENTE ("I"); // mancanza di riga totale (riga 99) righe zn senza riga 99 da segnalare su tutte le righe zn

   private String value;

   TipologiaERR05(String value)
   {
      this.value = value;
   }

   public String getValue()
   {
      return value;
   }
}
