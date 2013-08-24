package org.glassfish.servlet.annotation_war;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class illustrate WebServlet annotation
 *
 * @author Shing Wai Chan
 * @author Daniel Guo
 */
@WebServlet(name = "TestServlet", urlPatterns = {"/"},
            initParams = {@WebInitParam(name = "message", value = "my servlet")})
public class TestServlet extends HttpServlet {

    private String listenerMessage = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        listenerMessage = (String) config.getServletContext().getAttribute("listenerMessage");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
        PrintWriter writer = res.getWriter();
        writer.write("Hello, " + getInitParameter("message") + ", ");
        writer.write(req.getAttribute("filterMessage") + ", ");
        writer.write(listenerMessage + ".\n");
    }
}
