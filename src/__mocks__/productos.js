import { v4 as uuid } from 'uuid';

export const Productos = [
    { 
      id: uuid(),
      isModified:false,
      nombre:"canho pvc 50mm",
      iva:10.0,
      medidaStock:"metros",
      categoriaId:1,
      precio:3500,
      cantidad:5,
      categoriaNombre:"Plomeria",
      productoBoolean:true,
      archivoimg2:"http://192.168.56.1:8084/FerreSoft/rest/ImageAPI/image/1"
    },
    {
      id: uuid(),
      isModified:false,
      nombre:"Cemento bolsa de 50k",
      iva:10.0,
      medidaStock:"unidad",
      categoriaId:3,
      precio:5500,
      cantidad:5,
      categoriaNombre:"Varios",
      productoBoolean:true,
      archivoimg2:"http://192.168.56.1:8084/FerreSoft/rest/ImageAPI/image/2"
    },
    { 
      id: uuid(),
      isModified:false,
      nombre:"Pinturas amanecer 5litros",
      iva:10.0,
      medidaStock:"unidad",
      categoriaId:3,
      precio:4500,
      cantidad:5,
      categoriaNombre:"Varios",
      productoBoolean:true,
      archivoimg2:"http://192.168.56.1:8084/FerreSoft/rest/ImageAPI/image/3"
    }
  ]
  
;
