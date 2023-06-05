package com.protesys.utils.notifications;

public class NotificationGraveFactory extends NotificationFactory{

    @Override
    public Notification crearNotification() {
        return new NotificationGrave();
    }
}
