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
public interface ProductoRepository<Producto, Integer> extends Repository<Producto, Integer> {
//    
//    /**
//     *
//     * @param idProducto
//     * @return Boolean
//     * @throws Exception
//     */
//    public boolean ContainsId(int idProducto) throws Exception;
//    
//    /**
//     * 
//     * @param idProducto
//     * @return Producto
//     * @throws Exception
//     */
//    public Producto  getProducto(int idProducto) throws Exception;
//    
    /**
     * Todas los productos de una marca
     * @param idMarca
     * @return Collection
     * @throws Exception
     */
    public Collection<Producto> findByIdMarca(int idMarca) throws Exception;
    
    /**
     * Todas los productos de una categoria
     * @param idCategoria
     * @return Collection
     * @throws Exception
     */
    public Collection<Producto> findByIdCategoria(int idCategoria) throws Exception;
    
    /**
     * Todas las medidas asociadas a un producto
     * @param idProducto
     * @return Collection
     * @throws Exception
     */
    //public Collection<Metricas> getMetricas(int idProducto) throws Exception;
    
}
