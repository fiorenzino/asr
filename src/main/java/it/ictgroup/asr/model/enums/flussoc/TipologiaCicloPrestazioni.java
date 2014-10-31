package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaCicloPrestazioni
{
   NO ("0", "no prestazione a ciclo"),
   SI ("1", "si prestazione a ciclo");

   private String value;
   private String description;

   TipologiaCicloPrestazioni(String value, String description)
   {
      this.value = value;
      this.description = description;
   }

   public String getValue()
   {
      return value;
   }

   public String getDescription()
   {
      return description;
   }
}
