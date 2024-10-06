package com.entornos.tienda.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entornos.tienda.modelo.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

}
