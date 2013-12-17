package org.javaee7.batch.webserverlog.batch;

import javax.batch.api.chunk.listener.ItemProcessListener;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 * @author Masud
 */
@Dependent
@Named("LogItemProcessListener")
public class LogItemProcessListener implements ItemProcessListener{

    @Override
    public void beforeProcess(Object item) throws Exception {
        System.out.println("Before ItemProcessListener");
    }

    @Override
    public void afterProcess(Object item, Object result) throws Exception {
        System.out.println("After ItemProcessListener");
    }

    @Override
    public void onProcessError(Object item, Exception ex) throws Exception {
        System.out.println("OnProcessError ItemProcessListener");
    }

}
