/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.jsf;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Masudul Haque
 */
@Named(value = "converterBean")
@RequestScoped
public class ConverterBean implements Serializable {
    private double price=40.5;
    public ConverterBean() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}
