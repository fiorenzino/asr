package it.ictgroup.asr.test.enums;

import it.ictgroup.asr.util.ReflectionsUtil;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by stefano on 24/10/14.
 */
public class EnumTest
{
   @Test
   public void test()
   {
      try
      {
         Class[] classes = ReflectionsUtil.getClasses("it.ictgroup.asr.model.enums");
         String val = null;
         String desc = null;
         for(Class c : classes)
         {
            System.out.println("// -------------------");
            String createTableSql = "CREATE TABLE " + c.getSimpleName() + " (name varchar(255), value varchar(255), description varchar(255));";
            System.out.println(createTableSql);
            for(Object constant : Arrays.asList(c.getEnumConstants()))
            {
               Class<?> sub = constant.getClass();
               try
               {
                  Method getValue = sub.getDeclaredMethod("getValue");
                  val = (String) getValue.invoke(constant);
               }
               catch (NoSuchMethodException e)
               {}

               try
               {
                  Method getDescription = sub.getDeclaredMethod("getDescription");
                  desc = (String) getDescription.invoke(constant);
               }
               catch (NoSuchMethodException e)
               {}
               String insertSql = "INSERT INTO " + c.getSimpleName() + " VALUES (" +
                        "'" + ((Enum)constant).name() + "'" +
                        ", " + ((val != null) ? "'" + val + "'" : null) +
                        ", " + ((desc != null) ? "'" + desc + "'" : null) +
                        ")";
               System.out.println(insertSql);
               val = null;
               desc = null;
            }
         }
      }
      catch (ClassNotFoundException e)
      {
         e.printStackTrace();
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
      catch (InvocationTargetException e)
      {
         e.printStackTrace();
      }
      catch (IllegalAccessException e)
      {
         e.printStackTrace();
      }
   }
}
