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

    private static final int MAXIMUM_STRING_LENGTH = 80;
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
        loadSearchFile();
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
     * This method will load a file of search tokens
     *
     *
     */
    public void loadSearchFile() {

        try (
            InputStream inputStream = this.getClass().getResourceAsStream(properties.getProperty("classpath.search.tokens"));
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader searchTokensReader = new BufferedReader(inputStreamReader)


        ) {
            readSearchTokens(searchTokensReader);
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    /**
     * This method will read the search tokens and parse them into a map.
     *
     * @param searchTokensReader
     */
    public void readSearchTokens(BufferedReader searchTokensReader) throws IOException {
        String inputLine = null;

        while (searchTokensReader.ready()) {
            inputLine = searchTokensReader.readLine().trim();
            if (inputLine.isEmpty()) {
                continue;
            }


            foundLocations.put(inputLine, new ArrayList<Integer>());
        }
        // System.out.println(foundLocations);
    }


    /**
     * This method implements the processToken method in the TokenAnalyzer
     * interface and checks if the search token is the same as the input token.
     *
     * @param token A list of all the tokens from the input file.
     */
    public void processToken(String token) {

        currentTokenLocation += 1;

        if (foundLocations.containsKey(token)) {
            foundLocations.get(token).add(currentTokenLocation);
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
     * This method loops throught the list of map values and creates a new
     * string. Then limits the width of the output and prints out the string.
     *
     * @param valueList The list of values from the found locations map.
     * @param outputWriter The PrintWriter open to the new file.
     */
    public void createLocationString(List<Integer> valueList, PrintWriter outputWriter) {
        String outputLine = "";

        for (Integer value : valueList) {
            //outputLine + value;

            if (outputLine.length() == MAXIMUM_STRING_LENGTH) {
                outputWriter.println(outputLine);
                outputLine + value;
            } else {
                outputLine += value;
            }
        }
        //outputWriter.println(outputLine);
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
            outputWriter.println(entry.getKey() + " =");
            createLocationString(entry.getValue(), outputWriter);
            outputWriter.println();
        }
    }
}
