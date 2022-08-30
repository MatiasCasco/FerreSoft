/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.repository;

import ferre.domain.model.entity.Entity;
import ferre.domain.model.entity.Producto;
import ferre.util.DBUtils;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class JdbcProductoRepository implements ProductoRepository<Producto, Integer>{

//    @Override
//    public boolean ContainsId(int idProducto) throws Exception {
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        try {  
//            Connection c = null;
//            PreparedStatement pstmt = null;
//            ResultSet rs = null;
//            c = DBUtils.getConnection();
//            pstmt = c.prepareStatement("SELECT * FROM producto where ProductoId = ?");
//
//            pstmt.setInt(1, idProducto);
//
//            rs = pstmt.executeQuery();
//
//            if (rs.next()) {
//                return true;                
//            } 
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(JdbcProductoRepository.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return false;
//    }

//    @Override
//    public Producto getProducto(int idProducto) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
////        Producto retValue = null;
////        Connection c = null;
////        PreparedStatement pstmt = null;
////        ResultSet rs = null;
////
////        try {
////            c = DBUtils.getConnection();
////            pstmt = c.prepareStatement("SELECT * FROM producto WHERE ProductoId = ?");
////
////            pstmt.setInt(1, idProducto);
////
////            rs = pstmt.executeQuery();
////
////            if (rs.next()) {
////
////                retValue = new Producto(rs.getFloat("ProductoIva"), rs.getString("ProductoMedidaStock"), rs.getInt("CategoriaId"), rs.getBoolean("ProductoBoolean"), rs.getInt("ProductoId"), rs.getString("ProductoNombre"));
////            
////            } 
////        } catch (Exception e) {
////            e.printStackTrace();
////        } finally {
////            try {
////                if (rs != null) {
////                    rs.close();
////                }
////                if (pstmt != null) {
////                    pstmt.close();
////                }
////                DBUtils.closeConnection(c);
////            } catch (SQLException ex) {
////                Logger.getLogger(JdbcProductoRepository.class.getName()).log(Level.SEVERE, null, ex);
////            }
////        }
////        return retValue;
//    }

    @Override
    public Collection<Producto> findByIdMarca(int idMarca) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<Producto> retValue = new ArrayList();
        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;       
        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement(" select P.ProductoId, P.ProductoNombre, P.ProductoIva, P.ProductoMedidaStock, P.CategoriaId, C.CategoriaNombre, P.ProductoBoolean"
            + " from Producto P, DetalleProducto DP, Marca M, Categoria C"
            + " where P.ProductoId = DP.ProductoId"
            + " and DP.MarcaId = M.MarcaId"
            + " and P.CategoriaId = C.CategoriaId"         
            + " and M.MarcaId = ? GROUP BY P.ProductoNombre ORDER by P.ProductoNombre");
            pstmt.setInt(1, idMarca);
            rs = pstmt.executeQuery();

            while (rs.next()) {              
                retValue.add(new Producto(rs.getFloat("ProductoIva"), rs.getString("ProductoMedidaStock"), rs.getInt("CategoriaId"), rs.getString("CategoriaNombre"), rs.getBoolean("ProductoBoolean"), rs.getInt("ProductoId"), rs.getString("ProductoNombre")));
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
                Logger.getLogger(JdbcProductoRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retValue;
    }

    @Override
    public Collection<Producto> findByIdCategoria(int idCategoria) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<Producto> retValue = new ArrayList();
        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;       
        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement(" select P.ProductoId, P.ProductoNombre, P.ProductoIva, P.ProductoMedidaStock, P.CategoriaId, C.CategoriaNombre, P.ProductoBoolean"
            + " from Producto P, Categoria C"
            + " where P.CategoriaId = C.CategoriaId"
            + "CategoriaId = ? GROUP BY ProductoNombre ORDER by ProductoNombre");
            pstmt.setInt(1, idCategoria);
            rs = pstmt.executeQuery();

            while (rs.next()) {              
                retValue.add(new Producto(rs.getFloat("ProductoIva"), rs.getString("ProductoMedidaStock"), rs.getInt("CategoriaId"), rs.getString("CategoriaNombre"), rs.getBoolean("ProductoBoolean"), rs.getInt("ProductoId"), rs.getString("ProductoNombre")));
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
                Logger.getLogger(JdbcProductoRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retValue;
    }

    @Override
    public void add(Producto entity) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c = null;
        PreparedStatement pstmt = null;
        FileInputStream fis = null;
        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("INSERT INTO Producto (ProductoNombre, ProductoIva, ProductoMedidaStock, CategoriaId, ProductoBoolean, ProductoFoto) values (?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, entity.nombre);
            pstmt.setFloat(2, entity.getIva());
            pstmt.setString(3, entity.getMedidaStock());
            pstmt.setInt(4, entity.getCategoriaId());
            pstmt.setBoolean(5, entity.isProductoBoolean());
            pstmt.setBytes(6, entity.getArchivoimg());
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

    @Override
    public void remove(Integer id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c = null;
        PreparedStatement pstmt = null;
        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("DELETE FROM Producto WHERE ProductoId = ?");
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
                Logger.getLogger(JdbcProductoRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void update(Producto entity) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c = null;
        PreparedStatement pstmt = null;
        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("UPDATE Producto SET ProductoNombre = ?, ProductoIva = ?, ProductoMedidaStock = ?, CategoriaId = ?, ProductoBoolean = ?, ProductoFoto = ? WHERE ProductoId = ?");
            pstmt.setString(1, entity.getNombre());
            pstmt.setFloat(2, entity.getIva());
            pstmt.setString(3, entity.getMedidaStock());
            pstmt.setInt(4, entity.getCategoriaId());
            pstmt.setBoolean(5, entity.isProductoBoolean());
            pstmt.setBytes(6, entity.getArchivoimg());
            pstmt.setInt(7, entity.getId());
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

    @Override
    public boolean contains(Integer id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {  
            Connection c = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM producto where ProductoId = ?");

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                return true;                
            } 
            
        } catch (SQLException ex) {
            Logger.getLogger(JdbcProductoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Entity get(Integer id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Producto retValue = null;
        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("select P.ProductoId, P.ProductoNombre, P.ProductoIva, P.ProductoMedidaStock, P.CategoriaId, C.CategoriaNombre, P.ProductoBoolean"
            + " from Producto P, Categoria C"
            + " where P.CategoriaId = C.CategoriaId"
            + " and P.ProductoId = ?");

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                retValue = new Producto(rs.getFloat("ProductoIva"), rs.getString("ProductoMedidaStock"), rs.getInt("CategoriaId"), rs.getString("CategoriaNombre"), rs.getBoolean("ProductoBoolean"), Base64.getEncoder().encodeToString(rs.getBytes("ProductoFoto")), rs.getInt("ProductoId"), rs.getString("ProductoNombre"));               
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
                Logger.getLogger(JdbcProductoRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retValue;
    }

    @Override
    public Collection<Producto> getAll() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<Producto> retValue = new ArrayList();
        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("select P.ProductoId, P.ProductoNombre, P.ProductoIva, P.ProductoMedidaStock, P.CategoriaId, C.CategoriaNombre, P.ProductoBoolean"
            + " from Producto P, Categoria C"
            + " where P.CategoriaId = C.CategoriaId");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                retValue.add(new Producto(rs.getFloat("ProductoIva"), rs.getString("ProductoMedidaStock"), rs.getInt("CategoriaId"), rs.getString("CategoriaNombre"), rs.getBoolean("ProductoBoolean"), rs.getInt("ProductoId"), rs.getString("ProductoNombre")));
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
