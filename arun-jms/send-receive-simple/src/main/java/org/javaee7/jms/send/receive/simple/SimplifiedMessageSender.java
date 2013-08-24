package org.javaee7.jms.send.receive.simple;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;
import javax.jms.Queue;

/**
 * @author Arun Gupta
 */
@Stateless
@JMSDestinationDefinitions({@JMSDestinationDefinition(name = "java:global/jms/myQueue2",
        interfaceName = "javax.jms.Queue")
})
public class SimplifiedMessageSender {

    @Inject
    JMSContext context;
    
    @Resource(mappedName="java:global/jms/myQueue2")
    Queue myQueue;

    public void sendMessage(String message) {
        context.createProducer().send(myQueue, message);
    }
}
