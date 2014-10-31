package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaERR08
{
   NESSUN_ERRORE("0", "nessun value"),
   DATA_RICOVERO_ASSENTE("1", "data di ricovero assente o formalmente scorretta"),
   DATA_DIMISS_ASSENTE("2", "data di dimissione assente o formalmente scorretta o relativa ad un anno diverso da quello di competenza"),
   DATA_DIMISS_INFERIORE("3", "data di dimissione inferiore alla data di ricovero"),
   NUM_GG_RICOVERO_NON_VALORIZZATO("4", "in caso di ricovero diurno: “numero giornate di presenza in ricovero diurno” non valorizzato come numerico o uguale a 0 oppure differenza in giorni tra data di dimissione e data di ricovero + 1 minore del campo “numero giornate di presenza in ricovero diurno”"),
   EVENTI_SENTINELLA("5", "ricovero di 2/3 giorni “eventi sentinella”");

   private String value;
   private String description;

   TipologiaERR08(String value, String description)
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