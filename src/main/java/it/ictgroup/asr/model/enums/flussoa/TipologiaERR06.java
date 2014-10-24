package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaERR06
{
   NESSUN_ERRORE ("0"), // nessun errore
   IMPORTO_ASSENTE ("1"), // importo assente/non valorizzato come numerico
   IMORTO_NON_CORRISPONDENTE ("2"); // importo non corrispondente a DRG e tariffa

   private String errore;

   TipologiaERR06(String errore)
   {
      this.errore = errore;
   }
   }
