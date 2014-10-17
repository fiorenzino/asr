package it.ictgroup.asr.model;

public enum TipologiaAttivitaPS
{
   NO_PS ("0"), // no pronto soccorso
   SI_PS("1"); // si pronto soccorso

   private String attivita;

   TipologiaAttivitaPS(String attivita)
   {
      this.attivita = attivita;
   }
}
