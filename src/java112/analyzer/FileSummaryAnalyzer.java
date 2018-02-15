package java112.analyzer;

import java.io.*;
import java.util.*;

/**
 * @author Corissa Engel
 * class FileSummaryAnalyzer
 */

 //Class will create summary report and implement the TokenAnalyzer interface
public class FileSummaryAnalyzer implements TokenAnalyzer{

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

    public void processToken(String token){
       totalTokensCount += 1;
    }

    public void generateOutputFile(String inputFilePath, String outputFilePath){

         try (
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(inputFilePath)))
        ) {

            writer.println();

        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

}

   public String writer() {
      String message = "testing";
      return message;
}

}