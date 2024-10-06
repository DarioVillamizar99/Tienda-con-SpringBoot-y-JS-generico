package com.entornos.tienda.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entornos.tienda.modelo.Proveedor;
import com.entornos.tienda.repositorio.ProveedorRepositorio;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProveedorService implements IProveedorService{

    @Autowired
    ProveedorRepositorio proveedorRepositorio;

    @Override
    public List<Proveedor> getProveedor() {
        return proveedorRepositorio.findAll(); 
    }

    @Override
    public Proveedor nuevoProveedor(Proveedor proveedor) {
        return proveedorRepositorio.save(proveedor);
    }

    @Override
    public Proveedor buscaProveedor(Long id) {
        Proveedor proveedor = null;
        proveedor = proveedorRepositorio.findById(id).orElse(null);
        if (proveedor == null) {
            return null;
        } 
        return proveedor;
    }

    @Override
    public void eliminaProveedor(Long id) {
        proveedorRepositorio.deleteById(id);
    }



}
