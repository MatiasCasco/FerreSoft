/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.repository;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Matias
 */
public interface EmpresaContactoRepository<EmpresaContacto, Integer> extends Repository<EmpresaContacto, Integer> {
    /**
     * Listar contactos de una empresa
     * @param idEmpresa
     * @return Collection
     * @throws Exception
     */
    public ArrayList<EmpresaContacto> getContactos(int idEmpresa) throws Exception;
    
    /**
     * Obtener un contacto especifico
     * @param idEmpresa
     * @throws Exception
     */
    public void removeContactosEmpresa(int idEmpresa) throws Exception;
}
