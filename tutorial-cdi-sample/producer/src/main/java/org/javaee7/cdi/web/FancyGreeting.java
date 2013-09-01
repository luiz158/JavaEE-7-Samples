package org.javaee7.cdi.web;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Vetoed;


public class FancyGreeting implements Greeting {

    @Override
    public String greet(String name) {
        return "Hello " + name + " :)";
    }
    
}
