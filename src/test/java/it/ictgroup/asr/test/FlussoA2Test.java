package it.ictgroup.asr.test;

import it.ictgroup.asr.model.Flussoa2;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class FlussoA2Test
{
   @Test
   public void test() throws Exception
   {
      try
      {
//         FileHelperEngine<Flussoa2> fileHelperEngine =
//                  new FileHelperEngine<Flussoa2>(Flussoa2.class);
         List<Flussoa2> righe = new ArrayList<Flussoa2>();
         // righe = fileHelperEngine.readFile(
         // "docs/data/A2.txt");
         if (righe != null)
         {

            for (Flussoa2 flussoa2 : righe)
            {
               System.out.println(flussoa2);
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
