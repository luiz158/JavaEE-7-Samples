package org.javaee7.cdi;

import javax.enterprise.inject.Default;

/**
 *
 * @author Masudul Haque
 */
//@Fancy
@Default
public class FancyGreeting implements Greeting{

    @Override
    public String greet() {
        return "Hello Fancy Greeting";
    }
    
}
