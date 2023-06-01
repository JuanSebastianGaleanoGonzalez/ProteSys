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

import com.protesys.services.NotificationNormalService;
import com.protesys.utils.notifications.NotificationNormal;

@RestController
@RequestMapping(value = "/notification-normal")
public class NotificationNormalRestController {

    @Autowired
    NotificationNormalService notificationNormalService;

    @Secured({"ROLE_NORMAL", "ROLE_INVITADO", "ROLE_ADMINISTRADOR", "ROLE_ADMIN_GRUPO"})
    @GetMapping(value = "/search")
    public List<NotificationNormal> listarNotificationNormals(){
        return this.notificationNormalService.getNotificationNormals();
    }

    @Secured({"ROLE_NORMAL", "ROLE_INVITADO", "ROLE_ADMINISTRADOR", "ROLE_ADMIN_GRUPO"})
    @GetMapping(value = "/search/{id}")
    public NotificationNormal buscarNotificationNormal(@PathVariable("id") Long id){
        return this.notificationNormalService.getNotificationNormal(id);
    }

    @Secured({"ROLE_ADMINISTRADOR"})
    @DeleteMapping(value = "/delete/{id}")
    public boolean eliminarNotificationNormal(@PathVariable("id") Long id){
        return this.notificationNormalService.deleteNotificationNormal(id);
    }

    @Secured({"ROLE_NORMAL", "ROLE_INVITADO", "ROLE_ADMINISTRADOR", "ROLE_ADMIN_GRUPO"})
    @PostMapping(value = "/create")
    public boolean crearNotificationNormal(@RequestBody NotificationNormal notificationNormal){
        return this.notificationNormalService.createNotificationNormal(notificationNormal);
    }

    @Secured({"ROLE_NORMAL", "ROLE_INVITADO", "ROLE_ADMINISTRADOR", "ROLE_ADMIN_GRUPO"})
    @PutMapping(value = "/update")
    public boolean actualizarNotificationNormal(@RequestBody NotificationNormal notificationNormal){
        return this.notificationNormalService.updateNotificationNormal(notificationNormal);
    }
}
