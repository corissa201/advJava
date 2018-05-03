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


    // private Connection connection;

    /**
     * Constructor for EmployeeDirectory
     *
     * @param properties The properties file for project 4.
     */
    public EmployeeDirectory(Properties properties) {
        properties = properties;
    }


    private Connection establishDatabaseConnection() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(properties.getProperty("driver"));

            connection = DriverManager.getConnection(properties.getProperty("url"));

            statement = connection.createStatement();

            String insertSql = "insert into employees ("
            + "    first_name,"
            + "     last_name,"
            + "     ssn,"
            + "     dept,"
            + "     room,"
            + "     phone"
            + " ) values ("
            + "     ? ,"
            + "     ? ,"
            + "     ? ,"
            + "     ? ,"
            + "     ? ,"
            + "     ? ,"
            + " )";

            int rowsAffected = statement.executeUpdate(insertSql);

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

        return connection;
    }


    public void addNewEmployeeRecord() {

        establishDatabaseConnection();
    }


    public Search searchEmployeeDatabase(String enteredSearchType, String enteredSearchTerm) {
        Search search = null;

        return search;
    }
}
