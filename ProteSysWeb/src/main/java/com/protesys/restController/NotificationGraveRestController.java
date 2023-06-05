package com.protesys.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.protesys.services.NotificationGraveService;
import com.protesys.utils.notifications.NotificationGrave;

@RestController
@RequestMapping(value = "/notification-grave")
public class NotificationGraveRestController {

    @Autowired
    NotificationGraveService notificationGraveService;

    @Secured({"ROLE_NORMAL", "ROLE_INVITADO", "ROLE_ADMINISTRADOR", "ROLE_ADMIN_GRUPO"})
    @GetMapping(value = "/search")
    public List<NotificationGrave> listarNotificationGraves(){
        return this.notificationGraveService.getNotificationGraves();
    }

    @Secured({"ROLE_NORMAL", "ROLE_INVITADO", "ROLE_ADMINISTRADOR", "ROLE_ADMIN_GRUPO"})
    @GetMapping(value = "/search/{id}")
    public NotificationGrave buscarNotificationGrave(@PathVariable("id") Long id){
        return this.notificationGraveService.getNotificationGrave(id);
    }

    @Secured({"ROLE_ADMINISTRADOR"})
    @DeleteMapping(value = "/delete/{id}")
    public boolean eliminarNotificationGrave(@PathVariable("id") Long id){
        return this.notificationGraveService.deleteNotificationGrave(id);
    }

    @Secured({"ROLE_NORMAL", "ROLE_INVITADO", "ROLE_ADMINISTRADOR", "ROLE_ADMIN_GRUPO"})
    @PutMapping(value = "/update")
    public boolean actualizarNotificationGrave(@RequestBody NotificationGrave notificationGrave){
        return this.notificationGraveService.updateNotificationGrave(notificationGrave);
    }
}

