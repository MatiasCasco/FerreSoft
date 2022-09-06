/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Matias
 */
public class OrigenProducto extends BaseEntity<Integer> {

    private int detalleProductoId;
    private DetalleProducto detalleProducto;
    private int empresaId;
    private Empresa empresa;
    private int precioVenta;
    private String ultimaCompra;

    public OrigenProducto() {
    }

    public OrigenProducto(Integer id, String nombre) {
        super(id, nombre);
    }

    public OrigenProducto(int detalleProductoId, int empresaId, int precioVenta, String ultimaCompra, Integer id, String nombre) throws ParseException {
        super(id, nombre);
        this.detalleProductoId = detalleProductoId;
        this.empresaId = empresaId;
        this.precioVenta = precioVenta;
        this.ultimaCompra = ultimaCompra;
    }

    public OrigenProducto(int detalleProductoId, DetalleProducto detalleProducto, int empresaId, Empresa empresa, int precioVenta, String ultimaCompra, Integer id, String nombre) throws ParseException {
        super(id, nombre);
        this.detalleProductoId = detalleProductoId;
        this.detalleProducto = detalleProducto;
        this.empresaId = empresaId;
        this.empresa = empresa;
        this.precioVenta = precioVenta;
        this.ultimaCompra = ultimaCompra;
    }
    
    public String getUltimaCompra() {
        return ultimaCompra;
    }

    public void setUltimaCompra(String ultimaCompra) {
        this.ultimaCompra = ultimaCompra;
    }
    
    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
   
    public DetalleProducto getDetalleProducto() {
        return detalleProducto;
    }

    public void setDetalleProducto(DetalleProducto detalleProducto) {
        this.detalleProducto = detalleProducto;
    }

    public int getDetalleProductoId() {
        return detalleProductoId;
    }

    public void setDetalleProductoId(int detalleProductoId) {
        this.detalleProductoId = detalleProductoId;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    @Override
    public String toString() {
        return new StringBuilder("{id: ").append(id)
                .append(", detalleProductoId: ").append(detalleProductoId)
                .append(", productoId: ").append(detalleProducto.getProductoId())
                .append(", productoNombre: ").append(detalleProducto.getProducto().getProductoNombre())
                .append(", marcaId: ").append(detalleProducto.getMarcaId())
                .append(", marcaNombre: ").append(detalleProducto.getMarcaNombre())
                .append(", categoriaId: ").append(detalleProducto.getProducto().getCategoriaId())
                .append(", categoriaNombre: ").append(detalleProducto.getProducto().getCategoriaNombre())
                .append(", empresaId: ").append(empresaId)
                .append(", empresaNombre: ").append(empresa.getNombre())
                .append(", empresaRuc: ").append(empresa.getEmpresaRuc())
                .append(", precioCosto: ").append(detalleProducto.getProductoCosto())
                .append(", precioAdquisicionAnterior: ").append(precioVenta)
                .append(", fechaAquisicion: ").append(ultimaCompra)
                .append("}").toString();
    }
    
}
