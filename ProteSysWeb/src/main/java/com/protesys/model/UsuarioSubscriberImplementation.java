package com.protesys.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.protesys.services.NotificationGraveService;
import com.protesys.services.NotificationLeveService;
import com.protesys.services.NotificationNormalService;
import com.protesys.utils.notifications.Notification;
import com.protesys.utils.notifications.NotificationGrave;
import com.protesys.utils.notifications.NotificationLeve;
import com.protesys.utils.notifications.NotificationNormal;

@Component
public class UsuarioSubscriberImplementation implements UsuarioSubscriber{

    @Autowired
    NotificationGraveService notificationServiceGraveService;

    @Autowired
    NotificationNormalService notificationNormalService;

    @Autowired 
    NotificationLeveService notificationLeveService;

    @Override
    public void updateNotifications(Notification notification) {
        try{
            this.notificationLeveService.createNotification((NotificationLeve)notification);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        try{
            this.notificationNormalService.createNotification((NotificationNormal)notification);
        }catch(Exception e){
            System.out.println(e.getMessage());

        }

        try{
            this.notificationServiceGraveService.createNotification((NotificationGrave)notification);
        }catch(Exception e){
            System.out.println(e.getMessage());

        }
    }    
}
