/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.books.begjee7;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Masudul Haque
 */
public class DSTest {
    public static void main(String[] args) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("beginning-javaee7-booksPU");
        EntityManager em=emf.createEntityManager();
        Query q= em.createNativeQuery("select * from usertable");
//        q.setFirstResult(i)
//        q.setMaxResults(i)
        List<Object[]> list=q.getResultList();
        for(Object[] obj:list){
//            String[] res=(String[]) obj;
            System.out.println(obj[0]);
            System.out.println(obj[1]);
        }
        System.out.println(q);
    }
}
