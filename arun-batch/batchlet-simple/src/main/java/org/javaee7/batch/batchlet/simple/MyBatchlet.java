package org.javaee7.batch.batchlet.simple;

import javax.batch.api.AbstractBatchlet;

/**
 * @author Arun Gupta
 */
public class MyBatchlet extends AbstractBatchlet {

    @Override
    public String process() {
        System.out.println("Running inside a batchlet");
        
        return "COMPLETED";
    }

}
