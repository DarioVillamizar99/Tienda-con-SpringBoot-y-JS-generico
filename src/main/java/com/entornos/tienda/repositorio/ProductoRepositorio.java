package com.entornos.tienda.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entornos.tienda.modelo.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Long>{

}
