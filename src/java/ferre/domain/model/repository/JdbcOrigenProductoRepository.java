/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.repository;

import ferre.domain.model.entity.DetalleProducto;
import ferre.domain.model.entity.Empresa;
import ferre.domain.model.entity.Entity;
import ferre.domain.model.entity.OrigenProducto;
import ferre.domain.model.entity.Producto;
import ferre.util.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matiass
 */
public class JdbcOrigenProductoRepository implements OrigenProductoRepository<OrigenProducto, Integer> {
    String ip = "192.168.56.1";
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    @Override
    public Collection<OrigenProducto> findByIdDetalleProducto(int idDetalleProducto) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<OrigenProducto> retValue = new ArrayList();
        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        final String link  = "http://"+ip+":8084/FerreSoft/rest/ImageAPI/image/"; 
        String image = "";
        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("select"
            + " o.OrigenProductoId, o.EmpresaId, e.EmpresaNombre, e.EmpresaRuc, o.PrecioVentaEmpresa, o.UltimaCompraFecha,"
            + " p.ProductoId, p.ProductoNombre, p.ProductoIva, p.ProductoMedidaStock,"
            + " p.CategoriaId, c.CategoriaNombre, p.ProductoBoolean, dp.DetalleProductoId,"
            + " dp.MarcaId, m.MarcaNombre, dp.ProductoCosto, dp.ProductoPrecio,"
            + " dp.ProductoStockMin, dp.ProductoStockActual, dp.ProductoStockMax"
            + " from producto p, detalleproducto dp, marca m, origenProducto o, Empresa e, Categoria c "
            + "where p.ProductoId = dp.ProductoId and dp.MarcaId = m.MarcaId "
            + "and dp.DetalleProductoId = o.DetalleProductoId and o.EmpresaId = e.EmpresaId "
            + "and p.CategoriaId = c.CategoriaId and dp.DetalleProductoId = ?");
            pstmt.setInt(1, idDetalleProducto);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                image = link + String.valueOf(rs.getInt("ProductoId"));
                Producto prod = new Producto(rs.getFloat("ProductoIva"), rs.getString("ProductoMedidaStock"), rs.getInt("CategoriaId"), rs.getString("CategoriaNombre"), rs.getBoolean("ProductoBoolean"), image, rs.getInt("ProductoId"), rs.getString("ProductoNombre"));
                Empresa empresa = new Empresa(rs.getInt("EmpresaId"), rs.getString("EmpresaNombre"), rs.getString("EmpresaRuc"));
                DetalleProducto detalleProducto = new DetalleProducto(rs.getInt("ProductoId"), prod,rs.getInt("MarcaId"), rs.getString("MarcaNombre"),rs.getInt("ProductoCosto"), rs.getInt("ProductoPrecio"), rs.getInt("ProductoStockMax"), rs.getInt("ProductoStockActual"), rs.getInt("ProductoStockMin") , rs.getInt("DetalleProductoId"), "Descripcion");
                retValue.add(new OrigenProducto(detalleProducto.getId(), detalleProducto, empresa.getId(), empresa, rs.getInt("PrecioVentaEmpresa"), formato.format(rs.getDate("UltimaCompraFecha")), rs.getInt("OrigenProductoId"), " "));
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
                Logger.getLogger(JdbcOrigenProductoRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retValue;
    }

    @Override
    public Collection<OrigenProducto> findByIdProducto(int idProducto) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<OrigenProducto> retValue = new ArrayList();
        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        final String link  = "http://"+ip+":8084/FerreSoft/rest/ImageAPI/image/"; 
        String image = "";
        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("select"
            + " o.OrigenProductoId, o.EmpresaId, e.EmpresaNombre, e.EmpresaRuc, o.PrecioVentaEmpresa, o.UltimaCompraFecha,"
            + " p.ProductoId, p.ProductoNombre, p.ProductoIva, p.ProductoMedidaStock, p.CategoriaId, c.CategoriaNombre,"
            + " p.ProductoBoolean, dp.DetalleProductoId, dp.MarcaId, m.MarcaNombre, dp.ProductoCosto,"
            + " dp.ProductoPrecio, dp.ProductoStockMin, dp.ProductoStockActual, dp.ProductoStockMax "
            + "from producto p, detalleproducto dp, marca m, origenProducto o, Empresa e, Categoria c "
            + "where p.ProductoId = dp.ProductoId and dp.MarcaId = m.MarcaId "
            + "and dp.DetalleProductoId = o.DetalleProductoId and o.EmpresaId = e.EmpresaId"
            + " and p.CategoriaId = c.CategoriaId "
            + "and p.ProductoId = ?");
            pstmt.setInt(1, idProducto);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                image = link + String.valueOf(rs.getInt("ProductoId"));
                Producto prod = new Producto(rs.getFloat("ProductoIva"), rs.getString("ProductoMedidaStock"), rs.getInt("CategoriaId"), rs.getString("CategoriaNombre"), rs.getBoolean("ProductoBoolean"), image, rs.getInt("ProductoId"), rs.getString("ProductoNombre"));
                Empresa empresa = new Empresa(rs.getInt("EmpresaId"), rs.getString("EmpresaNombre"), rs.getString("EmpresaRuc"));
                DetalleProducto detalleProducto = new DetalleProducto(rs.getInt("ProductoId"), prod,rs.getInt("MarcaId"), rs.getString("MarcaNombre"),rs.getInt("ProductoCosto"), rs.getInt("ProductoPrecio"), rs.getInt("ProductoStockMax"), rs.getInt("ProductoStockActual"), rs.getInt("ProductoStockMin") , rs.getInt("DetalleProductoId"), "Descripcion");
                retValue.add( new OrigenProducto(detalleProducto.getId(), detalleProducto, empresa.getId(), empresa, rs.getInt("PrecioVentaEmpresa"), formato.format(rs.getDate("UltimaCompraFecha")), rs.getInt("OrigenProductoId"), " "));
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
                Logger.getLogger(JdbcOrigenProductoRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retValue;
    }

