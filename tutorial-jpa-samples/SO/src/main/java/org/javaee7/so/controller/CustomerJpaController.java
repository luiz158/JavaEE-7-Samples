/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.javaee7.so.controller;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.javaee7.so.controller.exceptions.NonexistentEntityException;
import org.javaee7.so.controller.exceptions.PreexistingEntityException;
import org.javaee7.so.model.Customer;
import org.javaee7.so.model.DiscountCode;
import org.javaee7.so.model.MicroMarket;

/**
 *
 * @author Masud
 */
public class CustomerJpaController implements Serializable {

    public CustomerJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Customer customer) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DiscountCode discountCode = customer.getDiscountCode();
            if (discountCode != null) {
                discountCode = em.getReference(discountCode.getClass(), discountCode.getDiscountCode());
                customer.setDiscountCode(discountCode);
            }
            MicroMarket microMarket = customer.getMicroMarket();
            if (microMarket != null) {
                microMarket = em.getReference(microMarket.getClass(), microMarket.getZipCode());
                customer.setMicroMarket(microMarket);
            }
            em.persist(customer);
            if (discountCode != null) {
                discountCode.getCustomerList().add(customer);
                discountCode = em.merge(discountCode);
            }
            if (microMarket != null) {
                microMarket.getCustomerList().add(customer);
                microMarket = em.merge(microMarket);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCustomer(customer.getCustomerId()) != null) {
                throw new PreexistingEntityException("Customer " + customer + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Customer customer) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Customer persistentCustomer = em.find(Customer.class, customer.getCustomerId());
            DiscountCode discountCodeOld = persistentCustomer.getDiscountCode();
            DiscountCode discountCodeNew = customer.getDiscountCode();
            MicroMarket microMarketOld = persistentCustomer.getMicroMarket();
            MicroMarket microMarketNew = customer.getMicroMarket();
            if (discountCodeNew != null) {
                discountCodeNew = em.getReference(discountCodeNew.getClass(), discountCodeNew.getDiscountCode());
                customer.setDiscountCode(discountCodeNew);
            }
            if (microMarketNew != null) {
                microMarketNew = em.getReference(microMarketNew.getClass(), microMarketNew.getZipCode());
                customer.setMicroMarket(microMarketNew);
            }
            customer = em.merge(customer);
            if (discountCodeOld != null && !discountCodeOld.equals(discountCodeNew)) {
                discountCodeOld.getCustomerList().remove(customer);
                discountCodeOld = em.merge(discountCodeOld);
            }
            if (discountCodeNew != null && !discountCodeNew.equals(discountCodeOld)) {
                discountCodeNew.getCustomerList().add(customer);
                discountCodeNew = em.merge(discountCodeNew);
            }
            if (microMarketOld != null && !microMarketOld.equals(microMarketNew)) {
                microMarketOld.getCustomerList().remove(customer);
                microMarketOld = em.merge(microMarketOld);
            }
            if (microMarketNew != null && !microMarketNew.equals(microMarketOld)) {
                microMarketNew.getCustomerList().add(customer);
                microMarketNew = em.merge(microMarketNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = customer.getCustomerId();
                if (findCustomer(id) == null) {
                    throw new NonexistentEntityException("The customer with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Customer customer;
            try {
                customer = em.getReference(Customer.class, id);
                customer.getCustomerId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The customer with id " + id + " no longer exists.", enfe);
            }
            DiscountCode discountCode = customer.getDiscountCode();
            if (discountCode != null) {
                discountCode.getCustomerList().remove(customer);
                discountCode = em.merge(discountCode);
            }
            MicroMarket microMarket = customer.getMicroMarket();
            if (microMarket != null) {
                microMarket.getCustomerList().remove(customer);
                microMarket = em.merge(microMarket);
            }
            em.remove(customer);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Customer> findCustomerEntities() {
        return findCustomerEntities(true, -1, -1);
    }

    public List<Customer> findCustomerEntities(int maxResults, int firstResult) {
        return findCustomerEntities(false, maxResults, firstResult);
    }

    private List<Customer> findCustomerEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Customer.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Customer findCustomer(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Customer.class, id);
        } finally {
            em.close();
        }
    }

    public int getCustomerCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Customer> rt = cq.from(Customer.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
