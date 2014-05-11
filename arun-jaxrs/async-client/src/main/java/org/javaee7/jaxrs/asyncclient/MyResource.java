package org.javaee7.jaxrs.asyncclient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Arun Gupta
 */
@Path("fruits")
public class MyResource {
    private String[] response = { "apple", "banana", "mango" };
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getList() {
        return response[0];
    }

}
