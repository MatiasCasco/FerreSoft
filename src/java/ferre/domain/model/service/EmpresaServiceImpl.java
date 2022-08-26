/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.service;

import ferre.domain.model.entity.Empresa;
import ferre.domain.model.entity.EmpresaContacto;
import ferre.domain.model.repository.EmpresaRepository;
import ferre.domain.model.repository.Repository;
import java.util.Collection;

/**
 *
 * @author User
 */
public class EmpresaServiceImpl extends BaseService<Empresa, Integer> implements EmpresaService{
    EmpresaRepository<Empresa, Integer> EmpresaRepository;
    public EmpresaServiceImpl(EmpresaRepository<Empresa, Integer> EmpresaRepository) {
        super(EmpresaRepository);
        this.EmpresaRepository = EmpresaRepository;
    }

    @Override
    public void insert(Empresa empresa) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int bandera = 0;
        if (EmpresaRepository.contains(empresa.getId()) == true) {
            bandera = 1;
            throw new Exception(String.format("Ya existe la empresa %s ", empresa.getEmpresaRuc()));
        }
               
        if(bandera == 0){
            EmpresaRepository.add(empresa);
        } 
    }

    @Override
    public void update(Empresa empresa) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int bandera = 0; 
        if (EmpresaRepository.contains(empresa.getId()) == false) {
            bandera = 1;
            throw new Exception(String.format("La empresa no esta registrada %s ", empresa.getEmpresaRuc()));
        }
        
        if(bandera == 0){
            EmpresaRepository.update(empresa);
        } 
    }

    @Override
    public void delete(Integer id) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int bandera = 0; 
        if (!EmpresaRepository.contains(id)) {
            bandera = 1;
            throw new Exception(String.format("No existe la empresa con el identificador %d ", id));
        }
        if(bandera == 0){EmpresaRepository.remove(id);}
    }

    @Override
    public Empresa findByName(String empresaNombre) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return EmpresaRepository.findByName(empresaNombre);
    }

    @Override
    public Empresa findByRuc(String empresaRuc) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return EmpresaRepository.findByRuc(empresaRuc); 
    }

    @Override
    public Collection<EmpresaContacto> getContactos(int idEmpresa) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return EmpresaRepository.getContactos(idEmpresa);
    }
    
}
