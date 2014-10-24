package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaAutorizzazioneProroga
{
   NESSUNA_AUTORIZZAZ ("0", "nessuna value"),
   AUTORIZZAZ_SUPERAMENTO_DEGENZA ("1", "value per il superamento della degenza limite (relativamente alla disciplina 56 Riabilitazione e 60 Lungodenza)"),
   ACCORDI_ISTIT_S_STEFANO ("2", "acconti Istituto Santo Stefano");

   private String value;
   private String description;

   TipologiaAutorizzazioneProroga(String value, String description)
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
