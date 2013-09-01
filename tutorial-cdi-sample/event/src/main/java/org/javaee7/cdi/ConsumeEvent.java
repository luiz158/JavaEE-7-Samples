/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.cdi;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;

/**
 *
 * @author Masudul Haque
 */
@Stateless
public class ConsumeEvent {

    public void test(@Observes String hello) {
        System.out.println("Observing the event of " + hello);
    }
}
