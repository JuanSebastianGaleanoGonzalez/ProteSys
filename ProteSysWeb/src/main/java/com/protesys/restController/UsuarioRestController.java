package com.protesys.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.protesys.model.Usuario;
import com.protesys.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioRestController {

    @Autowired
    UsuarioService usuarioService;

    @Secured({"ROLE_NORMAL", "ROLE_INVITADO", "ROLE_ADMINISTRADOR", "ROLE_ADMIN_GRUPO"})
    @GetMapping(value = "/search")
    public List<Usuario> listarUsuarios(){
        return this.usuarioService.getUsuarios();
    }

    @Secured({"ROLE_NORMAL", "ROLE_INVITADO", "ROLE_ADMINISTRADOR", "ROLE_ADMIN_GRUPO"})
    @GetMapping(value = "/search/{id}")
    public Usuario buscarUsuario(@PathVariable ("id") Long id){
        return this.usuarioService.getUsuario(id);
    }

    @Secured({"ROLE_ADMINISTRADOR"})
    @DeleteMapping(value = "/delete/{id}")
    public boolean eliminarUsuario(@PathVariable ("id") Long id){
        return this.usuarioService.deleteUsuario(id);
    }

    @Secured({"ROLE_NORMAL", "ROLE_INVITADO", "ROLE_ADMINISTRADOR", "ROLE_ADMIN_GRUPO"})
    @PostMapping(value = "/create")
    public boolean crearUsuario(@RequestBody Usuario usuario){
        return this.usuarioService.createUsuario(usuario);
    }

    @Secured({"ROLE_NORMAL", "ROLE_INVITADO", "ROLE_ADMINISTRADOR", "ROLE_ADMIN_GRUPO"})
    @PutMapping(value = "/update")
    public boolean actualizarUsuario(@RequestBody Usuario usuario){
        return this.usuarioService.updateUsuario(usuario);
    }
}
