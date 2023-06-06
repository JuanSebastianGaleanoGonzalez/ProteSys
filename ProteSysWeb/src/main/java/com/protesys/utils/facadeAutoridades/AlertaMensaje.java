package com.protesys.utils.facadeAutoridades;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.protesys.control.NotificationController;

@Component
public class AlertaMensaje implements ApplicationContextAware{

    private ApplicationContext applicationContext;
    private NotificationController notificationController;

    @Override
    public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext)
            throws BeansException {
                this.applicationContext = applicationContext;

    }

    public void enviarMensaje(long idUsuario) {
        System.out.println("Mensaje de texto enviado con exito. Usuario que activo el boton: " + idUsuario);
        //this.notificationController = this.applicationContext.getBean(NotificationController.class);
        //this.notificationController.crearNotificacionMensajeAutoridades(idUsuario);
    }
    
}
