package java112.project;


import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 *
 *
 *@author    Corissa Engel
 */
@WebServlet(
name = "JSTLLab2Servlet",
urlPatterns = {"/JSTL-lab2-servlet"}
) public class JSTLLab2Servlet extends HttpServlet {

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

        HttpSession session = request.getSession();

        List flowers = new ArrayList();
        flowers.add("Tulip");
        flowers.add("Rose");
        flowers.add("Daffodil");
        flowers.add("Petunia");
        flowers.add("Lily");

        session.setAttribute("flowersList", flowers);

        String url = "/jstl-lab2.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
