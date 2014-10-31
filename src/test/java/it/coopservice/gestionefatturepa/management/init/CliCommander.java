package it.coopservice.gestionefatturepa.management.init;

import it.ictgroup.asr.management.AppConstants;
import it.ictgroup.asr.management.AppProperties;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.jboss.as.controller.client.ModelControllerClient;

public class CliCommander
{

   private String host;
   private int port;
   private String username;
   private String password;
   private String realmName;

   public CliCommander(String host, int port)
   {
      super();
      this.host = host;
      this.port = port;
   }

   public CliCommander(String host, int port, String username, String password)
   {
      this(host, port);
      this.username = username;
      this.password = password;
   }

   public CliCommander(String host, int port, String username, String password, String realmName)
   {
      this(host, port, username, password);
      this.realmName = realmName;
   }

   public Boolean verifyOnJboss(AppConfiguration appConfiguration, boolean fixValues)
   {
      boolean printSystemProperties = false;
      if (!AppPropertiesInit.verifyLocally(appConfiguration, printSystemProperties))
      {
         return false;
      }

      ModelControllerClient client = CliUtils.connect(host,
               port, username, password, realmName);
      if (client == null)
      {
         System.out.println("CONNECTION FAILED");
         return null;
      }

      try
      {
         boolean result = false;
         for (AppProperties appProperties : AppProperties.values())
         {

            String name = AppConstants.APP_NAME + "." + appProperties.name();
            String expectedValue = AppPropertiesInit.getMap().get(appProperties).get(appConfiguration);
            String readOnJboss = CliUtils.readOnJBoss(client, name);
            if (readOnJboss == null)
            {
               System.out.println("READ ERROR");
               return null;
            }
            if (readOnJboss.equals(expectedValue))
            {
               System.out.println("OK -> name: " + name + " - value: " + expectedValue);
            }
            else
            {
               System.out.println("TO CORRECT -> name: " + name + " - expected: " + expectedValue + " - actual: "
                        + readOnJboss);
               if (fixValues)
               {
                  Boolean writeOnJboss = CliUtils.writeOnJBoss(client, name, expectedValue);
                  if (writeOnJboss == null)
                  {
                     System.out.println("WRITE ERROR");
                     return null;
                  }
                  if (!writeOnJboss.booleanValue())
                  {
                     System.out.println("ERROR ON FIX VALUE-> name: " + name);
                  }
                  else
                  {
                     System.out.println("FIXED -> name: " + name + " - value: " + expectedValue);
                     result = false;
                  }
               }
               else
               {
                  System.out.println("NOT FIXED -> name: " + name);
                  result = false;
               }
            }
         }

         cleanOnJBoss(client, fixValues);

         return result;
      }
      catch (Throwable t)
      {
         t.printStackTrace();
         return null;
      }
      finally
      {
         try
         {
            client.close();
         }
         catch (Throwable t)
         {
         }
      }
   }

   private void cleanOnJBoss(ModelControllerClient client, boolean fixValues)
   {
      String prefix = AppConstants.APP_NAME + ".";
      List<String> allAppProperties = CliUtils.listProperties(client, prefix);
      if (allAppProperties == null)
      {
         System.out.println("LIST ERROR");
         return;
      }
      int unused = 0;
      int cleaned = 0;
      for (String anAppProperty : allAppProperties)
      {
         try
         {
            AppProperties.valueOf(anAppProperty.substring(prefix.length()));
         }
         catch (Throwable t)
         {
            System.out.println("UNUSED -> name: " + anAppProperty);
            unused++;
            if (!fixValues)
            {
               System.out.println("NOT DELETED -> name: " + anAppProperty);
            }
            else
            {
               if (CliUtils.removeOnJBoss(client, anAppProperty))
               {
                  System.out.println("DELETED -> name: " + anAppProperty);
                  cleaned++;
               }
               else
               {
                  System.out.println("DELETION ERROR");
                  return;
               }
            }
         }
      }
      if (unused > 0)
      {
         System.out.println("FOUND " + unused + " UNUSED PROPERTIES; CLEANED: " + cleaned);
      }
      else
      {
         System.out.println("ALL PROPERTIES ON THE SERVER ARE NEEDED");
      }
   }

   public static void main(String[] args) throws Exception
   {

      AppConfiguration chosenConfiguration = AppPropertiesInit.choose();
      boolean printSystemProperties = true;
      if (!AppPropertiesInit.verifyLocally(chosenConfiguration, printSystemProperties))
      {
         return;
      }

      System.out.println();
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      System.out
               .println("Inserire l'host su cui configurare le proprieta' [INVIO = localhost]: ");
      String host = br.readLine();
      if (host == null || host.trim().isEmpty())
      {
         host = "localhost";
      }

      System.out
               .println("Inserire la porta di amministrazione su cui eseguire l'operazione [INVIO = 9999]: ");
      String port = br.readLine();
      if (port == null || port.trim().isEmpty())
      {
         port = "9999";
      }

      String username = null;
      String password = null;
      String realmName = null;
      if (!"localhost".equals(host))
      {
         System.out.println("Inserire lo username per l'autenticazione, se necessario [INVIO = null]");
         username = br.readLine();
         if (username == null || username.trim().isEmpty())
         {
            username = null;
         }

         if (username != null)
         {
            System.out.println("Inserire la password per l'autenticazione");
            password = br.readLine();
            System.out.println("Inserire il realm per l'autenticazione [INVIO = ManagementRealm]");
            realmName = br.readLine();
            if (realmName == null || realmName.trim().isEmpty())
            {
               realmName = "ManagementRealm";
            }
         }
      }

      System.out.println("Correggi i valori su jboss, se necessario (y/N) [INVIO = N]");
      boolean fixValues = "y".equalsIgnoreCase(br.readLine());

      new CliCommander(host, Integer.parseInt(port), username, password, realmName).verifyOnJboss(chosenConfiguration,
               fixValues);

      if ( !fixValues ) {
         System.out.println("Correggi i valori non corretti (y/N) [INVIO = N]");
         fixValues = "y".equalsIgnoreCase(br.readLine());
         if ( fixValues ) {
         new CliCommander(host, Integer.parseInt(port), username, password, realmName).verifyOnJboss(chosenConfiguration,
                  fixValues);
         }
      }

      System.out.println();
      System.out.println();
      System.out.println("Bye.");

   }
}
