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
@Table(name = "notification_grave")
public class NotificationGrave implements Notification{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idNotification;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToOne
    private Usuario usuario;
    
    public NotificationGrave(Usuario usuario, String titulo, String motivo, String descripcion) {
        this.usuario = usuario;
        this.titulo = titulo;
        this.motivo = motivo;
        this.descripcion = descripcion;
    }

    public NotificationGrave() {
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
