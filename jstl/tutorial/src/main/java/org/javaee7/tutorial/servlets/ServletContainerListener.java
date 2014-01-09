package org.javaee7.tutorial.servlets;

import java.util.Set;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class ServletContainerListener implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        System.out.println("Container Initialized");
//        ServletRegistration.Dynamic servReg
//                = ctx.addServlet("Greeting", "org.javaee7.tutorial.servlets.GreetingServlet");
//        servReg.addMapping("/greeting2");
    }

}
