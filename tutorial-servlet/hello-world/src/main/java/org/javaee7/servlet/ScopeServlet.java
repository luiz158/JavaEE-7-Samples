/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Masud
 */
@WebServlet("/ScopeServlet")
public class ScopeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        request.setAttribute("a1", "v1");
        HttpSession session = request.getSession();
        session.setAttribute("a2", "v2");
        ServletContext application = getServletContext();
        application.setAttribute("a3", "v3");
        request.setAttribute("c", "request");
        session.setAttribute("c", "session");
        application.setAttribute("c", "application");

        RequestDispatcher rd = request.getRequestDispatcher("Process.jsp");
        rd.forward(request, resp);
    }

}
