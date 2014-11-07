package it.ictgroup.asr.test.enums;

import it.ictgroup.asr.util.EnumToSQL;

import java.util.logging.Logger;

import org.junit.Test;

/**
 * Created by stefano on 24/10/14.
 */

/* Importazione file sql in mysql:
 * mysql < nome_file.sql --database db_name -u root -p
 */
public class EnumToSQLTest
{
   private static final String enumsPkg = "it.ictgroup.asr.model.enums";
   private static final String sqlFileName = "docs/data/db/enums-insert.sql";
   private static Logger logger = Logger.getLogger(EnumToSQLTest.class.getSimpleName());

   @Test
   public void enumToSQLTest()
   {
      EnumToSQL.enumToSQL(enumsPkg, sqlFileName);
   }
}
