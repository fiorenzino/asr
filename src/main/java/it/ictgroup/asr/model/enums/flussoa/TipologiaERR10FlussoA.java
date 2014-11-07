package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaERR10FlussoA
{
   NESSUN_ERRORE ("0", "nessun errore"),
   COD_REGIONE_ASSENTE ("1", "codice Regione/Azienda U.S.L. assente o errato");

   private String value;
   private String description;

   TipologiaERR10FlussoA(String value, String description)
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
