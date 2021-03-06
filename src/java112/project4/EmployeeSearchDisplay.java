package java112.project4;


import java.io.*;
import java.util.*;

import java112.employee.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 * The EmployeeSearchDisplay servlet will forward to the Employee Search JSP page.
 *
 *@author    Corissa Engel
 *
 */
@WebServlet(
name = "employeeSearchDisplay",
urlPatterns = {"/search-display"}
)
public class EmployeeSearchDisplay extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *
     *@param      request               the HttpRequest
     *@param      response              the HttpResponse
     *
     *@exception  ServletException      if there is a general servlet exception
     *@exception  IOException           if there is a general I/O exception
     *
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String url = "/employeeSearch.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}