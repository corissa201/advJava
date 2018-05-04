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
        properties = properties;
    }


    private Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName(properties.getProperty("driver"));

            connection = DriverManager.getConnection(properties.getProperty("url", "username", "password"));
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

        try {

            statement = connection.createStatement();

            String insertSql = "insert into employees ("
            + "    firstName,"
            + "     lastName,"
            + "     socialSecurityNumber,"
            + "     department,"
            + "     roomNumber,"
            + "     phoneNumber"
            + " ) values ("
            + "     '" + firstName + "' ,"
            + "     '" + lastName + "' ,"
            + "     '" + socialSecurityNumber + "' ,"
            + "     '" + department + "' ,"
            + "     '" + roomNumber + "' ,"
            + "     '" + phoneNumber + "' ,"
            + " )";

            statement.executeUpdate(insertSql);

        } catch (ClassNotFoundException classNotFound) {
            classNotFound.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
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


    public Search searchEmployeeDatabase(String searchTerm, String searchType) {
        Search search = new search();
        searchTerm = search.set(searchTerm);
        searchType = search.set(searchType);

        return search;
    }
}
