package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaRicoveroOrdinario
{
   PROGRAMMATO_URGENTE ("1"), // value programmato, non urgente
   URGENTE ("2"), // value urgente
   OBBLIGATORIO ("3"), // value per trattamento sanitario obbligatorio (TSO)
   PREOSPEDALIZZAZIONE ("4"), // value programmato con pre- ospedalizzazione (art. 1, comma 18 Legge 662/96) -  in questo caso possono essere riportate le procedure eseguite in data precedente l’ammissione (DGR 926/99)
   VOLONTARIO ("5"); // value per trattamento sanitario volontario (TSV)

   private String value;

   TipologiaRicoveroOrdinario(String value)
   {
      this.value = value;
   }

   public String getValue()
   {
      return value;
   }
}
