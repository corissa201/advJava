package java112.analyzer;


import java.io.*;
import java.net.URI;
import java.util.*;


/**
 * The TokenLocationSearchAnalyzer class will determine where search
 * tokens are in the input file.
 *
 * @author      Corissa Engel
 * @version     1.0
 */
public class TokenLocationSearchAnalyzer implements TokenAnalyzer {

    private Map<String, List <Integer>> foundLocations;
    private Properties properties;
    private int currentTokenLocation;


    /**
     * Empty constructor for the TokenLocationSearchAnalyzer class.
     */
    public TokenLocationSearchAnalyzer() {
        foundLocations = new TreeMap<>();
    }


    /**
     * Constructor with one Properties parameter
     *
     * @param properties The properties file for project 3.
     */
    public TokenLocationSearchAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }


    /**
     * This method is the getter for the foundLocations.
     *
     * @return foundLocations The map of search tokens and location of where
     * they occur in the input file.
     */
    public Map<String, List <Integer>> getFoundLocations() {
        return foundLocations;
    }


    /**
     *This method will load a file of search tokens, parse the file and store
     * all the them in a Map.
     *
     *
     */
    public void loadSearchFile() {
    }


    /**
     * This method implements the processToken method in the TokenAnalyzer
     * interface and checks if the search token is the same as the input token.
     *
     * @param token A list of all the tokens from the input file.
     */
    public void processToken(String token) {
        currentTokenLocation = 1;

        if (foundLocations.getValue() == token) {
            foundLocations.get.add(token, currentTokenLocation);
        } else {
            currentTokenLocation++;
        }
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
        + properties.getProperty("output.file.token.search.locations");

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
     * This method will loop through and print out each search token and where
     * each search token occured. Output line must come as close to 80 column
     * width as possible.
     *
     * @param outputWriter The PrintWriter open to the new file.
     */
    private void outputWriterPrint(PrintWriter outputWriter) {
        for (Map.Entry <String, List <Integer>> entry : foundLocations.entrySet()) {
            outputWriter.println(entry.getKey() + "\t" + entry.getValue());
        }
    }
}
