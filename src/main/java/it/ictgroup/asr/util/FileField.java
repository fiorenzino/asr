package it.ictgroup.asr.util;

public class FileField
{
   public String name;
   public String value;
   public int from;
   public int to;


   public FileField(String name)
   {
      this.name = name;
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
               + (value != null ? "value=" + value + ", " : "") + "from=" + from + ", to=" + to + "]";
   }

}
