package com.protesys.model;

import com.protesys.utils.notifications.Notification;

public interface UsuarioSubscriber {
    public void updateNotifications(Notification notification);
}
