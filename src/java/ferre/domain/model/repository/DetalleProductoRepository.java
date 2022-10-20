/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.repository;

import ferre.domain.model.entity.DetalleProducto;
import java.util.Collection;

/**
 *
 * @author User
 */
public interface DetalleProductoRepository<DetalleProducto, Integer> extends Repository<DetalleProducto, Integer> {
    
    /**
     * Busqueda por id producto
     * @param idProducto
     * @return Collection
     * @throws Exception
     */
    public Collection<DetalleProducto> findByIdProducto(int idProducto) throws Exception;
    
    /**
     * Todas los productos de una categoria
     * @param idProducto
     * @param idMarca
     * @return Collection
     * @throws Exception
     */
    public DetalleProducto findByIdProductoAndIdMarca (int idProducto, int idMarca) throws Exception;
    
    
    
    
    public Collection<DetalleProducto> getAlldetais() throws Exception;
    
    
    
    

}
