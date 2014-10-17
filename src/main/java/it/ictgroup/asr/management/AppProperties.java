package it.ictgroup.asr.management;

public enum AppProperties
{

   ;

   @SuppressWarnings("unchecked")
   public <T> T cast(Class<T> clazz)
   {
      if (Long.class.equals(clazz))
      {
         return (T) new Long(value());
      }
      if (Integer.class.equals(clazz))
      {
         return (T) new Integer(value());
      }
      if (Boolean.class.equals(clazz))
      {
         return (T) new Boolean(value());
      }
      return (T) value();
   }

   public String value()
   {
      String value = getProperty(AppConstants.APP_NAME, name());
      if (value == null)
      {
         throw new RuntimeException(
                  AppConstants.APP_NAME
                           + " - ATTENZIONE SISTEMA NON CONFIGURATO: MANCANO LE SYSTEM PROPERTIES IN STANDALONE.XML"
                           + "- " + name());
      }
      return value;
   }

   public String replace(String[] placeholders, Object[] values)
   {
      String value = value();
      if (placeholders != null && values != null
               && placeholders.length == values.length)
      {
         for (int i = 0; i < placeholders.length; i++)
         {
            value = value.replaceAll("\\{" + placeholders[i] + "\\}",
                     (values[i] == null ? "" : values[i].toString()));
         }
      }
      return value;
   }

   public String[] split(String string)
   {
      return value().split(string);
   }

   public static String getProperty(String prefix, String name)
   {
      return System.getProperty(prefix + "." + name);
   }

   public static void setProperty(String prefix, String name, String value)
   {
      System.out
               .println("ATTENZIONE! PERSISTENZA SU FILE DI PROPERTIES NON ANCORA IMPLEMENTATA");
      System.setProperty(prefix + "." + name, value);
   }

}
