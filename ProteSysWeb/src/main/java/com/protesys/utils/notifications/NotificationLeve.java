package com.protesys.utils.notifications;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.protesys.model.Usuario;

@Entity
@Table(name = "notification_leve")
public class NotificationLeve implements Notification{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idNotification;

    @Column(name = "texto")
    private String texto;

    @OneToOne
    private Usuario usuario;

    public NotificationLeve() {
    }

    public NotificationLeve(String texto, Usuario usuario) {
        this.texto = texto;
        this.usuario = usuario;
    }

    public long getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(long idNotification) {
        this.idNotification = idNotification;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
