package javaeetutorial.reservation;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Masudul Haque
 */
@Named
@SessionScoped
public class PassThroughBean implements Serializable {

    private String email;
    private Map<String, Object> nameValuePairs;

    public PassThroughBean() {
        this.nameValuePairs = new HashMap<>();
        this.nameValuePairs.put("type", "email"); 
        this.nameValuePairs.put("min", "1");
        this.nameValuePairs.put("max", "30");
        this.nameValuePairs.put("required", "required");
        this.nameValuePairs.put("title",
                "Enter a number between 1 and 4 inclusive.");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, Object> getNameValuePairs() {
        return nameValuePairs;
    }

    public void setNameValuePairs(Map<String, Object> nameValuePairs) {
        this.nameValuePairs = nameValuePairs;
    }
    
    

}
