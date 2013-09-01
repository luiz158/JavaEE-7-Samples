package org.javaee7.cdi;

import javax.enterprise.inject.Alternative;

/**
 *
 * @author Masudul Haque
 */
@Alternative
public class FancyGreeting implements Greeting{

    @Override
    public String greet() {
        return "Hello Fancy Greeting";
    }
    
}
