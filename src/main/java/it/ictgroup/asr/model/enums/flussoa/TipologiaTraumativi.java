package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaTraumativi
{
   INFORTUNIO_LAVORO ("1", "infortunio sul lavoro"),
   INFORTUNIO_DOMESTICO ("2", "infortunio in ambiente domestico"),
   INCIDENTE_STRADALE ("3", "incidente stradale"),
   VIOLENZA_ALTRUI ("4", "violenza altrui (indipendentemente dal luogo dove è avvenuta)"),
   AUTOLESIONE ("5", "autolesione o tentativo di suicidio (indipendentemente dal luogo dove è avvenuto)"),
   MORSO_ANIMALE ("6", "morso animale/insetto"),
   INCIDENTE_SPORTIVO ("7", "incidente sportivo"),
   ALTRO ("9", "altro tipo di incidente o di intossicazione");

   private String value;
   private String description;

   TipologiaTraumativi(String value, String description)
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
