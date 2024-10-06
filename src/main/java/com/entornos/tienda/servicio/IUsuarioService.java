package com.entornos.tienda.servicio;

import java.util.List;
import com.entornos.tienda.modelo.Usuario;


public interface IUsuarioService {

/*------------------------------------------------------------------------------
 * Se agregan las cabeceras de los metodos a programar en la clase de servicio,
 * para cada uno de los metodos del CRUD
 --------------------------------------------------------------------------------*/

    List<Usuario> getUsuarios();

    Usuario nuevoUsuario(Usuario usuario);

    Usuario buscarUsuario(Long id);
    
    int borrarUsuario(Long id);
}
