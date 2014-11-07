package it.ictgroup.asr.producer;



import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.jboss.logging.Logger;

@SessionScoped
public class LogProducer implements Serializable
{
   private static final long serialVersionUID = 1L;

   public LogProducer()
   {

   }

   @Produces
   public Logger createLogger(InjectionPoint injectionPoint)
   {
      return Logger.getLogger(injectionPoint.getMember().getDeclaringClass()
               .getCanonicalName());
   }

}
