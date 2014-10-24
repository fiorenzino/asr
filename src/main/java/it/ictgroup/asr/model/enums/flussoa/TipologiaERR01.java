package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaERR01
{
   NESSUN_ERRORE ("0"), //nessun errore
   ID_UTENTE_ERR ("1"), //identificativo utente assente/errato
   UTENTE_NON_IN_ANAGRAFICA ("2"); //utente assente da anagrafe residenti

   private String value;

   TipologiaERR01(String value)
   {
      this.value = value;
   }

   public String getValue()
   {
      return value;
   }
}
