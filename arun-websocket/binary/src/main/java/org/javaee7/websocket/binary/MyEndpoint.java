package org.javaee7.websocket.binary;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * @author Arun Gupta
 */
@ServerEndpoint("/websocket")
public class MyEndpoint {
    @OnMessage
    public void echoBinary(ByteBuffer data, Session session) {
        System.out.println("echoBinary: " + data);
        for (byte b : data.array()) {
            System.out.print(b);
        }
        try {
            session.getBasicRemote().sendBinary(data);
        } catch (IOException ex) {
            Logger.getLogger(MyEndpoint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    @WebSocketMessage
//    public void echoBinary(byte[] data, Session session) throws IOException {
//        System.out.println("echoBinary: " + data);
//        StringBuilder builder = new StringBuilder();
//        for (byte b : data) {
//            builder.append(b);
//        }
//        System.out.println(builder);
//        session.getRemote().sendBytes(ByteBuffer.wrap(data));
//    }
    
//    @WebSocketMessage
//    public void echoStream(InputStream stream, Session session) {
//        System.out.println("echoStream: " + stream);
//        byte[] b = new byte[20];
//        try {
//            int n = stream.read(b);
//            System.out.println("read " + n + " bytes");
//            System.out.println(new String(b));
//            session.getRemote().sendString(new String(b));
//        } catch (IOException ex) {
//            Logger.getLogger(MyEndpoint.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
