/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.service;

import ferre.domain.model.entity.OrigenProducto;
import java.util.Collection;

/**
 *
 * @author Matias
 */
public interface OrigenProductoService {
    /**
     *
     * @param origenProducto
     * @throws Exception
     */
    public void insert(OrigenProducto origenProducto) throws Exception;

    /**
     *
     * @param origenProducto
     * @throws Exception
     */
    public void update(OrigenProducto origenProducto) throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    public void delete(Integer id) throws Exception;
    
    /**
     *  
     * @param empresaNombre
     * @return Collection
     * @throws Exception
     */
    public Collection<OrigenProducto> findByIdDetalleProducto(int idDetalleProducto) throws Exception;
 
    /**
     * 
     * @param idProducto
     * @return Collection
     * @throws Exception
     */
    public Collection<OrigenProducto> findByIdProducto(int idProducto) throws Exception;
    
     /**
     * @param idProducto
     * @param idEmpresa
     * @return Collection
     * @throws Exception
     */
    public Collection<OrigenProducto> findByIdProductoAndIdEmpresa(int idProducto, int idEmpresa) throws Exception;
    
    /**
     * 
     * @param idEmpresa
     * @return Collection
     * @throws Exception
     */
    public Collection<OrigenProducto> findByIdEmpresa(int idEmpresa) throws Exception;
} 
