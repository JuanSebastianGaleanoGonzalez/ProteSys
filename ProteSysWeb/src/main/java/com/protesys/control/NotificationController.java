package com.protesys.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.protesys.model.Usuario;
import com.protesys.model.UsuarioSubscriber;
import com.protesys.model.UsuarioSubscriberImplementation;
import com.protesys.services.UsuarioService;
import com.protesys.utils.chat.Chat;
import com.protesys.utils.chat.Mensaje;
import com.protesys.utils.notifications.NotificationFactory;
import com.protesys.utils.notifications.NotificationGrave;
import com.protesys.utils.notifications.NotificationGraveFactory;
import com.protesys.utils.notifications.NotificationLeve;
import com.protesys.utils.notifications.NotificationLeveFactory;
import com.protesys.utils.notifications.NotificationNormal;
import com.protesys.utils.notifications.NotificationNormalFactory;

@Controller
public class NotificationController {

    @Autowired
    UsuarioSubscriberImplementation usuarioSubscriberImplementation;

    @Autowired
    UsuarioService usuarioService;

    NotificationFactory notificationGraveFactory = new NotificationGraveFactory();
    NotificationFactory notificationNormalFactory = new NotificationNormalFactory();
    NotificationFactory notificationLeveFactory = new NotificationLeveFactory();

    private List<UsuarioSubscriber> subscribers = new ArrayList<>();

    public void addSubscriber(UsuarioSubscriber usuarioSubscriber) {
        this.subscribers.add(usuarioSubscriber);
    }

    public void removeSubscriber(UsuarioSubscriber usuarioSubscriber) {
        this.subscribers.remove(usuarioSubscriber);
    }

    public void notificacionCreacionChat(Chat chat) {
        NotificationNormal notificationNormal = (NotificationNormal) this.notificationNormalFactory.crearNotification();
        this.subscribers.clear();
        for (Usuario usuario : chat.getUsuarios()) {
            this.subscribers.add(usuario);
        }

        for (UsuarioSubscriber usuarioSubscriber : chat.getUsuarios()) {
            if (((Usuario) usuarioSubscriber).getIdUsuario() != chat.getUsuarios().get(chat.getUsuarios().size() - 1)
                    .getIdUsuario()) {
                notificationNormal = (NotificationNormal) this.notificationNormalFactory.crearNotification();
                notificationNormal.setAsunto("Se ha creado un nuevo chat.");
                notificationNormal.setContenido(chat.getUsuarios().get(chat.getUsuarios().size() - 1).getNombre()
                        + " te ha agregado al chat " + chat.getNombre());
                notificationNormal.setUsuario((Usuario) usuarioSubscriber);
                usuarioSubscriber.updateNotifications(notificationNormal);
                usuarioSubscriberImplementation.updateNotifications(notificationNormal);
            }
        }
    }

    public void notificacionMensajeRecibido(Mensaje mensaje, List<Chat> chats) {
        NotificationLeve notificationLeve = (NotificationLeve) this.notificationLeveFactory.crearNotification();
        this.subscribers.clear();
        for (Chat chat : chats) {
            for(Mensaje mensajeIterador: chat.getMensajes()){
                if(mensajeIterador.getIdMensaje() == mensaje.getIdMensaje()){
                    for (Usuario usuario : chat.getUsuarios()) {
                        this.subscribers.add((UsuarioSubscriber) usuario);
                    }
                }
            }
        }

        for (UsuarioSubscriber usuarioSubscriber : this.subscribers) {
            if (mensaje.getUsuarioEmisor().getIdUsuario() != ((Usuario) usuarioSubscriber).getIdUsuario()) {
                notificationLeve = (NotificationLeve)this.notificationLeveFactory.crearNotification();
                notificationLeve.setUsuario((Usuario) usuarioSubscriber);
                notificationLeve.setTexto(mensaje.getUsuarioEmisor().getNombre() + " te ha enviado un mensaje: " + mensaje.getMensaje());
                usuarioSubscriber.updateNotifications(notificationLeve);
                usuarioSubscriberImplementation.updateNotifications(notificationLeve);
            }
        }
    }

    public void crearNotificacionCorreoAutoridades(long idUsuario){
        NotificationGrave notificationGrave = (NotificationGrave) notificationGraveFactory.crearNotification();
        this.subscribers.clear();
        for(Usuario usuario: this.usuarioService.getUsuario(idUsuario).getGrupo().getUsuarios()){
            this.subscribers.add((UsuarioSubscriber)usuario);
        }
        for(UsuarioSubscriber usuarioSubscriber: this.subscribers){
            notificationGrave = (NotificationGrave)notificationGraveFactory.crearNotification();
            notificationGrave.setUsuario((Usuario)usuarioSubscriber);
            notificationGrave.setTitulo("ALERTA CORREO ELECTRONICO - AUTORIDADES");
            notificationGrave.setMotivo(this.usuarioService.getUsuario(idUsuario).getNombre() + " ha activado el boton de panico.");
            notificationGrave.setDescripcion("Se ha enviado un correo electronico a las autoridades competentes.");
            usuarioSubscriber.updateNotifications(notificationGrave);
            usuarioSubscriberImplementation.updateNotifications(notificationGrave);
        }
    }

    public void crearNotificacionMensajeAutoridades(long idUsuario){
        NotificationGrave notificationGrave = (NotificationGrave) notificationGraveFactory.crearNotification();
        this.subscribers.clear();
        for(Usuario usuario: this.usuarioService.getUsuario(idUsuario).getGrupo().getUsuarios()){
            this.subscribers.add((UsuarioSubscriber)usuario);
        }
        for(UsuarioSubscriber usuarioSubscriber: this.subscribers){
            notificationGrave = (NotificationGrave)notificationGraveFactory.crearNotification();
            notificationGrave.setUsuario((Usuario)usuarioSubscriber);
            notificationGrave.setTitulo("ALERTA MENSAJE DE TEXTO - AUTORIDADES");
            notificationGrave.setMotivo(this.usuarioService.getUsuario(idUsuario).getNombre() + " ha activado el boton de panico.");
            notificationGrave.setDescripcion("Se ha enviado un mensaje de texto a las autoridades competentes.");
            usuarioSubscriber.updateNotifications(notificationGrave);
            usuarioSubscriberImplementation.updateNotifications(notificationGrave);
        }
    }

    public void crearNotificacionLlamadaAutoridades(long idUsuario){
        NotificationGrave notificationGrave = (NotificationGrave) notificationGraveFactory.crearNotification();
        this.subscribers.clear();
        for(Usuario usuario: this.usuarioService.getUsuario(idUsuario).getGrupo().getUsuarios()){
            this.subscribers.add((UsuarioSubscriber)usuario);
        }
        for(UsuarioSubscriber usuarioSubscriber: this.subscribers){
            notificationGrave = (NotificationGrave)notificationGraveFactory.crearNotification();
            notificationGrave.setUsuario((Usuario)usuarioSubscriber);
            notificationGrave.setTitulo("ALERTA LLAMADA TELEFONICA - AUTORIDADES");
            notificationGrave.setMotivo(this.usuarioService.getUsuario(idUsuario).getNombre() + " ha activado el boton de panico.");
            notificationGrave.setDescripcion("Se ha ralizado una llamada de emergencia a las autoridades competentes.");
            usuarioSubscriber.updateNotifications(notificationGrave);
            usuarioSubscriberImplementation.updateNotifications(notificationGrave);
        }
    }
}