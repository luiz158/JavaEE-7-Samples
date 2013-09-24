/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.simplewebsocketapi;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Masud
 */
@ServerEndpoint("/endpoint")
public class SimpleEndpoint {
    @OnOpen
    public void onOpen(){
        System.out.println("Connection is open");
    }
    @OnMessage
    public String onMessage(String message) {
        return "From Server : "+message;
    }
    
}
