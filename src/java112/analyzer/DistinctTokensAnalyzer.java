package java112.analyzer;


import java.io.*;
import java.net.URI;
import java.util.*;


/**
 * The DistinctTokenAnalyzer class will create the output report file of all
 * the distinct tokens.
 *
 * @author      Corissa Engel
 * @version     2.0
 */
public class DistinctTokensAnalyzer implements TokenAnalyzer {

    private Set<String> distinctTokens;
    private Properties properties;


    /**
     * Empty constructor for the DistinctTokensAnalyzer class.
     */
    public DistinctTokensAnalyzer() {
        distinctTokens = new TreeSet<>();
    }


    /**
     * Constructor with one Properties parameter
     *
     * @param properties The properties file for project 2.
     */
    public DistinctTokensAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }


    /**
     * This method is the getter for the distinctTokens.
     *
     * @return distinctTokens The treeSet of unique tokens from the input file.
     */
    public Set<String> getDistinctTokens() {
        return distinctTokens;
    }


    /**
     * This method implements the processToken method in the TokenAnalyzer
     * interface and adds each unique token to the distinctTokens treeSet.
     *
     * @param token A list of all the tokens from the input file.
     */
    public void processToken(String token) {
        distinctTokens.add(token);
    }


    /**
     * This method implements the generateOutputFile method in the TokenAnalyzer
     * interface and opens a PrintWriter to the file specified in the properties
     * file and calls the outputWriterPrint method to print out each token.
     *
     * @param inputFilePath The file path of the input file.
     */
    public void generateOutputFile(String inputFilePath) {

        String outputFilePath = properties.getProperty("output.directory")
        + properties.getProperty("output.file.distinct");

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
        for (String token : distinctTokens) {
            outputWriter.println(token);
        }
    }
}
