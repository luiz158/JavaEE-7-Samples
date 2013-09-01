/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.cdi;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

/**
 *
 * @author Masudul Haque
 */
@Stateless
public class ProduceEvent {

    @Inject
    @Any
    Event<String> helloEvent;

    public void sayHello() {
        helloEvent.fire("Masud");
    }
}
