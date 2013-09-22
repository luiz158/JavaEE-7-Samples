package org.javaee7.servlet;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * Web application lifecycle listener.
 *
 * @author Arun Gupta
 */
@WebListener()
public class MyHttpSessionActivationListener implements HttpSessionActivationListener {

    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        System.out.println("MyHttpSessionActivationListener.sessionWillPassivate: " + se.getSession().getId());
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        System.out.println("MyHttpSessionActivationListener.sessionDidActivate: " + se.getSession().getId());
    }

}
