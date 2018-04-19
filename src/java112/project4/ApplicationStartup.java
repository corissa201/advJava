package java112.project4;


import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 * The ApplicationStartup servlet will perform some initialization for the
 * project 4 web application.
 *
 *@author    Corissa Engel
 */
@WebServlet(
name = "applicationStartup",
urlPatterns = {"/project4-startup"},
loadOnStartup = 1
) public class ApplicationStartup extends HttpServlet {

    private Properties properties;


    /**
     * The init method loads the properties file path into the properties instance.
     *
     * @exception ServletException   If a servlet exception occurs.
     */
    public void init() throws ServletException {
        project4Properties = loadProperties("/project4.properties");
    }

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request               the HttpRequest
     *@param  response              the HttpResponse
     *@exception  ServletException  if there is a general servlet exception
     *@exception  IOException       if there is a general I/O exception
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    }
}
