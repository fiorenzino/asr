package it.flower.helper.test;

import it.ictgroup.asr.model.Flussoc1;
import it.ictgroup.asr.util.FlowerFileHelper;
import it.ictgroup.asr.util.annotations.FieldFixedLength;
import it.ictgroup.asr.util.annotations.FieldIgnored;

import java.io.File;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class AnnotationsTest
{

   public static void main(String[] args) throws Exception
   {
      FlowerFileHelper<Flussoc1> filedReader = new FlowerFileHelper<Flussoc1>(Flussoc1.class);

      Flussoc1 flussoc1 = filedReader
               .valorize("110103000002000002FSNTLNZ51M50G873Q                TOMASSINI                     IRMA                208061934TMSRMI34H48G516L109016110111                                                                              110130121274166 0113 1000000000017007851001");
      System.out.println(flussoc1);
   }

   public static void mainOK(String[] args) throws Exception
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

   public static void main1(String[] args)
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
}
