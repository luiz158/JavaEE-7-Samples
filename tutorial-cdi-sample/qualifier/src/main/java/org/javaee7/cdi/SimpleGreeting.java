package org.javaee7.cdi;

/**
 *
 * @author Masudul Haque
 */
@Simple
public class SimpleGreeting implements Greeting{
    
    
    @Override
    public String greet() {
        return "Hello Simple Greeting";
    }
    
    
}
