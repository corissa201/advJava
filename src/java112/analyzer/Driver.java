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
      //instantiate an instance of the project’s main processing class.
      FileAnalysis analyzer = new FileAnalysis();
      //call the main processing method of the main class passing the command line arguments array to the method.
      analyzer.analyze(arguments);
   }

}