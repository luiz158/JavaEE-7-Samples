package org.javaee7.desktopclient;

import java.net.URI;
import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        Session session = container.connectToServer(HelloWorldClient.class, new URI("ws://localhost:8080/SimpleWebSocketAPI/otherendpoint"));
        session.getBasicRemote().sendText("Hello World");
        Thread.sleep(100000);
       
    }
}
