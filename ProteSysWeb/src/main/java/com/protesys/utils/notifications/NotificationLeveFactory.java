package com.protesys.utils.notifications;

public class NotificationLeveFactory extends NotificationFactory{

    @Override
    public Notification crearNotification() {
        return new NotificationLeve();
    }
}
