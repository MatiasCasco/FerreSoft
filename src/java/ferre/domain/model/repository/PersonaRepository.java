/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.repository;

import java.util.Collection;
/**
 *
 * @author HP
 * @param <Persona>
 * @param <Integer>
 */
public interface PersonaRepository <Persona , Integer> extends Repository<Persona, Integer>{
     public Collection<Persona> findByEmail(String email) throws Exception;
    
     public Collection<Persona> findByRol(int rol) throws Exception;
     
     public Collection<Persona> findByRUC(String ruc) throws Exception;
     
     public Collection<Persona> findByNombreRazonSocial(String nombreRasonSocial) throws Exception;
     
     public Collection<Persona> findByNombreApellido(String nombre, String apellido) throws Exception;
     
     public boolean ContainsPassword(int id, String password) throws Exception;
     
     public boolean ContainsRUC(String RUC) throws Exception;
     
     public Collection<Persona> getClientes() throws Exception;
     
     public Collection<Persona> getEmpleados() throws Exception;
}
