/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.bvjsftest.web;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import java.util.Locale;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Masudul Haque
 */
@Named(value = "langController")
@SessionScoped
public class LangController implements Serializable{

    /**
     * Creates a new instance of LangController
     */
    public LangController() {
    }
     
    public String changeLang(String lang){
        Locale local=new Locale(lang);
        System.out.println("Local object is :"+local);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(local);
        return null;
    }
    
    
}
