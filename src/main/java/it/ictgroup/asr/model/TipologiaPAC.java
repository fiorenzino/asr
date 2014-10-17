package it.ictgroup.asr.model;

public enum TipologiaPAC
{
   NO_PAC ("0"), // no PAC
   SI_PAC("1"); // si PAC

   private String pac;

   TipologiaPAC(String pac)
   {
      this.pac = pac;
   }
}
