/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.cdi.web;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Masudul Haque
 */
@Named(value = "producerBean")
@SessionScoped
public class ProducerBean implements Serializable{
    
    @Produces
    @PersistenceContext(unitName = "org.javaee7_producer_war_1.0-SNAPSHOTPU")
    EntityManager em;
    
    private String selectedGreet;
    
     
    @Produces
    @FormProducer
    public Greeting setGreeting(SimpleGreeting simpleGreeting, FancyGreeting  fancyGreeting){
        if(selectedGreet.equals("Simple")){
            return simpleGreeting;
        }
        else{
            return fancyGreeting;
        }
    }
    
    public String getSelectedGreet(){    
        return selectedGreet;
    }

    public void setSelectedGreet(String selectedGreet) {
        this.selectedGreet = selectedGreet;
    }
    
    
}
