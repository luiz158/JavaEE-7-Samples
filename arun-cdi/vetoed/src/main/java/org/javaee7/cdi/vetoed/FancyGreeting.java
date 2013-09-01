package org.javaee7.cdi.vetoed;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Vetoed;

/**
 * @author Arun Gupta
 */
//@Vetoed
//@Alternative
@Fancy
public class FancyGreeting implements Greeting {

    @Override
    public String greet(String name) {
        return "Hello " + name + " :)";
    }
    
}
