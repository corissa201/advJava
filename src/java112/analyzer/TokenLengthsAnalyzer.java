package java112.analyzer;


import java.io.*;
import java.lang.*;
import java.net.URI;
import java.util.*;


/**
 * The TokenLengthsAnalyzer class will determine the length distribution of the
 * tokens in the input file
 *
 * @author      Corissa Engel
 * @version     1.0
 */
public class TokenLengthsAnalyzer implements TokenAnalyzer {

    private static final double MAXIMUM_COLUMN_LENGTH = 77.0;
    private Map<Integer, Integer> tokenLengths;
    private Properties properties;


    /**
     * Empty constructor for the TokenLengthsAnalyzer class.
     */
    public TokenLengthsAnalyzer() {
        tokenLengths = new TreeMap<>();
    }


    /**
     * Constructor with one Properties parameter
     *
     * @param properties The properties file for project 3.
     */
    public TokenLengthsAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }


    /**
     * This method is the getter for the tokenLengths.
     *
     * @return tokenLengths the map of lengths and number of tokens from the input file.
     * The length of each token is the map key.
     * The value of the Map will hold the number of tokens with the key’s length.
     */
    public Map<Integer, Integer> getTokenLengths() {
        return tokenLengths;
    }


    /**
     * This method implements the processToken method in the TokenAnalyzer
     * interface and adds each unique token to the tokenLengths map.
     *
     * @param token A list of all the tokens from the input file.
     */
    public void processToken(String token) {

        Integer length = token.length();

        if (tokenLengths.containsKey(length)) {
            Integer newLength = (tokenLengths.get(length) + 1);
            tokenLengths.replace(length, newLength);
        } else {
            tokenLengths.put(length, 1);
        }
    }


    /**
     * This method will convert the value to stars
     *
     * @param number The current map value.
     * @return builder.toString()
     */
    public String convertToStars(Integer number) {

        int maxValue = Collections.max(tokenLengths.values());

        double keyValue = maxValue / MAXIMUM_COLUMN_LENGTH;

        StringBuilder builder = new StringBuilder();
        double starsNumber = number / keyValue;

        for (int index = 0; index < starsNumber; index++) {
            builder.append('*');
        }
        return builder.toString();
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
        + properties.getProperty("output.file.token.lengths");

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
     * This method is called from the outputWriterPrint. It will loop through
     * the mapvalues an convert them to stars.
     *
     * @param outputWriter The PrinterWriter open to the new file.
     */
    public void starConverterOutput(PrintWriter outputWriter) {
        for (Map.Entry <Integer, Integer> entry : tokenLengths.entrySet()) {
            if (entry.getKey() < 10) {
                outputWriter.println(entry.getKey() + "  " + convertToStars(entry.getValue()));
            } else {
                outputWriter.println(entry.getKey() + " " + convertToStars(entry.getValue()));
            }
        }
    }


    /**
     * This method will loop through and print out each token to a new line once
     * for the listing of sizes and number of tokens then again for the  histogram.
     *
     * @param outputWriter The PrintWriter open to the new file.
     */
    private void outputWriterPrint(PrintWriter outputWriter) {

        for (Map.Entry <Integer, Integer> entry : tokenLengths.entrySet()) {
            outputWriter.println(entry.getKey() + "\t" + entry.getValue());
        }
        outputWriter.println();
        outputWriter.println();

        starConverterOutput(outputWriter);
        // outputWriter.println("Key= " + keyValue);
    }
}
