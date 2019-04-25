package com.shdic.test;
import java.util.logging.*;

public class Test_logger {
   // Invoke the factory method to get a new Logger or return the existing Logger
   //  of the fully-qualified class name.
   // Set to static as there is one logger per class.
   private static final Logger logger = Logger.getLogger(Test_logger.class.getName());
 
   public static void main(String[] args) {
      logger.info("Logging begins...");   // log INFO-level message
      try {
         // Simulating an Exception
         throw new Exception("Throw an exception !");
      } catch (Exception ex){
         logger.log(Level.SEVERE, ex.getMessage(), ex);
      }
      logger.info("Logging finished...");
   }
}