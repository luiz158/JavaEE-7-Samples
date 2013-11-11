
package org.javaee7.crudexam.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.javaee7.crudexam.model.Book;

/**
 *
 * @author Masudul Haque
 */
@Stateless
public class BookFacade extends AbstractFacade<Book> {
    @PersistenceContext(unitName = "org.javaee7_CRUDExam_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BookFacade() {
        super(Book.class);
    }

}
