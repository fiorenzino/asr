package it.coopservice.gestionefatturepa.management.init;

import it.ictgroup.asr.management.AppConstants;
import it.ictgroup.asr.management.AppProperties;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class AppPropertiesInit
{
   private static Map<AppProperties, Map<AppConfiguration, String>> map = new HashMap<AppProperties, Map<AppConfiguration, String>>();

   public static Map<AppProperties, Map<AppConfiguration, String>> getMap()
   {
      return map;
   }

   protected static void init(AppProperties appProperty, String predefinito)
   {
      Map<AppConfiguration, String> configurazione = new HashMap<AppConfiguration, String>();
      map.put(appProperty, configurazione);
      for (AppConfiguration appConfiguration : AppConfiguration.values())
      {
         configurazione.put(appConfiguration, predefinito);
      }
   }

   protected static void init(AppProperties appProperty,
            AppConfiguration appConfiguration, String predefinito)
   {
      Map<AppConfiguration, String> configurazione = map.get(appProperty);
      if (configurazione == null)
      {
         configurazione = new HashMap<AppConfiguration, String>();
         map.put(appProperty, configurazione);
      }
      configurazione.put(appConfiguration, predefinito);
   }

   static
   {

      // MASTER TIMER
      init(AppProperties.masterUrl,
               "http://localhost:8080/asr/rest/v1/master/checkRunning");

      // MASTER TIMER
      init(AppProperties.masterUrl, AppConfiguration.SVILUPPO_POLI,
               "http://localhost:8180/asr/rest/v1/master/checkRunning");

   }

   public static boolean verifyLocally(AppConfiguration appConfiguration,
            boolean printSystemProperties)
   {
      boolean result = true;
      for (AppProperties appProperties : AppProperties.values())
      {
         Map<AppConfiguration, String> configurazione = map
                  .get(appProperties);
         if (!configurazione.containsKey(appConfiguration))
         {
            System.out.println("NO PREDEFINED VALUE FOR :"
                     + appProperties.name());
            result = false;
         }
         String value = configurazione.get(appConfiguration);
         if (value == null)
         {
            System.out.println("NULL PREDEFINED VALUE FOR :"
                     + appProperties.name());
            result = false;
         }
         else if (printSystemProperties)
         {
            System.out.println("<property name=\"" + AppConstants.APP_NAME
                     + "." + appProperties.name() + "\" value=\""
                     + configurazione.get(appConfiguration) + "\"/>");
         }
      }
      return result;
   }

   public static void main(String[] args) throws Exception
   {

      AppConfiguration chosenConfiguration = choose();
      boolean printSystemProperties = true;
      if (!verifyLocally(chosenConfiguration, printSystemProperties))
      {
         System.err.println("CONFIGURAZIONE NON COMPLETATA");
      }
   }

   public static AppConfiguration choose() throws Exception
   {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      System.out.println("Inserire il tipo di configurazione richiesta: ");
      AppConfiguration chosenConfiguration = AppConfiguration.PRODUZIONE;

      for (AppConfiguration appConfiguration : AppConfiguration.values())
      {
         System.out.print("\t" + appConfiguration.ordinal() + " = "
                  + appConfiguration);
         if (chosenConfiguration.equals(appConfiguration))
         {
            System.out.println(" [default]");
         }
         else
         {
            System.out.println();
         }
      }
      String chosenConfigurationString = br.readLine();
      if (chosenConfigurationString != null
               && !chosenConfigurationString.trim().isEmpty())
      {
         chosenConfiguration = AppConfiguration.values()[Integer
                  .parseInt(chosenConfigurationString)];
      }
      return chosenConfiguration;
   }

}
