package com.protesys.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.protesys.model.Piso;
import com.protesys.services.PisoService;

@RestController
@RequestMapping(value = "/piso")
public class PisoRestController {

    @Autowired
    PisoService pisoService;

    @GetMapping(value = "/search")
    public List<Piso> listarPisos() {
        return this.pisoService.getPisos();
    }

    @GetMapping(value = "/search/{id}")
    public Piso buscarPiso(@PathVariable("id") Long id) {
        return this.pisoService.getPiso(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public boolean eliminarPiso(@PathVariable("id") Long id) {
        return this.pisoService.deletePiso(id);
    }

    @PostMapping(value = "/create")
    public boolean crearPiso(@RequestBody Piso piso) {
        return this.pisoService.createPiso(piso);
    }

    @PutMapping(value = "/update")
    public boolean actualizarPiso(@RequestBody Piso piso) {
        return this.pisoService.updatePiso(piso);
    }
}
