package it.ictgroup.asr.model;

public enum TipologiaPresenzaQuesitoDiagnostico
{
   SI ("0"), // si
   NO ("1"); // no

   private String presenza;

   TipologiaPresenzaQuesitoDiagnostico(String presenza)
   {
      this.presenza = presenza;
   }
}
