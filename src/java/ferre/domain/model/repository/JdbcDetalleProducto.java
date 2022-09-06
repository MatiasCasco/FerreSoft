/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.repository;

import ferre.domain.model.entity.DetalleProducto;
import ferre.domain.model.entity.Entity;
import ferre.domain.model.entity.Producto;
import ferre.util.DBUtils;
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
 * @author User
 */
public class JdbcDetalleProducto implements DetalleProductoRepository<DetalleProducto, Integer> {

    @Override
    public Collection<DetalleProducto> findByIdProducto(int idProducto) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<DetalleProducto> retValue = new ArrayList();
        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        final String link  = "localhost:8084/FerreSoft/rest/ImageAPI/image/"; 
        String image = "";
        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("select"
            + " p.ProductoId, p.ProductoNombre, p.ProductoIva, p.ProductoMedidaStock, p.CategoriaId, c.CategoriaNombre, p.ProductoBoolean,"
            + " dp.DetalleProductoId, dp.MarcaId, m.MarcaNombre, dp.ProductoCosto, dp.ProductoPrecio, dp.ProductoStockMin,"
            + " dp.ProductoStockActual, dp.ProductoStockMax "
            + "from producto p, detalleproducto dp, marca m, categoria c "
            + "where p.ProductoId = dp.ProductoId and dp.MarcaId = m.MarcaId"
            + " and p.CategoriaId = c.CategoriaId"        
            + " and p.ProductoId = ?");
            pstmt.setInt(1, idProducto);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                image = link + String.valueOf(rs.getInt("ProductoId"));
                Producto prod = new Producto(rs.getFloat("ProductoIva"), rs.getString("ProductoMedidaStock"), rs.getInt("CategoriaId"), rs.getString("CategoriaNombre"), rs.getBoolean("ProductoBoolean"), image, rs.getInt("ProductoId"), rs.getString("ProductoNombre"));
                retValue.add(new DetalleProducto(rs.getInt("ProductoId"), prod,rs.getInt("MarcaId"), rs.getString("MarcaNombre"),rs.getInt("ProductoCosto"), rs.getInt("ProductoPrecio"), rs.getInt("ProductoStockMax"), rs.getInt("ProductoStockActual"), rs.getInt("ProductoStockMin") , rs.getInt("DetalleProductoId"), "Descripcion"));
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
                Logger.getLogger(JdbcDetalleProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retValue;

    }

    @Override
    public DetalleProducto findByIdProductoAndIdMarca(int idProducto, int idMarca) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        DetalleProducto retValue = null;
        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        final String link  = "localhost:8084/FerreSoft/rest/ImageAPI/image/"; 
        String image = "";
        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("select "
            + "p.ProductoId, p.ProductoNombre, p.ProductoIva, p.ProductoMedidaStock, p.CategoriaId, c.CategoriaNombre, p.ProductoBoolean,"
            + " dp.DetalleProductoId, dp.MarcaId, m.MarcaNombre, dp.ProductoCosto, dp.ProductoPrecio, dp.ProductoStockMin,"
            + " dp.ProductoStockActual, dp.ProductoStockMax "
            + "from producto p, detalleproducto dp, marca m, categoria c "
            + "where p.ProductoId = dp.ProductoId and dp.MarcaId = m.MarcaId "
            + " and p.CategoriaId = c.CategoriaId "        
            + "and p.ProductoId = ? and m.MarcaId = ? ");
            pstmt.setInt(1, idProducto);
            pstmt.setInt(2, idMarca);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                image = link + String.valueOf(rs.getInt("ProductoId"));
                Producto prod = new Producto(rs.getFloat("ProductoIva"), rs.getString("ProductoMedidaStock"), rs.getInt("CategoriaId"), rs.getString("CategoriaNombre"), rs.getBoolean("ProductoBoolean"), image, rs.getInt("ProductoId"), rs.getString("ProductoNombre"));
                retValue = new DetalleProducto(rs.getInt("ProductoId"), prod,rs.getInt("MarcaId"), rs.getString("MarcaNombre"),rs.getInt("ProductoCosto"), rs.getInt("ProductoPrecio"), rs.getInt("ProductoStockMax"), rs.getInt("ProductoStockActual"), rs.getInt("ProductoStockMin") , rs.getInt("DetalleProductoId"), "Descripcion");                           
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
                Logger.getLogger(JdbcDetalleProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retValue;
    }

