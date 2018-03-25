package java112.project2;

import java112.utilities.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 * The Project2PropertiesServlet will output the keys and values from the
 * propeties file in a HTML formatted table.
 *
 *@author       CEngel
 *@version      1.0
 */
@WebServlet(
name = "propertiesServlet",
urlPatterns = "/properties"
) public class Project2PropertiesServlet extends HttpServlet implements PropertiesLoader {

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
     * The doGet method handles HTTP GET requests and loops through the properties
     * file and outputs each element in a html table row.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                  the HttpServletResponse object
     *@exception  ServletException      if there is a Servlet failure
     *@exception  IOException           if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");

        Enumeration e = properties.propertyNames();

        // set the response type before sending data
        PrintWriter out = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE>PropertiesServlet</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>This is the Project2 properties servlet</h1>");
        out.print("<table border=1>");
        out.print("<th>Property</th>");
        out.print("<th>Value</th>");

        while (e.hasMoreElements()) {
            String key = (String)e.nextElement();
            out.print("<tr>");
            out.print("<td>");
            out.print(key);
            out.print("</td>");
            out.print("<td>");
            out.print(properties.getProperty(key));
            out.print("</td>");
            out.print("</tr>");
        }

        out.print("</tr>");
        out.print("</table>");
        out.print("<p><a href=\"/java112/\">Return to Home page</a></p>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }
}
