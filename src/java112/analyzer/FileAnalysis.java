package java112.analyzer;


import java.io.*;
import java.util.*;


/**
 * @author Corissa Engel
 * class FileAnalysis
 */
public class FileAnalysis {

    private static final int VALID_ARGUMENTS_COUNT = 1;
    private FileSummaryAnalyzer summaryAnalyzer;
    private DistinctTokensAnalyzer distinctAnalyzer;

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

        createNewAnalyzerInstances();
        openInputFile(inputFilePath);
        writeOutputFiles(inputFilePath);


    }


    public void openInputFile(String inputFilePath) {

        try (BufferedReader input = new BufferedReader(new FileReader(inputFilePath))
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

            callProcessToken(tokenArray);
        }
    }


    public void createNewAnalyzerInstances() {
        summaryAnalyzer = new FileSummaryAnalyzer();
        distinctAnalyzer = new DistinctTokensAnalyzer();

    }


    public void callProcessToken(String[] tokenArray) {
        for (String token : tokenArray) {
            if (token != null && !token.isEmpty() && !Character.isDigit(token.charAt(0))) {
                summaryAnalyzer.processToken(token);
                distinctAnalyzer.processToken(token);
            }
        }
    }


    public void writeOutputFiles(String inputFilePath) {
        summaryAnalyzer.generateOutputFile(inputFilePath, "output/summary.txt");
        distinctAnalyzer.generateOutputFile(inputFilePath, "output/distinct_token.txt");
    }
}

