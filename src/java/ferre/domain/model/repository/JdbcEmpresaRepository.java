/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.repository;

import ferre.domain.model.entity.Empresa;
import ferre.domain.model.entity.EmpresaContacto;
import ferre.domain.model.entity.Entity;
import ferre.util.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class JdbcEmpresaRepository implements EmpresaRepository<Empresa, Integer>{
    
    JdbcEmpresaContactoRepository EmpresaContacto = new JdbcEmpresaContactoRepository();
    
    @Override
    public Empresa findByName(String EmpresaNombre) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Empresa retValue = null;
        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM empresa WHERE UPPER(EmpresaNombre) like UPPER(?)");
            pstmt.setString(1, EmpresaNombre);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                retValue = new Empresa(rs.getString("EmpresaRuc"), EmpresaContacto.getContactos(rs.getInt("EmpresaId")), rs.getInt("EmpresaId"), rs.getString("EmpresaNombre"));               
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
                Logger.getLogger(JdbcEmpresaRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retValue;
    }

    @Override
    public Empresa findByRuc(String EmpresaRuc) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Empresa retValue = null;
        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM empresa WHERE UPPER(EmpresaRuc) like UPPER(?)");
            pstmt.setString(1, EmpresaRuc);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                retValue = new Empresa(rs.getString("EmpresaRuc"), EmpresaContacto.getContactos(rs.getInt("EmpresaId")), rs.getInt("EmpresaId"), rs.getString("EmpresaNombre"));               
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
                Logger.getLogger(JdbcEmpresaRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retValue;
    }

    @Override
    public Collection<EmpresaContacto> getContactos(int idEmpresa) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         Collection<EmpresaContacto> retValue = new ArrayList();
          retValue = EmpresaContacto.getContactos(idEmpresa);
          return retValue;
    }

    @Override
    public void add(Empresa entity) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c = null;
        PreparedStatement pstmt = null;
        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("INSERT INTO empresa (EmpresaNombre, EmpresaRuc) values (?, ?)");
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getEmpresaRuc());
            int resp = pstmt.executeUpdate();
            if (resp > 0){
                ArrayList<EmpresaContacto> list = entity.getContacto();
                for (EmpresaContacto empresaContacto : list) {
                    EmpresaContacto.add(empresaContacto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                DBUtils.closeConnection(c);
            } catch (SQLException ex) {
                Logger.getLogger(JdbcEmpresaRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void remove(Integer id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c = null;
        PreparedStatement pstmt = null;
        try {
            EmpresaContacto.removeContactosEmpresa(id);
        } catch (Exception ex) {
            Logger.getLogger(JdbcEmpresaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("DELETE FROM empresa WHERE EmpresaId = ?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();      
        } catch (SQLException e) {
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                DBUtils.closeConnection(c);
            } catch (SQLException ex) {
                Logger.getLogger(JdbcEmpresaRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void update(Empresa entity) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c = null;
        PreparedStatement pstmt = null;
        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("UPDATE empresa SET EmpresaNombre = ?, EmpresaRuc = ? WHERE EmpresaId = ?");
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getEmpresaRuc());
            pstmt.setInt(3, entity.getId());
            int resp = pstmt.executeUpdate();
            if (resp > 0) {
                ArrayList<EmpresaContacto> list = entity.getContacto();
                for (EmpresaContacto empresaContacto : list) {
                    EmpresaContacto.update(empresaContacto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                DBUtils.closeConnection(c);
            } catch (SQLException ex) {
                Logger.getLogger(JdbcEmpresaRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean contains(Integer id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {  
            Connection c = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM Empresa where EmpresaId = ?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                return true;                
            } 
            
        } catch (SQLException ex) {
            Logger.getLogger(JdbcEmpresaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Entity get(Integer id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Empresa retValue = null;
        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM Empresa WHERE EmpresaId = ?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                retValue = new Empresa(rs.getString("EmpresaRuc"), EmpresaContacto.getContactos(id), rs.getInt("EmpresaId"), rs.getString("EmpresaNombre"));               
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
                Logger.getLogger(JdbcEmpresaRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retValue;
    }

    @Override
    public Collection<Empresa> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.     
    }
    
}
