/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.service;

import ferre.domain.model.entity.DetalleProducto;
import java.util.Collection;

/**
 *
 * @author Matias
 */
public interface DetalleProductoService {
    /**
     *
     * @param detalleProducto
     * @throws Exception
     */
    public void insert(DetalleProducto detalleProducto) throws Exception;

    /**
     *
     * @param detalleProducto
     * @throws Exception
     */
    public void update(DetalleProducto detalleProducto) throws Exception;

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
    public Collection<DetalleProducto> findByIdProducto(int idProducto) throws Exception;
    
    /**
     *  
     * @param idDetProducto
     * @return Empresa
     * @throws Exception
     */
    public DetalleProducto findByIdDetProducto(int idDetProducto) throws Exception;
    
    /**
     * 
     * @param idProducto
     * @param idMarca
     * @return Empresa
     * @throws Exception
     */
    public DetalleProducto findByIdProductoAndIdMarca(int idProducto, int idMarca) throws Exception;
    
     /**
     *  Criteria representa encontrar los cuestionarios de un curso
     * @return
     * @throws Exception
     */
    public Collection<DetalleProducto> getALL() throws Exception;  

}
