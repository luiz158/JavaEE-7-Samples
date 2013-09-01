package org.javaee7.cdi.decorators;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

/**
 * @author Arun Gupta
 */
@Decorator
public class MyDecorator implements Greeting {

    @Inject @Delegate @Any Greeting greeting;
    
    @Override
    public String greet(String name) {
        System.out.println(getClass().getName() + " greet");
        return greeting.greet(name + name);
    }
    
}
