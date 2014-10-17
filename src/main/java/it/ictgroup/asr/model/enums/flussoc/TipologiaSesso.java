package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaSesso
{
   MASCHIO ("1"), // maschio
   FEMMINA ("2"); // femmina

   private String sesso;

   TipologiaSesso(String sesso)
   {
      this.sesso = sesso;
   }
}
