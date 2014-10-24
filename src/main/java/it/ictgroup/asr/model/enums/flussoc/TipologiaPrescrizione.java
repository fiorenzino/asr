package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaPrescrizione
{
   S, // suggerita
   A; // altro

   public String getValue()
   {
      return this.name();
   }
}
