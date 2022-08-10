/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prueba;

import ferre.domain.model.entity.Producto;
import ferre.domain.model.repository.JdbcProductoRepository;
import ferre.domain.model.repository.ProductoRepository;

/**
 *
 * @author User
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        JdbcProductoRepository Producto = new JdbcProductoRepository();
        //System.out.println(Producto.getProducto(2).toString() + " JSON getProducto");
        //System.out.println(Producto.contains(3) + " Existe el producto 3");
        //System.out.println(Producto.get(2).toString() + " JSON get entity");
        System.out.println(Producto.findByIdCategoria(1).toString());
    }
    
}
