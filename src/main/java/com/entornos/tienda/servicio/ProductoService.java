package com.entornos.tienda.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entornos.tienda.modelo.Producto;
import com.entornos.tienda.repositorio.ProductoRepositorio;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductoService implements IProductoService{

    @Autowired
    ProductoRepositorio productoRepositorio;

    @Override
    public List<Producto> getProducto() {
        return productoRepositorio.findAll();
    }

    @Override
    public Producto nuevoProducto(Producto producto) {
        return productoRepositorio.save(producto);
    }

    @Override
    public Producto buscarProducto(Long id) {
        Producto producto = null;
        producto = productoRepositorio.findById(id).orElse(null);
        if (producto == null) {
            return null;
        }
        return producto;
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepositorio.deleteById(id);
    }

}
