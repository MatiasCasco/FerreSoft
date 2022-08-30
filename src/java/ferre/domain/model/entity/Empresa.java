/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.entity;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author User
 */
public class Empresa extends BaseEntity<Integer> {
    
    private String empresaRuc = "0000000-0";
    private ArrayList<EmpresaContacto> contacto = new ArrayList();

    public Empresa() {
    }
    
    public Empresa(Integer id, String nombre) {
        super(id, nombre);
    }
    
    public Empresa(Integer id, String nombre, String empresaRuc) {
        super(id, nombre);
        this.empresaRuc = empresaRuc;
    }
    
    public Empresa(String empresaRuc, ArrayList<EmpresaContacto> contacto, Integer id, String nombre) {
        super(id, nombre);
        this.empresaRuc = empresaRuc;
        this.contacto = contacto;
    }

    public String getEmpresaRuc() {
        return empresaRuc;
    }

    public void setEmpresaRuc(String empresaRuc) {
        this.empresaRuc = empresaRuc;
    }

    public ArrayList<EmpresaContacto> getContacto() {
        return contacto;
    }

    public void setContacto(ArrayList<EmpresaContacto> contacto) {
        this.contacto = contacto;
    }

    @Override
    public String toString() {
        return new StringBuilder("{id: ").append(id)
            .append(", nombre: ").append(nombre)
            .append(", empresaRuc: ").append(empresaRuc)
            .append(", contacto: ").append(contacto)
            .append("}").toString();
    }
}
