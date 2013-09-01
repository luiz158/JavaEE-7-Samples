package org.javaee7.cdi.interceptors;

/**
 * @author Arun Gupta
 */
@MyInterceptorBinding
public class SimpleGreeting implements Greeting {

    @Override
    public String greet(String name) {
        return "Hello " + name;
    }
    
}
