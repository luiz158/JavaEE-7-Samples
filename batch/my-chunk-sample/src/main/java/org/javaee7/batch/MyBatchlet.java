package org.javaee7.batch;

import javax.batch.api.Batchlet;
import javax.inject.Named;

/**
 *
 * @author Masud
 */
@Named
public class MyBatchlet implements Batchlet{

    @Override
    public String process() throws Exception {
        System.out.println("Entered to batchlet.....");
        return "COMPLETE";
    }

    @Override
    public void stop() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
