package java112.analyzer;


import java.io.*;
import java.net.URI;
import java.util.*;


/**
 * The LargestTokensAnalyzer class will only store unique tokens that are greater than or equal
 * to a specified number. The output for this TokenAnalyzer will be look like
 * the distinct tokens data file from project 1, except it will have fewer words.
 * The specified number for the minimum length token must come from the project
 * Properties object and can’t be hard-coded into the class.
 *
 * @author      Corissa Engel
 * @version     1.0
 */

public class LargestTokensAnalyzer implements TokenAnalyzer{
    private Properties properties;
    private Set<String> largestTokens;
    private int minimumTokenLength;

    public Set<String> getLargestTokens() {
        return largestTokens;
    }

 /**
     * Empty constructor for the LargestTokensAnalyzer class.
     */
    public LargestTokensAnalyzer() {

    }

    /**
     * Constructor with one Properties parameter
     */
    public LargestTokensAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }
    /**
     * This method implements the generateOutputFile method in the TokenAnalyzer
     * interface and opens a PrintWriter to the specified file name and call the
     * outputWriterPrint method to print out each token.
     * @param inputFilePath The file path of the input file.
     * @param outputFilePath The file path of the distinct_tokens output file.
     */
    public void generateOutputFile(String inputFilePath) {

        String outputFilePath = properties.getProperty("output.directory")
                + properties.getProperty("output.file.largest.words");

        try (PrintWriter outputWriter = new PrintWriter(new BufferedWriter(
                new FileWriter(outputFilePath)))
        ) {
            outputWriterPrint(outputWriter);
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    /**
     * This method will loop through and print out each token to a new line.
     * @param outputWriter The PrintWriter open to the new file.
     */
    private void outputWriterPrint(PrintWriter outputWriter) {
        for (String token : largestTokens) {
            outputWriter.println(token);
        }
    }
}
