package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaRicoveroOrdinario
{
   PROGRAMMATO_URGENTE ("1"), // ricovero programmato, non urgente
   URGENTE ("2"), // ricovero urgente
   OBBLIGATORIO ("3"), // ricovero per trattamento sanitario obbligatorio (TSO)
   PREOSPEDALIZZAZIONE ("4"), // ricovero programmato con pre- ospedalizzazione (art. 1, comma 18 Legge 662/96) -  in questo caso possono essere riportate le procedure eseguite in data precedente l’ammissione (DGR 926/99)
   VOLONTARIO ("5"); // ricovero per trattamento sanitario volontario (TSV)

   private String ricovero;

   TipologiaRicoveroOrdinario(String ricovero)
   {
      this.ricovero = ricovero;
   }
}
