package it.flower.helper.test;

import it.ictgroup.asr.model.*;
import it.ictgroup.asr.util.FlowerFileHelper;
import it.ictgroup.asr.util.annotations.FieldFixedLength;
import it.ictgroup.asr.util.annotations.FieldIgnored;

import java.io.File;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import org.jboss.logging.Logger;
import org.junit.Assert;
import org.junit.Test;

public class FlowerParserTest
{
   static Logger logger = Logger.getLogger(FlowerParserTest.class);

   @Test
   public void simpleFlussoc1Test()
   {
      Flussoc1 flussoc1 = new Flussoc1();
      flussoc1.setCodiceFiscalemedicoErogantePrescrittore("asdadasdad2");
      Field[] declaredFields = flussoc1.getClass().getDeclaredFields();
      int from = 0;
      int to = 0;
      for (Field field : declaredFields)
      {
         if (field.isAnnotationPresent(FieldIgnored.class))
         {
            System.out.println("SKIP:" + field.getName());
         }
         if (field.isAnnotationPresent(FieldFixedLength.class))
         {
            FieldFixedLength ta = field.getAnnotation(FieldFixedLength.class);
            System.out.println(field.getName() + ": " + ta.value());

            to = (from + Integer.valueOf(ta.value()));
            System.out.println("from: " + from + " - to: " + to);
            from += Integer.valueOf(ta.value());
         }
      }
   }

   @Test
   public void flussoc1Test()
   {
      try
      {
         FlowerFileHelper<Flussoc1> filedReader = new FlowerFileHelper<Flussoc1>(Flussoc1.class);

         Flussoc1 flussoc1 = filedReader
                  .valorize("110103000002000002FSNTLNZ51M50G873Q                TOMASSINI                     IRMA                208061934TMSRMI34H48G516L109016110111                                                                              110130121274166 0113 1000000000017007851001");
         System.out.println(flussoc1);
      }
      catch (Exception e)
      {
         logger.error(e.getMessage());

      }
   }

   @Test
   public void flussoC1FromFileTest()
   {
      try
      {
         FlowerFileHelper<Flussoc1> filedReader = new FlowerFileHelper<Flussoc1>(Flussoc1.class);

         Path path = Paths.get(new File(
                  "/Users/fiorenzo/workspace-all/workspace/asr/docs/data/flussi/ARSRE-20131231-20130101-c1.txt")
                  .getAbsolutePath());
         try (Scanner scanner = new Scanner(path, StandardCharsets.UTF_8.name()))
         {
            int i = 0;
            Flussoc1 flussoc1 = null;
            while (scanner.hasNextLine())
            {
               i++;
               flussoc1 = filedReader.valorize(scanner.nextLine());
               System.out.println(flussoc1);
               System.out.println(i);
            }
         }
      }
      catch (Exception e)
      {
         logger.error(e.getMessage());

      }
   }

   @Test
   public void flussoc2Test()
   {
      try
      {
         FlowerFileHelper<Flussoc2> filedReader = new FlowerFileHelper<Flussoc2>(Flussoc2.class);

         Flussoc2 flussoc2 = filedReader
                  .valorize("110111002603002603112111000 110100089846561 ZZA  00001181120100602201206022012        29012013        101       0N0160340095.02   00100016,500000000,001      Z000000000000000000016,50110000000000                      00000000000131596100   ");
         System.out.println(flussoc2);
      }
      catch (Exception e)
      {
         logger.error(e.getMessage());

      }
   }

   @Test
   public void flussoC2FromFileTest()
   {
      try
      {
         FlowerFileHelper<Flussoc2> filedReader = new FlowerFileHelper<Flussoc2>(Flussoc2.class);

         Path path = Paths.get(new File(
                  "/Users/fiorenzo/workspace-all/workspace/asr/docs/data/flussi/NC-20140131-20140101-c2.txt")
                  .getAbsolutePath());
         try (Scanner scanner = new Scanner(path, StandardCharsets.UTF_8.name()))
         {
            int i = 0;
            Flussoc2 flussoc2 = null;
            while (scanner.hasNextLine())
            {
               i++;
               flussoc2 = filedReader.valorize(scanner.nextLine());
               System.out.println(flussoc2);
               System.out.println(i);
            }
         }
      }
      catch (Exception e)
      {
         logger.error(e.getMessage());

      }
   }

