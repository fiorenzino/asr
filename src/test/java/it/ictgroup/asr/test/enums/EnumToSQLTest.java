package it.ictgroup.asr.test.enums;

import it.ictgroup.asr.util.EnumToSQL;
import it.ictgroup.asr.util.ReflectionUtils;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Created by stefano on 24/10/14.
 */
public class EnumToSQLTest
{
   private static final String enumsPkg = "it.ictgroup.asr.model.enums";
   private static final String sqlFileName = "docs/data/enums-insert.sql";
   private static Logger logger = Logger.getLogger(EnumToSQLTest.class.getSimpleName());

   @Test
   public void enumToSQLTest()
   {
      EnumToSQL.enumToSQL(enumsPkg, sqlFileName);
   }
}
