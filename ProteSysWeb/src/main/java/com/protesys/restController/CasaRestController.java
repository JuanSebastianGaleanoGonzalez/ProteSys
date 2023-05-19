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

import com.protesys.model.Casa;
import com.protesys.services.CasaService;

@RestController
@RequestMapping(value = "/casa")
public class CasaRestController {

    @Autowired
    CasaService casaService;

    @Secured({"ROLE_NORMAL", "ROLE_INVITADO", "ROLE_ADMINISTRADOR", "ROLE_ADMIN_GRUPO"})
    @GetMapping(value = "/search")
    public List<Casa> listarCasas() {
        return this.casaService.getCasas();
    }

    @Secured({"ROLE_NORMAL", "ROLE_INVITADO", "ROLE_ADMINISTRADOR", "ROLE_ADMIN_GRUPO"})
    @GetMapping(value = "/search/{id}")
    public Casa buscarCasa(@PathVariable("id") Long id) {
        return this.casaService.getCasa(id);
    }

    @Secured({"ROLE_ADMINISTRADOR"})
    @DeleteMapping(value = "/delete/{id}")
    public boolean eliminarCasa(@PathVariable("id") Long id) {
        return this.casaService.deleteCasa(id);
    }

    @Secured({"ROLE_ADMINISTRADOR"})
    @PostMapping(value = "/create")
    public boolean crearCasa(@RequestBody Casa casa) {
        return this.casaService.createCasa(casa);
    }

    @Secured({"ROLE_ADMINISTRADOR"})
    @PutMapping(value = "/update")
    public boolean actualizarCasa(@RequestBody Casa casa) {
        return this.casaService.updateCasa(casa);
    }
}