   @Test
   public void flussoc2rTest()
   {
      try
      {
         FlowerFileHelper<Flussoc2r> filedReader = new FlowerFileHelper<Flussoc2r>(Flussoc2r.class);

         Flussoc2r flussoc2r = filedReader
                  .valorize("1101110044000044001134745   110110229908780 ZZA  00001050620120608201205062012        06082012        101       0N0050080188.77.2 00100043,900000000,006E01   Z000000000000000000043,9041AAAAAAAAA0                      00000000000935138500   ");
         System.out.println(flussoc2r);
      }
      catch (Exception e)
      {
         logger.error(e.getMessage());

      }
   }

   @Test
   public void flussoC2rFromFileTest()
   {
      try
      {
         FlowerFileHelper<Flussoc2r> filedReader = new FlowerFileHelper<Flussoc2r>(Flussoc2r.class);

         Path path = Paths.get(new File(
//                  "/Users/fiorenzo/workspace-all/workspace/asr/docs/data/flussi/NC-20140131-20140101-c2r.txt")
                  "/home/stefano/work/workspaces/asur/asr/docs/data/flussi/FM_WD-20141231-20141201-c2r.txt")
                  .getAbsolutePath());
         try (Scanner scanner = new Scanner(path, StandardCharsets.UTF_8.name()))
         {
            int i = 0;
            Flussoc2r flussoc2r = null;
            while (scanner.hasNextLine())
            {
               i++;
               flussoc2r = filedReader.valorize(scanner.nextLine());
               System.out.println(flussoc2r);
               System.out.println(i);
            }
         }
      }
      catch (Exception e)
      {
         logger.error(e.getMessage());

      }
   }

   @Test
   public void trovaCorrispondenzaC1C2()
   {
      try
      {
         FlowerFileHelper<Flussoc1> filedReader = new FlowerFileHelper<Flussoc1>(Flussoc1.class);
         Path path = Paths.get(new File(
                  // "/Users/fiorenzo/workspace-all/workspace/asr/docs/data/flussi/FM_WD-20131231-20131201-c1.txt")
                  // "/home/stefano/work/workspaces/asur/asr/docs/data/flussi2/FM_WD-20131231-20131201-c1.txt")
                  // "/home/stefano/work/workspaces/asur/asr/docs/data/flussi2/WD-20131130-20131101-c1.txt")
                  // "/home/stefano/work/workspaces/asur/asr/docs/data/flussi2/WD-20131031-20131001-c1.txt")
                  "/home/stefano/work/workspaces/asur/asr/docs/data/flussi2/NC-20130331-20130301-c1.txt")
//                  "/home/stefano/work/workspaces/asur/asr/docs/data/flussi2/LA-20130131-20130101-c1.txt")
                  .getAbsolutePath());
         HashMap<String, Flussoc1> flussic1 = new HashMap<String, Flussoc1>();
         try (Scanner scanner = new Scanner(path, StandardCharsets.UTF_8.name()))
         {
            int i = 0;
            Flussoc1 flussoc1 = null;
            while (scanner.hasNextLine())
            {
               i++;
               flussoc1 = filedReader.valorize(scanner.nextLine());
               String key = flussoc1.getRegioneAddebitante() + flussoc1.getCodiceStrutturaErogante()
                        + flussoc1.getId() + flussoc1.getProgressivoRigaPerRicetta();
               if(flussic1.containsKey(key))
               {
                  Assert.fail("Chiave flussoc1 " + key + " già presente");
               }
               flussic1.put(key, flussoc1);
            }
         }

         FlowerFileHelper<Flussoc2> filedReaderc2 = new FlowerFileHelper<Flussoc2>(Flussoc2.class);
         Path path2 = Paths.get(new File(
                  // "/Users/fiorenzo/workspace-all/workspace/asr/docs/data/flussi/FM_WD-20131231-20131201-c2.txt")
                  // "/home/stefano/work/workspaces/asur/asr/docs/data/flussi2/FM_WD-20131231-20131201-c2.txt")
                  // "/home/stefano/work/workspaces/asur/asr/docs/data/flussi2/WD-20131130-20131101-c2.txt")
                  // "/home/stefano/work/workspaces/asur/asr/docs/data/flussi2/WD-20131031-20131001-c2.txt")
                  "/home/stefano/work/workspaces/asur/asr/docs/data/flussi2/NC-20130331-20130301-c2.txt")
//                  "/home/stefano/work/workspaces/asur/asr/docs/data/flussi2/LA-20130131-20130101-c2.txt")
                  .getAbsolutePath());
         HashMap<String, Flussoc2> flussic2 = new HashMap<String, Flussoc2>();
         try (Scanner scanner = new Scanner(path2, StandardCharsets.UTF_8.name()))
         {
            int i = 0;
            Flussoc2 flussoc2 = null;
            while (scanner.hasNextLine())
            {
               i++;
               flussoc2 = filedReaderc2.valorize(scanner.nextLine());
               String key = flussoc2.getRegioneAddebitante() + flussoc2.getCodiceStrutturaErogante()
                        + flussoc2.getId() + flussoc2.getProgressivoRigaPerRicetta();
               if(flussic2.containsKey(key))
               {
                  Assert.fail("Chiave flussoc2 " + key + " già presente");
               }
               flussic2.put(key, flussoc2);
            }
         }

         Iterator<String> it = flussic2.keySet().iterator();
         while(it.hasNext())
         {
            String key = it.next();
            if(!flussic2.containsKey(key))
            {
               Assert.fail("Chiave flussoc2r " + key + " non presente");
            }
         }
      }
      catch (Exception e)
      {
         logger.error(e.getMessage());

      }
   }

