package org.javaee7.jaxrs.client;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;

/**
 * @author Arun Gupta
 */
@WebServlet(urlPatterns = {"/TestJAXRS2Client"})
public class TestJAXRS2Client extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>JAX-RS 2 Client API</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>JAX-RS 2 Client API</h1>");
        out.println("Initializing client...<br>");
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://"
                + request.getServerName()
                + ":"
                + request.getServerPort()
                + request.getContextPath()
                + "/webresources/persons");

        out.print("<br>POSTing...<br>");
        // POST
        MultivaluedHashMap<String, String> map = new MultivaluedHashMap<>();
        map.add("name", "Name");
        map.add("age", "17");
        target.request().post(Entity.form(map));
        out.print("POSTed a new item ...<br>");

        // GET
        out.print("<br>GETTing...<br>");
        Person[] list = target.request().get(Person[].class);
        out.format("GOT %1$s items<br>", list.length);
        for (Person p : list) {
            out.print(p + "<br>");
        }
        out.println("... done.<br>");

        // GET with path param
        out.print("<br>GETTing with parameter...<br>");
        Person person = target
                .path("{id}")
                .resolveTemplate("id", "1")
                .request(MediaType.APPLICATION_XML)
                .get(Person.class);
        out.print("GOT person: " + person + "<br>");
        out.println("... done.<br>");
        
        // Client-driven content negotiation
        out.print("<br>Client-side content negotiation...<br>");
        String json = target.request().accept(MediaType.APPLICATION_JSON).get(String.class);
        out.print("GOT JSON: " + json + "<br>");
        out.println("... done.");
        
        out.println("</body>");
        out.println("</html>");
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
