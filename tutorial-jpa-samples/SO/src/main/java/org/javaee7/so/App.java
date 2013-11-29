package org.javaee7.so;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.javaee7.so.model.Customer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("samplePU");
        EntityManager em=emf.createEntityManager();
        String query="select cust from Customer cust";
        em.getTransaction().begin();
        Query q=em.createQuery(query);
        List<Customer> list= q.getResultList();
        em.close();
        em.getTransaction().commit();
        for (Customer customer : list) {
            System.out.println(customer.getName());
        }
        
      
    }
}
