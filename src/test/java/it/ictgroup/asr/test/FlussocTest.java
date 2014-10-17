package it.ictgroup.asr.test;

import it.ictgroup.asr.flussoc.model.Flussoc1;

import java.util.ArrayList;
import java.util.List;

import org.coury.jfilehelpers.engines.FileHelperEngine;
import org.junit.Assert;
import org.junit.Test;

public class FlussocTest
{
   @Test
   public void test() throws Exception
   {
      try
      {
         FileHelperEngine<Flussoc1> fileHelperEngine =
                  new FileHelperEngine<Flussoc1>(Flussoc1.class);
         List<Flussoc1> righe = new ArrayList<Flussoc1>();
         righe = fileHelperEngine.readFile(
                  "docs/data/20140831-20140801C1.txt");
         if (righe != null)
         {

            for (Flussoc1 fLussoC : righe)
            {
               System.out.println(fLussoC);
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
