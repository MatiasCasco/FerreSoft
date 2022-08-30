/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.repository;

import java.util.Collection;

/**
 *
 * @author User
 */
public interface OrigenProductoRepository<OrigenProducto, Integer> extends Repository<OrigenProducto, Integer> {
    
    /**
     * Informacion sobre un producto y sus proveedores
     * @param idDetalleProducto
     * @return Collection
     * @throws Exception
     */
    public Collection<OrigenProducto> findByIdDetalleProducto(int idDetalleProducto) throws Exception;
    
     /**
     * Informacion sobre un producto y sus proveedores
     * @param idProducto
     * @return Collection
     * @throws Exception
     */
    public Collection<OrigenProducto> findByIdProducto(int idProducto) throws Exception;
    
    /**
     * Informacion sobre un producto y sus proveedores
     * @param idProducto
     * @param idEmpresa
     * @return Collection
     * @throws Exception
     */
    public Collection<OrigenProducto> findByIdProductoAndIdEmpresa(int idProducto, int idEmpresa) throws Exception;
    
    /**
     * Informacion sobre un producto y sus proveedores
     * @param idEmpresa
     * @return Collection
     * @throws Exception
     */
    public Collection<OrigenProducto> findByIdEmpresa(int idEmpresa) throws Exception;
}
