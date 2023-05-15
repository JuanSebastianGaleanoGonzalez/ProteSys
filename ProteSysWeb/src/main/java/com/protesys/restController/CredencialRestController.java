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

import com.protesys.model.Credencial;
import com.protesys.services.CredencialService;

@RestController
@RequestMapping(value = "/credencial")
public class CredencialRestController {
    @Autowired
    CredencialService credencialService;

    @GetMapping(value = "/search")
    public List<Credencial> listarCredenciales() {
        return this.credencialService.getCredenciales();
    }

    @GetMapping(value = "/search/{id}")
    public Credencial buscarCredencial(@PathVariable("id") Long id) {
        return this.credencialService.getCredencial(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public boolean eliminarCredencial(@PathVariable("id") Long id) {
        return this.credencialService.deleteCredencial(id);
    }

    @PostMapping(value = "/create")
    public boolean crearCredencial(@RequestBody Credencial credencial) {
        return this.credencialService.createCredencial(credencial);
    }

    @PutMapping(value = "/update")
    public boolean actualizarCredencial(@RequestBody Credencial credencial) {
        return this.credencialService.updateCredencial(credencial);
    }
}
