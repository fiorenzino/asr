package it.ictgroup.asr.util;

import it.ictgroup.asr.util.annotations.FieldDatePattern;
import it.ictgroup.asr.util.annotations.FieldFixedLength;
import it.ictgroup.asr.util.annotations.FieldIgnored;

import java.io.File;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.jboss.logging.Logger;

public class FlowerFileHelper<T>
{
   static Logger logger = Logger.getLogger(FlowerFileHelper.class);
   public String line;
   public Class<T> typeArgumentClass;
   public List<FileField> fields;
   public int size;
   public int lastFieldSize;

   public FlowerFileHelper(Class<T> typeArgumentClass)
   {

      this.typeArgumentClass = typeArgumentClass;

      fields = new LinkedList<FileField>();
      int from = 0;
      int numField = typeArgumentClass.getDeclaredFields().length;
      int i = 0;
      for (Field field : typeArgumentClass.getDeclaredFields())
      {
         i++;
         if (field.isAnnotationPresent(FieldIgnored.class))
         {
            // System.out.println("SKIP:" + field.getName());
            continue;
         }
         FileField fileField = new FileField(field.getName(), field.getType());
         if (field.isAnnotationPresent(FieldDatePattern.class))
         {
            FieldDatePattern ta = field.getAnnotation(FieldDatePattern.class);
            String pattern = ta.value();
            fileField.pattern = pattern;
         }

         if (field.isAnnotationPresent(FieldFixedLength.class))
         {
            FieldFixedLength ta = field.getAnnotation(FieldFixedLength.class);
            // System.out.println(field.getName() + ": " + ta.value());
            int to = from + Integer.valueOf(ta.value());
            fileField.from = from;
            fileField.to = to;
            from += Integer.valueOf(ta.value());
            fields.add(fileField);
         }
         if (i == numField)
         {
            lastFieldSize = fileField.to - fileField.from;
         }
      }
      this.size = from;
   }

   public T valorize(String line) throws Exception
   {
      if (line.length() < (size - lastFieldSize))
      {
         String msg = "Linea di dimensione inferiore (" + line.length() + ") a quanto aspettato (" + size
                  + " compresa tolleranza " + lastFieldSize + ")";
         logger.info(msg);
         throw new Exception(msg);
      }
      T obj = this.typeArgumentClass.newInstance();
      int maxlength = line.length();
      for (FileField fileField : fields)
      {
         int max = fileField.to > maxlength ? maxlength
                  : fileField.to;
         String value = line.substring(fileField.from, max).trim();
         Field f = obj.getClass().getDeclaredField(fileField.name);
         f.setAccessible(true);
         if (value == null || value.trim().isEmpty())
            continue;
         if (fileField.clazz.equals(Date.class) && fileField.pattern != null && !fileField.pattern.isEmpty())
         {
            // System.out.println("DATE: " + value);
            SimpleDateFormat sdf = new SimpleDateFormat(fileField.pattern);
            f.set(obj, sdf.parse(value));
         }
         else if (fileField.clazz.equals(Double.class))
         {
            f.set(obj, new Double(value));
         }
         else if (fileField.clazz.equals(Long.class))
         {
            f.set(obj, new Long(value));
         }
         else if (fileField.clazz.equals(BigDecimal.class))
         {
            f.set(obj, new BigDecimal(value));
         }
         else
         {
            f.set(obj, value);
         }

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
