package com.entornos.tienda.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entornos.tienda.modelo.Producto;
import com.entornos.tienda.servicio.ProductoService;

import jakarta.validation.Valid;


@RestController
public class ProductoController {

    @Autowired
    ProductoService productoService;

    //Listar productos 
    @GetMapping("/list/productos")
    public List<Producto> cargarProductos() {
        return productoService.getProducto();
    }
    //buscar producto
    @GetMapping("/list/producto/{id}")
    public Producto buscarPorIdProducto(@RequestParam Long id) {
        return productoService.buscarProducto(id);
    }
    //agregar producto
    @PostMapping("/producto/agregar")
    public ResponseEntity<Producto> agregarProducto(@Valid @RequestBody Producto producto) {
        Producto obj = productoService.nuevoProducto(producto);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    //actualizar cliente
    @PutMapping("/producto/actualizar")
    public ResponseEntity<Producto> editarProducto(@Valid @RequestBody Producto producto) {
        Producto obj = productoService.buscarProducto(producto.getId());
        if (obj != null) {
            obj.setIdProveedor(producto.getIdProveedor());
            obj.setIvaCompra(producto.getIvaCompra());
            obj.setNombre(producto.getNombre());
            obj.setPrecioCompra(producto.getPrecioCompra());
            obj.setPrecioVenta(producto.getPrecioVenta());
            productoService.nuevoProducto(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    //eliminar cliente
    @DeleteMapping("/borrar/producto/{id}")
    public ResponseEntity<Producto> eliminarProducto(@PathVariable Long id) {
        Producto obj = productoService.buscarProducto(id);
        if (obj != null) {
            productoService.eliminarProducto(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}
