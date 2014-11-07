package it.ictgroup.asr.service.controller;

import it.ictgroup.asr.model.Flussoa2;

import java.io.IOException;
import java.util.List;

import org.coury.jfilehelpers.engines.EngineBase;
import org.coury.jfilehelpers.engines.FileHelperEngine;
import org.coury.jfilehelpers.events.AfterReadRecordEventArgs;
import org.coury.jfilehelpers.events.AfterReadRecordHandler;

public class FlussoA2Controller
{

   private FileHelperEngine<Flussoa2> fileHelperEngine;
   private List<Flussoa2> righe;
   private String fileName;
   boolean withErrori;

   public FlussoA2Controller(String fileName)
   {
      this.fileName = fileName;
      fileHelperEngine = new FileHelperEngine<>(Flussoa2.class);
   }

   public List<Flussoa2> execute() throws IOException
   {
      fileHelperEngine.setAfterReadRecordHandler(
               new AfterReadRecordHandler<Flussoa2>()
               {
                  public void handleAfterReadRecord(EngineBase<Flussoa2> engine, AfterReadRecordEventArgs<Flussoa2> e)
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

   public FileHelperEngine<Flussoa2> getFileHelperEngine()
   {
      return fileHelperEngine;
   }

   public void setFileHelperEngine(FileHelperEngine<Flussoa2> fileHelperEngine)
   {
      this.fileHelperEngine = fileHelperEngine;
   }

   public List<Flussoa2> getRighe()
   {
      return righe;
   }

   public void setRighe(List<Flussoa2> righe)
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
