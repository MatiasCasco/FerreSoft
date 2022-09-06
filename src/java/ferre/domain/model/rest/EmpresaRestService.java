/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.rest;

import ferre.domain.model.entity.Empresa;
import ferre.domain.model.entity.EmpresaContacto;
import ferre.domain.model.repository.JdbcEmpresaRepository;
import ferre.domain.model.service.EmpresaServiceImpl;
import java.util.ArrayList;

import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import org.codehaus.jettison.json.JSONObject;

/**
 * REST Web Service
 *
 * @author Matias
 */
@Path("/EmpresaAPI")
public class EmpresaRestService {
    
    private final EmpresaServiceImpl empresaService = new EmpresaServiceImpl(new JdbcEmpresaRepository());
    
    
    @POST
    @Path("/addEmpresa")
    @Consumes("application/json")
    @Produces("application/json")
    public Empresa addEmpresa(Empresa entity) throws Exception{
        empresaService.add(entity);
        return entity;
    }
    
    @PUT
    @Path("/updateEmpresa")
    @Consumes("application/json")
    @Produces("application/json")
    public Empresa updateEmpresa(Empresa entity) throws Exception{
        empresaService.update(entity);
        return entity;
    }
    
    @DELETE
    @Path("/deleteEmpresa/{id}")
    public void removeEmpresa(@PathParam("id") int id) throws Exception {
        empresaService.delete(id);
    }
    

    @GET
    @Path("/empresaByName/{Nombre}")
    @Produces("application/json")
    public Empresa empresaByNombre(@PathParam("Nombre") String Nombre) throws Exception {
        Empresa empresa = new Empresa(); 
        empresa = empresaService.findByName(Nombre);
        return empresa;
    }
    
    @POST
    @Path("/empresaByRuc")
    @Consumes("application/json")
    @Produces({"application/json", "application/xml"})
    public Empresa empresaBYRuc(String Json) throws Exception  {
        JSONObject ob = new JSONObject(Json);
        Empresa empresa = empresaService.findByRuc(ob.getString("Ruc"));
        return empresa;
    }

    @POST
    @Path("/contactos")
    @Consumes("application/json")
    @Produces("application/json")
    public ArrayList<EmpresaContacto> contactos(String Json) throws Exception {
        JSONObject ob = new JSONObject(Json);
        ArrayList<EmpresaContacto> contactos = (ArrayList<EmpresaContacto>) empresaService.getContactos(ob.getInt("idEmpresa"));
        return contactos;
    }
    
    @POST
    @Path("/contactosXML")
    @Consumes("application/json")
    @Produces({"application/xml", "application/json"})
    public ArrayList<EmpresaContacto> contactosXML(String Json) throws Exception {
        JSONObject ob = new JSONObject(Json);
        ArrayList<EmpresaContacto> contactos = (ArrayList<EmpresaContacto>) empresaService.getContactos(ob.getInt("idEmpresa"));
        return contactos;
    }
}
