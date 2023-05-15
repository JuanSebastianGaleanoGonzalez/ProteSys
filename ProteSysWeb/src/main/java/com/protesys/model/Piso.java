package com.protesys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "piso")
public class Piso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPiso;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "numero")
    private int numero_piso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "casa_id")
    private Casa casa;

    @OneToOne
    private Grupo grupo;

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
