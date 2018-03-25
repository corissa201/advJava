package java112.analyzer;


import java.io.*;
import java.net.URI;
import java.util.*;


/**
 * The LargestTokensAnalyzer class will store the unique tokens from the input file
 * that are greater than or equal to a number specified in the properties files.
 *
 * @author      Corissa Engel
 * @version     1.0
 */
public class LargestTokensAnalyzer implements TokenAnalyzer {

    private Properties properties;
    private Set<String> largestTokens;
    private int minimumTokenLength;


    /**
     * This is a empty constructor for the LargestTokensAnalyzer class.
     */
    public LargestTokensAnalyzer() {
        largestTokens = new TreeSet<>();
    }


    /**
     * This is a Constructor with one Properties parameter.
     *
     * @param properties The properties file for project 2.
     */
    public LargestTokensAnalyzer(Properties properties) {
        this();
        this.properties = properties;
        minimumTokenLength = Integer.parseInt(properties.getProperty("largest.words.minimum.length"));
    }


    /**
     * This method is the getter for the largestTokens.
     *
     * @return largestTokens The treeSet of the largest tokens from the input file.
     */
    public Set<String> getLargestTokens() {
        return largestTokens;
    }


    /**
     * This method implements the processToken method in the TokenAnalyzer
     * interface and if the token length is equal to or greater then the
     * minimumTokenLength written in the properties file the token is added to
     * the distinctTokens treeSet.
     *
     * @param token A list of all the tokens from the input file.
     */
    public void processToken(String token) {
        if (token.length() >= minimumTokenLength) {
            largestTokens.add(token);
        }
    }


    /**
     * This method implements the generateOutputFile method in the TokenAnalyzer
     * interface and opens a PrintWriter to the specified file name and calls the
     * outputWriterPrint method to print out each token.
     *
     * @param inputFilePath The file path of the input file.
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
     *
     * @param outputWriter The PrintWriter open to the new file.
     */
    private void outputWriterPrint(PrintWriter outputWriter) {
        for (String token : largestTokens) {
            outputWriter.println(token);
        }
    }
}
