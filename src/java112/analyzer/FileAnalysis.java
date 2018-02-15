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
       String inputFilePath = arguments[0];
       String outputFilePath = arguments[1];

      FileAnalysis fileAnalysis = new FileAnalysis();

      //fileAnalysis.createInstanceAnalyzerClasses();
      fileAnalysis.openInputFile(inputFilePath);
      //readInputFile();
      //fileAnalysis.callProcessToken();
      fileAnalysis.writeOutputFiles(inputFilePath, outputFilePath);
   }

   public void createInstanceAnalyzerClasses(){
      FileSummaryAnalyzer summaryAnalyzer = new FileSummaryAnalyzer();
      DistinctTokensAnalyzer distinctAnalyzer = new DistinctTokensAnalyzer();
      return;
   }

   public void openInputFile(String inputFilePath){

        try (
            BufferedReader input = new BufferedReader(new FileReader(inputFilePath))
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


   public void writeOutputFiles(String inputFilePath, String outputFilePath){
      summaryAnalyzer.generateOutputFile(inputFilePath, outputFilePath);
      distinctAnalyzer.generateOutputFile(inputFilePath, outputFilePath);
   }
}