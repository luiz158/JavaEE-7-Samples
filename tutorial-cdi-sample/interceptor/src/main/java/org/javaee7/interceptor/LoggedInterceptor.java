/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.interceptor;

import java.util.logging.Level;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;

/**
 *
 * @author Masudul Haque
 */

@Logged
@Interceptor
//@Transactional
public class LoggedInterceptor {
    @PersistenceContext(unitName = "samplePU")
    EntityManager em;
    
    @Resource
    UserTransaction ui;
    
    @AroundConstruct
    public Object logCon(InvocationContext ic) throws Exception{
        Logger logger=new Logger();
        logger.setLog("Before Construct");
        ui.begin();
        em.persist(logger);
        ui.commit();
        System.out.println("Before Construct");
        try {
            System.out.println(ic.getConstructor().getName());
            return ic.proceed();
        }
        finally{
            System.out.println("After Construct");
        }
        
    }
    
    @AroundInvoke
    public Object log(InvocationContext ic) throws Exception{
        Logger logger=new Logger();
        logger.setLog("Before login");
        ui.begin();
        em.persist(logger);
        ui.commit();
        System.out.println("Before login");
        try {
            System.out.println(ic.getTarget().getClass().getName());
            System.out.println(ic.getMethod().getName());
            return ic.proceed();
        }
        finally{
            System.out.println("After login");
        }
    }
}
