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

public class DistinctTokenCountsAnalyzer{
    private Properties properties;
    private Map<String, Integer> distinctTokenCounts;

    public Map<String, Integer> getDistinctTokenCounts() {
        return distinctTokenCounts;
    }

    /**
     * Empty constructor for the DistinctTokenCountsAnalyzer class.
     */
    public DistinctTokenCountsAnalyzer() {

    }

    /**
     * Constructor with one Properties parameter
     */
    public DistinctTokenCountsAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }

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