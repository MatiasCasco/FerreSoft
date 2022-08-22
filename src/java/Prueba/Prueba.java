/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prueba;

import ferre.domain.model.entity.DetalleProducto;
import ferre.domain.model.entity.Empresa;
import ferre.domain.model.entity.EmpresaContacto;
import ferre.domain.model.entity.Producto;
import ferre.domain.model.repository.JdbcDetalleProducto;
import ferre.domain.model.repository.JdbcEmpresaContactoRepository;
import ferre.domain.model.repository.JdbcEmpresaRepository;
import ferre.domain.model.repository.JdbcImageRepository;
import ferre.domain.model.repository.JdbcProductoRepository;
import ferre.domain.model.repository.ProductoRepository;
import java.io.FileInputStream;
import java.util.ArrayList;
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
      
//            Producto.update(Product);
//            Producto.add(Product);
//            System.out.println(Product.toString());
//            System.out.println(Producto.getProducto(2).toString() + " JSON getProducto");
//            System.out.println(Producto.contains(5) + " Existe el producto");
//            System.out.println(Producto.get(8).toString() + " JSON get entity");
//            System.out.println(Producto.get(1).toString() + " JSON get entity");
            System.out.println(Producto.get(12).toString() + " JSON get entity");
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
        /*
        JdbcImageRepository Imagen = new JdbcImageRepository();
        System.out.println(Imagen.image(13));
        System.out.println(Imagen.image(12));
        */
        JdbcEmpresaRepository Empresa = new JdbcEmpresaRepository();
//        ArrayList<EmpresaContacto> empCont = new ArrayList();
//        empCont.add(new EmpresaContacto(5, 3, "Carlos Coronel", "+59598108899", "coronel@gmail.com"));
//        empCont.add(new EmpresaContacto(6, 3, "Call Center Pai Puku", "+59598108898", "paipuku@gmail.com"));
        Empresa.remove(4);
//        Empresa.update(new Empresa("4321700-8", empCont, 3, "Pai Puku"));
//        System.out.println(Empresa.findByRuc("4321716-8"));
//        System.out.println(Empresa.findByName("Tigre s.a"));
//        JdbcEmpresaContactoRepository EC = new JdbcEmpresaContactoRepository();
//        EC.removeContactosEmpresa(1);

    }   
}
