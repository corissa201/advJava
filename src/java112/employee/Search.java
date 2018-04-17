package java112.employee;

import java.util.*;


/**
 *  This is a JavaBean class for the search
 *
 * @author       cEngel
 * @version     1.0
 */
public class Search {

    private String enteredSearchType;
    private String enteredSearchTerm;
    private ArrayList<String> databaseQueryResult;
    private boolean queryFoundEmployee;


    /**
     *  Constructor for the Search object
     */
    public Search() {

    }


    /**
     * Returns the value of enteredSearchType.
     * @return enteredSearchType A string that holds the entered search type.
     */
    public String getEnteredSearchType() {
        return enteredSearchType;
    }


    /**
     * Sets the value of enteredSearchType.
     * @param enteredSearchType The value to assign enteredSearchType.
     */
    public void setEnteredSearchType(String enteredSearchType) {
        this.enteredSearchType = enteredSearchType;
    }


    /**
     * Returns the value of enteredSearchTerm.
     * @return enteredSearchTerm A string that holds the entered search term.
     */
    public String getEnteredSearchTerm() {
        return enteredSearchTerm;
    }


    /**
     * Sets the value of enteredSearchTerm.
     * @param enteredSearchTerm The value to assign enteredSearchTerm.
     */
    public void setEnteredSearchTerm(String enteredSearchTerm) {
        this.enteredSearchTerm = enteredSearchTerm;
    }


    /**
     * Returns the value of databaseQueryResult.
     * @return databaseQueryResult An ArrayList that holds the results from the
     * database query.
     */
    public ArrayList<String> getDatabaseQueryResult() {
        return databaseQueryResult;
    }


    /**
     * Sets the value of databaseQueryResult.
     * @param databaseQueryResult The value to assign databaseQueryResult.
     */
    public void setDatabaseQueryResult(ArrayList<String> databaseQueryResult) {
        this.databaseQueryResult = databaseQueryResult;
    }


    /**
     * Returns the value of queryFoundEmployee.
     * @return queryFoundEmployee A boolean indicating whether or not the query
     * found any employees.
     */
    public boolean getQueryFoundEmployee() {
        return queryFoundEmployee;
    }


    /**
     * Sets the value of queryFoundEmployee.
     * @param queryFoundEmployee The value to assign queryFoundEmployee.
     */
    public void setQueryFoundEmployee(boolean queryFoundEmployee) {
        this.queryFoundEmployee = queryFoundEmployee;
    }


    /**
     * This method will add the employee object to the List of found Employee
     * objects.
     * @param employee A object of employee.
     */
    public void addFoundEmployee(Employee employee) {
        //databaseQueryResult.put(employee);
    }
}
