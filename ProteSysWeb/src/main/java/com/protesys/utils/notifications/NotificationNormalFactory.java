package com.protesys.utils.notifications;

public class NotificationNormalFactory extends NotificationFactory{
    @Override
    public Notification crearNotification() {
        return new NotificationNormal();
    }
}
