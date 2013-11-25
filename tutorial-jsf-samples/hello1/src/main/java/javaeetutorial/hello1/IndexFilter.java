/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaeetutorial.hello1;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Masudul Haque
 */
@WebFilter(filterName = "IndexFilter", urlPatterns = {"/*"})
public class IndexFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String requestURL = request.getRequestURI().toString();
        if (request.getServletPath().equals("/index.xhtml") && !requestURL.contains("index.xhtml")) {
            response.sendRedirect("http://" + req.getServerName() + ":"
                    + request.getServerPort() + request.getContextPath()+"/index.xhtml");
            
        } else {
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

}
