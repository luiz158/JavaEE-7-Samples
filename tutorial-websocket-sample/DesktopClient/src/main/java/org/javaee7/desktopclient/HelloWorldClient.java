/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.desktopclient;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

/**
 *
 * @author Masud
 */
@ClientEndpoint
public class HelloWorldClient {
    @OnOpen
    public void onOpen(Session session){
        System.out.println("Connection Opened");
    }
    @OnMessage
    public void onMessage(String message,Session session){
        System.out.println("Received  :"+message);
    }
    @OnError
    public void onOpen(Session session,Throwable t){
        t.printStackTrace();
    }
    @OnClose
    public void onClose(Session session){
        System.out.println("Connection Closed");
    }
}
