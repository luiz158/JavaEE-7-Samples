/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.customermanager.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.javaee7.customermanager.entities.MicroMarket;

/**
 *
 * @author Masud
 */
@Stateless
public class MicroMarketFacade extends AbstractFacade<MicroMarket> {
    @PersistenceContext(unitName = "org.javaee7_CustomerManager_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MicroMarketFacade() {
        super(MicroMarket.class);
    }
    
}
