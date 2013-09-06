package org.javaee7.concurrency.executor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Future;
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
@WebServlet(urlPatterns = {"/TestResourceServlet"})
public class TestResourceServlet extends HttpServlet {

//    @Resource(name = "concurrent/myExecutor2")
//    @Resource(name = "DefaultManagedExecutorService")
    @Resource(name = "java:comp/DefaultManagedExecutorService")
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
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TestServlet at " + request.getContextPath() + "</h1>");

            System.out.println("Getting ManagedExecutorService using @Resource");
            for (int i = 0; i < 5; i++) {
                out.format("submitting runnable(%d)<br>", i);
                Future<?> f = executor.submit(new MyRunnableTask(i));
                out.format("executing runnable(%d)<br>", i);
                executor.execute(new MyRunnableTask(i));
                out.format("submitting callable(%d)<br>", i);
                Future<Product> f2 = executor.submit(new MyCallableTask(i));
            }
            out.println("all tasks submitted<br/><br/>");
            out.println("Check server.log for output from the task.");
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
