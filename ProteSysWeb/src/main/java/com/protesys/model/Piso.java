package com.protesys.model;

public class Piso {
    private long idPiso;
    private String codigo;
    private int numero_piso;
    private Casa casa;

    //CONSTRUCTOR
    public Piso() {
    }

    //ACCESSORS
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getNumero_piso() {
        return numero_piso;
    }

    public void setNumero_piso(int numero_piso) {
        this.numero_piso = numero_piso;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public long getIdPiso() {
        return idPiso;
    }

    public void setIdPiso(long idPiso) {
        this.idPiso = idPiso;
    }

    
}
