package it.ictgroup.asr.test;

import it.ictgroup.asr.model.Flussoa1;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class FlussoA1Test
{
   @Test
   public void test() throws Exception
   {
      try
      {
         // FileHelperEngine<Flussoa1> fileHelperEngine =
         // new FileHelperEngine<Flussoa1>(Flussoa1.class);
         List<Flussoa1> righe = new ArrayList<Flussoa1>();
         // righe = fileHelperEngine.readFile(
         // "docs/data/A1.txt");
         if (righe != null)
         {

            for (Flussoa1 flussoa1 : righe)
            {
               System.out.println(flussoa1);
            }
            System.out.println(righe.size());
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
         Assert.fail("merda");
      }

   }
}
