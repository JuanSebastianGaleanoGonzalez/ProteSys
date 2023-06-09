package com.protesys.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.protesys.utils.chat.Chat;
import com.protesys.utils.notifications.Notification;

@Entity
@Table(name = "usuario")
public class Usuario implements UsuarioSubscriber{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUsuario;

    @Column(name = "cedula")
    private long cedula;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "correo")
    private String correo;

    @Column(name = "telefono")
    private long telefono;

    @Column(name = "rol")
    private String rol;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;

    @JsonIgnore
    @ManyToMany(mappedBy = "usuarios")
    private List<Chat> chats = new ArrayList<>();

    @OneToOne
    private Credencial credencial;
    
    //CONSTRUCTORES
    public Usuario() {
    }

    public Usuario(long cedula, String nombre, String correo, long telefono, String rol) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.rol = rol;
    }

    //ACCESSORS
    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public long getCedula() {
        return cedula;
    }
    
    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public void setChats(List<Chat> chats) {
        this.chats = chats;
    }

    public void setCredencial(Credencial credencial) {
        this.credencial = credencial;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public List<Chat> getChats() {
        return chats;
    }

    public Credencial getCredencial() {
        return credencial;
    }

    @Override
    public void updateNotifications(Notification notification) {
    }
}
