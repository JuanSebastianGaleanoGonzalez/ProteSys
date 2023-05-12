package com.protesys.model;

import java.util.Date;
import java.util.List;

import com.protesys.utils.chat.Chat;
import com.protesys.utils.estado.Estado;

public class Grupo {
    private long idGrupo;
    private String nombre;
    private Date fecha_creacion;
    private int cantidad_usuarios;
    private List<Usuario> usuarios;
    private List<Chat> chats;
    private Estado estado;
    private Piso piso;
    
    //CONSTRUCTOR
    
    public Grupo() {
    }

    //ACCESSORS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public int getCantidad_usuarios() {
        return cantidad_usuarios;
    }

    public void setCantidad_usuarios(int cantidad_usuarios) {
        this.cantidad_usuarios = cantidad_usuarios;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Chat> getChats() {
        return chats;
    }

    public void setChats(List<Chat> chats) {
        this.chats = chats;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Piso getPiso() {
        return piso;
    }

    public void setPiso(Piso piso) {
        this.piso = piso;
    }

    public long getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(long idGrupo) {
        this.idGrupo = idGrupo;
    }

}
