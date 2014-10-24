package it.ictgroup.asr.model.enums.flussoc;

public enum TipologiaModalitaAccessoPrestazioni
{
   SPECIALISTICA_AMBUL  ("10"), //prestazione specialistica ambulatoriale prescritta su ricettario S.S.N.
   AGGIUNTIVA  ("11"), //prestazione aggiuntiva qualora il medico specialista ritenga necessario effettuare  ulteriori prestazioni rispetto a quelle inizialmente prescritte dal medico di fiducia del paziente, deve procedere alla compilazione di una nuova ricetta
   SPECIALISTICA_INVITO  ("12"), //prestazione specialistica su invito  ("relativa agli screening")
   EX_ART_26  ("13"), //prestazione ex art. 26 Legge 833/1978
   DOMICILIO  ("14"), //prestazione erogata presso il domicilio del paziente
   RIDUZ_LISTE_ATTESA  ("15"), //Libera professione prestazione rientrante tra le attività aziendali aggiuntive  ("ex art. 55, comma 2 CCNL 1998/2001") finalizzate alla riduzione delle liste d’attesa
   CERTIFICAZ_MEDICA  ("16"), //prestazione erogata al fine del rilascio della certificazione medico – sportiva
   CENTRO_ANTIDIABETICO  ("17"), //prestazione Centro Antidiabetico
   RADIOTERAPIA  ("18"), //prestazione di Radioterapia
   DIALISI  ("19"), //prestazione di Dialisi
   LIBERO_ACCESSO  ("20"), //prestazione a libero accesso
   LIBERA_PROFESSIONE  ("21"), //prestazione erogata in regime di libera professione
   SERT  ("22"), //prestazione erogata dai SERT
   LEA  ("23"), //prestazione non rientrante nei LEA
   PS_NON_CLASSIFICATA  ("30"), //prestazione di pronto soccorso  ("non seguito da ricovero") non classificata
   PS_COD_BIANCO  ("31"), //prestazione di pronto soccorso  ("non seguito da ricovero") classificata codice bianco
   PS_COD_VERDE  ("32"), //prestazione di pronto soccorso  ("non seguito da ricovero") classificata codice verde
   PS_COD_GIALLO  ("33"), //prestazione di pronto soccorso  ("non seguito da ricovero") classificata codice giallo
   OSSERVAZ_BREVE_INTENSIVA  ("34"), //prestazione di Osservazione Breve Intensiva  ("O.B.I.")
   PS_COD_ROSSO  ("35"), //prestazione di pronto soccorso  ("non seguito da ricovero") classificata codice rosso
   RICHIESTA_IN_REGIME  ("50"), //prestazione richiesta in regime di cessione di servizi
   SPECIALISTICA_INTERNA  ("99"); //ricetta specialistica interna


   private String value;

   TipologiaModalitaAccessoPrestazioni (String value)
   {
      this.value = value;
   }

   public String getValue()
   {
      return value;
   }
}
