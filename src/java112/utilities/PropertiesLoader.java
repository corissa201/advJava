package java112.utilities;


import java.io.*;
import java.util.*;


/**
 * @author Eric Knapp
 *
 */
public interface PropertiesLoader{

    default Properties loadProperties(String propertiesFilePath){
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return null;
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        return properties;
    }
}

