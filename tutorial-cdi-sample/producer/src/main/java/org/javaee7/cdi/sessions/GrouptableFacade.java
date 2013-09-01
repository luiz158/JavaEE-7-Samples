/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.cdi.sessions;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.javaee7.cdi.entities.Grouptable;

/**
 *
 * @author Masudul Haque
 */
@Stateless
public class GrouptableFacade extends AbstractFacade<Grouptable> {
    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GrouptableFacade() {
        super(Grouptable.class);
    }
    
}
