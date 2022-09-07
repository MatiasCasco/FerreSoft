/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.service;

import ferre.domain.model.entity.DetalleProducto;
import ferre.domain.model.repository.DetalleProductoRepository;
import java.util.Collection;

/**
 *
 * @author User
 */
public class DetalleProductoServiceImpl extends BaseService<DetalleProducto, Integer> implements DetalleProductoService {
    DetalleProductoRepository<DetalleProducto, Integer> DetalleProductoRepository;
    public DetalleProductoServiceImpl(DetalleProductoRepository<DetalleProducto, Integer> DetalleProductoRepository) {
        super(DetalleProductoRepository);
        this.DetalleProductoRepository = DetalleProductoRepository;
    } 

    @Override
    public void insert(DetalleProducto detalleProducto) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int bandera = 0;
        if (DetalleProductoRepository.contains(detalleProducto.getId()) == true) {
            bandera = 1;
            throw new Exception(String.format("Ya existe el detalle del producto %s ", detalleProducto.getProducto().getProductoNombre()));
        }
               
        if(bandera == 0){
           DetalleProductoRepository.add(detalleProducto);
        }
    }

    @Override
    public void update(DetalleProducto detalleProducto) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int bandera = 0; 
        if (DetalleProductoRepository.contains(detalleProducto.getId()) == false) {
            bandera = 1;
            throw new Exception(String.format("El detalle del producto no esta registrado %s ", detalleProducto.getProducto().getProductoNombre()));
        }
        
        if(bandera == 0){
            DetalleProductoRepository.update(detalleProducto);
        }
    }

    @Override
    public void delete(Integer id) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int bandera = 0; 
        if (!DetalleProductoRepository.contains(id)) {
            bandera = 1;
            throw new Exception(String.format("No existe el detalle del producto con el identificador %d ", id));
        }
        if(bandera == 0){DetalleProductoRepository.remove(id);}
    }

    @Override
    public Collection<DetalleProducto> findByIdProducto(int idProducto) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return DetalleProductoRepository.findByIdProducto(idProducto);
    }

    @Override
    public DetalleProducto findByIdProductoAndIdMarca(int idProducto, int idMarca) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return DetalleProductoRepository.findByIdProductoAndIdMarca(idProducto, idMarca);
    }

    @Override
    public Collection<DetalleProducto> getALL() throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return DetalleProductoRepository.getAll();
    }

    @Override
    public DetalleProducto findByIdDetProducto(int idDetProducto) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return (DetalleProducto) DetalleProductoRepository.get(idDetProducto);
    }
    
}
