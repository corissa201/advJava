package java112.project2;


import java.io.*;
import java.util.*;

import java112.utilities.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 * The first112Servlet will generate HTML output of my name and this course. It
 * will also contain a html image tag.
 *
 *@author       CEngel
 *@version      1.0
 */
@WebServlet(
name = "first112Servlet",
urlPatterns = {"/first"}
) public class First112Servlet extends HttpServlet implements PropertiesLoader {

    private Properties properties;


    /**
     * The init method loads the properties file path into the properties instance.
     *
     *@exception ServletException   If a servlet exception occurs.
     */
    public void init() throws ServletException {
        properties = loadProperties("/project2.properties");
    }


    /**
     * This method handles the HTTP GET requests and outputs the html formatted
     * information.
     *
     *@param  request                       the HttpServletRequest object
     *@param  response                      the HttpServletResponse object
     *@exception  ServletException          if there is a Servlet failure
     *@exception  IOException               if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");

        // set the response type before sending data
        PrintWriter out = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE>Corissa Engel</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>Advanced Java Spring 2018</h1>");
        out.print("<img src=\"images/first112Image.png\"/>");
        out.print("<p><a href=\"/java112\">Return to Home page</a></p>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }
}
