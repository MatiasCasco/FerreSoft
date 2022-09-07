/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.service;

import ferre.domain.model.entity.Producto;
import ferre.domain.model.repository.ProductoRepository;
import java.util.Collection;

/**
 *
 * @author Matias
 */
public class ProductoServiceImpl extends BaseService<Producto, Integer> implements ProductoService {
    ProductoRepository<Producto, Integer> ProductoRepository;
    public ProductoServiceImpl(ProductoRepository<Producto, Integer> ProductoRepository) {
        super(ProductoRepository);
        this.ProductoRepository = ProductoRepository;
    } 

    @Override
    public void insert(Producto producto) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int bandera = 0;
        if (ProductoRepository.contains(producto.getId()) == true) {
            bandera = 1;
            throw new Exception(String.format("Ya existe el producto %s ", producto.getProductoNombre()));
        }
               
        if(bandera == 0){
           ProductoRepository.add(producto);
        } 
    }

    @Override
    public void update(Producto producto) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int bandera = 0; 
        if (ProductoRepository.contains(producto.getId()) == false) {
            bandera = 1;
            throw new Exception(String.format("El producto no esta registrado %s ", producto.getProductoNombre()));
        }
        
        if(bandera == 0){
            ProductoRepository.update(producto);
        }
    }

    @Override
    public void delete(Integer id) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int bandera = 0; 
        if (!ProductoRepository.contains(id)) {
            bandera = 1;
            throw new Exception(String.format("No existe el producto con el identificador %d ", id));
        }
        if(bandera == 0){ProductoRepository.remove(id);}
    }

    @Override
    public Collection<Producto> findByIdMarca(int idMarca) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return ProductoRepository.findByIdMarca(idMarca);
    }

    @Override
    public Collection<Producto> findByIdCategoria(int idCategoria) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return ProductoRepository.findByIdCategoria(idCategoria);
    }

    @Override
    public Collection<Producto> getALL() throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return ProductoRepository.getAll();
    }

    @Override
    public Producto findByIdProducto(int idProducto) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return (Producto) ProductoRepository.get(idProducto);
    }
    
}
