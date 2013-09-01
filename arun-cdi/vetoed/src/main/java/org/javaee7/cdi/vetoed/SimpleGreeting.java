package org.javaee7.cdi.vetoed;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Vetoed;

/**
 * @author Arun Gupta
 */
//@Vetoed
@Default
public class SimpleGreeting implements Greeting {

    @Override
    public String greet(String name) {
        return "Hello " + name;
    }
    
}
