package org.javaee7.concurrency.executor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Arun Gupta
 */
@WebServlet(name = "TestInvokeAnyServlet", urlPatterns = {"/TestInvokeAnyServlet"})
public class TestInvokeAnyServlet extends HttpServlet {

//    @Resource(name = "concurrent/myExecutor2")
    @Resource(name = "DefaultManagedExecutorService")
    ManagedExecutorService executor;

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestInvokeAnyServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TestInvokeAnyServlet at " + request.getContextPath() + "</h1>");
            Collection<Callable<Product>> tasks = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                out.format("Adding task(%d) to the list<br>", i);
                tasks.add(new MyCallableTask(i));
            }
            try {
                out.format("invokeAny<br>");
                Product result = executor.invokeAny(tasks);
                out.format("got response: %d", result.getId());
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(TestInvokeAnyServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

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
