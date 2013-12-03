
package org.javaee7.crudexam.sessions;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import org.javaee7.crudexam.model.Person;

/**
 *
 * @author Masudul Haque
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class PersonFacade {
    @PersistenceContext(unitName = "org.javaee7_CRUDExam_war_1.0-SNAPSHOTPU")
    EntityManager em;
    @Resource
    UserTransaction ut;
    
    public Person save(Person person){
        try {
            ut.begin();
            em.persist(person);
            ut.commit();
            em.close();
        } catch (Exception ex) {
            Logger.getLogger(PersonFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return person;
    }
    
}
