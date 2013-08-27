package org.javaee7.books.begjee7;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.javaee7.books.begjee7.entities.Book;

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
        
//        Book book = new Book("Begining Java EE 7", "A guide to learn Java EE 7", 12.5F,
//                         "1-84023-742-2", 354, false);
//        em.getTransaction().begin();
//        em.persist(book);
//        em.getTransaction().commit();
//        em.close();
//        emf.close();
    }
}
