package it.ictgroup.asr.service.controller;

import it.ictgroup.asr.model.Flussoc2;

import java.io.IOException;
import java.util.List;

import org.coury.jfilehelpers.engines.EngineBase;
import org.coury.jfilehelpers.engines.FileHelperEngine;
import org.coury.jfilehelpers.events.AfterReadRecordEventArgs;
import org.coury.jfilehelpers.events.AfterReadRecordHandler;

public class FlussoC2Controller
{

   private FileHelperEngine<Flussoc2> fileHelperEngine;
   private List<Flussoc2> righe;
   private String fileName;
   boolean withErrori;

   public FlussoC2Controller(String fileName)
   {
      this.fileName = fileName;
      fileHelperEngine = new FileHelperEngine<>(Flussoc2.class);
   }

   public List<Flussoc2> execute() throws IOException
   {
      fileHelperEngine.setAfterReadRecordHandler(
               new AfterReadRecordHandler<Flussoc2>()
               {
                  public void handleAfterReadRecord(EngineBase<Flussoc2> engine, AfterReadRecordEventArgs<Flussoc2> e)
                  {
                     if (e.getRecord().containsErrors())
                     {
                        setWithErrori(true);
                     }
                  }
               }
               );
      this.righe = fileHelperEngine.readFile(fileName);
      return righe;
   }

   public FileHelperEngine<Flussoc2> getFileHelperEngine()
   {
      return fileHelperEngine;
   }

   public void setFileHelperEngine(FileHelperEngine<Flussoc2> fileHelperEngine)
   {
      this.fileHelperEngine = fileHelperEngine;
   }

   public List<Flussoc2> getRighe()
   {
      return righe;
   }

   public void setRighe(List<Flussoc2> righe)
   {
      this.righe = righe;
   }

   public boolean isWithErrori()
   {
      return withErrori;
   }

   public void setWithErrori(boolean withErrori)
   {
      this.withErrori = withErrori;
   }

   public String getFileName()
   {
      return fileName;
   }

   public void setFileName(String fileName)
   {
      this.fileName = fileName;
   }
}
