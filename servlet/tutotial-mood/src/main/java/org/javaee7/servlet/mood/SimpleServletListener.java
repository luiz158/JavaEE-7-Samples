package org.javaee7.servlet.mood;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author Masudul Haque
 */
public class SimpleServletListener implements ServletContextListener, ServletContextAttributeListener {
    Logger log=Logger.getLogger("SimpleServletListener");
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("Context Initialized.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("Context Destroyed.");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        log.log(Level.INFO, "Attribute {0} has been added, with value: {1}", 
                new Object[]{event.getName(), event.getValue()});
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        log.log(Level.INFO, "Attribute {0} has been removed", 
                event.getName());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        log.log(Level.INFO, "Attribute {0} has been replaced, with value: {1}", 
                new Object[]{event.getName(), event.getValue()});
    }
}
