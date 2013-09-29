package org.javaee7.concurrency.executor;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Arun Gupta
 */
public class MyRunnableTask implements Runnable {

    private int id;

    public MyRunnableTask(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            System.out.format("%d (runnable): starting", id);
            System.out.format("%d (runnable): sleeping 2 seconds", id);
            Thread.sleep(2000);
            System.out.format("%d (runnable): complete", id);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestResourceServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
