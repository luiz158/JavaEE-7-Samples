
package org.glassfish.servlet.session_cookie_config_war;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

@WebListener()
public class ConfigListener implements ServletContextListener {

    /**
     * Receives notification that the web application initialization
     * process is starting.
     *
     * @param sce The servlet context event
     */
    public void contextInitialized(ServletContextEvent sce) {
        SessionCookieConfig scc =
            sce.getServletContext().getSessionCookieConfig();
        scc.setName("MYJSESSIONID");
        scc.setPath("/myPath");
        scc.setDomain("mydomain");
        scc.setComment("myComment");
        scc.setSecure(true);
        scc.setHttpOnly(true);
        scc.setMaxAge(123);
    }

    /**
     * Receives notification that the servlet context is about to be shut down.
     *
     * @param sce The servlet context event
     */
    public void contextDestroyed(ServletContextEvent sce) {
        // Do nothing
    }
}
