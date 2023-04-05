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
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("mobile/services")
public class MobileCatalogResource {

    @RestClient
    MobileCatalogService mobileCatalogService;

    @Inject
    JsonWebToken jwt; 

    /**
     * Get a paginated list of products
     */
    @GET
    @Path("/product")
    @Authenticated
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> readAll(@QueryParam("page") Integer page, @QueryParam("limit") Integer limit, @QueryParam("inventory") Boolean inventory) {
        return mobileCatalogService.readAll(page, limit, inventory);
    }

    /**
     * Get product by id
     */
    @Path("/product/{id}")
    @GET
    @Authenticated
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> getProductById(@PathParam("id") String id, @QueryParam("inventory") Boolean inventory){
        return mobileCatalogService.getProductById(id, inventory);
    }

    /**
     * Get product list
     */
    @Path("/product/list/{ids}")
    @GET
    @Authenticated 
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> getProductList(@PathParam("ids") String ids, @QueryParam("inventory") Boolean inventory){
        return mobileCatalogService.getProductList(ids, inventory);
    }

    @Path("/product/category/{categories}")
    @GET
    @Authenticated    
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response>  getProductsByCategory(@PathParam("categories") String categories,
            @QueryParam("inventory") Boolean inventory){
                return mobileCatalogService.getProductsByTag(inventory, categories);
            }

    @Path("/product/tag/{tags}")
    @GET
    @Authenticated    
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response>  getProductsByTag(@QueryParam("inventory") Boolean inventory, @PathParam("tags") String tags){
        return mobileCatalogService.getProductsByTag(inventory, tags);
    }

    @Path("/category/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Authenticated
    public Uni<Response>  getCategoryList(@Context SecurityContext ctx){        
        return mobileCatalogService.getCategoryList();       
        
    }

    private String getResponseString(SecurityContext ctx) {
        String name;
        if (ctx.getUserPrincipal() == null) { 
            name = "anonymous";
        } else if (!ctx.getUserPrincipal().getName().equals(jwt.getName())) { 
            throw new InternalServerErrorException("Principal and JsonWebToken names do not match");
        } else {
            name = ctx.getUserPrincipal().getName(); 
        }
        return String.format("hello + %s,"
            + " isHttps: %s,"
            + " authScheme: %s,"
            + " hasJWT: %s",
            name, ctx.isSecure(), ctx.getAuthenticationScheme(), hasJwt()); 
    }

    private boolean hasJwt() {
        return jwt.getClaimNames() != null;
    }

    

    


}