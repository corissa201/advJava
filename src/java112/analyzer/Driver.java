package java112.analyzer;


/**
 * Driver class in the analyzer program.
 * The Driver class will call the main processing method of the main
 * class, FileAnalysis, passing the command line arguments array to the method.
 *
 * @author     Corissa Engel
 * @version    2.0
 */
public class Driver {

    /**
     * The main method that will run the project 1 program.
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {
        FileAnalysis analyzer = new FileAnalysis();
        analyzer.analyze(arguments);
    }
}
