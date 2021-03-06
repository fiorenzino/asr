package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaERR08FlussoC
{
   NESSUN_ERRORE ("0", "nessun errore"),
   DATA_EROGAZIONE_ERRATA ("1", "la data di erogazione o di fine ciclo è assente/errata o non appartenente all’anno di competenza sulla riga zn (nel caso di data non appartenente all’anno di competenza sarà da segnalare l’value solo se tutte le righe non appartengono all’anno di competenza)"),

   // Segnalazioni di value nell’ambito dei controlli regionali:
   CR_NESSUN_ERRORE ("A", "nessun errore"),
   CR_DATA_RICETTA_ASSENTE ("B", "'data ricetta' assente o errata"),
   CR_DATA_PRENOTAZIONE_ASSENTE ("C", "'data di prenotazione' assente o errata"),
   CR_DATA_EROGAZIONE_ASSENTE ("D", "'data di erogazione delle prestazioni' assente o errata"),
   CR_DATA_PAC_ASSENTE ("E", "data inizio P.A.C./inizio ciclo di prestazioni assente o errata se i campi 'P.A.C.' e 'ciclo di  prestazioni' assumono valore 1");

   private String value;
   private String description;

   TipologiaERR08FlussoC(String value, String description)
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
