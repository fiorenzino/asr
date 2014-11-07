package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaERR02FlussoA
{
   NESSUN_ERRORE ("0", "nessun errore"),
   COD_COMUNE_RESIDENZA_ASSENTE ("1", "codice comune di residenza assente/errato"),
   COMUNE_RESIDENZA_NO_REGIONE ("2", "comune di residenza non appartenente alla regione (per utenti residenti fuori regione) alla Zona Territoriale (per  utenti residenti nelle Marche) che riceve l’addebito");

   private String value;
   private String description;

   TipologiaERR02FlussoA(String value, String description)
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
