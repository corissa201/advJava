package java112.analyzer;


/**
 * TokenAnalyzer interface in the analyzer program
 *
 * @author      Corissa Engel
 * @version     1.1
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
     * @param outPutFilePath The file path to the output file.
     */
    void generateOutputFile(String inputFilePath, String outputFilePath);
}
