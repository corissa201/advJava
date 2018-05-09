package java112.project4;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *The EmployeeSearchResultsServlet will perform searches for employees.
 *
 *@author    Corissa Engel
 */
@WebServlet(
    name = "searchResults",
    urlPatterns = { "/searchResults-servlet" }
)

public class EmployeeSearchResultsServlet extends HttpServlet {

     /**
     * The init method ....
     *
     * @exception ServletException   If a servlet exception occurs.
     */
    public void init() throws ServletException {

    }

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

        ServletContext context = request.getServletContext();

        HttpSession session = request.getSession();

        EmployeeDirectory directory = (EmployeeDirectory)context.getAttribute("project4Directory");

        String searchTerm = request.getParameter("searchTerm");
        String searchType = request.getParameter("searchType");


        directory.searchEmployeeDatabase(searchTerm, searchType);

        String url = "/content-employeeSearch.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

}





