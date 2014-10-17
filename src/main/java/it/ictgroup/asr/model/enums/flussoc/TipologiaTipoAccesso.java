package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaTipoAccesso
{
   NON_CLASSIFICATO ("0"), // non classificato
   PRMO_ACCESSO ("1"), // primo accesso
   SECONDO_ACCESSO ("2"); // secondo accesso (per approfondimento, controlli, ecc)

   private String accesso;

   TipologiaTipoAccesso(String accesso)
   {
      this.accesso = accesso;
   }
}
