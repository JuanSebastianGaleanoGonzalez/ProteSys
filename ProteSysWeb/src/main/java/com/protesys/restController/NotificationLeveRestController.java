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

import com.protesys.services.NotificationLeveService;
import com.protesys.utils.notifications.NotificationLeve;

@RestController
@RequestMapping(value = "/notification-leve")
public class NotificationLeveRestController {

    @Autowired
    NotificationLeveService notificationLeveService;

    @Secured({"ROLE_NORMAL", "ROLE_INVITADO", "ROLE_ADMINISTRADOR", "ROLE_ADMIN_GRUPO"})
    @GetMapping(value = "/search")
    public List<NotificationLeve> listarNotificationLeves(){
        return this.notificationLeveService.getNotificationLeves();
    }

    @Secured({"ROLE_NORMAL", "ROLE_INVITADO", "ROLE_ADMINISTRADOR", "ROLE_ADMIN_GRUPO"})
    @GetMapping(value = "/search/{id}")
    public NotificationLeve buscarNotificationLeve(@PathVariable("id") Long id){
        return this.notificationLeveService.getNotificationLeve(id);
    }

    @Secured({"ROLE_ADMINISTRADOR"})
    @DeleteMapping(value = "/delete/{id}")
    public boolean eliminarNotificationLeve(@PathVariable("id") Long id){
        return this.notificationLeveService.deleteNotificationLeve(id);
    }

    @Secured({"ROLE_NORMAL", "ROLE_INVITADO", "ROLE_ADMINISTRADOR", "ROLE_ADMIN_GRUPO"})
    @PostMapping(value = "/create")
    public boolean crearNotificationLeve(@RequestBody NotificationLeve notificationLeve){
        return this.notificationLeveService.createNotificationLeve(notificationLeve);
    }

    @Secured({"ROLE_NORMAL", "ROLE_INVITADO", "ROLE_ADMINISTRADOR", "ROLE_ADMIN_GRUPO"})
    @PutMapping(value = "/update")
    public boolean actualizarNotificationLeve(@RequestBody NotificationLeve notificationLeve){
        return this.notificationLeveService.updateNotificationLeve(notificationLeve);
    }
}
