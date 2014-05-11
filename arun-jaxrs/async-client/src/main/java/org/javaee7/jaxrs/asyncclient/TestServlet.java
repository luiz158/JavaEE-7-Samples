package org.javaee7.jaxrs.asyncclient;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * @author Arun Gupta
 */
@WebServlet(name = "TestServlet", urlPatterns = {"/TestServlet"})
public class TestServlet extends HttpServlet {

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
        try {
            final PrintWriter out = response.getWriter();
            response.setContentType("text/html;charset=UTF-8");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>JAX-RS 2 Async Client</h1>");
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("http://"
                            + request.getServerName()
                            + ":"
                            + request.getServerPort()
                            + request.getContextPath()
                            + "/webresources/fruits");
            
            // Polling (Response)
            out.println("Invoking Future&lt;Response>...");
            Future<Response> r1 = target.request().async().get();
            out.println("<br>Received response (Future&lt;Response>): " + r1.get().readEntity(String.class));

            // Polling (String)
            out.println("<br>Invoking Future&lt;String>...");
            Future<String> r2 = target.request().async().get(String.class);
            out.println("<br>Received response (Future&lt;String>): " + r2.get());
            
            // Polling (String)
            out.println("<br>Invoking Future&lt;String>...");
            Future<String> r3 = target.request().async().get(String.class);
            out.println("<br>Received response (Future&lt;String>): " + r3.get());

            // Callback
            out.println("<br>Invoking InvocationCallback&lt;String>...");
            target.request().async().get(new InvocationCallback<String>() {

                @Override
                public void completed(String r) {
                    System.out.println("Received response (InovcationCallback<String>): " + r);
                }

                @Override
                public void failed(Throwable t) {
                    t.printStackTrace(out);
                }
                
            });
            out.print("<br>Check server.log for InvocationCallback&lt;String> results.");
            out.println("</body>");
            out.println("</html>");
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(TestServlet.class.getName()).log(Level.SEVERE, null, ex);
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
