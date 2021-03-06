package org.javaee7.servlet.fileupload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Masudul Haque
 */
@WebServlet(name = "FileUploadAnnotation", urlPatterns = {"/FileUploadAnnotation"})
@MultipartConfig
public class FileUploadAnnotation extends HttpServlet {

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

        Part part = request.getPart("file");
        FileOutputStream fileOutputStream = null;
        InputStream inputStream= null;
        try (PrintWriter out = response.getWriter()) {
            fileOutputStream = new FileOutputStream(new File(request.getServletContext().getRealPath("/upload")+File.separator+"upload.jpg"));
            inputStream=part.getInputStream(); 
            
            int read=0;
            final byte bytes[]=new byte[1024];
            
            while((read=inputStream.read(bytes))!= -1){
                fileOutputStream.write(bytes, 0, read);
            }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FileUploadAnnotation</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FileUploadAnnotation at " + request.getContextPath() + "</h1>");
            out.println("<h2> File uploaded at " + request.getServletContext().getRealPath("/upload") + "</h2>");
            out.println("</body>");
            out.println("</html>");
        }
        finally{
            inputStream.close();
            fileOutputStream.close();
            
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
