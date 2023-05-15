package com.protesys.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.protesys.model.Grupo;
import com.protesys.services.GrupoService;

public class GrupoRestController {
    
    @Autowired
    GrupoService grupoService;

    @GetMapping(value = "/search")
    public List<Grupo> listarGrupos() {
        return this.grupoService.getGrupos();
    }

    @GetMapping(value = "/search/{id}")
    public Grupo buscarGrupo(@PathVariable("id") Long id) {
        return this.grupoService.getGrupo(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public boolean eliminarGrupo(@PathVariable("id") Long id) {
        return this.grupoService.deleteGrupo(id);
    }

    @PostMapping(value = "/create")
    public boolean crearGrupo(@RequestBody Grupo grupo) {
        return this.grupoService.createGrupo(grupo);
    }

    @PutMapping(value = "/update")
    public boolean actualizarGrupo(@RequestBody Grupo grupo) {
        return this.grupoService.updateGrupo(grupo);
    }
}
