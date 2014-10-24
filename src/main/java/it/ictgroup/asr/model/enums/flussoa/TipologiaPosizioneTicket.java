package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaPosizioneTicket
{
   ESENTE_TOT ("1"), // esente totale
   NON_ESENTE ("2"), // non esente
   QUOTA_RICETTA ("3"); // pagamento quota ricetta

   private String value;

   TipologiaPosizioneTicket(String value)
   {
      this.value = value;
   }

   public String getValue()
   {
      return value;
   }
}
