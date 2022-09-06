/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.rest;

import ferre.domain.model.repository.JdbcImageRepository;
import ferre.domain.model.service.ImageServiceImpl;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import sun.net.www.content.image.jpeg;

/**
 * REST Web Service
 *
 * @author User
 */
@Path("/ImageAPI")
public class ImageRestService {
    
    private final ImageServiceImpl ImageService = new ImageServiceImpl(new JdbcImageRepository());
    
    @GET
    @Path("/image/{id}")
    @Produces("image/jpg")
    public InputStream getImagen(@PathParam("id") int id) throws Exception {
        InputStream targetStream = new ByteArrayInputStream(ImageService.image(id));
        return targetStream;
    }
    
//    @GET
//    @Path("/imageVer/{id}")
//    @Produces("image/jpeg")
//    public jpeg getImagenVer(@PathParam("id") int id) throws Exception {
//        ;
//        return ImageService.image(id);
//    }
}
