/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.interceptor;

import javax.ejb.Stateless;
import javax.interceptor.ExcludeClassInterceptors;

/**
 *
 * @author Masudul Haque
 */
//@Stateless
@Logged
public class LoginSession {
    
    public LoginSession() {
        System.out.println("Try to Construct.");
    }
     
    
    public void tryLogin(){
        System.out.println("Try to login");
//        tryRegister();
    }
//    @ExcludeClassInterceptors
    public void tryRegister(){
        System.out.println("Try to Register");
    }
}
