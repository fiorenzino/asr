package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaMedicoPrescrittore
{
   F ("F", "medico di medicina generale"),
   P ("P", "pediatra di libera scelta"),
   H ("H", "ospedaliero"),
   A ("A", "specialista ambulatoriale (ex SUMAI)"),
   G ("G", "guardia medica"),
   T ("T", "guardia medica turistica"),
   C ("C", "specialista di struttura privata accreditata"),
   U ("U", "medico di azienda ospedaliero-universitaria"),
   D ("D", "dipendente dei servizi territoriali ASL/ASUR"),
   Z ("Z", "altra specializzazione"),
   W ("W", "medico di altra regione"),
   X ("X", "medico pronto soccorso"),
   Y ("Y", "medico SERT");

   private String value;
   private String description;

   TipologiaMedicoPrescrittore(String value, String description)
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
