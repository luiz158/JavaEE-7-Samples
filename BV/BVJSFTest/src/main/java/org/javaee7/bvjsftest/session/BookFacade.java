/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.bvjsftest.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.javaee7.bvjsftest.model.Book;

/**
 *
 * @author Masudul Haque
 */
@Stateless
public class BookFacade extends AbstractFacade<Book> {
    @PersistenceContext(unitName = "samplePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BookFacade() {
        super(Book.class);
    }
    
}
