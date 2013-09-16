/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.jsf;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Masudul Haque
 */
@Named(value = "bookMarkBean")
@RequestScoped
public class BookMarkBean implements Serializable{
    private int id;
    public BookMarkBean() {
        System.out.println("Id is : "+id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
