package org.javaee7.batch.webserverlog.batch;

import javax.batch.api.chunk.listener.ItemProcessListener;
import javax.batch.api.chunk.listener.ItemReadListener;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 * @author Masud
 */
@Dependent
@Named("LogItemReadListener")
public class LogItemReadListener implements ItemReadListener {

    @Override
    public void beforeRead() throws Exception {
        System.out.println("Before Item Read");
    }

    @Override
    public void afterRead(Object item) throws Exception {
        System.out.println("After Item Read");
    }

    @Override
    public void onReadError(Exception ex) throws Exception {
        System.out.println("On Item Read Error");
    }

}
