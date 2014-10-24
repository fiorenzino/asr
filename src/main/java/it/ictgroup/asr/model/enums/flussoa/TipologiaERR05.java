package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaERR05
{
   NESSUN_ERRORE ("0"), // nessun errore
   RICOVERO_RIPETUTO ("3"); // ricovero ripetuto effettivo

   private String errore;

   TipologiaERR05(String errore)
   {
      this.errore = errore;
   }
}
