package org.javaee7.cdi.web;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Vetoed;

public class SimpleGreeting implements Greeting {

    @Override
    public String greet(String name) {
        return "Hello " + name;
    }
    
}