    @Override
    public void add(DetalleProducto entity) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c = null;
        PreparedStatement pstmt = null;
        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("INSERT INTO DetalleProducto (ProductoId, MarcaId, ProductoCosto, ProductoPrecio, ProductoStockMax, ProductoStockActual, ProductoStockMin) values (?, ?, ?, ?, ?, ?, ?)");
            pstmt.setInt(1, entity.getProductoId());
            pstmt.setInt(2, entity.getMarcaId());
            pstmt.setInt(3, entity.getProductoCosto());
            pstmt.setInt(4, entity.getProductoPrecio());
            pstmt.setInt(5, entity.getProductoStockMax());
            pstmt.setInt(6, entity.getProductoStockActual());
            pstmt.setInt(7, entity.getProductoStockMin());
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
                Logger.getLogger(JdbcDetalleProducto.class.getName()).log(Level.SEVERE, null, ex);
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
            pstmt = c.prepareStatement("DELETE FROM DetalleProducto WHERE DetalleProductoId = ?");
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
                Logger.getLogger(JdbcDetalleProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void update(DetalleProducto entity) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c = null;
        PreparedStatement pstmt = null;
        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("UPDATE DetalleProducto SET ProductoId = ?, MarcaId = ?, ProductoCosto = ?, ProductoPrecio = ?, ProductoStockMax = ?, ProductoStockActual = ?, ProductoStockMin = ? WHERE DetalleProductoId = ?");
            pstmt.setInt(1, entity.getProductoId());
            pstmt.setInt(2, entity.getMarcaId());
            pstmt.setInt(3, entity.getProductoCosto());
            pstmt.setInt(4, entity.getProductoPrecio());
            pstmt.setInt(5, entity.getProductoStockMax());
            pstmt.setInt(6, entity.getProductoStockActual());
            pstmt.setInt(7, entity.getProductoStockMin());
            pstmt.setInt(8, entity.getId());
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
                Logger.getLogger(JdbcDetalleProducto.class.getName()).log(Level.SEVERE, null, ex);
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
            pstmt = c.prepareStatement("SELECT * FROM DetalleProducto where DetalleProductoId = ?");

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                return true;                
            } 
            
        } catch (SQLException ex) {
            Logger.getLogger(JdbcDetalleProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Entity get(Integer id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        DetalleProducto retValue = null;
        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        final String link  = "localhost:8084/FerreSoft/rest/ImageAPI/image/"; 
        String image = "";
        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("select "
            + "p.ProductoId, p.ProductoNombre, p.ProductoIva, p.ProductoMedidaStock, p.CategoriaId, c.CategoriaNombre, p.ProductoBoolean,"
            + " dp.DetalleProductoId, dp.MarcaId, m.MarcaNombre, dp.ProductoCosto, dp.ProductoPrecio,"
            + " dp.ProductoStockMin, dp.ProductoStockActual, dp.ProductoStockMax from producto p, detalleproducto dp,"
            + " marca m, categoria c where p.ProductoId = dp.ProductoId and dp.MarcaId = m.MarcaId "
            + " and p.CategoriaId = c.CategoriaId"
            + " and dp.DetalleProductoId = ? ");

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                image = link + String.valueOf(rs.getInt("ProductoId"));
                Producto prod = new Producto(rs.getFloat("ProductoIva"), rs.getString("ProductoMedidaStock"), rs.getInt("CategoriaId"), rs.getString("CategoriaNombre"), rs.getBoolean("ProductoBoolean"), image, rs.getInt("ProductoId"), rs.getString("ProductoNombre"));
                retValue = new DetalleProducto(rs.getInt("ProductoId"), prod,rs.getInt("MarcaId"), rs.getString("MarcaNombre"),rs.getInt("ProductoCosto"), rs.getInt("ProductoPrecio"), rs.getInt("ProductoStockMax"), rs.getInt("ProductoStockActual"), rs.getInt("ProductoStockMin") , rs.getInt("DetalleProductoId"), "Descripcion");                           
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
                Logger.getLogger(JdbcDetalleProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retValue;
    }

    @Override
    public Collection<DetalleProducto> getAll() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<DetalleProducto> retValue = new ArrayList();
        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        final String link  = "localhost:8084/FerreSoft/rest/ImageAPI/image/"; 
        String image = "";
        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("select "
            + "p.ProductoId, p.ProductoNombre, p.ProductoIva, p.ProductoMedidaStock, p.CategoriaId, c.CategoriaNombre, p.ProductoBoolean, "
            + "dp.DetalleProductoId, dp.MarcaId, m.MarcaNombre, dp.ProductoCosto, dp.ProductoPrecio, dp.ProductoStockMin,"
            + " dp.ProductoStockActual, dp.ProductoStockMax "
            + "from producto p, detalleproducto dp, marca m, categoria c "
            + "where p.ProductoId = dp.ProductoId"
            + " and p.CategoriaId = c.CategoriaId"
            + " and dp.MarcaId = m.MarcaId");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                image = link + String.valueOf(rs.getInt("ProductoId"));
                Producto prod = new Producto(rs.getFloat("ProductoIva"), rs.getString("ProductoMedidaStock"), rs.getInt("CategoriaId"), rs.getString("CategoriaNombre"), rs.getBoolean("ProductoBoolean"), image, rs.getInt("ProductoId"), rs.getString("ProductoNombre"));
                retValue.add(new DetalleProducto(rs.getInt("ProductoId"), prod,rs.getInt("MarcaId"), rs.getString("MarcaNombre"),rs.getInt("ProductoCosto"), rs.getInt("ProductoPrecio"), rs.getInt("ProductoStockMax"), rs.getInt("ProductoStockActual"), rs.getInt("ProductoStockMin") , rs.getInt("DetalleProductoId"), "Descripcion"));
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
                Logger.getLogger(JdbcDetalleProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retValue;
    }
  
}
