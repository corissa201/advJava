package java112.project2;


import java.io.*;
import java.util.*;

import java112.utilities.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 *  This is part of a lab and is the first servlet for the course.
 *
 *@author    CEngel
 */
@WebServlet(
name = "propertiesServlet",
urlPatterns = "/properties"
) public class Project2PropertiesServlet extends HttpServlet implements PropertiesLoader {

    private Properties properties;


    public void init() throws ServletException {

        properties = loadProperties("/project2.properties");
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
        out.print("<HEAD><TITLE>PropertiesServlet</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>This is the Project2 properties servlet</h1>");
        out.print("<table border=1>");
        out.print("<th>Property</th>");
        out.print("<th>Value</th>");
        out.print("<tr>");
        out.print("<td>Author</td>");
        out.print("<td>");
        out.print(properties.getProperty("author"));
        out.print("</td>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td>Author Email</td>");
        out.print("<td>");
        out.print(properties.getProperty("author.email.address"));
        out.print("</td>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td>Course Title</td>");
        out.print("<td>");
        out.print(properties.getProperty("course.title"));
        out.print("</td>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td>Course Meeting Day & Time</td>");
        out.print("<td>");
        out.print(properties.getProperty("course.day.time"));
        out.print("</td>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td>Instructor Name</td>");
        out.print("<td>");
        out.print(properties.getProperty("course.instructor"));
        out.print("</td>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td>Description of Project</td>");
        out.print("<td>");
        out.print(properties.getProperty("project.description"));
        out.print("</td>");
        out.print("</tr>");
        out.print("</table>");
        out.print("<p><a href=\"/java112/\">Return to Home page</a></p>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }
}
