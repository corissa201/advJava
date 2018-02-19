package java112.analyzer;


import java.io.*;
import java.util.*;


/**
 * @author Corissa Engel
 * class FileSummaryAnalyzer
 */
public class FileSummaryAnalyzer implements TokenAnalyzer {

    private int totalTokensCount;


    /**
     * Constructor for FileSummaryAnalyzer
     */
    public FileSummaryAnalyzer() {
    }


    /**
     *
     */
    public int getTotalTokensCount() {
        return totalTokensCount;
    }


    public void processToken(String token) {

            totalTokensCount += 1;

    }


    public void generateOutputFile(String inputFilePath, String outputFilePath) {

        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))
        ) {

            writer.println(writer());
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    public String writer() {
        String message = "Application: File Magic\n"
        + "Author: Corissa Engel AdvJava-S18\n"
        + "Author Email: cengel@madisoncollege.edu\n"
        + "File: n"
        + "Date of analysis: " + new Date() + "\n"
        + "Last Modified Date: " + new Date() + "\n"
        + "File size: \n"
        + "File URI: file:\n"
        + "Total Tokens:" + getTotalTokensCount();
        return message;
    }
}

