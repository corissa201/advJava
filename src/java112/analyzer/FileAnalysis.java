package java112.analyzer;

import java.io.*;
import java.util.*;

/**
 * @author Corissa Engel
 * class FileAnalysis
 */
public class FileAnalysis {
   private static final int VALID_ARGUMENTS_COUNT = 1;


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

      createInstanceAnalyzerClasses();
      openInputFile(arguments[0]);
      //readInputFile();
      callProcessToken();
      writeOutputFiles()
   }

   public void createInstanceAnalyzerClasses(){
      FileSummaryAnalyzer summaryAnalyzer = new FileSummaryAnalyzer();
      DistinctTokensAnalyzer distinctAnalyzer = new DistinctTokensAnalyzer();
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
    }


   public void callProcessToken(){

   }


   public void writeOutputFiles(){
      createInstanceAnalyzerClasses()
      summaryAnalyzer.generateOutputFiles();
      distinctAnalyzer.generateOutputFiles();
   }
}