    @Override
    public Collection<OrigenProducto> findByIdProductoAndIdEmpresa(int idProducto, int idEmpresa) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<OrigenProducto> retValue = new ArrayList();
        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        final String link  = "http://"+ip+":8084/FerreSoft/rest/ImageAPI/image/"; 
        String image = "";
        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("select"
            + " o.OrigenProductoId, o.EmpresaId, e.EmpresaNombre, e.EmpresaRuc, o.PrecioVentaEmpresa, o.UltimaCompraFecha,"
            + " p.ProductoId, p.ProductoNombre, p.ProductoIva, p.ProductoMedidaStock, p.CategoriaId, c.CategoriaNombre,"
            + " p.ProductoBoolean, dp.DetalleProductoId, dp.MarcaId, m.MarcaNombre, dp.ProductoCosto,"
            + " dp.ProductoPrecio, dp.ProductoStockMin, dp.ProductoStockActual, dp.ProductoStockMax "
            + "from producto p, detalleproducto dp, marca m, origenProducto o, Empresa e, Categoria c "
            + "where p.ProductoId = dp.ProductoId and dp.MarcaId = m.MarcaId "
            + "and dp.DetalleProductoId = o.DetalleProductoId and o.EmpresaId = e.EmpresaId"
            + " and p.CategoriaId = c.CategoriaId "
            + "and p.ProductoId = ? and e.EmpresaId = ?");
            pstmt.setInt(1, idProducto);
            pstmt.setInt(2, idEmpresa);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                image = link + String.valueOf(rs.getInt("ProductoId"));
                Producto prod = new Producto(rs.getFloat("ProductoIva"), rs.getString("ProductoMedidaStock"), rs.getInt("CategoriaId"), rs.getString("CategoriaNombre"), rs.getBoolean("ProductoBoolean"), image, rs.getInt("ProductoId"), rs.getString("ProductoNombre"));
                Empresa empresa = new Empresa(rs.getInt("EmpresaId"), rs.getString("EmpresaNombre"), rs.getString("EmpresaRuc"));
                DetalleProducto detalleProducto = new DetalleProducto(rs.getInt("ProductoId"), prod,rs.getInt("MarcaId"), rs.getString("MarcaNombre"),rs.getInt("ProductoCosto"), rs.getInt("ProductoPrecio"), rs.getInt("ProductoStockMax"), rs.getInt("ProductoStockActual"), rs.getInt("ProductoStockMin") , rs.getInt("DetalleProductoId"), "Descripcion");
                retValue.add(new OrigenProducto(detalleProducto.getId(), detalleProducto, empresa.getId(), empresa, rs.getInt("PrecioVentaEmpresa"), formato.format(rs.getDate("UltimaCompraFecha")), rs.getInt("OrigenProductoId"), " "));
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
                Logger.getLogger(JdbcOrigenProductoRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retValue;
    }

