package it.ictgroup.asr.model.enums;

public enum StatoInvio
{

   // ho una parte dei due files iniziali: es a1 e NON a2 oppure a2 e NON a1
   INCOMPLETO,
   // ho i 2 files iniziali: es a1, a2
   IN_ATTESA_DI_ESITO,
   // incompleto non inviabile
   ERRORE_INZIALE,
   // i due files non sono coerenti (es numero righe)
   ERRORE_COERENZA,
   // trovo il file r
   ESITATO_CON_ERRORI,
   // non c'e' file r -> ma dalla maschera ho flagatto esito senza errori
   ESITATO_SENZA_ERRORI;
}
