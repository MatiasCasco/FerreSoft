/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.service;

import ferre.domain.model.entity.Producto;
import java.util.Collection;

/**
 *
 * @author Matias
 */
public interface ProductoService {
    /**
     *
     * @param producto
     * @throws Exception
     */
    public void insert(Producto producto) throws Exception;

    /**
     *
     * @param producto
     * @throws Exception
     */
    public void update(Producto producto) throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    public void delete(Integer id) throws Exception;
    
     /**
     *  
     * @param idProducto
     * @return Empresa
     * @throws Exception
     */
    public Producto findByIdProducto(int idProducto) throws Exception;
    
    /**
     *  
     * @param idMarca
     * @return Empresa
     * @throws Exception
     */
    public Collection<Producto> findByIdMarca(int idMarca) throws Exception;
 
    /**
     * Buscar el curso por su nombre
     * @param idCategoria
     * @return Empresa
     * @throws Exception
     */
    public Collection<Producto> findByIdCategoria(int idCategoria) throws Exception;
    
     /**
     *  Criteria representa encontrar los cuestionarios de un curso
     * @return
     * @throws Exception
     */
    public Collection<Producto> getALL() throws Exception;  
}
