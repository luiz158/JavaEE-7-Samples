package org.javaee7.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Masud
 */
@WebServlet(name = "ParamServlet", urlPatterns = {"/ParamServlet"}, initParams = {
    @WebInitParam(name = "Name", value = "Masud"),
    @WebInitParam(name = "age", value = "26")})
public class ParamServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet init is called");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        for(Enumeration<String> names = request.getHeaderNames();names.hasMoreElements();){
//            String token=names.nextElement();
//            String header = request.getHeader(token);
//            System.out.println(token+" -> "+header);
//        }      
//        for(Enumeration<String> names = getInitParameterNames();names.hasMoreElements();){
//            String token=names.nextElement();
////            String header = request.getHeader(token);
//            String value=getInitParameter("age");
//            System.out.println(token);
//            System.out.println(value);
//        }      
//        System.out.println("Servlet Info : "+getServletInfo());
//        System.out.println("Servlet Name : "+getServletName());

        request.getServletContext().setAttribute("name", "Masudul Haque");

        response.setContentType("text/html;charset=UTF-8");
        response.addCookie(new Cookie("dept", "CSE"));
        System.out.println("ParamServlet2 is called");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ParamServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ParamServlet at " + request.getContextPath() + "</h1>");
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("dept")) {
                    out.println("<p>Cookies : " + cookie.getValue() + "</p>");
                }
            }
            out.println("</body>");
            out.println("</html>");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("doGet called");
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("doPost called");
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
