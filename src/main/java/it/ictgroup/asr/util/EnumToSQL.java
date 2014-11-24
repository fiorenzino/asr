package it.ictgroup.asr.util;

import org.apache.commons.lang.StringEscapeUtils;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by stefano on 31/10/14.
 */
public class EnumToSQL
{
   private static Logger logger = Logger.getLogger(EnumToSQL.class.getSimpleName());

   public enum SQLDialect
   {
      MYSQL, POSTGRES
   }

   public static void enumToSQL(String packageName, String sqlFileName, SQLDialect dialect)
   {
      try
      {
         Class[] classes = ReflectionUtils.getClasses(packageName);
         PrintStream printStream = new PrintStream(sqlFileName);
         enumToSql(classes, printStream,dialect);
         printStream.close();
      }
      catch (ClassNotFoundException e)
      {
         e.printStackTrace();
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
   }

   public static void enumToSql(Class[] classes, PrintStream printStream, SQLDialect dialect)
   {
      for(Class c : classes)
      {
         enumToSQL(c, printStream, dialect);
      }
   }
   
   public static void enumToSQL(Class clz, PrintStream printStream, SQLDialect dialect)
   {
      String val = null;
      String desc = null;
      logger.info("------------------- " + clz.getSimpleName() + " -------------------");
      printStream.println();
//      printStream.println("-- ------------------- " + clz.getSimpleName() + " -------------------");
      String createTableSql = "";
      if(dialect == SQLDialect.MYSQL)
         createTableSql = "CREATE TABLE " + clz.getSimpleName().toLowerCase() + " (id int NOT NULL AUTO_INCREMENT, name varchar(255) NOT NULL, value varchar(255), description varchar(500), PRIMARY KEY (id));";
      else if(dialect == SQLDialect.POSTGRES)
         createTableSql = "CREATE TABLE \"" + clz.getSimpleName().toLowerCase() + "\" (\"id\" serial primary key, \"name\" varchar(255) NOT NULL, \"value\" varchar(255), \"description\" varchar(500));";
      else
         logger.log(Level.SEVERE, "invalid SQL dialect " + dialect);
      logger.info(createTableSql);
      printStream.println(createTableSql);
      for(Object constant : Arrays.asList(clz.getEnumConstants()))
      {
         Class<?> sub = constant.getClass();
         try
         {
            Method getValue = sub.getDeclaredMethod("getValue");
            val = (String) getValue.invoke(constant);
         }
         catch (NoSuchMethodException e)
         {}
         catch (InvocationTargetException e)
         {}
         catch (IllegalAccessException e)
         {}

         try
         {
            Method getDescription = sub.getDeclaredMethod("getDescription");
            desc = (String) getDescription.invoke(constant);
         }
         catch (NoSuchMethodException e)
         {}
         catch (InvocationTargetException e)
         {}
         catch (IllegalAccessException e)
         {}
         String insertSql = "";
         if(dialect == SQLDialect.MYSQL)
            insertSql = "INSERT INTO " + clz.getSimpleName().toLowerCase() + " (name, value, description) VALUES (" +
                  "'" + StringEscapeUtils.escapeSql(((Enum)constant).name()) + "'" +
                  ", " + ((val != null) ? "'" + StringEscapeUtils.escapeSql(val) + "'" : null) +
                  ", " + ((desc != null) ? "'" + StringEscapeUtils.escapeSql(desc) + "'" : null) +
                  ");";
         else if(dialect == SQLDialect.POSTGRES)
            insertSql = "INSERT INTO \"" + clz.getSimpleName().toLowerCase() + "\" (\"name\", \"value\", \"description\") VALUES (" +
                     "'" + StringEscapeUtils.escapeSql(((Enum)constant).name()) + "'" +
                     ", " + ((val != null) ? "'" + StringEscapeUtils.escapeSql(val) + "'" : null) +
                     ", " + ((desc != null) ? "'" + StringEscapeUtils.escapeSql(desc) + "'" : null) +
                     ");";
         else
            logger.log(Level.SEVERE, "invalid SQL dialect " + dialect);
         logger.info(insertSql);
         printStream.println(insertSql);
         val = null;
         desc = null;
      }
   }
}
