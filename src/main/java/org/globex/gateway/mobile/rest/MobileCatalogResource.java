package org.globex.gateway.mobile.rest;

import io.quarkus.security.Authenticated;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.globex.gateway.mobile.services.MobileCatalogService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("mobile")
public class MobileCatalogResource {

    @RestClient
    MobileCatalogService mobileCatalogService;

    @Inject
    JsonWebToken jwt; 

    @Path("/services/product/category/{categories}")
    @GET
    @Authenticated    
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response>  getProductsByCategory(@PathParam("categories") String categories,
            @QueryParam("inventory") Boolean inventory){
                return mobileCatalogService.getProductsByTag(inventory, categories);
            }

    @Path("/services/category/list")
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Authenticated
    public Uni<Response>  getCategoryList(@Context SecurityContext ctx){        
        return mobileCatalogService.getCategoryList();       
        
    }

}