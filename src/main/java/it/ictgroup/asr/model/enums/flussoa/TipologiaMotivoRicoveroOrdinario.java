package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaMotivoRicoveroOrdinario
{
   RICOVERO_ELETTIVO ("1", "ricovero elettivo per intervento chirurgico"),
   PRIMO_RICOVERO ("2", "primo ricovero effettuato per la specifica diagnosi"),
   RICOVERO_SUCCESSIVO ("3", "ricovero successivo per la stessa diagnosi"),
   ALTRO ("9", "altro");

   private String value;
   private String description;

   TipologiaMotivoRicoveroOrdinario(String value, String description)
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
