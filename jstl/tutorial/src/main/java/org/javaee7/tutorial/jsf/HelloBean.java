/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.tutorial.jsf;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Masud
 */
@Named
@RequestScoped
public class HelloBean {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
