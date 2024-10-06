package com.entornos.tienda.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entornos.tienda.modelo.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{

}
