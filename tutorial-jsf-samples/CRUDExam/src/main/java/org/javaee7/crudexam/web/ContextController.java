package org.javaee7.crudexam.web;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Masudul Haque
 */
@Named
@RequestScoped
public class ContextController {

    public void test() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Object controller =  facesContext.getApplication().getELResolver().
                getValue(facesContext.getELContext(), null,"bookController");
        Object name =  facesContext.getApplication().getELResolver().
                getValue(facesContext.getELContext(), controller,"name");
        System.out.println("Controller Bean : " + name);
    }

}
