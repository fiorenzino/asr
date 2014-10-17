package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaCicloPrestazioni
{
   NO ("0"), // no prestazione a ciclo
   SI ("1"); // si prestazione a ciclo

   private String cicloPrestaz;

   TipologiaCicloPrestazioni(String cicloPrestaz)
   {
      this.cicloPrestaz = cicloPrestaz;
   }
}
