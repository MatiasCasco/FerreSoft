/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prueba;

import ferre.domain.model.entity.DetalleProducto;
import ferre.domain.model.entity.Producto;
import ferre.domain.model.repository.JdbcDetalleProducto;
import ferre.domain.model.repository.JdbcImageRepository;
import ferre.domain.model.repository.JdbcProductoRepository;
import ferre.domain.model.repository.ProductoRepository;
import java.io.FileInputStream;
import org.apache.commons.io.IOUtils;


/**
 *
 * @author Matias
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
/* Producto     
        try{
            JdbcProductoRepository Producto = new JdbcProductoRepository();
            FileInputStream myStream = new FileInputStream("C:\\Users\\User\\Pictures\\Productos\\Pintura.jpg");
            byte[] imageInBytes = IOUtils.toByteArray(myStream);
            Producto Product = new Producto(10, "Kilo", 1, false, imageInBytes, " ", 13,"Clavo 1 x 18 mm");
      
            Producto.update(Product);
//            Producto.add(Product);
//            System.out.println(Product.toString());
//            System.out.println(Producto.getProducto(2).toString() + " JSON getProducto");
//            System.out.println(Producto.contains(5) + " Existe el producto");
//            System.out.println(Producto.get(8).toString() + " JSON get entity");
//            System.out.println(Producto.get(1).toString() + " JSON get entity");
            System.out.println(Producto.get(13).toString() + " JSON get entity");
//            System.out.println(Producto.contains(4) + " Busca y retorna un boolean");
//            Producto.remove(6);
//            System.out.println(Producto.getAll());
//            System.out.println(Producto.findByIdMarca(6).toString());
//          System.out.println(Producto.findByIdCategoria(1).toString());
        } catch (Exception ex){
//        
        }
  Producto */
        /*DetalleProducto
        JdbcDetalleProducto DP = new JdbcDetalleProducto();
        DetalleProducto DetP = new DetalleProducto(1, 2, 0, 0, 0, 0, 0, 6, " ");
        System.out.println(DP.contains(5));
        System.out.println(DP.get(5));
        System.out.println(DP.getAll().toString());
//        DP.add(DetP);
//        DP.update(DetP);
        System.out.println(DP.findByIdProducto(1));
        System.out.println(DP.findByIdProductoAndIdMarca(2, 1));
        DetalleProducto*/
        JdbcImageRepository Imagen = new JdbcImageRepository();
        System.out.println(Imagen.image(13));
        System.out.println(Imagen.image(12));
    }   
}
