package java112.project4;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *
 *
 * @author    Corissa Engel
 * @version   1.0
 */
@WebServlet(
    name = "EmployeeSearch-Servlet",
    urlPatterns = {"/employeeSearch-servlet"}
)

public class EmployeeSearchServlet extends HttpServlet {

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

        //ServletContext context = getServletContext();

        //context.getAtribute(directory);

        //String  searchTerm = request.getParameter("searchTerm");

        //if (searchTerm == null || searchTerm.isEmpty()){
        String url = "/employeeSearch.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
        }

        //System.out.println("searchTerm: " + searchTerm);

        //String  param2 = request.getParameter("param2");

        //System.out.println("param2: " + param2);

    }





