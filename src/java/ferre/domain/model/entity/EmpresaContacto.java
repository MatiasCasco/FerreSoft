/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.entity;

/**
 *
 * @author User
 */
public class EmpresaContacto {
    
    private int empresaContactoId;
    private int empresaId;
    private String contactoNombre;
    private String contactoPhone;
    private String contactoEmail;

    public EmpresaContacto() {
    }

    public EmpresaContacto(int empresaContactoId, int empresaId, String contactoNombre, String contactoPhone, String contactoEmail) {
        this.empresaContactoId = empresaContactoId;
        this.empresaId = empresaId;
        this.contactoNombre = contactoNombre;
        this.contactoPhone = contactoPhone;
        this.contactoEmail = contactoEmail;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }

    public int getEmpresaContactoId() {
        return empresaContactoId;
    }

    public void setEmpresaContactoId(int empresaContactoId) {
        this.empresaContactoId = empresaContactoId;
    }

    public String getContactoNombre() {
        return contactoNombre;
    }

    public void setContactoNombre(String contactoNombre) {
        this.contactoNombre = contactoNombre;
    }

    public String getContactoPhone() {
        return contactoPhone;
    }

    public void setContactoPhone(String contactoPhone) {
        this.contactoPhone = contactoPhone;
    }

    public String getContactoEmail() {
        return contactoEmail;
    }

    public void setContactoEmail(String contactoEmail) {
        this.contactoEmail = contactoEmail;
    }

    @Override
    public String toString() {
        return new StringBuilder("{empresaContactoId: ").append(empresaContactoId)
                .append(", empresaId: ").append(empresaId)
                .append(", contactoNombre: ").append(contactoNombre)
                .append(", contactoPhone: ").append(contactoPhone)
                .append(", contactoEmail: ").append(contactoEmail)
                .append("}").toString();
    }  
}
