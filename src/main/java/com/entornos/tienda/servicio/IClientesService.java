package com.entornos.tienda.servicio;

import java.util.List;

import com.entornos.tienda.modelo.Cliente;

public interface IClientesService {

    List<Cliente> getClientes();

    Cliente nuevoCliente(Cliente cliente);

    Cliente buscarCliente(Long id);

    void borrarCliente(Long id);

}
