package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaERR07
{
   NESSUN_ERRORE ("0"), // nessun errore
   DIFF_DATA_DIMISSIONE_DATA_RICOVERO_PREC ("1"), // ricovero ripetuto con differenza tra la “data di dimissione” del ricovero precedente e la “data di ricovero” del ricovero successivo inferiore a  4 giorni
   DIFF_DATA_DIMISSIONE_DATA_RICOVERO_SUCC ("2"); // ricovero ripetuto con differenza tra la “data di dimissione” del ricovero precedente e la “data di ricovero” del ricovero successivo compresa tra  4 e 30 giorni

   private String errore;

   TipologiaERR07(String errore)
   {
      this.errore = errore;
   }
   }
