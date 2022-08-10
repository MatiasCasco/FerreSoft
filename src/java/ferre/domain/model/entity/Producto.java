/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferre.domain.model.entity;

/**
 *
 * @author Matias
 */
public class Producto extends BaseEntity<Integer>{
    
 
    private float iva;
    private String medidaStock;
    private int categoriaId;
    private boolean productoBoolean;

    public Producto(Integer id, String nombre) {
        super(0, "");
    }

    public Producto(float iva, String medidaStock, int categoriaId, boolean productoBoolean, Integer id, String nombre) {
        super(id, nombre);
        this.iva = iva;
        this.medidaStock = medidaStock;
        this.categoriaId = categoriaId;
        this.productoBoolean = productoBoolean;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public String getMedidaStock() {
        return medidaStock;
    }

    public void setMedidaStock(String medidaStock) {
        this.medidaStock = medidaStock;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public boolean isProductoBoolean() {
        return productoBoolean;
    }

    public void setProductoBoolean(boolean productoBoolean) {
        this.productoBoolean = productoBoolean;
    }

    @Override
    public String toString() {
        return new StringBuilder("{id: ").append(id)
                .append(", nombre: ").append(nombre)
                .append(", iva: ").append(iva)
                .append(", medidaStock: ").append(medidaStock)
                .append(", categoriaId: ").append(categoriaId)
                .append(", productoBoolean: ").append(productoBoolean).append("}").toString();
    }

}
