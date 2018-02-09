package java112.analyzer;

/**
 * @author Corissa Engel
 * class Driver
 */
public class Driver {

   /**
    *
    * @param arguments The command line arguments.
    */
   public static void main(String[] arguments) {

      FileAnalysis analyzer = new FileAnalysis();

      analyzer.analyze(arguments);
   }

}