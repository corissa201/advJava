package java112.project;


import java.io.*;
import java.util.*;
import java112.utilities.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 * The PropertiesServlet servlet will set the properties reference to the request
 * object as an attribute and forward to the properties3 jsp page.
 *
 *@author    Corissa Engel
 */
@WebServlet(
name = "project3PropertiesServlet",
urlPatterns = {"/project3-properties"}
) public class PropertiesServlet extends HttpServlet implements PropertiesLoader {

    private Properties properties;


    /**
     * The init method loads the properties file path into the properties instance.
     *
     * @exception ServletException   If a servlet exception occurs.
     */
    public void init() throws ServletException {
        properties = loadProperties("/project3.properties");
    }


    /**
     *  Handles HTTP GET requests.
     *
     *@param  request               the HttpRequest
     *@param  response              the HttpResponse
     *@exception  ServletException  if there is a general servlet exception
     *@exception  IOException       if there is a general I/O exception
     *
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        request.setAttribute("myProperties3", properties);

        String url = "/properties3.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
