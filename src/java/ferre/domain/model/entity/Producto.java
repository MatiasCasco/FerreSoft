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
    private String categoriaNombre;
    private boolean productoBoolean;
    private byte[] archivoimg/* = {}*/;
    private String archivoimg2/* = " "*/;

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
    
    public Producto(float iva, String medidaStock, int categoriaId, String categoriaNombre, boolean productoBoolean, Integer id, String nombre) {
        super(id, nombre);
        this.iva = iva;
        this.medidaStock = medidaStock;
        this.categoriaId = categoriaId;
        this.categoriaNombre = categoriaNombre;
        this.productoBoolean = productoBoolean;
    }

    public Producto(float iva, String medidaStock, int categoriaId, boolean productoBoolean, byte[] archivoimg, String archivoimg2, Integer id, String nombre) {
        super(id, nombre);
        this.iva = iva;
        this.medidaStock = medidaStock;
        this.categoriaId = categoriaId;
        this.productoBoolean = productoBoolean;
        this.archivoimg = archivoimg;
        this.archivoimg2 = archivoimg2;
    }
    
    public Producto(float iva, String medidaStock, int categoriaId, String categoriaNombre, boolean productoBoolean, String archivoimg2, Integer id, String nombre) {
        super(id, nombre);
        this.iva = iva;
        this.medidaStock = medidaStock;
        this.categoriaId = categoriaId;
        this.categoriaNombre = categoriaNombre;
        this.productoBoolean = productoBoolean;
        this.archivoimg2 = archivoimg2;
    }

    public Producto(float iva, String medidaStock, int categoriaId, String categoriaNombre, boolean productoBoolean, byte[] archivoimg, String archivoimg2, Integer id, String nombre) {
        super(id, nombre);
        this.iva = iva;
        this.medidaStock = medidaStock;
        this.categoriaId = categoriaId;
        this.categoriaNombre = categoriaNombre;
        this.productoBoolean = productoBoolean;
        this.archivoimg = archivoimg;
        this.archivoimg2 = archivoimg2;
    }

    public String getProductoNombre() {
        return getNombre();
    }

    public String getCategoriaNombre() {
        return categoriaNombre;
    }

    public void setCategoriaNombre(String categoriaNombre) {
        this.categoriaNombre = categoriaNombre;
    }

    public byte[] getArchivoimg() {
        return archivoimg;
    }

    public void setArchivoimg(byte[] archivoimg) {
        this.archivoimg = archivoimg;
    }

    public String getArchivoimg2() {
        return archivoimg2;
    }

    public void setArchivoimg2(String archivoimg2) {
        this.archivoimg2 = archivoimg2;
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
                .append(", categoriaNombre: ").append(categoriaNombre)
                .append(", productoBoolean: ").append(productoBoolean)
                .append(", imageView: ").append(archivoimg)
                .append(", imageByte: ").append(archivoimg2)
                .append("}").toString();
    }

}
