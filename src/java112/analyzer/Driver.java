package java112.analyzer;

/**
 * @author Corissa Engel
 * class Driver
 */
public class Driver {

   /**
    *The main class to that will run the project 1 program 
    * @param arguments The command line arguments.
    */
   public static void main(String[] arguments) {
      FileAnalysis analyzer = new FileAnalysis();
      analyzer.analyze(arguments);
   }

}