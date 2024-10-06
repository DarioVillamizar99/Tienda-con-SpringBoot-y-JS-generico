package com.entornos.tienda.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entornos.tienda.modelo.Proveedor;

public interface ProveedorRepositorio extends JpaRepository<Proveedor, Long>{ 

}
