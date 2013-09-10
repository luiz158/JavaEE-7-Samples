/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.formlogin.sessions;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.javaee7.formlogin.entities.Student;

/**
 *
 * @author Masudul Haque
 */
@Stateless
@DeclareRoles({"user","admin"})
public class StudentFacade extends AbstractFacade<Student> {
    @PersistenceContext(unitName = "formloginPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentFacade() {
        super(Student.class);
    }
    
}
