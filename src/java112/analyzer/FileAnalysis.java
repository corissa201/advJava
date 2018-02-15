package java112.analyzer;

import java.io.*;
import java.util.*;

/**
 * @author Corissa Engel
 * class FileAnalysis
 */
public class FileAnalysis {
   private static final int VALID_ARGUMENTS_COUNT = 1;

      FileSummaryAnalyzer summaryAnalyzer = new FileSummaryAnalyzer();
      DistinctTokensAnalyzer distinctAnalyzer = new DistinctTokensAnalyzer();


   /**
     * Constructor for FileAnalyzer
    */
   public FileAnalysis() {

   }

   public void analyze(String[] arguments) {

      if (arguments.length != VALID_ARGUMENTS_COUNT) {
         System.out.println("Please enter a file path");
         return;
      }

      FileAnalysis fileAnalysis = new FileAnalysis();

      //fileAnalysis.createInstanceAnalyzerClasses();
      fileAnalysis.openInputFile(arguments[0]);
      //readInputFile();
      //fileAnalysis.callProcessToken();
      fileAnalysis.writeOutputFiles();
   }

   public void createInstanceAnalyzerClasses(){
      FileSummaryAnalyzer summaryAnalyzer = new FileSummaryAnalyzer();
      DistinctTokensAnalyzer distinctAnalyzer = new DistinctTokensAnalyzer();
      return;
   }

   public void openInputFile(String filePath){

        try (
            BufferedReader input = new BufferedReader(new FileReader(filePath))
            ) {
                readInputFile(input);

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

   public void readInputFile(BufferedReader input) throws IOException {
      String inputLine = null;
      String[] tokenArray = null;

      while (input.ready()) {
         inputLine = input.readLine();
         tokenArray = inputLine.split("\\W");
       }

       callProcessToken(tokenArray);
    }


   public void callProcessToken(String[] tokenArray){
      for (String token : tokenArray){
      summaryAnalyzer.processToken(token);
      distinctAnalyzer.processToken(token);
      }
   }


   public void writeOutputFiles(){
      summaryAnalyzer.generateOutputFile();
      distinctAnalyzer.generateOutputFile();
   }
}