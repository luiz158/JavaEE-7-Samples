/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.javaee7.components.model;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Masudul Haque
 */
@ManagedBean
@RequestScoped
public class DataManagedBean {
  private   List<User> listNewestCocktails;
    public DataManagedBean() {
        listNewestCocktails=new ArrayList<>();
        listNewestCocktails.add(new User("Masud", 200.0, "phoasd"));
        listNewestCocktails.add(new User("Mahmud", 200.0, "phoasd"));
        listNewestCocktails.add(new User("Haque", 200.0, "phoasd"));
    }

    public List<User> getListNewestCocktails() {
        return listNewestCocktails;
    }

    public void setListNewestCocktails(List<User> listNewestCocktails) {
        this.listNewestCocktails = listNewestCocktails;
    }
    
    
}