    @Override
    public Collection<OrigenProducto> findByIdEmpresa(int idEmpresa) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<OrigenProducto> retValue = new ArrayList();
        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        final String link  = "http://"+ip+":8084/FerreSoft/rest/ImageAPI/image/"; 
        String image = "";
        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("select"
            + " o.OrigenProductoId, o.EmpresaId, e.EmpresaNombre, e.EmpresaRuc, o.PrecioVentaEmpresa, o.UltimaCompraFecha,"
            + " p.ProductoId, p.ProductoNombre, p.ProductoIva, p.ProductoMedidaStock, p.CategoriaId, c.CategoriaNombre,"
            + " p.ProductoBoolean, dp.DetalleProductoId, dp.MarcaId, m.MarcaNombre, dp.ProductoCosto,"
            + " dp.ProductoPrecio, dp.ProductoStockMin, dp.ProductoStockActual, dp.ProductoStockMax "
            + "from producto p, detalleproducto dp, marca m, origenProducto o, Empresa e, Categoria c "
            + "where p.ProductoId = dp.ProductoId and dp.MarcaId = m.MarcaId "
            + "and dp.DetalleProductoId = o.DetalleProductoId and o.EmpresaId = e.EmpresaId"
            + " and p.CategoriaId = c.CategoriaId "
            + "and e.EmpresaId = ?");
            pstmt.setInt(1, idEmpresa);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                image = link + String.valueOf(rs.getInt("ProductoId"));
                Producto prod = new Producto(rs.getFloat("ProductoIva"), rs.getString("ProductoMedidaStock"), rs.getInt("CategoriaId"), rs.getString("CategoriaNombre"), rs.getBoolean("ProductoBoolean"), image, rs.getInt("ProductoId"), rs.getString("ProductoNombre"));
                Empresa empresa = new Empresa(rs.getInt("EmpresaId"), rs.getString("EmpresaNombre"), rs.getString("EmpresaRuc"));
                DetalleProducto detalleProducto = new DetalleProducto(rs.getInt("ProductoId"), prod,rs.getInt("MarcaId"), rs.getString("MarcaNombre"),rs.getInt("ProductoCosto"), rs.getInt("ProductoPrecio"), rs.getInt("ProductoStockMax"), rs.getInt("ProductoStockActual"), rs.getInt("ProductoStockMin") , rs.getInt("DetalleProductoId"), "Descripcion");
                retValue.add(new OrigenProducto(detalleProducto.getId(), detalleProducto, empresa.getId(), empresa, rs.getInt("PrecioVentaEmpresa"), formato.format(rs.getDate("UltimaCompraFecha")), rs.getInt("OrigenProductoId"), " "));
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
                Logger.getLogger(JdbcOrigenProductoRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retValue; 
    }

