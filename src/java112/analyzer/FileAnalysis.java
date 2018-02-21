package java112.analyzer;


import java.io.*;
import java.util.*;


/**
 * The main controller class for project 1
 *
 * @author     Corissa Engel
 * @created    Febuary 18, 2018
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

    /**
     * The analyze method will first checks that 1 argument have been entered by
     * the user. Then calls the methods createNewAnalyzerInstances, openInputFile
     * and writeOutputFiles.
     * @param arguments This is the user entered argument
     */
    private void analyze(String[] arguments) {

        if (arguments.length != VALID_ARGUMENTS_COUNT) {
            System.out.println("Please enter a file path");
            return;
        }


        String inputFilePath = arguments[0];

        createNewAnalyzerInstances();
        openInputFile(inputFilePath);
        writeOutputFiles(inputFilePath);
    }

    /**
     *  This method opens the input file for reading.
     * @param inputFilePath The file path to the input file.
    */
    private void openInputFile(String inputFilePath) {

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

    /**
     * This meathod will read through the input file and create a token array
     * for each line.
     * @param input The BufferedReader for the input file.
     */
    private void readInputFile(BufferedReader input) throws IOException {
        String inputLine = null;
        String[] tokenArray = null;

        while (input.ready()) {
            inputLine = input.readLine();
            tokenArray = inputLine.split("\\W");

            callProcessToken(tokenArray);
        }
    }

    /**
     *This method will instantiate both Analyzer class instance variables
     */
    private void createNewAnalyzerInstances() {
        summaryAnalyzer = new FileSummaryAnalyzer();
        distinctAnalyzer = new DistinctTokensAnalyzer();
    }

    /**
     * This method will pass the generated tokens to each Analyzer instance.
     * @param tokenArray The token array created in the readInputFile method
     */
    private void callProcessToken(String[] tokenArray) {
        for (String token : tokenArray) {
            if (!(token.isEmpty() || Character.isDigit(token.charAt(0)))) {
                summaryAnalyzer.processToken(token);
                distinctAnalyzer.processToken(token);
            }
        }
    }

    /**
     * This method will generate the output files by calling the
     * generateOutputFile method for each Analyzer class.
     * @param inputFilePath The file path to the input file.
     */
    private void writeOutputFiles(String inputFilePath) {
        summaryAnalyzer.generateOutputFile(inputFilePath, "output/summary.txt");
        distinctAnalyzer.generateOutputFile(inputFilePath, "output/distinct_token.txt");
    }
}
