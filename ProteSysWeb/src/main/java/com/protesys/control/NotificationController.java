package com.protesys.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.api.services.storage.model.Notification;
import com.protesys.services.NotificationGraveService;
import com.protesys.services.NotificationLeveService;
import com.protesys.services.NotificationNormalService;

@Controller
public class NotificationController {
    
    @Autowired
    NotificationLeveService notificationLeveService;

    @Autowired
    NotificationNormalService notificationNormalService;

    @Autowired
    NotificationGraveService notificationGraveService;

    public void crearNotification(Notification notification){
        
    }

}