   @Test
   public void trovaCorrispondenzaC2C2R()
   {
      try
      {
         FlowerFileHelper<Flussoc2r> filedReader = new FlowerFileHelper<Flussoc2r>(Flussoc2r.class);

         Path path = Paths.get(new File(
                  // "/Users/fiorenzo/workspace-all/workspace/asr/docs/data/flussi/FM_WD-20131231-20131201-c2r.txt")
                  // "/home/stefano/work/workspaces/asur/asr/docs/data/flussi2/FM_WD-20131231-20131201-c2r.txt")
                  // "/home/stefano/work/workspaces/asur/asr/docs/data/flussi2/WD-20131130-20131101-c2r.txt")
                  // "/home/stefano/work/workspaces/asur/asr/docs/data/flussi2/WD-20131031-20131001-c2r.txt")
                  // "/home/stefano/work/workspaces/asur/asr/docs/data/flussi2/NC-20130331-20130301-c2r.txt")
                  "/home/stefano/work/workspaces/asur/asr/docs/data/flussi2/LA-20130131-20130101-c2r.txt")
                  .getAbsolutePath());
         HashMap<String, Flussoc2r> flussic2r = new HashMap<String, Flussoc2r>();
         try (Scanner scanner = new Scanner(path, StandardCharsets.UTF_8.name()))
         {
            int i = 0;
            Flussoc2r flussoc2r = null;
            while (scanner.hasNextLine())
            {
               i++;
               flussoc2r = filedReader.valorize(scanner.nextLine());
               String key = flussoc2r.getRegioneAddebitante() + flussoc2r.getCodiceStrutturaErogante()
                        + flussoc2r.getId() + flussoc2r.getProgressivoRigaPerRicetta();
               if(flussic2r.containsKey(key))
               {
                  Assert.fail("Chiave flussoc2r " + key + " già presente");
               }
               flussic2r.put(key, flussoc2r);
            }
         }
         FlowerFileHelper<Flussoc2> filedReaderc2 = new FlowerFileHelper<Flussoc2>(Flussoc2.class);

         Path path2 = Paths.get(new File(
                  // "/Users/fiorenzo/workspace-all/workspace/asr/docs/data/flussi/FM_WD-20131231-20131201-c2.txt")
                  // "/home/stefano/work/workspaces/asur/asr/docs/data/flussi2/FM_WD-20131231-20131201-c2.txt")
                  // "/home/stefano/work/workspaces/asur/asr/docs/data/flussi2/WD-20131130-20131101-c2.txt")
                  // "/home/stefano/work/workspaces/asur/asr/docs/data/flussi2/WD-20131031-20131001-c2.txt")
                  // "/home/stefano/work/workspaces/asur/asr/docs/data/flussi2/NC-20130331-20130301-c2.txt")
                  "/home/stefano/work/workspaces/asur/asr/docs/data/flussi2/LA-20130131-20130101-c2.txt")
                  .getAbsolutePath());
         HashMap<String, Flussoc2> flussic2 = new HashMap<String, Flussoc2>();

         try (Scanner scanner = new Scanner(path2, StandardCharsets.UTF_8.name()))
         {
            int i = 0;
            Flussoc2 flussoc2 = null;
            while (scanner.hasNextLine())
            {
               i++;
               flussoc2 = filedReaderc2.valorize(scanner.nextLine());
               String key = flussoc2.getRegioneAddebitante() + flussoc2.getCodiceStrutturaErogante()
                        + flussoc2.getId() + flussoc2.getProgressivoRigaPerRicetta();
               if(flussic2.containsKey(key))
               {
                  Assert.fail("Chiave flussoc2 " + key + " già presente");
               }
               flussic2.put(key, flussoc2);
            }
         }

         Iterator<String> it = flussic2r.keySet().iterator();
         while(it.hasNext())
         {
            String key = it.next();
            if(!flussic2.containsKey(key))
            {
               Assert.fail("Chiave flussoc2r " + key + " non presente");
            }
         }
      }
      catch (Exception e)
      {
         logger.error(e.getMessage());

      }
   }


