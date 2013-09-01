package org.javaee7.cdi.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * @author Arun Gupta
 */
@Interceptor
@MyInterceptorBinding
public class MyInterceptor {

    @AroundInvoke
    public Object log(InvocationContext context) throws Exception {
        String name = context.getMethod().getName();
        String params = "";
        for (Object param : context.getParameters()) {
            params += param + " ";
        }
        System.out.println("MyInterceptor: " + name + "  " + params);
        return context.proceed();
    }
}
