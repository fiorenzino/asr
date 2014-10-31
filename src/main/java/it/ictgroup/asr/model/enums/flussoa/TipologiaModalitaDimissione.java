package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaModalitaDimissione
{
   DECEDUTO ("1", "paziente deceduto"),
   DIMISS_ORDINARIA_DOMICILIO ("2", "dimissione ordinaria al domicilio del paziente"),
   DIMISS_ORDINARIA_RESIDENZA_SANITARIA ("3", "dimissione ordinaria presso una residenza sanitaria assistenziale (RSA) o Istituto di lungodegenza"),
   DIMISS_DOMICILIO ("4", "dimissione al domicilio del paziente con attivazione di ospedalizzazione domiciliare"),
   DIMISS_VOLONTARIA ("5", "dimissione volontaria (da usare anche nei casi in cui il paziente – in ciclo di trattamento diurno non si sia presentato durante il ciclo programmato)"),
   TRASFER_ALTRO_ISTITUTO_ACUTI ("6", "trasferimento ad un altro Istituto di ricovero e cura, pubblico o privato, per acuti"),
   TRASFER_ALTRO_REGIME ("7", "trasferimento ad altro regime di ricovero o ad altro tipo di attività di ricovero nell’ambito dello stesso Istituto"),
   TRASFER_ALTRO_ISTITUTO_RIABILITAZ ("8", "trasferimento ad un Istituto pubblico o privato di riabilitazione"),
   DIMISS_ORDINARIA_ASSISTENZA ("9", "dimissione ordinaria con attivazione di assistenza domiciliare integrata (ADI)");

   private String value;
   private String description;

   TipologiaModalitaDimissione(String value, String description)
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
