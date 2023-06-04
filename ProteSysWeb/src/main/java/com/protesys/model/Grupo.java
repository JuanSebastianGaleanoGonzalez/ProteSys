package com.protesys.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.protesys.utils.chat.Chat;

@Entity
@Table(name = "grupo")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idGrupo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fecha_creacion")
    private Date fecha_creacion;

    @Column(name = "cantidad_usuarios")
    private int cantidad_usuarios;

    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL)
    private List<Usuario> usuarios = new ArrayList<>();

    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL)
    private List<Chat> chats = new ArrayList<>();

    @Column(name = "estado")
    private String estado;

    @JsonIgnore
    @OneToOne(mappedBy = "grupo")
    private Piso piso;
    
    //CONSTRUCTOR
    
    public Grupo() {
    }


    //ACCESSORS

    public Grupo(String nombre, Date fecha_creacion, int cantidad_usuarios, String estado) {
        this.nombre = nombre;
        this.fecha_creacion = fecha_creacion;
        this.cantidad_usuarios = cantidad_usuarios;
        this.estado = estado;
    }



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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
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
