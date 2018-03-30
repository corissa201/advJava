package java112.project3;


import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 *
 *
 *@author    CEngel
 */
@WebServlet(
name = "lab32Servlet",
urlPatterns = {"/lab32"}
) public class Lab32Servlet extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request               the HttpRequest
     *@param  response              the HttpResponse
     *@exception  ServletException  if there is a general
     *                              servlet exception
     *@exception  IOException       if there is a general
     *                              I/O exception
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE>Lab32Servlet</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>This is the Lab 3-2 Servlet</h1>");
        out.print("<p>" + request.getLocale() + "</p>");
        out.print("<p>" + request.getContextPath() + "</p>");
        out.print("<p>" + request.getLocalName() + "</p>");
        out.print("<p>" + request.getScheme() + "</p>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }
}
