package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaProvenienzaPaziente
{
   SENZA_PROPOSTA_RICOVERO ("1"), // paziente che acceda all’istituto di cura senza proposta di ricovero formulata da un medico
   CON_PROPOSTA_RICOVERO ("2"), // paziente inviato all’istituto di cura con proposta del medico di base
   RICOVERO_PROGRAMMATO ("3"), // ricovero precedentemente programmato dallo stesso istituto di cura
   PAZIENTE_TRASFERITO_STESSO_ISTIT ("4"), // paziente trasferito da un istituto di cura pubblico
   PAZIENTE_TRASFERITO_ALTRO_ISTIT ("5"), // paziente trasferito da un istituto di cura privato accreditato
   PAZIENTE_TRASFERITO_ISTIT_PRIVATO ("6"), // paziente trasferito da un istituto di cura privato non accreditato
   PAZIENTE_TRASFERITO_ALTRO ("7"), // paziente trasferito da altro tipo di attività di ricovero (acuti, riabilitazione, lungodegenza) o da altro regime di ricovero (ricovero diurno ò ordinario) nello stesso Istituto
   GUARDIA_MDICA ("8"), // guardia medica
   ALTRO ("9"); // altro

   private String provenienza;

   TipologiaProvenienzaPaziente(String provenienza)
   {
      this.provenienza = provenienza;
   }
}
