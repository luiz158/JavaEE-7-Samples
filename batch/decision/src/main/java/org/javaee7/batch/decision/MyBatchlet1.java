package org.javaee7.batch.decision;

import javax.batch.api.AbstractBatchlet;

/**
 * @author Arun Gupta
 */
public class MyBatchlet1 extends AbstractBatchlet {

    @Override
    public String process() {
        System.out.println("Running inside a batchlet 1");
        
        return "COMPLETED";
    }

}
