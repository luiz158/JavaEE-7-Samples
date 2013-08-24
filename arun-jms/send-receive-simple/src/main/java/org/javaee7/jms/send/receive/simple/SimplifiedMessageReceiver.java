package org.javaee7.jms.send.receive.simple;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 * @author Arun Gupta
 */
@Stateless
public class SimplifiedMessageReceiver {

    @Inject
    private JMSContext context;
    
    @Resource(mappedName="java:global/jms/myQueue2")
    Queue myQueue;

    public String receiveMessage() {
        String message = context.createConsumer(myQueue).receiveBody(String.class, 1000);
        return message;
    }
}
