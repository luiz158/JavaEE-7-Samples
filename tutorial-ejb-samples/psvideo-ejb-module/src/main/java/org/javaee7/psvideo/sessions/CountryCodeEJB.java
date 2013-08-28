/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.psvideo.sessions;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;

/**
 *
 * @author Masudul Haque
 */
@Singleton
@LocalBean
public class CountryCodeEJB {
    @PostConstruct
    public void init(){
        System.out.println("Country Code EJB initialized");
    }
}
