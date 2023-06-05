package com.protesys.utils.command;

import com.protesys.utils.empresaSeguridad.EmpresaSeguridad;

public class CommandBotonPanicoImplementation implements Command{

    @Override
    public void execute() {
        EmpresaSeguridad empresaSeguridad = EmpresaSeguridad.getInstance();
        empresaSeguridad.alertarAutoridades();
    }
    
}
