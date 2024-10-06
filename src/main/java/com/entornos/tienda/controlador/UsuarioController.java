package com.entornos.tienda.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entornos.tienda.modelo.Usuario;
import com.entornos.tienda.servicio.UsuarioService;

import jakarta.validation.Valid;

@RestController
public class UsuarioController {

    /*---------------------------------------------------------
        inyectamos el/la interface del servicio para 
        acceder a los metodos del negocio
     ------------------------------------------------------------*/

     @Autowired
     UsuarioService usuarioService;

     //Listar los usuarios
     @GetMapping("/list/Usuario")
     public List<Usuario> cargarUsuarios() {
        return usuarioService.getUsuarios();
     }

     //Buscar por id
     @PostMapping("/list/Usuario/{id}")
     public Usuario buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarUsuario(id);
     }

     //Agregar un usuario
     @PostMapping("/usuario/agregar")
     public ResponseEntity<Usuario> agregar(@Valid @RequestBody Usuario usuario) {
        Usuario obj = usuarioService.nuevoUsuario(usuario);
        return new ResponseEntity<>(obj, HttpStatus.OK);
     }

     //Acturalizar un usuario
     @PutMapping("/usuario/actualizar")
     public ResponseEntity<Usuario> actualizar(@Valid @RequestBody Usuario usuario) {
        Usuario obj = usuarioService.buscarUsuario(usuario.getId());
        if (obj != null) {
            obj.setEmail(usuario.getEmail());
            obj.setIdTipodocumento(usuario.getIdTipodocumento());
            obj.setNombre(usuario.getNombre());
            obj.setNombreUsuario(usuario.getNombreUsuario());
            obj.setNumeroDocumento(usuario.getNumeroDocumento());
            obj.setPassword(usuario.getPassword());
            usuarioService.nuevoUsuario(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
            return new ResponseEntity<>(obj, HttpStatus.OK);
     }

     //Eliminar un usuario
     @DeleteMapping("/usuario/{id}")
     public ResponseEntity<Usuario> eliminar(@PathVariable Long id) {
        Usuario obj = usuarioService.buscarUsuario(id);
        if(obj != null) {
            usuarioService.borrarUsuario(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
     }

}
