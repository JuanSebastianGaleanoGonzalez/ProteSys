package com.protesys.utils.facadeAutoridades;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.protesys.control.NotificationController;

@Component
public class AlertaCorreo implements ApplicationContextAware{

    private ApplicationContext applicationContext;
    private NotificationController notificationController;

    @Override
    public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext)
            throws BeansException {
                this.applicationContext = applicationContext;

    }

    public void enviarCorreo(long idUsuario) {
        System.out.println("Correo enviado con exito. Usuario que activo el boton: " + idUsuario);
        //this.notificationController = this.applicationContext.getBean(NotificationController.class);
        //this.notificationController.crearNotificacionCorreoAutoridades(idUsuario);
    } 
}
