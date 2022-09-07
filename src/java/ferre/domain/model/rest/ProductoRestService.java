/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.rest;

import ferre.domain.model.entity.Producto;
import ferre.domain.model.repository.JdbcProductoRepository;
import ferre.domain.model.service.ProductoServiceImpl;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import org.codehaus.jettison.json.JSONObject;

/**
 * REST Web Service
 *
 * @author Matias
 */
@Path("/ProductoAPI")
public class ProductoRestService {
    private final ProductoServiceImpl productoService = new ProductoServiceImpl(new JdbcProductoRepository());
    
    @POST
    @Path("/addProducto")
    @Consumes("application/json")
    @Produces("application/json")
    public Producto addProducto(Producto entity) throws Exception{
        productoService.add(entity);
        return entity;
    }
    
    @PUT
    @Path("/updateProducto")
    @Consumes("application/json")
    @Produces("application/json")
    public Producto updateProducto(Producto entity) throws Exception{
        productoService.update(entity);
        return entity;
    }
    
    @DELETE
    @Path("/deleteProducto/{id}")
    public void removeProducto(@PathParam("id") int id) throws Exception {
        productoService.delete(id);
    }
    
    @GET
    @Path("/productoByMarca/{MarcaId}")
    @Produces("application/json")
    public ArrayList<Producto> findByIdMarca(@PathParam("MarcaId") int MarcaId) throws Exception {         
         ArrayList<Producto> list = (ArrayList<Producto>) productoService.findByIdMarca(MarcaId);
        return list;
    }
    
    @POST
    @Path("/productoByCategoria")
    @Consumes("application/json")
    @Produces({"application/json", "application/xml"})
     public ArrayList<Producto> findByIdCategoria(String Json) throws Exception  {
        JSONObject ob = new JSONObject(Json);
        ArrayList<Producto> list = (ArrayList<Producto>) productoService.findByIdCategoria(ob.getInt("idCategoria"));
        return list;
    }

    @GET
    @Path("/all")
    @Produces("application/json")
    public ArrayList<Producto> getALL() throws Exception {
        ArrayList<Producto> list = (ArrayList<Producto>) productoService.getALL();
        return list;
    }
    
    @POST
    @Path("/productoById")
    @Consumes("application/json")
    @Produces("application/json")
    public Producto findByIdMarca(String Json) throws Exception {         
        JSONObject ob = new JSONObject(Json);
        Producto producto = productoService.findByIdProducto(ob.getInt("idProducto"));
        return producto;
    }
}
