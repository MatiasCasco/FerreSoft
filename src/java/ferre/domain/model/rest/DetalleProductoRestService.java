/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.rest;

import ferre.domain.model.entity.DetalleProducto;
import ferre.domain.model.repository.JdbcDetalleProductoRepository;
import ferre.domain.model.service.DetalleProductoServiceImpl;
import java.util.ArrayList;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.PATCH;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import org.codehaus.jettison.json.JSONObject;

/**
 * REST Web Service
 *
 * @author Matias
 */
@Path("/DetalleProductoAPI")
public class DetalleProductoRestService {
    private final DetalleProductoServiceImpl detProductoService = new DetalleProductoServiceImpl(new JdbcDetalleProductoRepository());
    
    @POST
    @Path("/addDetProducto")
    @Consumes("application/json")
    @Produces("application/json")
    public DetalleProducto addDetProducto(DetalleProducto entity) throws Exception{
        detProductoService.add(entity);
        return entity;
    }
    
    @PUT
    @Path("/updateDetProducto")
    @Consumes("application/json")
    @Produces("application/json")
    public DetalleProducto updateDetProducto(DetalleProducto entity) throws Exception{
        detProductoService.update(entity);
        return entity;
    }
    
    @DELETE
    @Path("/deleteDetProducto/{id}")
    public void removeDetProducto(@PathParam("id") int id) throws Exception {
        detProductoService.delete(id);
    }
    

    @GET
    @Path("/detProductoByProducto/{ProductoId}")
    @Produces("application/json")
    public ArrayList<DetalleProducto> findByIdProducto(@PathParam("ProductoId") int ProductoId) throws Exception {         
         ArrayList<DetalleProducto> list = (ArrayList<DetalleProducto>) detProductoService.findByIdProducto(ProductoId);
        return list;
    }
    
    @POST
    @Path("/detProductoByProductoAndByMarca")
    @Consumes("application/json")
    @Produces({"application/json", "application/xml"})
     public DetalleProducto findByIdProductoAndIdMarca(String Json) throws Exception  {
        JSONObject ob = new JSONObject(Json);
        DetalleProducto detalleProducto = detProductoService.findByIdProductoAndIdMarca(ob.getInt("idProducto"), ob.getInt("idMarca"));
        return detalleProducto;
    }

    @GET
    @Path("/all")
    @Produces("application/json")
    public ArrayList<DetalleProducto> getALL() throws Exception {
        ArrayList<DetalleProducto> list = (ArrayList<DetalleProducto>) detProductoService.getALL();
        return list;
    }
    
    @POST
    @Path("/detProducto")
    @Consumes("application/json")
    @Produces({"application/json", "application/xml"})
     public DetalleProducto findByIdDetProducto(String Json) throws Exception  {
        JSONObject ob = new JSONObject(Json);
        DetalleProducto detalleProducto = detProductoService.findByIdDetProducto(ob.getInt("idDetProducto"));
        return detalleProducto;
    }
    
}
