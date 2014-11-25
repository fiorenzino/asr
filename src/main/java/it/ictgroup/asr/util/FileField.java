package it.ictgroup.asr.util;

public class FileField
{
   public String name;
   public Class<?> clazz;
   public String value;
   public int from;
   public int to;
   public String pattern;

   public FileField(String name, Class<?> clazz)
   {
      this.name = name;
      this.clazz = clazz;
   }

   public FileField(String name, int from, int to)
   {
      this.name = name;
      this.from = from;
      this.to = to;
   }

   @Override
   public String toString()
   {
      return "FileField [" + (name != null ? "name=" + name + ", " : "")
               + (clazz != null ? "clazz=" + clazz + ", " : "") + (value != null ? "value=" + value + ", " : "")
               + "from=" + from + ", to=" + to + ", " + (pattern != null ? "pattern=" + pattern : "") + "]";
   }

}
