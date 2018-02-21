package java112.analyzer;


import java.io.*;
import java.net.URI;
import java.util.*;


/**
 * FileSummaryAnalyzer will create the summary report
 *
 * @author      Corissa Engel
 * @version     1.1
 */
public class FileSummaryAnalyzer implements TokenAnalyzer {

    private int totalTokensCount;


    /**
     * Constructor for FileSummaryAnalyzer
     */
    public FileSummaryAnalyzer() {
    }


    /**
     * Gets the totalTokensCounts
     *
     * @return totalTokensCount The total count of all tokens
     */
    public int getTotalTokensCount() {
        return totalTokensCount;
    }


    public void processToken(String token) {
        totalTokensCount += 1;
    }


    public void generateOutputFile(String inputFilePath, String outputFilePath) {

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
     * This method with create the information that will go into the summary report
     * @param writer  The PrinterWiter open to a new file
     * @param inputFilePath That file path to the input file.
     */
    private void writer(PrintWriter writer, String inputFilePath) {
        File file = new File(inputFilePath);

        String path = file.getAbsolutePath();
        Date modifiedDate = new Date(file.lastModified());
        long size = file.length();
        URI uri = file.toURI();

        writer.println("Application: Counting Agatha");
        writer.println("Author: Corissa Engel AdvJava-S18");
        writer.println("Author Email: cengel@madisoncollege.edu");
        writer.println("File: " + path);
        writer.println("Date of analysis:  " + new Date());
        writer.println("Last Modified Date: " + modifiedDate);
        writer.println("File size: " + size);
        writer.println("File URI: " + uri);
        writer.println("Total Tokens: " + getTotalTokensCount());
    }
}
