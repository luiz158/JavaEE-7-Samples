package org.javaee7.concurrency.executor;

/**
 * @author Arun Gupta
 */
public class MyWaitingTask implements Runnable {

    @Override
    public void run() {
        System.out.println("MyWaitingTask.run");
    }
    
}
