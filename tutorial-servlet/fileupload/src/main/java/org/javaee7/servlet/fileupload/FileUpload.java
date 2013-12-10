package org.javaee7.servlet.fileupload;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.io.IOUtils;
import org.javaee7.servlet.fileupload.sessions.FileUploadBean;

/**
 * http://stackoverflow.com/questions/2422468/how-to-upload-files-to-server-using-jsp-servlet
 *
 * @author Masudul Haque
 */
@WebServlet(name = "FileUpload", urlPatterns = {"/upload"})
@MultipartConfig
public class FileUpload extends HttpServlet {

    @Inject
    FileUploadBean fileUploadBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Part part = request.getPart("file");

        InputStream is = part.getInputStream();
        final byte[] data = IOUtils.toByteArray(is);

        Profile p = new Profile();
        p.setPhoto(data);
        fileUploadBean.save(p);
        response.setContentType("image/gif");
        ServletOutputStream output = response.getOutputStream();
        output.write(data);
        output.close();
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
