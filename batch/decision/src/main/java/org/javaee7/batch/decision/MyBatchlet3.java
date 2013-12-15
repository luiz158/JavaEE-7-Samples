package org.javaee7.batch.decision;

import javax.batch.api.AbstractBatchlet;

/**
 * @author Arun Gupta
 */
public class MyBatchlet3 extends AbstractBatchlet {

    @Override
    public String process() {
        System.out.println("Running inside a batchlet 3");
        
        return "COMPLETED";
    }

}
