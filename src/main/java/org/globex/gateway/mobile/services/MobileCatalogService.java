package org.globex.gateway.mobile.services;

import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import io.smallrye.mutiny.Uni;

@RegisterRestClient(configKey = "globex-store-api")
@Path("/services")
public interface MobileCatalogService {

    
    /**
     * Get a paginated list of products
     */
    @Path("/catalog/product")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    
    Uni<Response> readAll(@QueryParam("page") Integer page, @QueryParam("limit") Integer limit,
            @QueryParam("inventory") Boolean inventory);


    /**
     * Get product by id
     */
    @Path("/catalog/product/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Uni<Response>  getProductById(@PathParam("id") String id, @QueryParam("inventory") Boolean inventory);


    /**
     * Get product list
     */
    @Path("/catalog/product/list/{ids}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Uni<Response>  getProductList(@PathParam("ids") String ids, @QueryParam("inventory") Boolean inventory);


    @Path("/catalog/product/category/{categories}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Uni<Response>  getProductsByCategory(@PathParam("categories") String categories, @QueryParam("inventory") Boolean inventory);


    @GET
    @Path("/catalog/product/tag/{tags}")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<Response> getProductsByTag(@QueryParam("inventory") Boolean inventory, @PathParam("tags") String tags);
    
    @GET
    @Path("/catalog/category/list")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<Response> getCategoryList();
}
