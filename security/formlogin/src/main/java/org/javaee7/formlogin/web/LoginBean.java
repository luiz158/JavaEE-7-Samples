/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.formlogin.web;

import java.io.Serializable;
import java.security.Principal;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Masudul Haque
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable{

    private String userName;

    public LoginBean() {
        if(userName==null || userName.isEmpty()){
        Principal principal=FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
        userName=principal.getName();
        }
        
    }
    
    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login?faces-redirect=true";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
