package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaAutorizzazioneProroga
{
   NESSUNA_AUTORIZZAZ ("0"), // nessuna autorizzazione
   AUTORIZZAZ_SUPERAMENTO_DEGENZA ("1"), // autorizzazione per il superamento della degenza limite (relativamente alla disciplina 56 Riabilitazione e 60 Lungodenza)
   ACCORDI_ISTIT_S_STEFANO ("2"); // acconti Istituto Santo Stefano

   private String autorizzazione;

   TipologiaAutorizzazioneProroga(String autorizzazione)
   {
      this.autorizzazione = autorizzazione;
   }
}
