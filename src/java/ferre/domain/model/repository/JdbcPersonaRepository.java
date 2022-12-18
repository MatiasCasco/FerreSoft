/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.repository;

import ferre.domain.model.entity.Entity;
import ferre.domain.model.entity.Persona;
import ferre.util.DBUtils;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class JdbcPersonaRepository implements PersonaRepository<Persona, Integer>{

    @Override
    public Collection<Persona> findByEmail(String email) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Persona> findByRol(int rol) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Persona> findByRUC(String ruc) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Persona> findByNombreRazonSocial(String nombreRasonSocial) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Persona> findByNombreApellido(String nombre, String apellido) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ContainsPassword(int id, String password) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ContainsRUC(String RUC) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(Persona entity) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //rol(1,2,3)admin,empleado,Cliente
        if(entity.getRol()==3){
            addCliente(entity);
        }else{
            addEmpleado(entity);
        }
    }

    @Override
    public void remove(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Persona entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entity get(Integer id) {
        Entity retValue = null;
        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
       

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("select * from empleado where Empleadoid = ?");

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                
              retValue=new Persona( rs.getInt("EmpleadoId"),rs.getString("EmpleadoNombre"));// rs.getString("apellido"), rs.getString("email"),  rs.getInt("rol"), rs.getString("descripcion"),rs.getString("password"),rs.getInt("id"), rs.getString("login_name"), rs.getInt("idCurso"));                      
              
              //retValue =  new Persona( rs.getString("nombre"), rs.getString("apellido"), rs.getString("email"),  rs.getInt("rol"), rs.getString("descripcion"),rs.getString("password"),rs.getInt("id"), rs.getString("login_name"));
                
                
            } else {
               retValue = new Persona(null,null);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                DBUtils.closeConnection(c);
            } catch (SQLException ex) {
                //Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return retValue;

       
    }
    



    @Override
    public Collection<Persona> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void addCliente(Persona entity) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c = null;
        PreparedStatement pstmt = null;
        FileInputStream fis = null;
        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("INSERT INTO cliente (ClienteNombreORazonSocial, ClienteRuc, ClienteDireccion, ClienteMovil, ClienteEmail) values (?, ?, ?, ?, ?)");
            pstmt.setString(1, entity.getNombreRazonSocial());
            pstmt.setString(2, entity.getRuc());
            pstmt.setString(3, entity.getDireccion());
            pstmt.setString(4, entity.getMovil());
            pstmt.setString(5, entity.getEmail());
            pstmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                DBUtils.closeConnection(c);
            } catch (SQLException ex) {
                Logger.getLogger(JdbcProductoRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void addEmpleado(Persona entity) {
        Connection c = null;
        PreparedStatement pstmt = null;
        FileInputStream fis = null;
        try {
            c = DBUtils.getConnection();
            //INSERT INTO `empleado` ( `EmpleadoNombre`, `EmpleadoApellido`, `EmpleadoRol`, `EmpleadoFoto`, `EmpleadoUbicacion`, `EmpleadoMovil`, `EmpleadoEmail`, `EmpleadoPassword`) 
            pstmt = c.prepareStatement("INSERT INTO empleado (EmpleadoNombre, EmpleadoApellido, EmpleadoRol, EmpleadoFoto, EmpleadoUbicacion, EmpleadoMovil, EmpleadoEmail, EmpleadoPassword) values (?, ?, ?, ?, ?,?,?,?)");
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getApellido());
            pstmt.setInt(3, entity.getRol());
            pstmt.setBytes(4, entity.getFoto());
            pstmt.setString(5, entity.getDireccion());
            pstmt.setString(6, entity.getMovil());
            pstmt.setString(7, entity.getEmail());
            pstmt.setString(8, entity.getPassword());
            pstmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                DBUtils.closeConnection(c);
            } catch (SQLException ex) {
                Logger.getLogger(JdbcProductoRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }}

    @Override
    public Collection<Persona> getClientes() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.   
        Collection<Persona> retValue = new ArrayList();
        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        //final String link  = "http://"+ip+":8084/FerreSoft/rest/ImageAPI/image/"; 
        String image = "";
        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("Select * from Cliente");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                
                retValue.add(new  Persona(rs.getInt("ClienteId"),rs.getString ("ClientenombreORazonSocial"), rs.getString("ClienteRuc"), rs.getString("ClienteDireccion"), rs.getString("ClienteMovil"), rs.getString("ClienteEmail") ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                DBUtils.closeConnection(c);
                return retValue;
            } catch (SQLException ex) {
                Logger.getLogger(JdbcProductoRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retValue;
    }

    @Override
    public Collection<Persona> getEmpleados() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<Persona> retValue = new ArrayList();
        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        //final String link  = "http://"+ip+":8084/FerreSoft/rest/ImageAPI/image/"; 
        String image = "";
        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("Select * from Empleado");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                //image = link + String.valueOf(rs.getInt("ProductoId"));
                 //Persona(Integer id, String nombre, String apellido, int rol, String password, String direccion, String movil, String email) {
    
                retValue.add(new Persona(rs.getInt("EmpleadoId"), rs.getString("EmpleadoNombre"), rs.getString("EmpleadoApellido"), rs.getInt("EmpleadoRol"), rs.getString("EmpleadoPassword"), rs.getString("EmpleadoUbicacion"), rs.getString("EmpleadoMovil"),rs.getString("EmpleadoEmail"),rs.getBytes("EmpleadoFoto")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                DBUtils.closeConnection(c);
                return retValue;
            } catch (SQLException ex) {
                Logger.getLogger(JdbcProductoRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retValue;
    }
    
}
