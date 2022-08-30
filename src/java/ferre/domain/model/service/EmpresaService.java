/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.service;

import ferre.domain.model.entity.Empresa;
import ferre.domain.model.entity.EmpresaContacto;
import java.util.Collection;

/**
 *
 * @author Matias
 */
public interface EmpresaService {
    /**
     *
     * @param empresa
     * @throws Exception
     */
    public void insert(Empresa empresa) throws Exception;

    /**
     *
     * @param empresa
     * @throws Exception
     */
    public void update(Empresa empresa) throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    public void delete(Integer id) throws Exception;
    
    /**
     *  
     * @param empresaNombre
     * @return Empresa
     * @throws Exception
     */
    public Empresa findByName(String empresaNombre) throws Exception;
 
    /**
     * Buscar el curso por su nombre
     * @param empresaRuc
     * @return Empresa
     * @throws Exception
     */
    public Empresa findByRuc(String empresaRuc) throws Exception;
    
     /**
     *  Criteria representa encontrar los cuestionarios de un curso
     * @param idEmpresa
     * @return
     * @throws Exception
     */
    public Collection<EmpresaContacto> getContactos(int idEmpresa) throws Exception;
    
}
