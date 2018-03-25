package java112.analyzer;


import java.io.*;
import java.util.*;
import java112.utilities.*;


/**
 * The FileAnalysis class is the main controller class for project 2. It
 * contains the main processing method, analyze, for the project. It will
 * implement the PropertiesLoader interface.
 *
 * @author     Corissa Engel
 * @version     2.0
 */
public class FileAnalysis implements PropertiesLoader {

    private static final int VALID_ARGUMENTS_COUNT = 2;
    private List<TokenAnalyzer> analyzers;


    /**
     * Constructor for FileAnalyzer class.
     */
    public FileAnalysis() {
    }


    /**
     * The analyze method will first checks that 1 argument has been entered by
     * the user. The second arguement is the properties file path which is
     * hardcoded in the runanalyzer program. It will then call the methods
     * createNewAnalyzerInstances, openInputFile and writeOutputFiles to run the
     * analyzer program.
     *
     * @param arguments This is the user entered argument.
     */
    public void analyze(String[] arguments) {
        if (arguments.length != VALID_ARGUMENTS_COUNT) {
            System.out.println("Please enter a file path");
            return;
        }

        String inputFilePath = arguments[0];
        String propertiesFilePath = arguments[1];

        createNewAnalyzerInstances(propertiesFilePath);
        openInputFile(inputFilePath);
        writeOutputFiles(inputFilePath);
    }


    /**
     * This method will instantiate the TokenAnalyzer classes to call the new
     * constructor with the Properties parameter
     *
     * @param propertiesFilePath The property file path for project 2.
     */
    private void createNewAnalyzerInstances(String propertiesFilePath) {

        analyzers = new ArrayList<>();

        Properties properties = loadProperties(propertiesFilePath);

        analyzers.add(new FileSummaryAnalyzer(properties));
        analyzers.add(new DistinctTokensAnalyzer(properties));
        analyzers.add(new DistinctTokenCountsAnalyzer(properties));
        analyzers.add(new LargestTokensAnalyzer(properties));
    }


    /**
     *  This method opens the input file for reading.
     *
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
     *
     * @param input The BufferedReader for the input file.
     * @throws IOException If an input exception occurs.
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
     * This method will pass the generated tokens to each Analyzer instance.
     *
     * @param tokenArray The token array created in the readInputFile method.
     */
    private void callProcessToken(String[] tokenArray) {
        for (String token : tokenArray) {
            if (token.isEmpty() || Character.isDigit(token.charAt(0))) {
                continue;
            }
            createProcessToken(token);
        }
    }

    /**
     * This method will loop through the analyzers and pass them each the list
     * of tokens.
     *
     * @param token The list of tokens from the input file.
     */
    private void createProcessToken(String token) {
        for (TokenAnalyzer analyzer : analyzers) {
            analyzer.processToken(token);
        }
    }


    /**
     * This method will generate the output files by calling the
     * generateOutputFile method for each Analyzer class.
     *
     * @param inputFilePath The file path to the input file.
     */
    private void writeOutputFiles(String inputFilePath) {
        for (TokenAnalyzer analyzer : analyzers) {
            analyzer.generateOutputFile(inputFilePath);
        }
    }
}
