package java112.employee;


import java.util.*;


/**
 * The Search class is a JavaBean that contains the application search
 * information.
 *
 * @author       Corissa Engel
 * @version     1.0
 *
 */
public class Search {

    private String searchType;
    private String searchTerm;
    private List<Employee> databaseQueryResult;
    private boolean queryFoundEmployee;


    /**
     *  Constructor for the Search object
     */
    public Search() {
        databaseQueryResult = new ArrayList<>();
    }


    /**
     * This method will add the employee object to the List of found Employee
     * objects and set the queryFoundEmployee to true.
     * @param employee A object of employee.
     */
    public void addFoundEmployee(Employee employee) {
        queryFoundEmployee = true;

        databaseQueryResult.add(employee);
    }


    /**
     * Returns the value of enteredSearchType.
     * @return searchType A string that holds the entered search type.
     */
    public String getSearchType() {
        return searchType;
    }


    /**
     * Sets the value of searchType.
     * @param searchType The value to assign searchType.
     */
    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }


    /**
     * Returns the value of searchTerm.
     * @return searchTerm A string that holds the entered search term.
     */
    public String getSearchTerm() {
        return searchTerm;
    }


    /**
     * Sets the value of searchTerm.
     * @param searchTerm The value to assign searchTerm.
     */
    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }


    /**
     * Returns the value of databaseQueryResult.
     * @return databaseQueryResult An ArrayList that holds the results from the
     * database query.
     */
    public List<Employee> getDatabaseQueryResult() {
        return databaseQueryResult;
    }


    /**
     * Sets the value of databaseQueryResult.
     * @param databaseQueryResult The value to assign databaseQueryResult.
     */
    public void setDatabaseQueryResult(ArrayList<Employee> databaseQueryResult) {
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


    public String toString() {
        return getSearchType();
    }
}
