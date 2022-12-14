/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.rest;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Matias
 */

public class FerreApp extends Application {
    
    private Set<Object> singletons = new HashSet<Object>();

    public FerreApp() {
        singletons.add(new EmpresaRestService());
        singletons.add(new OrigenProductoRestService());
        singletons.add(new ImageRestService());
        singletons.add(new ProductoRestService());
        singletons.add(new DetalleProductoRestService());
        singletons.add(new PersonaRest());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
 
}
