package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaERR06
{
   NESSUN_ERRORE ("0", "nessun value"),
   IMPORTO_RIGA_NON_VALIDO ("1", "importo riga non valorizzato come numerico"),

   // I successivi errori sono evidenziabili solo sulla riga 99
   R99_IMPORTO_TICKET_NON_VALIDO ("2", "importo ticket riga 99 non valorizzato come numerico"),
   R99_RIGA99_NON_VALIDO ("3", "importo totale riga 99 non valorizzato come numerico e importo ticket riga 99 non valorizzato come numerico"),
   R99_RIGA99_MAGGIORE_SOMMA ("4", "importo totale della riga 99 maggiore della somma dell’importo delle righe zn meno il ticket della riga 99"),
   R99_IMPORTO_SUPERIORE ("5", "importo superiore all’importo calcolato da quantità e tariffa del nomenclatore regionale solo sulle righe zn"),

   // Segnalazioni di value nell’ambito dei controlli regionali:
   CR_NESSUN_ERRORE("A", "nessun value"),
   CR_TICKET_aSSISTITO_NON_VALIDO("B", "campo “ticket pagato dall’assistito” non valorizzato oppure maggiore di € 36,20 quando il campo “tipo esenzione” assume valore 1"),
   CR_QUOTA_FISSA_NON_VALIDO ("C", "campo “quota fissa pagata dall’assistito” assente o errata quando il campo “quota fissa per ricetta” assume i valori A o B"),
   CR_TOT_99_NON_VALIDO ("D", "importo totale della riga 99 diverso della somma dell’importo delle righe zn meno il “ticket pagato dall’assistito” e della “quota fissa pagata dall’assistito” della riga 99 o non valorizzato come numerico"),
   CR_TOT_NON_VALIDO("E", "“importo totale” delle righe da 1 a 98 diverso dall’importo calcolato come prodotta tra “numero delle prestazioni” per [“tariffa della prestazione erogata”  meno “importo Sconto”] per “tariffa prestazione erogata” meno “importo sconto” o non valorizzato come numerico"),
   CR_SCONOT_NON_VALIDO("F", "“percentuale sconto da applicare” non numerico"),
   CR_SCONT_ASSENTE("G", "“importo sconto” assente o errato quando il valore del campo “percentuale di sconto da Applicare” è diversa da 00"),
   CR_QUOTA_FISSA_ASSENTE("H", "“quota fissa per ricetta” assente o errata");

   private String value;
   private String description;

   TipologiaERR06(String value, String description)
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
