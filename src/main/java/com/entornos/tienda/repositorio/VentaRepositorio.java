package com.entornos.tienda.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entornos.tienda.modelo.Venta;

public interface VentaRepositorio extends JpaRepository<Venta, Long>{

}
