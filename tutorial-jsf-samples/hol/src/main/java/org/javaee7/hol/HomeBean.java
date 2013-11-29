
package org.javaee7.hol;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Masudul Haque
 */
@Named
@SessionScoped
public class HomeBean implements Serializable{
    private List<String> names;

    public HomeBean() {
       names =new ArrayList<>(Arrays.asList("Hello","Hello","Hello","Hello"));
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }
    
   
   
}
