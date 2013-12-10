/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.javaee7.servlet.fileupload.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.javaee7.servlet.fileupload.Profile;

/**
 *
 * @author Masudul Haque
 */
@Stateless
public class FileUploadBean {
     @PersistenceContext(unitName = "samplePU")
     EntityManager em;
    
     public Profile save(Profile profile){
         em.persist(profile);
         return profile;
     }
}
