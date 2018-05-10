package java112.project4;


import java.io.*;
import java.sql.*;
import java.util.*;

import java112.employee.*;
import java112.utilities.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 *
 *
 *@author    Corissa Engel
 */
@WebServlet(
name = "EmployeeAddActionServlet",
urlPatterns = {"/employeeAddAction-servlet"}
) public class EmployeeAddActionServlet extends HttpServlet {

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
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        ServletContext context = request.getServletContext();

        HttpSession session = request.getSession();

        EmployeeDirectory directory = (EmployeeDirectory)context.getAttribute("project4Directory");


        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String socialSecurityNumber = request.getParameter("socialSecurityNumber");
        String department = request.getParameter("department");
        String roomNumber = request.getParameter("roomNumber");
        String phoneNumber = request.getParameter("phoneNumber");

        if (firstName.equals("") || lastName.equals("") || socialSecurityNumber.equals("") ||
        department.equals("") || roomNumber.equals("") || phoneNumber.equals("")) {
            String noValueEntered = "Employee information was not added. Please fill in all form fields";

            session.setAttribute("project4message", noValueEntered);

        } else {
            String message = directory.addNewEmployeeRecord(firstName, lastName, socialSecurityNumber,
            department, roomNumber, phoneNumber);

            session.setAttribute("project4message", message);
        }


        String url = "/java112/addNewEmployee-servlet";

        response.sendRedirect(url);
    }
}
