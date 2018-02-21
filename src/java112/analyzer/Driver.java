package java112.analyzer;


/**
 * Driver class in the analyzer program
 *
 * @author     Corissa Engel
 * @version     1.1
 */
public class Driver {

    /**
     * The main method that will run the project 1 program
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {
        FileAnalysis analyzer = new FileAnalysis();
        analyzer.analyze(arguments);
    }
}
