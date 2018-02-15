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
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))
        ) {

            writer.println(writer());

        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

}

   public String writer() {
      String message = "Application: File Magic\nAuthor: Corissa Engel AdvJava-S18\nAuthor Email: cengel@madisoncollege.edu\nFile: /home/student/AgathaChristie.txt\nLast Modified Date: " + new Date() + "\nTotal Tokens:" + getTotalTokensCount();
      return message;
}

}