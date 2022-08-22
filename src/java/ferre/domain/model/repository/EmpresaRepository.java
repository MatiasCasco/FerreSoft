/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.repository;

import ferre.domain.model.entity.EmpresaContacto;
import java.util.Collection;

/**
 *
 * @author Matias
 */
public interface EmpresaRepository<Empresa, Integer> extends Repository<Empresa, Integer> {
     /**
     * Burcar empresa por nombre de la empresa
     * @param EmpresaNombre
     * @return Collection
     * @throws Exception
     */
    public Empresa findByName(String EmpresaNombre) throws Exception;
    
    /**
     * Burcar empresa por nro de ruc
     * @param EmpresaRuc
     * @return Collection
     * @throws Exception
     */
    public Empresa findByRuc(String EmpresaRuc) throws Exception;
    
        
     /**
     * Listar contactos de una empresa
     * @param idEmpresa
     * @return Collection
     * @throws Exception
     */
    public Collection<EmpresaContacto> getContactos(int idEmpresa) throws Exception;
}
