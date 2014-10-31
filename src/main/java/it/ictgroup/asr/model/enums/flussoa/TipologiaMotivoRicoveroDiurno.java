package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaMotivoRicoveroDiurno
{
   DIAGNOSTICO ("1", "ricovero diurno diagnostico (ivi compreso il follow up)"),
   CHIRURGICO ("2", "ricovero diurno chirurgico (day surgery)"),
   TERAPEUTICO ("3", "ricovero diurno terapeutico"),
   RIABILITATIVO ("4", "ricovero diurno riabilitativo");

   private String value;
   private String description;

   TipologiaMotivoRicoveroDiurno(String value, String description)
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
