/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.customermanager.sessions;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.javaee7.customermanager.entities.Customer;

/**
 *
 * @author Masud
 */
@Stateless
@Named
public class CustomerFacade extends AbstractFacade<Customer> {
    @PersistenceContext(unitName = "org.javaee7_CustomerManager_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }

    public List<Customer> getCustomers() {
        return em.createNamedQuery("Customer.findAll").getResultList();
    }
    
    
    
}
