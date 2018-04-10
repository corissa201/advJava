package java112.project3;

import java.io.*;
import java.util.*;
import java.lang.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *
 *
 *@author    Corissa Engel
 */
@WebServlet(
    name = "requestServlet",
    urlPatterns = { "/request-servlet" }
)

public class HttpRequestServlet extends HttpServlet {

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

        HttpRequestData myHttpBean = new HttpRequestData();

        myHttpBean.setRemoteComputer(request.getRemoteHost());
        myHttpBean.setRemoteAddress(request.getRemoteAddr());
        myHttpBean.setHttpMethod(request.getMethod());
        myHttpBean.setRequestUri(request.getRequestURI());
        myHttpBean.setRequestUrl(request.getRequestURL());
        myHttpBean.setRequestProtocal(request.getProtocol());
        myHttpBean.setServerName(request.getServerName());
        myHttpBean.setServerPortNmb(request.getServerPort());
        myHttpBean.setCurrentServerLocale(request.getLocale());
        myHttpBean.setQuery(request.getQueryString());
        myHttpBean.setQueryParameter(request.getParameter("queryParameter"));
        myHttpBean.setUserAgent(request.getHeader("User-Agent"));

        request.setAttribute("myProject3Bean", myHttpBean);

        String url = "/project3Request.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

}





