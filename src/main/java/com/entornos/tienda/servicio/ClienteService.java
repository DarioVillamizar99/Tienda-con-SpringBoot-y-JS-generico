package com.entornos.tienda.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entornos.tienda.modelo.Cliente;
import com.entornos.tienda.repositorio.ClienteRepositorio;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ClienteService implements IClientesService{

    @Autowired
    ClienteRepositorio clienteRepositorio;

    @Override
    public List<Cliente> getClientes() {
        return clienteRepositorio.findAll();
    }

    @Override
    public Cliente nuevoCliente(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    @Override
    public Cliente buscarCliente(Long id) {
        Cliente cliente = null;
        cliente = clienteRepositorio.findById(id).orElse(null);
        if (cliente == null) {
            return null;
        }
        return cliente;
    }

    @Override
    public void borrarCliente(Long id) {
        clienteRepositorio.deleteById(id);
    }

}
