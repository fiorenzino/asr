package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaCicloPrestazioni
{
   NO ("0"), // no prestazione a ciclo
   SI ("1"); // si prestazione a ciclo

   private String value;

   TipologiaCicloPrestazioni(String value)
   {
      this.value = value;
   }

   public String getValue()
   {
      return value;
   }
}
