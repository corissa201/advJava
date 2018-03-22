package java112.analyzer;


/**
 * The TokenAnalyzer interface is implemented by the Analyzer classes in the
 * analyzer program to process tokens and generate the output file.
 *
 * @author      Corissa Engel
 * @version     2.0
 */
public interface TokenAnalyzer{

    /**
     * This method is used to process the token for all Analyzer classes.
     * @param token A list of all the tokens read from the file.
     */
    void processToken(String token);
    /**
     * This method is used to generate the output files for all Analyzer classes.
     * @param inputFilePath The file path to the input file.
     */
    void generateOutputFile(String inputFilePath);
}
