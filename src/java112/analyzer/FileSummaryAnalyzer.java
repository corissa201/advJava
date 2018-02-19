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

        try (PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))
        ) {
            writer(output, inputFilePath);
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    public void writer(PrintWriter writer, String inputFilePath) {
        File file  = new File(inputFilePath);
        String path = file.getAbsolutePath();
        writer.println("Application: File Magic");
        writer.println("Author: Corissa Engel AdvJava-S18");
        writer.println("Author Email: cengel@madisoncollege.edu");
        writer.println("File: "+ path);
        writer.println("Date of analysis:  "+ new Date());
        writer.println("Last Modified Date: "+ new Date());
        writer.println("File size: ");
        writer.println("File URI: file:");
        writer.println("Total Tokens: "+ getTotalTokensCount());
    }
}

