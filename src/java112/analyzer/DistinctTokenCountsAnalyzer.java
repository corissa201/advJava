package java112.analyzer;


import java.io.*;
import java.net.URI;
import java.util.*;


/**
 * The DistinctTokenCountsAnalyzer class will count the number of unique tokens.
 * The output file will contain a row for each  unique token and the number of
 * times that token occurred in the input file.
 *
 * @author      Corissa Engel
 * @version     2.0
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
     * Constructor with Properties parameter.
     *
     * @param properties The properties file for project 2.
     */
    public DistinctTokenCountsAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }


    /**
     * This method is the getter for the distinctTokensCounts.
     *
     * @return distinctTokensCount A treeMap with the key a string containing
     * unique tokens and the value a integer count of unique tokens from the
     * input file.
     */
    public Map<String, Integer> getDistinctTokenCounts() {
        return distinctTokenCounts;
    }


    /**
     * This method implements the processToken method in the TokenAnalyzer
     * interface and adds each token and token count to the distinctTokenCounts
     * treeMap.
     *
     * @param token A list of all the tokens read from the input file.
     */
    public void processToken(String token) {

        if (distinctTokenCounts.containsKey(token)) {
            Integer count = distinctTokenCounts.get(token);
            count++;
            distinctTokenCounts.put(token, count);
        } else {
            distinctTokenCounts.put(token, 1);
        }
    }


    /**
     * This method implements the generateOutputFile method in the TokenAnalyzer
     * interface and opens a PrintWriter to the file specified in the properties
     * file and calls the outputWriter method to print out each token.
     *
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
     * This method is called from the generateOutputFile method. It will loop
     * through the treeMap of distinctTokenCounts and write the token and count
     * to a new line.
     *
     * @param outputWriter The PrintWriter open to the new file.
     */
    private void outputWriterPrint(PrintWriter outputWriter) {
        for (Map.Entry <String, Integer> entry : distinctTokenCounts.entrySet()) {
            outputWriter.println(entry.getKey() + "\t" + entry.getValue());
        }
    }
}
