package java112.analyzer;

/**
 * @author Corissa Engel
 * class FileAnalysis
 */
public class FileAnalysis {
   //create a constant for the valid number of command-line arguments
   private static final int VALID_ARGUMENTS_COUNT = 1;


   /**
     * Constructor for FileAnalyzer
    */
   public FileAnalysis() {

   }

   public void analyze(String[] arguments) {
      // If 1 argument is entered the application will output a message to the
      //command line asking for the right input and then terminate the program
      if (arguments.length != 1) {
         System.out.println("Please enter one argument on the command line");
         return;
      }

      //Call method that will create an instance of each Analyzer class and assign them to their instance variables
      createInstanceAnalyzerClasses();
      //Call method that will open the input file.
      openFile();
      //Call method that will loop through all the lines of the input file and generate individual tokens
      loopThroughFile();
      //Call method that will pass generated tokens to all Analyzer instances via the processToken() method

      //Call method that will call the generateOutputFile() method for each Analyzer class in a method named writeOutputFiles()
   }

   //Create method that will create an instance of each Analyzer class and assign them to their instance variables
   public void createInstanceAnalyzerClasses(){
      FileSummaryAnalyzer summaryAnalyzer = new FileSummaryAnalyzer();
      DistinctTokensAnalyzer distinctAnalyzer = new DistinctTokensAnalyzer();
   }

   //Create method to open the inputfile
   public void openFile(){
      try (BufferedReader input = new BufferedReader(new FileReader("AgathaChristie.txt")))

      catch (FileNotFoundException fileNotFoundException) {
         fileNotFoundException.printStackTrace();
      } catch (IOException inputOutputException) {
         inputOutputException.printStackTrace();
      } catch (Exception exception) {
         exception.printStackTrace();
      }
   }

   //Create method to loop through all the lines of the input file and generate individual tokens
   public void loopThroughFile(){
      String line = null;

      while (input.ready()) {
         line = input.readLine();
      }
   }
   //Create method to Pass generated tokens to all Analyzer instances via the processToken() method    //Create method to Call the generateOutputFile() method for each Analyzer class in a method named generateOutputFiles()
}