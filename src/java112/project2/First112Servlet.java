package java112.project2;

import java112.utilities.*;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 *  This is part of a lab and is the first servlet for the course.
 *
 *@author    CEngel
 */
@WebServlet(
name = "first112Servlet",
urlPatterns = {"/first"}
) public class First112Servlet extends HttpServlet implements PropertiesLoader {

    private Properties properties;

    public void init() throws ServletException {
        properties = loadProperties("/project2/properties");
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
        PrintWriter out = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE>Corissa Engel</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>Advanced Java Spring 2018</h1>");
        out.print("<p><a href=/java112/>Return to Home page</a></p>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }
}
