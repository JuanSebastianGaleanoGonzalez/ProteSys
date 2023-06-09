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

import com.protesys.services.MensajeService;
import com.protesys.utils.chat.Mensaje;
import com.protesys.utils.notifications.NotificationFactory;
import com.protesys.utils.notifications.NotificationNormal;
import com.protesys.utils.notifications.NotificationNormalFactory;

@RestController
@RequestMapping(value = "/mensaje")
public class MensajeRestController {

    @Autowired
    MensajeService mensajeService;

    NotificationFactory notificationFactory = new NotificationNormalFactory();
    NotificationNormal notificationNormal = (NotificationNormal) notificationFactory.crearNotification();
    
    @Secured({"ROLE_NORMAL", "ROLE_INVITADO", "ROLE_ADMINISTRADOR", "ROLE_ADMIN_GRUPO"})
    @GetMapping(value = "/search")
    public List<Mensaje> listarMensajes() {
        return this.mensajeService.getMensajes();
    }

    @Secured({"ROLE_NORMAL", "ROLE_INVITADO", "ROLE_ADMINISTRADOR", "ROLE_ADMIN_GRUPO"})
    @GetMapping(value = "/search/{id}")
    public Mensaje buscarMensaje(@PathVariable("id") Long id) {
        return this.mensajeService.getMensaje(id);
    }

    @Secured({"ROLE_ADMINISTRADOR"})
    @DeleteMapping(value = "/delete/{id}")
    public boolean eliminarMensaje(@PathVariable("id") Long id) {
        return this.mensajeService.deleteMensaje(id);
    }

    @Secured({"ROLE_NORMAL", "ROLE_INVITADO", "ROLE_ADMINISTRADOR", "ROLE_ADMIN_GRUPO"})
    @PostMapping(value = "/create")
    public Mensaje crearMensaje(@RequestBody Mensaje mensaje) {
        //notificationNormal.setAsunto("Mensaje Recibido");
        //notificationNormal.setContenido("Mensajeeeee");
        //notificationNormal.crearNotification();
        return this.mensajeService.createMensaje(mensaje);
    }

    @Secured({"ROLE_ADMINISTRADOR"})
    @PutMapping(value = "/update")
    public boolean actualizarMensaje(@RequestBody Mensaje mensaje) {
        return this.mensajeService.updateMensaje(mensaje);
    }
}
