package org.glassfish.servlet.annotation_war;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Web application lifecycle listener.
 *
 * @author Shing Wai Chan
 * @author Daniel Guo
 *
 */
@WebListener()
public class TestServletContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        String msg = "my listener";
        context.setAttribute("listenerMessage", msg);
    }

    public void contextDestroyed(ServletContextEvent sce) {
    }
}
