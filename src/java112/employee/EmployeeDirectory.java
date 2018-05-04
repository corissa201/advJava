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
    public Connection connection;

    /**
     * Constructor for EmployeeDirectory
     *
     * @param properties The properties file for project 4.
     */
    public EmployeeDirectory(Properties properties) {
        properties = properties;
    }


    public Connection getConnection() throws SQLException , ClassNotFoundException{
        Connection connection = null;

        try {
            Class.forName(properties.getProperty("driver"));

            connection = DriverManager.getConnection(properties.getProperty("url"));
        } catch (ClassNotFoundException classNotFound) {
            classNotFound.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return connection;
    }


    public void addNewEmployeeRecord(String firstName, String lastName,
    String socialSecurityNumber, String department, String roomNumber, String phoneNumber) throws SQLException, ClassNotFoundException{
        Statement statement = null;
        ResultSet resultSet = null;
        getConnection();

        // int rowsAffected = "";
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
            + "     ? ,"
            + "     ? ,"
            + "     ? ,"
            + "     ? ,"
            + "     ? ,"
            + "     ? ,"
            + " )";

            int rowsAffected = statement.executeUpdate(insertSql);
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


    public Search searchEmployeeDatabase(String enteredSearchType, String enteredSearchTerm) {
        Search search = null;

        return search;
    }
}
