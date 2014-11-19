package it.ictgroup.asr.test;

import it.ictgroup.asr.model.Flussoc2;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class FlussoC2Test
{
   @Test
   public void test() throws Exception
   {
      try
      {
//         FileHelperEngine<Flussoc2> fileHelperEngine =
//                  new FileHelperEngine<Flussoc2>(Flussoc2.class);
         List<Flussoc2> righe = new ArrayList<Flussoc2>();
         // righe = fileHelperEngine.readFile(
         //        "docs/data/20140831-20140801C2.txt");
         if (righe != null)
         {

            for (Flussoc2 flussoc2 : righe)
            {
               System.out.println(flussoc2);
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
