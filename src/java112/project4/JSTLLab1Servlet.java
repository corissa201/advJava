package java112.project;

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
    name = "JSTLLab1Servlet",
    urlPatterns = { "/JSTL-lab1-servlet" }
)

public class JSTLLab1Servlet extends HttpServlet {

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

       HttpSession  session  = request.getSession();

    List flowers = new ArrayList();
    flowers.add("Tulip");
    flowers.add("Rose");
    flowers.add("Daffodil");
    flowers.add("Petunia");
    flowers.add("Lily");

    session.setAttribute("flowersList", flowers);


    }

}





