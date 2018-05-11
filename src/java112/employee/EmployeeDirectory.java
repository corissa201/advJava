package java112.employee;


import java.io.*;
import java.sql.*;
import java.util.*;


/**
 * The EmployeeDirectory class will complete the tasks of database connection.
 *
 * @author Corissa Engel
 * @version 1.0
 */
public class EmployeeDirectory {

    private Properties properties;


    /**
     * Empty constructor for the EmployeeDirectory class.
     *
     */
    public EmployeeDirectory() {
    }


    /**
     * Constructor for the EmployeeDirectory class.
     *
     * @param properties The properties file for project 4.
     */
    public EmployeeDirectory(Properties properties) {
        this();
        this.properties = properties;
    }

    /**
     * The getConnection method will establish a connection to the database.
     *
     * @return connection The database connection.
     */
    private Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName(properties.getProperty("driver"));

            connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));

        } catch (ClassNotFoundException classNotFound) {
            classNotFound.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return connection;
    }

    /**
     * The addNewEmployeeRecord method will add a new record to the Employee
     * table in the database.
     *
     * @param firstName             The new employees first name.
     * @param lastName              The new employees last name.
     * @param socialSecurityNumber  The new employees social security number.
     * @param department            The new employees department.
     * @param roomNumber            The new employees room number.
     * @param phoneNumber           The new employees phone number.
     *
     * @return message              The message verifying a record was added to the table.
     */
    public String addNewEmployeeRecord(String firstName, String lastName,
    String socialSecurityNumber, String department, String roomNumber, String phoneNumber) {
        Statement statement = null;
        ResultSet resultSet = null;

        Connection connection = getConnection();

        String message = null;

        try {
            statement = connection.createStatement();

            String insertSql = "INSERT INTO employees (first_name, last_name, ssn, dept, room, phone)"
            + " VALUES ('" + firstName + "' ,'" + lastName + "' ,'" + socialSecurityNumber + "' ,'" + department + "' ,'" + roomNumber + "' ,'" + phoneNumber + "')";

            statement.executeUpdate(insertSql);

            message = firstName + " has been added as a new employee";

        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                if (statement != null) {
                    statement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return message;
    }

    /**
     * The searchEmployeeDatabase will call a method determined by the search type
     * and search the database.
     *
     * @param searchTerm    The term used for searching the database.
     * @param searchType    The search term type used to search the database.
     *
     * @return search       The search object.
     */
    public Search searchEmployeeDatabase(String searchTerm, String searchType) {
        Search search = new Search();

        search.setSearchTerm(searchTerm);
        search.setSearchType(searchType);

        if (search.getSearchType().equals("firstName")) {
            searchFirstName(search);

        } else if (search.getSearchType().equals("lastName")) {
            searchLastName(search);

        } else if (search.getSearchType().equals("employeeId")){
            searchEmployeeId(search);
        }

        return search;
    }

    /**
     * The searchFirstName method is called from the searchEmployeeDatabase method
     * and will search the database using the searchTerm.
     *
     * @param search    The search object.
     *
     */
    private void searchFirstName(Search search) {

        String queryString = "SELECT emp_id, first_name, last_name, ssn, dept, room, phone"
        + " FROM employees " + "WHERE first_name like '"
        + search.getSearchTerm() + "%'";

        queryDatabase(queryString, search);
    }

    /**
     * The searchLastName method is called from the searchEmployeeDatabase method
     * and will search the database using the searchTerm.
     *
     * @param search    The search object.
     *
     */
    private void searchLastName(Search search) {

        String employeeIDQueryString = search.getSearchTerm();

        String queryString = "SELECT * FROM employees WHERE last_name like '" + employeeIDQueryString + "%'";

        queryDatabase(queryString, search);
    }

    /**
     * The searchEmployeeId method is called from the searchEmployeeDatabase method
     * and will search the database using the searchTerm.
     *
     * @param search    The search object.
     *
     */
    private void searchEmployeeId(Search search) {

        int employeeID = Integer.parseInt(search.getSearchTerm());

        String queryString = "SELECT * FROM employees WHERE emp_id = '" + employeeID + "'";

        queryDatabase(queryString, search);
    }

    /**
     * The queryDatabase method will connect and query the database. Then create
     * a new employee with the resultSet.
     *
     * @param queryString    The search object.
     * @param search         The search object.
     *
     */
    private void queryDatabase(String queryString, Search search) {
        Statement statement = null;
        ResultSet resultSet = null;

        Connection connection = getConnection();
        try {

            statement = connection.createStatement();

            resultSet = statement.executeQuery(queryString);

            if (resultSet.equals(null)) {
                search.setQueryFoundEmployee(false);

            } else {
                while (resultSet.next()) {
                    Employee employee = new Employee();

                    String employeeId = resultSet.getString("emp_id");
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    String socialSecurityNumber = resultSet.getString("ssn");
                    String department = resultSet.getString("dept");
                    String roomNumber = resultSet.getString("room");
                    String phoneNumber = resultSet.getString("phone");

                    employee.setEmployeeId(employeeId);
                    employee.setFirstName(firstName);
                    employee.setLastName(lastName);
                    employee.setSocialSecurityNumber(socialSecurityNumber);
                    employee.setDepartment(department);
                    employee.setRoomNumber(roomNumber);
                    employee.setPhoneNumber(phoneNumber);
                    search.addFoundEmployee(employee);
                }
            }
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                if (statement != null) {
                    statement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}
