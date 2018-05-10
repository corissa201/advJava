package java112.employee;


import java.io.*;
import java.sql.*;
import java.util.*;


/**
 * @author Corissa Engel
 * class EmployeeDirectory
 */
public class EmployeeDirectory {

    private Properties properties;


    /**
     * Empty constructor for EmployeeDirectory
     *
     */
    public EmployeeDirectory() {
    }


    /**
     * Constructor for EmployeeDirectory
     *
     * @param properties The properties file for project 4.
     */
    public EmployeeDirectory(Properties properties) {
        this();
        this.properties = properties;
    }


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


    private void searchFirstName(Search search) {

        String queryString = "SELECT emp_id, first_name, last_name, ssn, dept, room, phone"
        + " FROM employees " + "WHERE first_name like '"
        + search.getSearchTerm() + "%'";

        queryDatabase(queryString, search);
    }


    private void searchLastName(Search search) {

        String queryString = "SELECT emp_id, first_name, last_name, ssn, dept, room, phone"
        + " FROM employees " + "WHERE last_name like '"
        + search.getSearchTerm() + "%'";

        queryDatabase(queryString, search);
    }


    private void searchEmployeeId(Search search) {

        String employeeID = search.searchTerm;

        String queryString = "SELECT emp_id, first_name, last_name, ssn, dept, room, phone"
        + " FROM employees " + "WHERE emp_id = employeeID";

        queryDatabase(queryString, search);
    }


    private void queryDatabase(String queryString, Search search) {
        Statement statement = null;
        ResultSet resultSet = null;

        // String queryString = null;
        Connection connection = getConnection();
        try {

            statement = connection.createStatement();

            resultSet = statement.executeQuery(queryString);

            if (!resultSet.next()) {

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
