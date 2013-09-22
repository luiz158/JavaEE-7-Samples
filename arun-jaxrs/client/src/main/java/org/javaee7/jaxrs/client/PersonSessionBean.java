package org.javaee7.jaxrs.client;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Singleton;

/**
 * @author Arun Gupta
 */
@Singleton
public class PersonSessionBean {
    List<Person> list;
    
    public PersonSessionBean() {
        list = new ArrayList<>();
    }
    
    public void addPerson(Person p) {
        list.add(p);
    }
    
    public void deletePerson(String name) {
        for (Person p : list) {
            if (p.getName().equals(name)) {
                list.remove(p);
            }
        }
    }
    
    public List<Person> getPersons() {
        return list;
    }
}
