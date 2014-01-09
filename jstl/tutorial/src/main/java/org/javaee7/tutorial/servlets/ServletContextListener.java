/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.javaee7.tutorial.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;

/**
 * Web application lifecycle listener.
 *
 * @author Masud
 */
@WebListener
public class ServletContextListener implements javax.servlet.ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Context Initialized");
//        ServletRegistration.Dynamic servReg=
//                sce.getServletContext().addServlet("Greeting", "org.javaee7.tutorial.servlets.GreetingServlet");
//        servReg.addMapping("/greeting");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
       System.out.println("Context Destroyed");
    }
}
