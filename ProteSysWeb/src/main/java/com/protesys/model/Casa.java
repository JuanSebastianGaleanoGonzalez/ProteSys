package com.protesys.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "casa")
public class Casa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCasa;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "barrio")
    private String barrio;

    @Column(name = "direccion")
    private String direccion;

    @OneToMany(mappedBy = "casa", cascade = CascadeType.ALL)
    private List<Piso> pisos = new ArrayList<>();
    
    //CONSTRUCTOR
    public Casa() {
    }

    public Casa(String nombre, String barrio, String direccion) {
        this.nombre = nombre;
        this.barrio = barrio;
        this.direccion = direccion;
    }

    //ACCESSORS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Piso> getPisos() {
        return pisos;
    }

    public void setPisos(List<Piso> pisos) {
        this.pisos = pisos;
    }

    public long getIdCasa() {
        return idCasa;
    }

    public void setIdCasa(long idCasa) {
        this.idCasa = idCasa;
    } 
}
