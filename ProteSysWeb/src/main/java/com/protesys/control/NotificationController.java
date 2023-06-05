package com.protesys.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.protesys.model.Usuario;
import com.protesys.model.UsuarioSubscriber;
import com.protesys.model.UsuarioSubscriberImplementation;
import com.protesys.utils.chat.Chat;
import com.protesys.utils.notifications.Notification;
import com.protesys.utils.notifications.NotificationFactory;
import com.protesys.utils.notifications.NotificationGraveFactory;
import com.protesys.utils.notifications.NotificationLeveFactory;
import com.protesys.utils.notifications.NotificationNormal;
import com.protesys.utils.notifications.NotificationNormalFactory;

@Controller
public class NotificationController {
    
    @Autowired
    UsuarioSubscriberImplementation usuarioSubscriberImplementation;
    
    NotificationFactory notificationGraveFactory = new NotificationGraveFactory();
    NotificationFactory notificationNormalFactory = new NotificationNormalFactory();
    NotificationFactory notificationLeveFactory = new NotificationLeveFactory();

    private List<UsuarioSubscriber> subscribers = new ArrayList<>();

    public void addSubscriber(UsuarioSubscriber usuarioSubscriber){
        this.subscribers.add(usuarioSubscriber);
    }

    public void removeSubscriber(UsuarioSubscriber usuarioSubscriber){
        this.subscribers.remove(usuarioSubscriber);
    }

    public void notificacionCreacionChat(Chat chat){
        NotificationNormal notificationNormal = (NotificationNormal) this.notificationNormalFactory.crearNotification();
        this.subscribers.clear();
        for(Usuario usuario: chat.getUsuarios()){
            this.subscribers.add(usuario);
        }
        
        for(UsuarioSubscriber usuarioSubscriber: chat.getUsuarios()){
            notificationNormal = (NotificationNormal) this.notificationNormalFactory.crearNotification();
            notificationNormal.setAsunto("Se ha creado un nuevo chat.");
            notificationNormal.setContenido(chat.getUsuarios().get(chat.getUsuarios().size() - 1).getNombre() + " te ha agregado al chat " + chat.getNombre());
            notificationNormal.setUsuario((Usuario)usuarioSubscriber);
            usuarioSubscriber.updateNotifications(notificationNormal);
            usuarioSubscriberImplementation.updateNotifications(notificationNormal);
        }
    }
}