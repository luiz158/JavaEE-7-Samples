/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package org.javaee7.validation.methods;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

/**
 * @author Arun Gupta
 */
@WebServlet(urlPatterns = {"/TestClient"})
public class TestClient extends HttpServlet {
    
    @Inject MyBean bean;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestClient</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TestClient at " + request.getContextPath() + "</h1>");
            out.println("Method parameter (with incorrect parameter, length=4)<br>");
            try {
                out.println(bean.sayHello("Duke"));
            } catch (ConstraintViolationException ex) {
                out.println("ConstraintViolationException caught<br>");
            } finally {
                out.println("Was ConstraintViolationException caught ?<br>");
            }
            out.println("Method parameter (with correct parameter, length=3)<br>");
            out.println(bean.sayHello("Duk"));
            out.println("<p><p>");
            
            out.println("Return value (with incorrect value, past date)<br>");
            try {
                out.println(bean.showDate(false) + "<br>");
            } catch (ConstraintViolationException ex) {
                out.println("ConstraintViolationException caught<br>");
            } finally {
                out.println("Was ConstraintViolationException caught ?<br>");
            }
                
            out.println("Return value (with correct value, future date)<br>");
            out.println(bean.showDate(true)+ "<br>");
            out.println("<p><p>");
            
            out.println("Multiple parameter constraint (with incorrect value, empty list)<br>");
            try {
                out.println(bean.showList(new ArrayList<String>(), "foo") + "<br>");
            } catch (ConstraintViolationException ex) {
                out.println("ConstraintViolationException caught<br>");
            } finally {
                out.println("Was ConstraintViolationException caught ?<br>");
            }
                
            List<String> list = new ArrayList<>();
            out.println("Multiple parameter constraint (with incorrect value, null second parameter)<br>");
            try {
                list.add("bar");
                out.println(bean.showList(list, null) + "<br>");
            } catch (ConstraintViolationException ex) {
                out.println("ConstraintViolationException caught<br>");
            } finally {
                out.println("Was ConstraintViolationException caught ?<br>");
            }
            out.println("Multiple parameter constraint (with correct value)<br>");
            out.println(bean.showList(list, "foo") + "<br>");
            out.println("<p><p>");
            
//            out.println("Cross-parameter constraint (with incorrect value, null first parameter)<br>");
//            try {
//                bean.concat(null, "bar");
//                out.println(bean.showList(list, null) + "<br>");
//            } catch (ConstraintViolationException ex) {
//                out.println("ConstraintViolationException caught<br>");
//            } finally {
//                out.println("Was ConstraintViolationException caught ?<br>");
//            }
//            out.println("Cross-parameter constraint (with incorrect value, null second parameter)<br>");
//            try {
//                bean.concat("foo", null);
//                out.println(bean.showList(list, null) + "<br>");
//            } catch (ConstraintViolationException ex) {
//                out.println("ConstraintViolationException caught<br>");
//            } finally {
//                out.println("Was ConstraintViolationException caught ?<br>");
//            }
//            
//            out.println("Multiple parameter constraint (with correct value)<br>");
//            bean.concat("foo", "bar");
            out.println("<p><p>");
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }
// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
/**
 * Handles the HTTP
 * <code>GET</code> method.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
@Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
