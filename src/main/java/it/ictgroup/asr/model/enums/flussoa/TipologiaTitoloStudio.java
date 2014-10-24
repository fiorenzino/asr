package it.ictgroup.asr.model.enums.flussoa;

public enum TipologiaTitoloStudio
{
   NESSUN_TITOLO ("0"), // nessun titolo
   ELEMENTARE ("1"), // licenza scuola elementare
   MEDIA ("2"), // licenza scuola media inferiore o avviamento professionale
   DIPLOMA_PROFESSIONALE ("3"), // diploma di qualifica professionale (corso di 2/3 anni che non permette l'accesso all'Università)
   DIPLOMA_MATURITA ("4"), // diploma di maturità
   LAUREA ("5"); // diploma universitario, laurea

   private String value;

   TipologiaTitoloStudio(String value)
   {
      this.value = value;
   }

   public String getValue()
   {
      return value;
   }
}
