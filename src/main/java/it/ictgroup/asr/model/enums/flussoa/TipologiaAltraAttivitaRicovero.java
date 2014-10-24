package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaAltraAttivitaRicovero
{
   ESPIANTO ("1"), // espianto di organo da cadavere per trapianto
   IMPIANTO_CUORE ("2"), // impianto di cuore artificiale
   ASSISTENZA_ALBERGHIERA ("3"), // assistenza alberghiera per il genitore che assiste il bambino ricoverato
   IMPIANTO_PROTESI ("4"); // impianto di protesi (Allegato 3 D.G.R. n. 1621 del 10.09.2002

   private String value;

   TipologiaAltraAttivitaRicovero(String value)
   {
      this.value = value;
   }

   public String getValue()
   {
      return value;
   }
}
