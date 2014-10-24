package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaERR03
{
   NESSUN_ERRORE ("0"), // nessun value
   DRG_NON_VALORIZZATO ("1"), // DRG non valorizzato o non appartenente alla tabella in vigore
   DRG_DIVERSO ("2"), // DRG diverso da quello determinato dalla Regione/Azienda che riceve l’addebito
   COD_DIAGNOSI_PRINCIPALE ("3"); // codice diagnosi principale non valorizzato o non appartenente alla tabella in vigore

   private String value;

   TipologiaERR03(String value)
   {
      this.value = value;
   }

   public String getValue()
   {
      return value;
   }
}
