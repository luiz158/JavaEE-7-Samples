package org.javaee7.jaxrs.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * @author Arun Gupta
 */
@WebServlet(urlPatterns = {"/TestURLConnectionClient"})
public class TestURLConnectionClient extends HttpServlet {

    private static final String CHARSET = "UTF-8";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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
            out.println("<title>REST Endpoint using HttpURLConnection</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>REST Endpoint using HttpURLConnection</h1>");
            URL url = new URL("http://"
                    + request.getServerName()
                    + ":"
                    + request.getServerPort()
                    + request.getContextPath()
                    + "/webresources/persons");

            out.print("<br>POSTing...<br>");
            // POST
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            connection.setDoOutput(true); // required to be able to POST
            connection.setRequestProperty("Accept-Charset", CHARSET);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHARSET);
            String postRequest = String.format("name=%s&age=%s",
                    URLEncoder.encode("Name", CHARSET),
                    URLEncoder.encode("17", CHARSET));
            try (OutputStream os = connection.getOutputStream()) {
                os.write(postRequest.getBytes(CHARSET));
            }
            try (InputStream is = connection.getInputStream()) {
                byte[] bytes = new byte[1024];
                is.read(bytes);
                out.println(new String(bytes));
            }
            connection.disconnect();
            out.print("POSTed a new item ...<br>");

            // GET
            out.print("<br>GETTing...<br>");
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(false);
            connection.setRequestMethod("GET");
//            try (InputStream is = connection.getInputStream()) {
//                byte[] bytes = new byte[1024];
//                is.read(bytes);
//                out.println(new String(bytes));
//            }
                
            try {
                JAXBContext jc = JAXBContext.newInstance(Person.class, People.class);
                Unmarshaller um = jc.createUnmarshaller();
                People people = (People) um.unmarshal(connection.getInputStream());
                out.format("GOT %1$s items<br>", people.getPerson().length);
                for (Person p : people.getPerson()) {
                    out.print(p + "<br>");
                }
            } catch (JAXBException ex) {
                Logger.getLogger(TestURLConnectionClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.println("... done.<br>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
