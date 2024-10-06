package com.entornos.tienda.servicio;

import java.util.List;

import com.entornos.tienda.modelo.Producto;

public interface IProductoService {

    List<Producto> getProducto();

    Producto nuevoProducto(Producto producto);

    Producto buscarProducto(Long id);

    void eliminarProducto(Long id);

}
