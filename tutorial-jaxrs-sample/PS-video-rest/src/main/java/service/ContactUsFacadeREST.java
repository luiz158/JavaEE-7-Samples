/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.javaee7.psvideo.entities.ContactUs;

/**
 *
 * @author Masud
 */
@Stateless
@Path("contactus")
public class ContactUsFacadeREST extends AbstractFacade<ContactUs> {
    @PersistenceContext(unitName = "pcstorePU")
    private EntityManager em;

    public ContactUsFacadeREST() {
        super(ContactUs.class);
    }

    @POST
//    @Consumes({"application/xml", "application/json"})
    public void create(@FormParam("firstName") String firstName,@FormParam("lastName") String lastName) {
        ContactUs contactUs=new ContactUs();
        contactUs.setFirstName(firstName);
        contactUs.setLastName(lastName);
        em.persist(contactUs);
    }
//
//    @PUT
//    @Override
//    @Consumes({"application/xml", "application/json"})
//    public void edit(ContactUs entity) {
//        super.edit(entity);
//    }
//
//    @DELETE
//    @Path("{id}")
//    public void remove(@PathParam("id") Long id) {
//        super.remove(super.find(id));
//    }
//
//    @GET
//    @Path("{id}")
//    @Produces({"application/xml", "application/json"})
//    public ContactUs find(@PathParam("id") Long id) {
//        return super.find(id);
//    }
//
//    @GET
//    @Override
//    @Produces({"application/xml", "application/json"})
//    public List<ContactUs> findAll() {
//        return super.findAll();
//    }
//
//    @GET
//    @Path("{from}/{to}")
//    @Produces({"application/xml", "application/json"})
//    public List<ContactUs> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
//        return super.findRange(new int[]{from, to});
//    }
//
    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
