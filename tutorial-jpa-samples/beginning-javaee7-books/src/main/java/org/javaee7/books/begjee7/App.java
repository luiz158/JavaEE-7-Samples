package org.javaee7.books.begjee7;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.javaee7.books.begjee7.entities.Address;
import org.javaee7.books.begjee7.entities.Doctor;
import org.javaee7.books.begjee7.entities.ExDoctor;
import org.javaee7.books.begjee7.entities.InDoctor;
import org.javaee7.books.begjee7.entities.Member;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("beginning-javaee7-booksPU");
        EntityManager em=emf.createEntityManager();
        Member member=new Member();
        member.setFirstName("Fazle");
        member.setLastName("Rabbi");
        em.getTransaction().begin();
        em.detach(member);
        em.persist(member);
        em.getTransaction().commit();
        System.out.println(em.contains(member));
        em.detach(member);
        System.out.println(em.contains(member));
          em.close();
          emf.close();
        
    }
}
