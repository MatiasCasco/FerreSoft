/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.rest;

import ferre.domain.model.entity.Persona;
import ferre.domain.model.repository.JdbcPersonaRepository;
import ferre.domain.model.service.PersonaServiceImpl;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author HP
 */
@Path("/PersonaApi")
public class PersonaRest {
    private final PersonaServiceImpl personaService = new PersonaServiceImpl(new JdbcPersonaRepository());
    @GET
    @Path("/empleados")
    @Produces("application/json")
    public ArrayList<Persona> getEmpleados() throws Exception {
        ArrayList<Persona> list = (ArrayList<Persona>) personaService.getEmpleados();
        return list;
    }
    
    @GET
    @Path("/clientes")
    @Produces("application/json")
    public ArrayList<Persona> getClientes() throws Exception {
        ArrayList<Persona> list = (ArrayList<Persona>) personaService.getClientes();
        return list;
    }
    

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EmpleadoRest
     */
    public PersonaRest() {
    }

    /**
     * Retrieves representation of an instance of ferre.domain.rest.PersonaRest
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of PersonaRest
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
