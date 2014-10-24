package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaMedicoPrescrittore
{
   F, // medico di medicina generale
   P, // pediatra di libera scelta
   H, // ospedaliero
   A, // specialista ambulatoriale (ex SUMAI)
   G, // guardia medica
   T, // guardia medica turistica
   C, // specialista di struttura privata accreditata
   U, // medico di azienda ospedaliero-universitaria
   D, // dipendente dei servizi territoriali ASL/ASUR
   Z, // altra specializzazione
   W, // medico di altra regione
   X, // medico pronto soccorso
   Y; // medico SERT

   public String getValue()
   {
      return this.name();
   }
}
