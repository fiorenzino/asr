package it.ictgroup.asr.util;

import it.ictgroup.asr.model.Flussoa2;
import it.ictgroup.asr.model.Flussoa2r;
import it.ictgroup.asr.model.Flussoc2;
import it.ictgroup.asr.model.Flussoc2r;

public class FlussiUtils
{
   public static void valorizzaErroriFlussoc2(Flussoc2 riferimento, Flussoc2r conErrori)
   {
      riferimento.setErr10(conErrori.getErr10());
      riferimento.setErr01(conErrori.getErr01());
      riferimento.setErr08(conErrori.getErr08());
      riferimento.setErr09(conErrori.getErr09());
      riferimento.setErr04(conErrori.getErr04());
      riferimento.setErr06(conErrori.getErr06());
      riferimento.setErr07(conErrori.getErr07());
      riferimento.setErr03(conErrori.getErr03());
      riferimento.setErr05(conErrori.getErr05());
      riferimento.setErr02(conErrori.getErr02());
   }

   public static void valorizzaErroriFlussoa2(Flussoa2 riferimento, Flussoa2r conErrori)
   {
      riferimento.setErr10(conErrori.getErr10());
      riferimento.setErr01(conErrori.getErr01());
      riferimento.setErr08(conErrori.getErr08());
      riferimento.setErr09(conErrori.getErr09());
      riferimento.setErr04(conErrori.getErr04());
      riferimento.setErr06(conErrori.getErr06());
      riferimento.setErr07(conErrori.getErr07());
      riferimento.setErr03(conErrori.getErr03());
      riferimento.setErr05(conErrori.getErr05());
      riferimento.setErr02(conErrori.getErr02());
   }
}
