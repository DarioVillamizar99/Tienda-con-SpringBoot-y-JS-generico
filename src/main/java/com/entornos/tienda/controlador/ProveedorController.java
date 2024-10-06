package com.entornos.tienda.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.entornos.tienda.modelo.Proveedor;
import com.entornos.tienda.servicio.ProveedorService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
public class ProveedorController {

    @Autowired
    ProveedorService proveedorService;

    //Listar proveedores
    @GetMapping("/list/proveedores")
    public List<Proveedor> cargarProveedores() {
        return proveedorService.getProveedor();
    }
    
    //buscar proveedor
    @PostMapping("/list/proveedores/{id}")
    public Proveedor buscarPorId(@PathVariable Long id) {
        return proveedorService.buscaProveedor(id);
    }
    
    //agregar proveedor
    @PostMapping("/proveedor/agregar")
    public ResponseEntity<Proveedor> agregarProveedor(@Valid @RequestBody Proveedor proveedor) {
        Proveedor obj = proveedorService.nuevoProveedor(proveedor);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    //actualizar proveedor
    @PutMapping("proveedor/editar/{id}")
    public ResponseEntity<Proveedor> editarProveedor(@Valid @RequestBody Proveedor proveedor) {
        Proveedor obj = proveedorService.buscaProveedor(proveedor.getId());
        if (obj != null) {
            obj.setCiudad(proveedor.getCiudad());
            obj.setDireccion(proveedor.getDireccion());
            obj.setNombre(proveedor.getNombre());
            obj.setTelefono(proveedor.getTelefono());
            obj.setNit(proveedor.getNit());
            proveedorService.nuevoProveedor(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    //eliminar proveedor
    @DeleteMapping("/proveedor/{id}")
    public ResponseEntity<Proveedor> eliminarProveedor(@PathVariable Long id) {
        Proveedor obj = proveedorService.buscaProveedor(id);
        if (obj != null) {
            proveedorService.eliminaProveedor(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}
