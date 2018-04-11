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

    private Map<String, List<Integer>> foundLocations;
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
     * @return foundLocations
     */
    public Map<String, List<Integer>> getFoundLocations() {
        return foundLocations;
    }




        /**
     *  This method opens the input file for reading.
     *
     * @param inputFilePath The file path to the input file.
     */
    private void openSearchFile(String inputFilePath) {
        String filePath = properties.getProperty("class.search.tokens");
        try (BufferedReader input = new BufferedReader(new FileReader(filePath))
        ) {
            readSearchFile(input);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    /**
     * This meathod will read through the input file and create a token array
     * for each line.
     *
     * @param input The BufferedReader for the input file.
     * @throws IOException If an input exception occurs.
     */
    private void readSearchFile(BufferedReader input) throws IOException {
        String inputLine = null;
        foundLoc;

        while (input.ready()) {
            inputLine = input.readLine();
            tokenArray = inputLine.split("\\W");


      foundLocations.put(tokenArray, "");
    }
    }




    /**
     * This method implements the processToken method in the TokenAnalyzer
     * interface and ***
     *
     * @param token A list of all the tokens from the input file.
     */
    public void processToken(String token) {

        currentTokenLocation++;
        if (foundLocations.getValue() = token){
        foundLocations.get.add(token, currentTokenLocation);
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
     * This method will loop through and print out each token to a new line.
     *
     * @param outputWriter The PrintWriter open to the new file.
     */
    private void outputWriterPrint(PrintWriter outputWriter) {
        for (Map.Entry <String, List<Integer>> entry : foundLocations.entrySet()) {
            outputWriter.println(entry.getKey() + "\t" + entry.getValue());
        }
    }
}
