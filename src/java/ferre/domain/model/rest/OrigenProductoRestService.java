/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.rest;

import ferre.domain.model.entity.OrigenProducto;
import ferre.domain.model.repository.JdbcOrigenProductoRepository;
import ferre.domain.model.service.OrigenProductoServiceImpl;
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
@Path("/OrigenProductoAPI")
public class OrigenProductoRestService {

    private final OrigenProductoServiceImpl OrigenProductoService = new OrigenProductoServiceImpl(new JdbcOrigenProductoRepository());
    
    @POST
    @Path("/addOrigenProducto")
    @Consumes("application/json")
    @Produces("application/json")
    public OrigenProducto addOrigenProducto(OrigenProducto entity) throws Exception {
        OrigenProductoService.add(entity);
        return entity;
    }
    
    @PUT
    @Path("/updateOrigenProducto")
    @Consumes("application/json")
    @Produces("application/json")
    public OrigenProducto updateOrigenProducto(OrigenProducto entity) throws Exception{
        OrigenProductoService.update(entity);
        return entity;
    }
    
    @DELETE
    @Path("/deleteOrigenProducto/{id}")
    public void removeOrigenProducto(@PathParam("id") int id) throws Exception {
        OrigenProductoService.delete(id);
    }
    
    @GET
    @Path("/opByDetalleProducto/{IdDetalle}")
    @Produces("application/json")
    public ArrayList<OrigenProducto> opByIdDetalleProducto(@PathParam("IdDetalle") int IdDetalle) throws Exception {
        ArrayList<OrigenProducto> listOP = (ArrayList<OrigenProducto>) OrigenProductoService.findByIdDetalleProducto(IdDetalle);
        return listOP;
    }
    
    @POST
    @Path("/opByProducto")
    @Consumes("application/json")
    @Produces("application/json")
    public ArrayList<OrigenProducto> opByProducto(String Json) throws Exception {
        JSONObject ob = new JSONObject(Json);
        ArrayList<OrigenProducto> listOP = (ArrayList<OrigenProducto>) OrigenProductoService.findByIdProducto(ob.getInt("idProducto"));
        return listOP;
    }
    
    @POST
    @Path("/opByProductoAndByEmpresa")
    @Consumes("application/json")
    @Produces("application/json")
    public ArrayList<OrigenProducto> opByProductoAndByEmpresa(String Json) throws Exception {
        JSONObject ob = new JSONObject(Json);
        ArrayList<OrigenProducto> listOP = (ArrayList<OrigenProducto>) OrigenProductoService.findByIdProductoAndIdEmpresa(ob.getInt("idProducto"), ob.getInt("idEmpresa"));
        return listOP;
    }
    
    @POST
    @Path("/opByEmpresa")
    @Consumes("application/json")
    @Produces("application/json")
    public ArrayList<OrigenProducto> opByEmpresa(String Json) throws Exception {
        JSONObject ob = new JSONObject(Json);
        ArrayList<OrigenProducto> listOP = (ArrayList<OrigenProducto>) OrigenProductoService.findByIdEmpresa(ob.getInt("idEmpresa"));
        return listOP;
    }
    
    @POST
    @Path("/origenProductoById")
    @Consumes("application/json")
    @Produces("application/json")
    public OrigenProducto opByOrigenProducto(String Json) throws Exception {
        JSONObject ob = new JSONObject(Json);
        OrigenProducto OP =  OrigenProductoService.findByIdOrigenProducto(ob.getInt("idOrigenProducto"));
        return OP;
    }
//    
//    @GET
//    @Produces("application/xml")
//    public String getXml() {
//        //TODO return proper representation object
//        throw new UnsupportedOperationException();
//    }
//
//    /**
//     * PUT method for updating or creating an instance of OrigenProductoRestService
//     * @param content representation for the resource
//     * @return an HTTP response with content of the updated or created resource.
//     */
//    @PUT
//    @Consumes("application/xml")
//    public void putXml(String content) {
//    }
}
