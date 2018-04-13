package java112.project4;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *
 *
 *@author    Eric Knapp
 */
@WebServlet(
    name = "Lab41Servlet",
    urlPatterns = { "/lab41-servlet" }
)

public class Lab41Servlet extends HttpServlet {

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
        String  param1 = request.getParameter("param1");

        if (param1 == null || param1.isEmpty()){

        }

        System.out.println("param1: " + param1);

        String  param2 = request.getParameter("param2");

        System.out.println("param2: " + param2);
    }

}