   @Test
   public void trovaCorrispondenzaA1A2()
   {
      try
      {
         FlowerFileHelper<Flussoa1> filedReader = new FlowerFileHelper<Flussoa1>(Flussoa1.class);

         Path path = Paths.get(new File(
                  // "/home/stefano/work/workspaces/asur/asr/docs/data/flussi2/ARSAE-20131231-20130101-a1.txt")
                  // "/home/stefano/work/workspaces/asur/asr/docs/data/flussi2/ARSPE-20131231-20130101-a1.txt")
                  "/home/stefano/work/workspaces/asur/asr/docs/data/flussi2/ARSRE-20131231-20130101-a1.txt")
                  .getAbsolutePath());
         HashMap<String, Flussoa1> flussia1 = new HashMap<String, Flussoa1>();
         try (Scanner scanner = new Scanner(path, StandardCharsets.UTF_8.name()))
         {
            int i = 0;
            Flussoa1 flussoa1 = null;
            while (scanner.hasNextLine())
            {
               i++;
               flussoa1 = filedReader.valorize(scanner.nextLine());
               String key = flussoa1.getRegioneAddebitante() + flussoa1.getCodiceIstitutoDiRicovero() + flussoa1.getNumeroDellaScheda();
               System.out.println("a1 - " + i + ") " + key);
               if(flussia1.containsKey(key))
               {
                  Assert.fail("Chiave flussoa1 " + key + " già presente");
               }
               flussia1.put(key, flussoa1);
            }
         }

         FlowerFileHelper<Flussoa2> fileReadera2 = new FlowerFileHelper<Flussoa2>(Flussoa2.class);

         Path path2 = Paths.get(new File(
                  // "/home/stefano/work/workspaces/asur/asr/docs/data/flussi2/ARSAE-20131231-20130101-a2.txt")
                  // "/home/stefano/work/workspaces/asur/asr/docs/data/flussi2/ARSPE-20131231-20130101-a2.txt")
                  "/home/stefano/work/workspaces/asur/asr/docs/data/flussi2/ARSRE-20131231-20130101-a2.txt")
                  .getAbsolutePath());
         HashMap<String, Flussoa2> flussia2 = new HashMap<String, Flussoa2>();

         try (Scanner scanner = new Scanner(path2, StandardCharsets.UTF_8.name()))
         {
            int i = 0;
            Flussoa2 flussoa2 = null;
            while (scanner.hasNextLine())
            {
               i++;
               flussoa2 = fileReadera2.valorize(scanner.nextLine());
               String key = flussoa2.getRegioneAddebitante() + flussoa2.getCodiceIstituto() + flussoa2.getNumeroDellaScheda();
               System.out.println("a2 - " + i + ") " + key);
               if(flussia2.containsKey(key))
               {
                  Assert.fail("Chiave flussoa2 " + key + " già presente");
               }
               flussia2.put(key, flussoa2);
            }
         }

         Iterator<String> it = flussia1.keySet().iterator();
         while(it.hasNext())
         {
            String key = it.next();
            if(!flussia2.containsKey(key))
            {
               Assert.fail("Chiave flussoa2 " + key + " non presente");
            }
         }
      }
      catch (Exception e)
      {
         logger.error(e.getMessage());

      }
   }
}
