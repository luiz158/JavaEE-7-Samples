package org.javaee7.json.object.reader;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Arun Gupta
 */
@WebServlet(urlPatterns = {"/JsonReaderFromReader"})
public class JsonReaderFromReader extends HttpServlet {

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
            out.println("<title>Servlet TestJsonParser</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Reading JSON from a Reader</h1>");

            out.println("Reading an empty object<br>");
            JsonReader jsonReader = Json.createReader(new StringReader("{}"));
            JsonObject json = jsonReader.readObject();
            out.println(json);

            out.println("<br><br>Reading an object with two elements<br>");
            jsonReader = Json.createReader(new StringReader("{"
                    + "  \"apple\":\"red\","
                    + "  \"banana\":\"yellow\""
                    + "}"));
            json = jsonReader.readObject();
            out.println("Apple: " + json.getString("apple")+"<br>");
            out.println("Banana: " + json.getString("banana")+"<br>");
            out.println(json);

            out.println("<br><br>Reading an array with two objects<br>");
            jsonReader = Json.createReader(new StringReader("["
                    + "  { \"apple\":\"red\" },"
                    + "  { \"banana\":\"yellow\" }"
                    + "]"));
            JsonArray jsonArr = jsonReader.readArray();
            out.println(jsonArr);

            out.println("<br><br>Reading a nested structure<br>");
            jsonReader = Json.createReader(new StringReader("{"
                    + "  \"title\":\"The Matrix\","
                    + "  \"year\":1999,"
                    + "  \"cast\":["
                    + "    \"Keanu Reaves\","
                    + "    \"Laurence Fishburne\","
                    + "    \"Carrie-Anne Moss\""
                    + "  ]"
                    + "}"));
            json = jsonReader.readObject();
            out.println(json);

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
