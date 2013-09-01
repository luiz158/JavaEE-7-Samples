/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.interceptor;

import javax.ejb.Stateless;

/**
 *
 * @author Masudul Haque
 */
//@Stateless
@Logged
public class LoginSession {
    
    public void tryLogin(){
        System.out.println("Try to login");
    }
}
