package java112.project4;


import java.io.*;
import java.util.*;

import java112.utilities.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 *
 *
 *@author    Eric Knapp
 */
@WebServlet(
name = "sessionlab4",
urlPatterns = {"/session4"}
) public class Project4SessionLab extends HttpServlet {

    // thread safe
    private int pageCounter;


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

        Integer sessioncounter = (Integer)session.getAttribute("sessioncounter");

        if (sessioncounter == null) {
            sessioncounter = new Integer(1);
        } else {
            sessioncounter += 1;
        }

        session.setAttribute("sessioncounter", sessioncounter);

        pageCounter += 1;

        session.setAttribute("pageCounter", pageCounter);

        session.setAttribute("sessionID", session.getId());

        String url = "/sessionLab.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
