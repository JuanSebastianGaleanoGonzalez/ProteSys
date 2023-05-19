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

import com.protesys.model.Grupo;
import com.protesys.services.GrupoService;

@RestController
@RequestMapping(value = "/grupo")
public class GrupoRestController {
    
    @Autowired
    GrupoService grupoService;

    @Secured({"ROLE_NORMAL", "ROLE_INVITADO", "ROLE_ADMINISTRADOR", "ROLE_ADMIN_GRUPO"})
    @GetMapping(value = "/search")
    public List<Grupo> listarGrupos() {
        return this.grupoService.getGrupos();
    }

    @Secured({"ROLE_NORMAL", "ROLE_INVITADO", "ROLE_ADMINISTRADOR", "ROLE_ADMIN_GRUPO"})
    @GetMapping(value = "/search/{id}")
    public Grupo buscarGrupo(@PathVariable("id") Long id) {
        return this.grupoService.getGrupo(id);
    }

    @Secured({"ROLE_ADMINISTRADOR"})
    @DeleteMapping(value = "/delete/{id}")
    public boolean eliminarGrupo(@PathVariable("id") Long id) {
        return this.grupoService.deleteGrupo(id);
    }

    @Secured({"ROLE_ADMINISTRADOR"})
    @PostMapping(value = "/create")
    public boolean crearGrupo(@RequestBody Grupo grupo) {
        return this.grupoService.createGrupo(grupo);
    }

    @Secured({"ROLE_ADMINISTRADOR", "ROLE_ADMIN_GRUPO"})
    @PutMapping(value = "/update")
    public boolean actualizarGrupo(@RequestBody Grupo grupo) {
        return this.grupoService.updateGrupo(grupo);
    }
}
