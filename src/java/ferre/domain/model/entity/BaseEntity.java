/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.entity;



/**
 *
 * @author Matias
 * @param <T>  
 */
public abstract class BaseEntity<T> extends Entity<T> {
    
    private boolean isModified;
    public String nombre;

    public BaseEntity() {
    }
    
    /**
     *
     * @param id
     * @param nombre
     */
    public BaseEntity(T id, String nombre) {
        super.id = id;
        this.nombre = nombre;
        isModified = false;
    }

    public boolean isIsModified() {
        return isModified;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
