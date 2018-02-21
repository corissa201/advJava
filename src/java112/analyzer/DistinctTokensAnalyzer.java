package java112.analyzer;


import java.io.*;
import java.util.*;


/**
 * DistinctTokenAnalyzer class will create the report of all distinct tokens
 * @author      Corissa Engel
 * @version     1.1
 */
public class DistinctTokensAnalyzer implements TokenAnalyzer {

    private Set<String> distinctTokens;


    /**
     * Constructor for DistinctTokensAnalyzer that will create an instance of a
     * TreeSet and assigns it to the distinctTokens variable
     */
    public DistinctTokensAnalyzer() {
        distinctTokens = new TreeSet<>();
    }


    /**
     * Gets the distinctTokens
     *
     * @return distinctTokens
     */
    private Set<String> getDistinctTokens() {
        return distinctTokens;
    }


    public void processToken(String token) {
        distinctTokens.add(token);
    }


    public void generateOutputFile(String inputFilePath, String outputFilePath) {

        try (PrintWriter outputWriter = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))
        ) {
            outputWriterPrint(outputWriter);
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    /**
     * This method will through and print out each token to a new line
     * @param outputWriter The PrintWriter open to the new file.
     */
    private void outputWriterPrint(PrintWriter outputWriter) {
        for (String token : distinctTokens) {
            outputWriter.println(token);
        }
    }
}
