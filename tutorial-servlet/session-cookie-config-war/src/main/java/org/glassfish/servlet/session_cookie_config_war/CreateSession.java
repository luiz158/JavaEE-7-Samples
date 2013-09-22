package org.glassfish.servlet.session_cookie_config_war;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = "/")
public class CreateSession extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.getSession(true);

        String sessionCookie = res.getHeader("Set-Cookie");
        if (sessionCookie == null) {
            throw new ServletException("Missing Set-Cookie response header");
        }

        // name
        if (sessionCookie.indexOf("MYJSESSIONID=") == -1) {
            throw new ServletException("Missing session id");
        }

        // comment
        if (sessionCookie.indexOf("Comment=myComment") == -1) {
            throw new ServletException("Missing cookie comment");
        }

        // domain
        if (sessionCookie.indexOf("Domain=mydomain") == -1) {
            throw new ServletException("Missing cookie domain");
        }

        // path
        if (sessionCookie.indexOf("Path=/myPath") == -1) {
            throw new ServletException("Missing cookie path");
        }

        // secure
        if (sessionCookie.indexOf("Secure") == -1) {
            throw new ServletException("Missing Secure attribute");
        }

        // http-only
        if (sessionCookie.indexOf("HttpOnly") == -1) {
            throw new ServletException("Missing HttpOnly attribute");
        }

        // max-age
        if (sessionCookie.indexOf("Max-Age=123") == -1) {
            throw new ServletException("Missing max-age");
        }

        res.getWriter().println("SUCCESS");
    }
}
