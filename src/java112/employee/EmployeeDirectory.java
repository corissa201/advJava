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

        // searchTerm = search.set(searchTerm);
        // searchType = search.set(searchType);
        return search;
    }
}
