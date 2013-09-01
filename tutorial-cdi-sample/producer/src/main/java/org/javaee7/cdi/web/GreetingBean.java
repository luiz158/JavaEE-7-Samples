/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.cdi.web;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Masudul Haque
 */
@Named(value = "greetingBean")
@RequestScoped
public class GreetingBean {

    @Inject
    @FormProducer
    private Greeting greeting;
    
    
    public String show(){
        System.out.println(greeting.greet("Hello"));
        return "show";
    }
}
