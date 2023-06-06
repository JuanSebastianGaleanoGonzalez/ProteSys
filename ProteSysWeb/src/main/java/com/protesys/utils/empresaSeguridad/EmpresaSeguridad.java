package com.protesys.utils.empresaSeguridad;

import com.protesys.utils.facadeAutoridades.AlertaAutoridadesImplementacion;
import com.protesys.utils.facadeAutoridades.FacadeAlertaAutoridades;

public class EmpresaSeguridad {
    private static EmpresaSeguridad empresaSeguridad = new EmpresaSeguridad();
    FacadeAlertaAutoridades facadeAlertaAutoridades = new AlertaAutoridadesImplementacion();

    private EmpresaSeguridad(){};

    public static EmpresaSeguridad getInstance(){
        return empresaSeguridad;
    }
    
    public void alertarAutoridades(long idUsuario){
        this.facadeAlertaAutoridades.alertarAutoridades(idUsuario);
    }
}
