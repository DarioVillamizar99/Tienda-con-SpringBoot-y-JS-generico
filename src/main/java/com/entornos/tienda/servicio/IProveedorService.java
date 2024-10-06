package com.entornos.tienda.servicio;

import java.util.List;

import com.entornos.tienda.modelo.Proveedor;
 
public interface IProveedorService{

    List<Proveedor> getProveedor();

    Proveedor nuevoProveedor(Proveedor proveedor);

    Proveedor buscaProveedor(Long id);

    void eliminaProveedor(Long id);
    
}
