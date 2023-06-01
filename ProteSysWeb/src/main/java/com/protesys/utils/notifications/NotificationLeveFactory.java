package com.protesys.utils.notifications;

import com.protesys.model.Usuario;

public class NotificationLeveFactory implements NotificationFactory{
    public Notification crearNotification(String texto, Usuario usuario){
        return new NotificationLeve(texto, usuario);
    }

    @Override
    public Notification crearNotification() {
        return new NotificationLeve();
    }
}
