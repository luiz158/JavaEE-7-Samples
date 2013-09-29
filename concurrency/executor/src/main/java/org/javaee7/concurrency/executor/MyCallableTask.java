package org.javaee7.concurrency.executor;

import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Arun Gupta
 */
public class MyCallableTask implements Callable<Product> {

    private int id;
    
    public MyCallableTask(int id) {
        this.id = id;
    }
    
    @Override
    public Product call() {
        try {
            System.out.format("%d (callable): starting", id);
            System.out.format("%d (callable): sleeping 2 seconds", id);
            Thread.sleep(2000);
            System.out.format("%d (callable): complete", id);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestResourceServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Product(id);
    }
}
