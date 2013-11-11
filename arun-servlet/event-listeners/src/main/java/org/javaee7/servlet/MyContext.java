/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.servlet;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author Masud
 */
@WebListener()
public class MyContext implements ServletContextListener {

    private ScheduledExecutorService sched;

    @Override
    public void contextInitialized(ServletContextEvent event) {
        sched = Executors.newSingleThreadScheduledExecutor();
        sched.scheduleAtFixedRate(new MyTask(), 0, 1, TimeUnit.SECONDS);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        sched.shutdownNow();
    }

}
