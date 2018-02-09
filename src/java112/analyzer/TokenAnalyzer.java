package java112.analyzer;

/**
 * @author Corissa Engel
 * class TokenAnalyzer
 */
//needs to be implemented by any class that performs an analysis
public interface TokenAnalyzer {

   void processToken(String token);
   void generateOutputFile(String inputFilePath, String outputFilePath);

}