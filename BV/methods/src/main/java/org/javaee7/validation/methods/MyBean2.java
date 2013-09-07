package org.javaee7.validation.methods;

import javax.validation.constraints.NotNull;

/**
 * @author Arun Gupta
 */
public class MyBean2 {
    private String value;
    
    public MyBean2(@NotNull String value) {
        this.value = value;
    }
}
