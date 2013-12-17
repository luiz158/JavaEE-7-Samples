package org.javaee7.batch.webserverlog.batch;

import javax.batch.api.Batchlet;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 * @author Masud
 */
@Dependent
@Named
public class LogBatchlet implements Batchlet{

    @Override
    public String process() throws Exception {
        System.out.println("LogBatchlet process is called");
        return "COMPLETED";
    }

    @Override
    public void stop() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
