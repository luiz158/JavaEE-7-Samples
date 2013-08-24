package org.glassfish.endpoint.programmatic;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.CloseReason;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.PongMessage;
import javax.websocket.Session;

/**
 * @author Arun Gupta
 */
public class MyEndpoint extends Endpoint {

    @Override
    public void onOpen(final Session session, EndpointConfig ec) {
        session.addMessageHandler(new MessageHandler.Whole<String>() {

            @Override
            public void onMessage(String text) {
                try {
                    session.getBasicRemote().sendText(text);
                } catch (IOException ex) {
                    Logger.getLogger(MyEndpoint.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        session.addMessageHandler(new MessageHandler.Whole<ByteBuffer>() {

            @Override
            public void onMessage(ByteBuffer t) {
                try {
                    session.getBasicRemote().sendBinary(t);
                } catch (IOException ex) {
                    Logger.getLogger(MyEndpoint.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        session.addMessageHandler(new MessageHandler.Whole<PongMessage>() {

            @Override
            public void onMessage(PongMessage t) {
                System.out.println("PongMessage received: " + t.getApplicationData());
            }
        });
        
    }

    @Override
    public void onClose(Session session, CloseReason closeReason) {
        System.out.println("Closing: " + closeReason.getReasonPhrase());
    }

    @Override
    public void onError(Session session, Throwable t) {
        System.out.println("Error: " + t.getLocalizedMessage());
    }
}
