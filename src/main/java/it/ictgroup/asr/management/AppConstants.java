package it.ictgroup.asr.management;

public class AppConstants
{

   public static String APP_NAME = "asr";

   public static final String HOSTNAME_PROPERTY = "jboss.qualified.host.name";

   public static final String FLUSSI_ASR_QUEUE = "java:/jms/queue/flussiAsr";
   public static final String VERIFICA_INVIO_ASR_QUEUE = "java:/jms/queue/verificaInvioAsr";

   public static final String CORREGGI_ERRORI_ASR_QUEUE = "java:/jms/queue/correggiErroriAsr";

   public static final boolean CORREGGO = false;

}
