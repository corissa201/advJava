package java112.analyzer;

import java.io.*;
import java.util.*;

/**
 * @author Corissa Engel
 * class DistinctTokensAnalyzer,
 */

 //Class will create the report of all distinct tokens
public class DistinctTokensAnalyzer implements TokenAnalyzer{

    private Set<String> distinctTokens;

   /**
    * Constructor for DistinctTokensAnalyzer, zero parameter
    */
   public DistinctTokensAnalyzer() {
      distinctTokens = new TreeSet<>();
   }

   public Set<String> getDistinctTokens() {
      return distinctTokens;
   }

   public void processToken(String token){
      distinctTokens.add(token);
   }

   public void generateOutputFile(String inputFilePath, String outputFilePath){
      PrintWriter outputWriter = null;
         try {
            outputWriter = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));

            outputWriter.println("Sample output.");
         } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
         } catch (Exception exception) {
            exception.printStackTrace();
         } finally {
            if (outputWriter != null) {
               outputWriter.close();
            }
         }
    }
 }