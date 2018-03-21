package java112.project2;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.utilities.*;

/**
 *  This is part of a lab and is the first servlet for the course.
 *
 *@author    CEngel
 */
@WebServlet(
    name = "propertiesServlet",
    urlPatterns = { "/properties" }
)
public class Project2PropertiesServlet extends HttpServlet implements PropertiesLoader {

    private Properties properties;

    public void init() throws ServletException {

    properties = loadProperties("./project2/properties");

}

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        // set the response type before sending data
        PrintWriter  out  = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE>This is the Project2 properties servlet</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>Table goes here</h1>");
        out.print("<p><a href="/java112">Return to Home page</a></p>")

        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }

}

