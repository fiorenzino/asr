package it.ictgroup.asr.util;

import it.ictgroup.asr.model.enums.TipologiaFlusso;
import it.ictgroup.asr.model.enums.TipologiaInvio;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SiglaUtils
{

   //
   // Applicazione applicazione = null;
   // invio.setApplicazione(applicazione);
   // Date periodoA = null;
   // invio.setPeriodoA(periodoA);
   // Date periodoDa = null;

   public static String getApplicazione(String sigla) throws Exception
   {
      return getPezzi(sigla)[0];

   }

   public static TipologiaInvio getTipologiaInvio(String sigla) throws Exception
   {
      TipologiaFlusso tipologiaFlusso = getTipologiaFlusso(sigla);
      switch (tipologiaFlusso)
      {
      case A1:
      case A2:
      case A2R:
         return TipologiaInvio.A;
      case C1:
      case C2:
      case C2R:
         return TipologiaInvio.C;
      }
      throw new Exception("No tipo Invio");
   }

   public static TipologiaFlusso getTipologiaFlusso(String sigla) throws Exception
   {
      String _4 = getPezzi(sigla)[3];
      return TipologiaFlusso.valueOf(_4.substring(0, _4.indexOf(".")).toUpperCase());

   }

   public static Date getPeriodoA(String sigla) throws Exception
   {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
      return sdf.parse(getPezzi(sigla)[1]);
   }

   public static Date getPeriodoDa(String sigla) throws Exception
   {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
      return sdf.parse(getPezzi(sigla)[2]);
   }

   private static String[] getPezzi(String sigla) throws Exception
   {
      String[] pezzi = sigla.split("-");
      if (pezzi.length != 4)
         throw new Exception("Numero di pezzi insufficiente");

      return pezzi;
   }

   public static String getSiglaByFileName(String fileName)
   {
      return fileName.substring(0, fileName.lastIndexOf("-"));
   }

   public static void main(String[] args) throws Exception
   {
      String sigla = "AA-20140731-20140701-a1.txt";
      System.out.println("applicazione: " + getApplicazione(sigla));
      System.out.println("periodoA: " + getPeriodoA(sigla));
      System.out.println("periodoDa: " + getPeriodoDa(sigla));
      System.out.println("tipologia di flusso: " + getTipologiaFlusso(sigla));
      System.out.println("fileName: " + getSiglaByFileName(sigla));
   }
}
