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

public class LargestTokensAnalyzer{
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