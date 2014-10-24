package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaMotivoRicoveroDiurno
{
   DIAGNOSTICO ("1"), // ricovero diurno diagnostico (ivi compreso il follow up)
   CHIRURGICO ("2"), // ricovero diurno chirurgico (day surgery)
   TERAPEUTICO ("3"), // ricovero diurno terapeutico
   RIABILITATIVO ("4"); // ricovero diurno riabilitativo

   private String motivo;

   TipologiaMotivoRicoveroDiurno(String motivo)
   {
      this.motivo = motivo;
   }
}
