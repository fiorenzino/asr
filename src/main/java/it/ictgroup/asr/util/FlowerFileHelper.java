package it.ictgroup.asr.util;

import it.ictgroup.asr.util.annotations.FieldFixedLength;
import it.ictgroup.asr.util.annotations.FieldIgnored;

import java.io.File;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FlowerFileHelper<T>
{
   public String line;
   public Class<T> typeArgumentClass;
   public List<FileField> fields;

   public FlowerFileHelper(Class<T> typeArgumentClass)
   {

      this.typeArgumentClass = typeArgumentClass;

      fields = new LinkedList<FileField>();
      int from = 0;
      for (Field field : typeArgumentClass.getDeclaredFields())
      {
         if (field.isAnnotationPresent(FieldIgnored.class))
         {
            System.out.println("SKIP:" + field.getName());
            continue;
         }
         FileField fileField = new FileField(field.getName());
         if (field.isAnnotationPresent(FieldFixedLength.class))
         {
            FieldFixedLength ta = field.getAnnotation(FieldFixedLength.class);
            System.out.println(field.getName() + ": " + ta.value());
            int to = from + Integer.valueOf(ta.value());
            fileField.from = from;
            fileField.to = to;
            from += Integer.valueOf(ta.value());
            fields.add(fileField);
         }

      }

   }

   public T valorize(String line) throws Exception
   {
      T obj = this.typeArgumentClass.newInstance();
      int maxlength = line.length();
      for (FileField fileField : fields)
      {
         int max = fileField.to > maxlength ? maxlength
                  : fileField.to;
         String value = line.substring(fileField.from, max).trim();
         Field f = obj.getClass().getDeclaredField(fileField.name);
         f.setAccessible(true);
         f.set(obj, value);
      }
      return obj;
   }

   public List<T> read(File file) throws Exception
   {
      List<T> result = new LinkedList<T>();
      Path path = Paths.get(file.getAbsolutePath());
      try (Scanner scanner = new Scanner(path, StandardCharsets.UTF_8.name()))
      {
         while (scanner.hasNextLine())
         {
            result.add(valorize(scanner.nextLine()));
         }
      }

      return result;
   }
}
