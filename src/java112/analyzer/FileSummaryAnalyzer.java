package java112.analyzer;


import java.io.*;
import java.net.URI;
import java.util.*;


/**
 * The FileSummaryAnalyzer class will create the summary report.
 *
 * @author      Corissa Engel
 * @version     2.0
 */
public class FileSummaryAnalyzer implements TokenAnalyzer {

    private int totalTokensCount;
    private Properties properties;


    /**
     * Empty constructor for the FileSummaryAnalyzer class.
     */
    public FileSummaryAnalyzer() {
    }


    /**
     * Constructor with one Properties parameter
     *
     * @param properties The properties file for project 2.
     */
    public FileSummaryAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }


    /**
     * The getter for the totalTokensCounts.
     *
     * @return totalTokensCount The total count of all tokens.
     */
    public int getTotalTokensCount() {
        return totalTokensCount;
    }


    /**
     * This method implements the processToken method in the TokenAnalyzer
     * interface and increments the value of totalTokensCount by 1 for each token.
     *
     * @param token A list of all the tokens within the file.
     */
    public void processToken(String token) {
        totalTokensCount += 1;
    }


    /**
     * This method implements the generateOutputFile method in the TokenAnalyzer
     * interface and opens a PrintWriter to the specified file name. It then
     * calls the writer method to create the summary report.
     *
     * @param inputFilePath The file path of the input file.
     */
    public void generateOutputFile(String inputFilePath) {

        String outputFilePath = properties.getProperty("output.directory")
        + properties.getProperty("output.file.summary");

        try (PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))
        ) {
            writer(output, inputFilePath);
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    /**
     * This method with create the information that will go into the summary report.
     *
     * @param writer  The PrinterWiter open to a new file.
     * @param inputFilePath That file path to the input file.
     */
    private void writer(PrintWriter writer, String inputFilePath) {
        File file = new File(inputFilePath);

        String path = file.getAbsolutePath();
        Date modifiedDate = new Date(file.lastModified());
        long size = file.length();
        URI uri = file.toURI();

        // String applicationName = properties.getProperty("application.name");
        writer.println("Application: " + properties.getProperty("application.name"));
        writer.println("Author: " + properties.getProperty("author"));
        writer.println("Author Email: " + properties.getProperty("author.email.address"));
        writer.println("File: " + file);
        writer.println("Date of analysis:  " + new Date());
        writer.println("Last Modified Date: " + modifiedDate);
        writer.println("File size: " + size);
        writer.println("File URI: " + uri);
        writer.println("Total Tokens: " + getTotalTokensCount());
    }
}
