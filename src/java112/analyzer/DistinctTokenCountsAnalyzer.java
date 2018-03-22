package java112.analyzer;


import java.io.*;
import java.net.URI;
import java.util.*;


/**
 * The DistinctTokenCountsAnalyzer class will count the number of unique tokens.
 * The output file will contain a row for each unique token. Each row will have
 * the token, a tab character, and the number of times that token occurred in
 * the file.
 *
 * @author      Corissa Engel
 * @version     1.0
 */
public class DistinctTokenCountsAnalyzer implements TokenAnalyzer {

    private Map<String, Integer> distinctTokenCounts;
    private Properties properties;


    /**
     * Empty constructor for the DistinctTokenCountsAnalyzer class.
     */
    public DistinctTokenCountsAnalyzer() {
        distinctTokenCounts = new TreeMap<>();
    }


    /**
     * Constructor with one Properties parameter
     */
    public DistinctTokenCountsAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }


    /**
     * This method is the getter for the distinctTokensCounts.
     *
     * @return distinctTokensCount A string and count of unique tokens from the
     * input file.
     */
    public Map<String, Integer> getDistinctTokenCounts() {
        return distinctTokenCounts;
    }


    /**
     * This method is used to process the token for the DistinctTokenCountsAnalyzer class.
     * @param token A list of all the tokens read from the file.
     */
    public void processToken(String token) {

        distinctTokenCounts.put(token, new Integer);
    }


    /**
     * This method is used to generate the output files for all Analyzer classes.
     * @param inputFilePath The file path to the input file.
     */
    public void generateOutputFile(String inputFilePath) {

        String outputFilePath = properties.getProperty("output.directory")
        + properties.getProperty("output.file.distinct.counts");

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
        for (Map.Entry <String, Integer> entry : distinctTokenCounts.entrySet()) {
            outputWriter.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
