/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.javaee7.crudexam.web;

import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.javaee7.crudexam.model.Person;
import org.javaee7.crudexam.sessions.PersonFacade;

/**
 *
 * @author Masudul Haque
 */
@Named
@RequestScoped
public class PersonController {
    private Date dob;
    @Inject
    PersonFacade pf;

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
    
    
    
    
    public String save(){
        Person p=new Person();
        p.setDob(dob);
        pf.save(p);
        System.out.println("Person is saved");
       return null;
    }
}
