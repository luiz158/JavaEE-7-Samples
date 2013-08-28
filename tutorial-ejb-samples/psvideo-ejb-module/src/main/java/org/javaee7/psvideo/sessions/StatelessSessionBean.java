/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.psvideo.sessions;

import java.util.List;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.javaee7.psvideo.entities.Student;

/**
 *
 * @author martin
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class StatelessSessionBean {

    @PersistenceContext(unitName = "samplePU")
    EntityManager em;

    public String sayHello(String name) {
        return "Hello  " + name;
    }

    public List<Student> getAllStudents() {
        return em.createNamedQuery("Student.findAll", Student.class).getResultList();
    }
    
    public void create(String name){
        Student s=new Student(name);
        em.persist(s);
    }

}
