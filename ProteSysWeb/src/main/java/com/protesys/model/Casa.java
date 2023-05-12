package com.protesys.model;

import java.util.List;

public class Casa {
    private long idCasa;
    private String nombre;
    private String barrio;
    private String direccion;
    private List<Piso> pisos;
    
    //CONSTRUCTOR
    public Casa() {
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
