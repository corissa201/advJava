package java112.analyzer;

/**
 * @author Corissa Engel
 * class DistinctTokensAnalyzer,
 */

 //Class will create the report of all distinct tokens and implement the TokenAnalyzer interface
public class DistinctTokensAnalyzer{
   /**
    * Constructor for DistinctTokensAnalyzer, zero parameter
    */
   public DistinctTokensAnalyzer() {
      //create an instance of a TreeSet and assigns it to the distinctTokens variable.
      distinctTokens TreeSet = new distinctTokens();
   }

   private Set<String> distinctTokens;

   public Set<String> getDistinctTokens() {
      return distinctTokens;
   }

}