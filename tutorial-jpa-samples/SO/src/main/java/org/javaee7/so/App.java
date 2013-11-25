package org.javaee7.so;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        EntityManagerFactory emf=Persistence.createEntityManagerFactory("samplePU");
//        EntityManager em=emf.createEntityManager();
//        String query="select count(cust) from Customer cust";
//        Query q=em.createQuery(query);
//        Long countObj=(Long) q.getSingleResult();
//        System.out.println(countObj);
        try {
            int a=4/0;
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println(e.toString());
        }
        catch(Error e){
            e.printStackTrace();
        }
    }
}
