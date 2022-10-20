/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.entity;

/**
 *
 * @author HP
 * Persona puede ser Cliente o Empleado
 */
public class Persona extends BaseEntity<Integer>{
    private String apellido;
    private int rol;
    private String password;
    //datosdelCliente
    private String nombreRasonSocial;
    private String ruc;
    private String direccion;
    private String movil;
    private String email;
    private byte[] foto/* = {}*/;

    public Persona(){
        
    }
    
    public Persona(Integer id, String nombre) {
        super(id, nombre);
    }
//Empleado
    public Persona(Integer id, String nombre, String apellido, int rol, String password, String direccion, String movil, String email) {
        super(id, nombre);
        this.apellido = apellido;
        this.rol = rol;
        this.password = password;
        this.direccion = direccion;
        this.movil = movil;
        this.email = email;
    }
     public Persona(Integer id, String nombre, String apellido, int rol, String password, String direccion, String movil, String email, byte[] foto) {
        super(id, nombre);
        this.apellido = apellido;
        this.rol = rol;
        this.password = password;
        this.direccion = direccion;
        this.movil = movil;
        this.email = email;
        this.foto=foto;
    }
     public Persona(Integer id, String nombre,String apellido, int rol, String password) {
        super(id, nombre);
        this.apellido = apellido;
        this.rol = rol;
        this.password = password;
    }
//Cliente

    public Persona(Integer id,String nombreRasonSocial, String ruc, String direccion, String movil, String email) {
        super(id, nombreRasonSocial);
        this.nombreRasonSocial = nombreRasonSocial;
        this.ruc = ruc;
        this.direccion = direccion;
        this.movil = movil;
        this.email = email;
    }
    
     public Persona(String nombreRasonSocial, String ruc, String direccion, String movil, String email) {
        this.nombreRasonSocial = nombreRasonSocial;
        this.ruc = ruc;
        this.direccion = direccion;
        this.movil = movil;
        this.email = email;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
     

  

    
    
    
    
    
    
    
    
    
    
    
    
    
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreRazonSocial() {
        return nombreRasonSocial;
    }

    public void setNombreRazonSocial(String nombreRasonSocial) {
        this.nombreRasonSocial = nombreRasonSocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

  
    
    
    
    
    @Override
    public String toString() {
       

        return new StringBuilder("{id: ").append(id)
                .append(", nombre: ").append(nombre)
                .append(", apellido: ").append(apellido)
                .append(", email: ").append(email)
                .append(", rol: ").append(rol)
                .append(", passwd: ").append(password)
                .append("}").toString();
    }


    
}
