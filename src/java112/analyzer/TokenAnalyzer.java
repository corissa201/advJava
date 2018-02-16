package java112.analyzer;


/**
 * @author Corissa Engel
 * class TokenAnalyzer
 */
public interface TokenAnalyzer{

    void processToken(String token);
    void generateOutputFile(String inputFilePath, String outputFilePath);
}

