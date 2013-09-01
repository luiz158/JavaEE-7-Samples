/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.interceptor;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Masudul Haque
 */

@Logged
@Interceptor
public class LoggedInterceptor {
    
    @AroundInvoke
    public Object log(InvocationContext ic) throws Exception{
        System.out.println("Before login");
        try {
            return ic.proceed();
        }
        finally{
            System.out.println("After login");
        }
    }
}
