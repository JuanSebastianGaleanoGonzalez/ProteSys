package com.protesys.utils.notifications;

import com.protesys.model.Usuario;

public class NotificationNormalFactory implements NotificationFactory{
    public Notification crearNotification(String asunto, String contenido, Usuario usuario){
        return new NotificationNormal(usuario, asunto, contenido);
    }

    @Override
    public Notification crearNotification() {
        return new NotificationNormal();
    }
}
