package it.ictgroup.asr.util;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtils
{
   public static List<String> listFiles(String folderPath) throws IOException
   {
      List<String> result = new ArrayList<>();

      DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(folderPath));
      for (Path entry : stream)
      {
         if (Files.isDirectory(entry))
         {
            listFiles(entry.getFileName().toAbsolutePath().toString());
         }
         result.add(entry.getFileName().toAbsolutePath().toString());
      }
      return result;
   }

   public static List<String> listFilesWithFilter(String folderPath, String postfix, List<String> filesList)
            throws IOException
   {
      List<String> result = new ArrayList<>();

      DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(folderPath), postfix);
      for (Path entry : stream)
      {
         String fileName = entry.getFileName().getName(0).toString();
         if (Files.isDirectory(entry))
         {
            listFiles(entry.getFileName().toAbsolutePath().toString());
         }
         if (!filesList.contains(fileName))
            result.add(fileName);
      }
      return result;
   }
}
