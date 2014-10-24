package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaERR01
{
   NESSUN_ERRORE ("0"), //nessun errore
   ID_UTENTE_ERR ("1"), //identificativo utente assente/errato
   UTENTE_NON_IN_ANAGRAFICA ("2"); //utente assente da anagrafe residenti

   private String errore;

   TipologiaERR01(String errore)
   {
      this.errore = errore;
   }
}
