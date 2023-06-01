package com.protesys.utils.notifications;

import com.protesys.model.Usuario;

public class NotificationGraveFactory implements NotificationFactory{

    public Notification crearNotification(String titulo, String motivo, String descripcion, Usuario usuario) {
        return new NotificationGrave(usuario, titulo, motivo, descripcion);
    }

    @Override
    public Notification crearNotification() {
        return new NotificationGrave();
    }
    
}
