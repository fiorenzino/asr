package it.ictgroup.asr.servlet;

import it.ictgroup.asr.model.Elaborazione;
import it.ictgroup.asr.repository.ElaborazioniRepository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.MimetypesFileTypeMap;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DownloadServlet", urlPatterns = { "/download/*" })
public class DownloadServlet extends HttpServlet
{
   private static final long serialVersionUID = 1L;
   int BUFFER_LENGTH = 4096;

   @Inject
   ElaborazioniRepository elaborazioniRepository;

   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
   {
      service(req, resp);
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
   {
      service(req, resp);
   }

   @Override
   protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
   {
      try
      {
         String uri = req.getRequestURI();
         if (uri.indexOf("?") >= 0)
         {
            uri.substring(0, uri.indexOf("?"));
         }
         String parts[] = uri.split("/");
         String filename = parts[parts.length - 1];
         String id = parts[parts.length - 2];

         Elaborazione elaborazione = elaborazioniRepository.find(Long.valueOf(id));

         String contentType = getContentType(filename);

         // Init servlet response.
         resp.setHeader("Content-Type", contentType);
         resp.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");

         File file = new File(elaborazione.getConfigurazione().getFolder() + filename);
         InputStream input = new FileInputStream(file);

         resp.setContentLength((int) file.length());
         resp.setContentType(new MimetypesFileTypeMap().getContentType(file));

         OutputStream output = resp.getOutputStream();
         byte[] bytes = new byte[BUFFER_LENGTH];
         int read = 0;
         while ((read = input.read(bytes, 0, BUFFER_LENGTH)) != -1)
         {
            output.write(bytes, 0, read);
            output.flush();
         }

         input.close();
         output.close();
      }
      catch (Exception e)
      {
         throw new RuntimeException(
                  "Errore nella lettura dello stream di input!");
      }

   }

   protected String getContentType(String filename)
   {
      if (filename == null || filename.equals(""))
      {
         return "text/html";
      }
      else if (filename.toLowerCase().endsWith(".pdf"))
      {
         return "application/pdf";
      }
      else if (filename.toLowerCase().endsWith(".rtf"))
      {
         return "application/rtf";
      }
      else if (filename.toLowerCase().endsWith(".doc"))
      {
         return "application/msword";
      }
      else if (filename.toLowerCase().endsWith(".xls"))
      {
         return "application/excel";
      }
      else if (filename.toLowerCase().endsWith(".zip"))
      {
         return "application/zip";
      }
      else if (filename.toLowerCase().endsWith(".xml"))
      {
         return "text/xml";
      }
      // application/vnd.openxmlformats .docx .pptx .xlsx .xltx . xltm .dotx
      // .potx .ppsx
      else if (filename.toLowerCase().endsWith(".docx") || filename.toLowerCase().endsWith(".pptx")
               || filename.toLowerCase().endsWith(".xlsx") || filename.toLowerCase().endsWith(".xltx")
               || filename.toLowerCase().endsWith(".xltm") || filename.toLowerCase().endsWith(".dotx")
               || filename.toLowerCase().endsWith(".potx") || filename.toLowerCase().endsWith(".ppsx"))
      {
         return "application/vnd.openxmlformats";
      }
      else if (filename.toLowerCase().endsWith(".jpg") || filename.toLowerCase().endsWith(".jpeg")
               || filename.toLowerCase().endsWith(".jpe"))
      {
         return "image/jpeg";
      }
      else if (filename.toLowerCase().endsWith(".csv"))
      {
         return "text/csv";
      }
      else if (filename.toLowerCase().endsWith(".png"))
      {
         return "image/png";
      }
      else if (filename.toLowerCase().endsWith(".gif"))
      {
         return "image/gif";
      }
      else if (filename.toLowerCase().endsWith(".msg"))
      {
         return "application/vnd.ms-outlook";
      }
      else if (filename.toLowerCase().endsWith(".eml"))
      {
         return "message/rfc822";
      }
      else if (filename.toLowerCase().endsWith(".tif") || filename.toLowerCase().endsWith(".tiff"))
      {
         return "image/tiff";
      }
      else if (filename.toLowerCase().endsWith(".bmp"))
      {
         return "image/bmp";
      }
      else if (filename.toLowerCase().endsWith(".txt"))
      {
         return "text/plain";
      }

      return "text/html";
   }
}
