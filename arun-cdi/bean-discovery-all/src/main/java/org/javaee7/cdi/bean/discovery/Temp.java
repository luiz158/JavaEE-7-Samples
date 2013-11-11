package org.javaee7.cdi.bean.discovery;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.inject.Named;

/**
 *
 * @author Masud
 */
@RequestScoped
public class Temp {

    public Temp() {

    }

    public String getMe() {
        return "something";
    }
}
