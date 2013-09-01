/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.cdi.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.javaee7.cdi.entities.Usertable;

/**
 *
 * @author Masudul Haque
 */
@Stateless
public class UsertableFacade extends AbstractFacade<Usertable> {
    @PersistenceContext(unitName = "org.javaee7_producer_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsertableFacade() {
        super(Usertable.class);
    }
    
}
