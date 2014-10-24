package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaAttivitaPS
{
   NO_PS("0"), // no pronto soccorso
   SI_PS("1"); // si pronto soccorso

   private String value;

   TipologiaAttivitaPS(String value)
   {
      this.value = value;
   }

   public String getValue()
   {
      return value;
   }
}
