package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaOnereDegenza
{
   RESPONSABILITA_TERZI ("0"), // presunta responsabilità terzi
   TOT_CARICO_SSN ("1"), // ricovero a totale carico del SSN
   PREVALENTE_CARICO_SSN_DIFF_ALBERGHIERA ("2"), // ricovero a prevalente carico SSN, con parte delle spese a carico  paziente (differenza alberghiera)
   RIMBORSO ("3"), // ricovero con successivo rimborso (totale o parziale) a carico del SSN
   SENZA_ONERI ("4"), // ricovero senza oneri per il SSN
   PREVALENTE_CARICO_SSN_LIBERA_PROF("5"), // ricovero a prevalente carico SSN, con parte delle spese a carico  paziente  (libera professione)
   PREVALENTE_CARICO_SSN_DIFF_ALBERGHIERA_PROF ("6"), // ricovero a prevalente carico SSN, con parte delle spese a carico paziente (differenza alberghiera + libera professione)
   CARICO_SSN_STRANIERI_CONVENZ ("7"), // ricovero a carico del SSN di paziente stranieri provenienti da paesi convenzionati con il SSN
   CARICO_SSN_STRANIERI_INDIGENZA ("8"), // ricovero a carico del SSN di pazienti stranieri con dichiarazione di indigenza (minori e gravidanza/maternità)
   CARICO_MINISTERO ("A"), // ricovero a carico del Ministero dell’Interno di pazienti stranieri con dichiarazione di indigenza
   CARICO_SSN_STRANIERI_TRASFERITI ("B"), // ricovero a carico del SSN di pazienti stranieri trasferiti in Italia per cure (programmi Umanitari ex art. 12 comma 2 lett. c del D. Lgs. 502/92)
   ALTRO ("9"); // altro

   private String value;

   TipologiaOnereDegenza(String value)
   {
      this.value = value;
   }

   public String getValue()
   {
      return value;
   }
}
