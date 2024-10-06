package com.entornos.tienda.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.entornos.tienda.modelo.Cliente;
import com.entornos.tienda.servicio.ClienteService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    //Listar los clientes
    @GetMapping("/list/cliente") // las rutas deben ser diferentes para cada metodo o si no seria ambiguo
    public List<Cliente> cargarClientes() {
        return clienteService.getClientes();
    }
    
    //buscar por id
    @GetMapping("/list/cliente/{id}")
    public Cliente buscarPorIDCliente(@RequestParam Long id) {
        return clienteService.buscarCliente(id);
    }
    
    //agregar cliente
    @PostMapping("/cliente/agregar")
    public ResponseEntity<Cliente> agregarCliente(@Valid @RequestBody Cliente cliente) {
        Cliente obj = clienteService.nuevoCliente(cliente);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    //actualizar cliente
    @PutMapping("/cliente/actualizar")
    public ResponseEntity<Cliente> editarCliente(@Valid @RequestBody Cliente cliente) {
        Cliente obj = clienteService.buscarCliente(cliente.getId());
        if (obj != null) {
            obj.setIdTipodocumento(cliente.getIdTipodocumento());
            obj.setNumeroDocumento(cliente.getNumeroDocumento());
            obj.setDireccion(cliente.getDireccion());
            obj.setEmail(cliente.getEmail());
            obj.setNombre(cliente.getNombre());
            obj.setTelefono(cliente.getTelefono());
            clienteService.nuevoCliente(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    //eliminar cliente

    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<Cliente> eliminarCliente(@PathVariable Long id) {
        Cliente obj = clienteService.buscarCliente(id);
        if (obj != null) {
            clienteService.borrarCliente(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}
