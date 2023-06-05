package com.protesys.utils.command;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
    private List<Command> comandos = new ArrayList<>();

    public Invoker(){
        Command botonPanico = new CommandBotonPanicoImplementation();
        comandos.add(botonPanico);
    }

    public List<Command> getComandos() {
        return comandos;
    }

    public void setComandos(List<Command> comandos) {
        this.comandos = comandos;
    }

    
}
