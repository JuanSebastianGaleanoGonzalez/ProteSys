package com.protesys.utils.notifications;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import com.protesys.model.Usuario;
import com.protesys.services.NotificationNormalService;

@Entity
@Table(name = "notification_normal")
public class NotificationNormal implements Notification{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idNotification;

    public NotificationNormal() {
    }

    @Column(name = "asunto")
    private String asunto;

    @Column(name = "contenido")
    private String contenido;

    @OneToOne
    private Usuario usuario;
    
    public NotificationNormal(Usuario usuario, String asunto, String contenido) {
        this.usuario = usuario;
        this.asunto = asunto;
        this.contenido = contenido;
    }

    public long getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(long idNotification) {
        this.idNotification = idNotification;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Autowired
    @Transient
    NotificationNormalService notificationNormalService;

    @Override
    public void crearNotification() {
        this.notificationNormalService.createNotificationNormal(this);
    }
    
    
}
