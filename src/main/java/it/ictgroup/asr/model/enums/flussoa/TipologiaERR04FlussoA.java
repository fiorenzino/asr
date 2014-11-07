package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaERR04FlussoA
{
   NESSUN_ERRORE ("0", "nessun errore"),
   REGIME_ASSENTE ("1", "regime di ricovero assente/errato"),
   REPARTO_DIMISSIONE_ASSENTE ("2", "reparto di dimissione assente e/o i primi due caratteri del reparto dimissione non nel dominio (da flussi ministeriali per l’anno di riferimento)"),
   MODALITA_DIMISSIONE_ASSENTE("3", "modalità di dimissione assente/errata (non esistente nel dominio)"),
   TIPO_RICOVERO_NON_VALIDO("4", "tipo di ricovero non valorizzato o non esistente nel dominio"),
   PIU_ERRORI ("5", "più errori concomitanti per questa tipologia di value");
         
   private String value;
   private String description;

   TipologiaERR04FlussoA(String value, String description)
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
