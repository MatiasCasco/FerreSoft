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
public class DetalleProducto extends BaseEntity<Integer> {
    private int productoId;
    private int marcaId;
    private int productoCosto;
    private int productoPrecio;
    private int productoStockMax;
    private int productoStockActual;
    private int productoStockMin;

    public DetalleProducto(Integer id, String nombre) {
        super(0, "");
    }

    public DetalleProducto(int productoId, int marcaId, int productoCosto, int productoPrecio, int productoStockMax, int productoStockActual, int productoStockMin, Integer id, String nombre) {
        super(id, nombre);
        this.productoId = productoId;
        this.marcaId = marcaId;
        this.productoCosto = productoCosto;
        this.productoPrecio = productoPrecio;
        this.productoStockMax = productoStockMax;
        this.productoStockActual = productoStockActual;
        this.productoStockMin = productoStockMin;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public int getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(int marcaId) {
        this.marcaId = marcaId;
    }

    public int getProductoCosto() {
        return productoCosto;
    }

    public void setProductoCosto(int productoCosto) {
        this.productoCosto = productoCosto;
    }

    public int getProductoPrecio() {
        return productoPrecio;
    }

    public void setProductoPrecio(int productoPrecio) {
        this.productoPrecio = productoPrecio;
    }

    public int getProductoStockMax() {
        return productoStockMax;
    }

    public void setProductoStockMax(int productoStockMax) {
        this.productoStockMax = productoStockMax;
    }

    public int getProductoStockActual() {
        return productoStockActual;
    }

    public void setProductoStockActual(int productoStockActual) {
        this.productoStockActual = productoStockActual;
    }

    public int getProductoStockMin() {
        return productoStockMin;
    }

    public void setProductoStockMin(int productoStockMin) {
        this.productoStockMin = productoStockMin;
    }

    @Override
    public String toString() {
         return new StringBuilder("{id: ").append(id)
                .append(", nombre: ").append(nombre)
                .append(", productoId: ").append(productoId)
                .append(", marcaId: ").append(marcaId)
                .append(", productoCosto: ").append(productoCosto)
                .append(", productoPrecio: ").append(productoPrecio)
                .append(", productoStockMax: ").append(productoStockMax)
                .append(", productoStockActual: ").append(productoStockActual) 
                .append(", productoStockMin: ").append(productoStockMin).append("}").toString();
    }

}
