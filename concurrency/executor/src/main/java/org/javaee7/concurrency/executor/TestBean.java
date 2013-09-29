package org.javaee7.concurrency.executor;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;

/**
 * @author Arun Gupta
 */
@Stateless
public class TestBean {
//    @Resource(name = "concurrent/myExecutor")
    @Resource(name = "DefaultManagedExecutorService")
    ManagedExecutorService executor;

    public void run() {
        for (int i = 0; i < 5; i++) {
            executor.submit(new MyRunnableTask(i));
        }
    }
}