    @Override
    public void add(OrigenProducto entity) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c = null;
        PreparedStatement pstmt = null;
        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("INSERT INTO OrigenProducto (DetalleProductoId, EmpresaId, PrecioVentaEmpresa, UltimaCompraFecha,) values (?, ?, ?, STR_TO_DATE(?,'%Y-%m-%d'))");
            pstmt.setInt(1, entity.getDetalleProductoId());
            pstmt.setInt(2, entity.getEmpresaId());
            pstmt.setInt(3, entity.getPrecioVenta());
            pstmt.setString(4, entity.getUltimaCompra());
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
                Logger.getLogger(JdbcOrigenProductoRepository.class.getName()).log(Level.SEVERE, null, ex);
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
            pstmt = c.prepareStatement("DELETE FROM OrigenProducto WHERE OrigenProductoId = ?");
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
                Logger.getLogger(JdbcOrigenProductoRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void update(OrigenProducto entity) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c = null;
        PreparedStatement pstmt = null;
        Date fecha = null;
        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("UPDATE OrigenProducto SET DetalleProductoId = ?, EmpresaId = ?, PrecioVentaEmpresa = ?, UltimaCompraFecha = STR_TO_DATE(?,'%Y-%m-%d') WHERE OrigenProductoId = ?");
            pstmt.setInt(1, entity.getDetalleProductoId());
            pstmt.setInt(2, entity.getEmpresaId());
            pstmt.setInt(3, entity.getPrecioVenta());
            pstmt.setString(4, entity.getUltimaCompra());
            pstmt.setInt(5, entity.getId());
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
                Logger.getLogger(JdbcOrigenProductoRepository.class.getName()).log(Level.SEVERE, null, ex);
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
            pstmt = c.prepareStatement("SELECT * FROM OrigenProducto where OrigenProductoId = ?");

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                return true;                
            } 
            
        } catch (SQLException ex) {
            Logger.getLogger(JdbcOrigenProductoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Entity get(Integer id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        OrigenProducto retValue = null;
        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        final String link  = "http://"+ip+":8084/FerreSoft/rest/ImageAPI/image/"; 
        String image = "";
        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("select"
            + " o.OrigenProductoId, o.EmpresaId, e.EmpresaNombre, e.EmpresaRuc, o.PrecioVentaEmpresa, o.UltimaCompraFecha,"
            + " p.ProductoId, p.ProductoNombre, p.ProductoIva, p.ProductoMedidaStock, p.CategoriaId, c.CategoriaNombre,"
            + " p.ProductoBoolean, dp.DetalleProductoId, dp.MarcaId, m.MarcaNombre, dp.ProductoCosto,"
            + " dp.ProductoPrecio, dp.ProductoStockMin, dp.ProductoStockActual, dp.ProductoStockMax "
            + "from producto p, detalleproducto dp, marca m, origenProducto o, Empresa e, Categoria c "
            + "where p.ProductoId = dp.ProductoId and dp.MarcaId = m.MarcaId "
            + "and dp.DetalleProductoId = o.DetalleProductoId and o.EmpresaId = e.EmpresaId"
            + " and p.CategoriaId = c.CategoriaId "
            + "and o.OrigenProductoId = ?");

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                image = link + String.valueOf(rs.getInt("ProductoId"));
                Producto prod = new Producto(rs.getFloat("ProductoIva"), rs.getString("ProductoMedidaStock"), rs.getInt("CategoriaId"), rs.getString("CategoriaNombre"), rs.getBoolean("ProductoBoolean"), image, rs.getInt("ProductoId"), rs.getString("ProductoNombre"));
                Empresa empresa = new Empresa(rs.getInt("EmpresaId"), rs.getString("EmpresaNombre"), rs.getString("EmpresaRuc"));
                DetalleProducto detalleProducto = new DetalleProducto(rs.getInt("ProductoId"), prod,rs.getInt("MarcaId"), rs.getString("MarcaNombre"),rs.getInt("ProductoCosto"), rs.getInt("ProductoPrecio"), rs.getInt("ProductoStockMax"), rs.getInt("ProductoStockActual"), rs.getInt("ProductoStockMin") , rs.getInt("DetalleProductoId"), "Descripcion");
                retValue = new OrigenProducto(detalleProducto.getId(), detalleProducto, empresa.getId(), empresa, rs.getInt("PrecioVentaEmpresa"), formato.format(rs.getDate("UltimaCompraFecha")), rs.getInt("OrigenProductoId"), " ");
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
                Logger.getLogger(JdbcOrigenProductoRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retValue;

    }

    @Override
    public Collection<OrigenProducto> getAll() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<OrigenProducto> retValue = new ArrayList();
        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        final String link  = "http://"+ip+":8084/FerreSoft/rest/ImageAPI/image/"; 
        String image = "";
        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("select"
            + " o.OrigenProductoId, o.EmpresaId, e.EmpresaNombre, e.EmpresaRuc, o.PrecioVentaEmpresa, o.UltimaCompraFecha,"
            + " p.ProductoId, p.ProductoNombre, p.ProductoIva, p.ProductoMedidaStock, p.CategoriaId, c.CategoriaNombre,"
            + " p.ProductoBoolean, dp.DetalleProductoId, dp.MarcaId, m.MarcaNombre, dp.ProductoCosto,"
            + " dp.ProductoPrecio, dp.ProductoStockMin, dp.ProductoStockActual, dp.ProductoStockMax "
            + "from producto p, detalleproducto dp, marca m, origenProducto o, Empresa e, Categoria c "
            + "where p.ProductoId = dp.ProductoId and dp.MarcaId = m.MarcaId "
            + "and dp.DetalleProductoId = o.DetalleProductoId and o.EmpresaId = e.EmpresaId"
            + " and p.CategoriaId = c.CategoriaId ");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                image = link + String.valueOf(rs.getInt("ProductoId"));
                Producto prod = new Producto(rs.getFloat("ProductoIva"), rs.getString("ProductoMedidaStock"), rs.getInt("CategoriaId"), rs.getString("CategoriaNombre"), rs.getBoolean("ProductoBoolean"), image, rs.getInt("ProductoId"), rs.getString("ProductoNombre"));
                Empresa empresa = new Empresa(rs.getInt("EmpresaId"), rs.getString("EmpresaNombre"), rs.getString("EmpresaRuc"));
                DetalleProducto detalleProducto = new DetalleProducto(rs.getInt("ProductoId"), prod,rs.getInt("MarcaId"), rs.getString("MarcaNombre"),rs.getInt("ProductoCosto"), rs.getInt("ProductoPrecio"), rs.getInt("ProductoStockMax"), rs.getInt("ProductoStockActual"), rs.getInt("ProductoStockMin") , rs.getInt("DetalleProductoId"), "Descripcion");
                retValue.add(new OrigenProducto(detalleProducto.getId(), detalleProducto, empresa.getId(), empresa, rs.getInt("PrecioVentaEmpresa"), formato.format(rs.getDate("UltimaCompraFecha")), rs.getInt("OrigenProductoId"), " "));
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
                Logger.getLogger(JdbcOrigenProductoRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retValue;
    }
    
}
