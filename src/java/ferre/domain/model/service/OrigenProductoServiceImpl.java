/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.service;

import ferre.domain.model.entity.Empresa;
import ferre.domain.model.entity.EmpresaContacto;
import ferre.domain.model.entity.OrigenProducto;
import ferre.domain.model.repository.OrigenProductoRepository;
import java.util.Collection;

/**
 *
 * @author User
 */
public class OrigenProductoServiceImpl extends BaseService<OrigenProducto, Integer> implements OrigenProductoService {
    
    OrigenProductoRepository<OrigenProducto, Integer> OrigenProductoRepository;
    
    public OrigenProductoServiceImpl(OrigenProductoRepository<OrigenProducto, Integer> OrigenProductoRepository) {
        super(OrigenProductoRepository);
        this.OrigenProductoRepository = OrigenProductoRepository;
    }

    @Override
    public void insert(OrigenProducto origenProducto) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int bandera = 0;
        if (OrigenProductoRepository.contains(origenProducto.getId()) == true) {
            bandera = 1;
            throw new Exception(String.format("Ya existe en origen del producto"));
        }    
        if(bandera == 0){
            OrigenProductoRepository.add(origenProducto);
        }
    }

    @Override
    public void update(OrigenProducto origenProducto) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int bandera = 0;
        if (OrigenProductoRepository.contains(origenProducto.getId()) == false) {
            bandera = 1;
            throw new Exception(String.format("No esta registrado el origen del producto"));
        }    
        if(bandera == 0){
            OrigenProductoRepository.update(origenProducto);
        }
    }

    @Override
    public void delete(Integer id) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int bandera = 0; 
        if (!OrigenProductoRepository.contains(id)) {
            bandera = 1;
            throw new Exception(String.format("No existe el origen del producto con el identificador %d ", id));
        }
        if(bandera == 0){OrigenProductoRepository.remove(id);}
    }

    @Override
    public Collection<OrigenProducto> findByIdDetalleProducto(int idDetalleProducto) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return OrigenProductoRepository.findByIdDetalleProducto(idDetalleProducto);
    }

    @Override
    public Collection<OrigenProducto> findByIdProducto(int idProducto) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return OrigenProductoRepository.findByIdProducto(idProducto);
    }

    @Override
    public Collection<OrigenProducto> findByIdProductoAndIdEmpresa(int idProducto, int idEmpresa) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return OrigenProductoRepository.findByIdProductoAndIdEmpresa(idProducto, idEmpresa);
    }

    @Override
    public Collection<OrigenProducto> findByIdEmpresa(int idEmpresa) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return OrigenProductoRepository.findByIdEmpresa(idEmpresa);
    }

    @Override
    public OrigenProducto findByIdOrigenProducto(int idOrigenProducto) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return (OrigenProducto) OrigenProductoRepository.get(idOrigenProducto);
    }
     
}    
    
    
