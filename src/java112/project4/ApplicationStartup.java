package java112.project4;


import java.io.*;
import java.util.*;

import java112.employee.*;
import java112.utilities.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 * The ApplicationStartup servlet will perform some initialization for the
 * project 4 web application.
 *
 * @author    Corissa Engel
 * @version 1.0
 *
 */
@WebServlet(
name = "applicationStartup",
urlPatterns = {"/project4-startup"},
loadOnStartup = 1
)
public class ApplicationStartup extends HttpServlet implements PropertiesLoader {

    /**
     * The init method will load the properties file path into the
     * properties instance.
     *
     * @exception ServletException   If a servlet exception occurs.
     */
    public void init() throws ServletException {

        Properties properties = loadProperties("/project4.properties");

        ServletContext context = getServletContext();

        context.setAttribute("project4Properties", properties);

        EmployeeDirectory directory = new EmployeeDirectory(properties);

        context.setAttribute("project4Directory", directory);
    }
}