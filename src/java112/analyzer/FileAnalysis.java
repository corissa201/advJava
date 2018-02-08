package java112.analyzer;

/**
 * @author Corissa Engel
 * class FileAnalysis
 */
public class FileAnalysis {
   //create a constant for the valid number of command-line arguments

   //instantiate an instance of the FileSummaryAnalyzer Analyzer class
   FileSummaryAnalyzer summaryAnalyzer = new FileSummaryAnalyzer();

   //instantiate an instance of the DistinctTokensAnalyzer Analyzer class
   DistinctTokensAnalyzer distinctAnalyzer = new DistinctTokensAnalyzer();

    /**
    * Constructor for FileAnalyzer
    */
    public FileAnalysis() {

    }

    public void analyze(String[] arguments) {

       //System.out.println("in FileAnalysis.analyze");

       // If 1 argument is entered the application will output a message to the
       //command line asking for the right input and then terminate the program
       if (arguments.length != 1) {
          System.out.println("Please enter one argument on the command line");
          return;
      }
      //Create an instance of each Analyzer class and assign them to their instance variables

      //Open the input file.

      //Loop through all the lines of the input file and generate individual tokens

      //Pass generated tokens to all Analyzer instances via the processToken() method

      //Call the generateOutputFile() method for each Analyzer class in a method named writeOutputFiles()
    }
}