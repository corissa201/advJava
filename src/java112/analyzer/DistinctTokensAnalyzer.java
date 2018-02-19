package java112.analyzer;


import java.io.*;
import java.util.*;


/**
 * @author Corissa Engel
 * class DistinctTokensAnalyzer,
 */
public class DistinctTokensAnalyzer implements TokenAnalyzer {

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

    public void outputWriterPrint(PrintWriter outputWriter){
        for (String token : distinctTokens) {
                outputWriter.println(token);
            }
    }
}
