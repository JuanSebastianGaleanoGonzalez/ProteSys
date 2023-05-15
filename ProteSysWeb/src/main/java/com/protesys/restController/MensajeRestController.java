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

import com.protesys.services.MensajeService;
import com.protesys.utils.chat.Mensaje;

@RestController
@RequestMapping(value = "/mensaje")
public class MensajeRestController {

    @Autowired
    MensajeService mensajeService;

    @GetMapping(value = "/search")
    public List<Mensaje> listarMensajes() {
        return this.mensajeService.getMensajes();
    }

    @GetMapping(value = "/search/{id}")
    public Mensaje buscarMensaje(@PathVariable("id") Long id) {
        return this.mensajeService.getMensaje(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public boolean eliminarMensaje(@PathVariable("id") Long id) {
        return this.mensajeService.deleteMensaje(id);
    }

    @PostMapping(value = "/create")
    public boolean crearMensaje(@RequestBody Mensaje mensaje) {
        return this.mensajeService.createMensaje(mensaje);
    }

    @PutMapping(value = "/update")
    public boolean actualizarMensaje(@RequestBody Mensaje mensaje) {
        return this.mensajeService.updateMensaje(mensaje);
    }

}
