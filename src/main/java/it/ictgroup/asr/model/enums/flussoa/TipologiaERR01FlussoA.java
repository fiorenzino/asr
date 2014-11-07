package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaERR01FlussoA
{
   NESSUN_ERRORE ("0", "nessun errore"),
   ID_UTENTE_ERR ("1", "identificativo utente assente/errato"),
   UTENTE_NON_IN_ANAGRAFICA ("2", "utente assente da anagrafe residenti");

   private String value;
   private String description;

   TipologiaERR01FlussoA(String value, String description)
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
