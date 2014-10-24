package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaAutorizzazioneProroga
{
   NESSUNA_AUTORIZZAZ ("0"), // nessuna value
   AUTORIZZAZ_SUPERAMENTO_DEGENZA ("1"), // value per il superamento della degenza limite (relativamente alla disciplina 56 Riabilitazione e 60 Lungodenza)
   ACCORDI_ISTIT_S_STEFANO ("2"); // acconti Istituto Santo Stefano

   private String value;

   TipologiaAutorizzazioneProroga(String value)
   {
      this.value = value;
   }

   public String getValue()
   {
      return value;
   }
}
