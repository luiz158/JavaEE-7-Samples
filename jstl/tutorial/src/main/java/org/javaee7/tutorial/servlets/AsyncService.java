package org.javaee7.tutorial.servlets;

import javax.servlet.AsyncContext;

/**
 *
 * @author Masud
 */
public class AsyncService implements Runnable{
    AsyncContext ac;

    public AsyncService(AsyncContext ac) {
        this.ac = ac;
    }
    
    @Override
    public void run() {
        System.out.println("Async Service Run");
        ac.complete();
        System.out.println("After Async service complete");
    }

}
