package com.protesys.utils.facadeAutoridades;

public class AlertaAutoridadesImplementacion implements FacadeAlertaAutoridades{

    private AlertaCorreo alertaCorreo = new AlertaCorreo();
    private AlertaMensaje alertaMensaje = new AlertaMensaje();
    private AlertaLlamada alertaLlamada = new AlertaLlamada();

    @Override
    public void alertarAutoridades(long idUsuario) {
        this.alertaCorreo.enviarCorreo(idUsuario);
        this.alertaMensaje.enviarMensaje(idUsuario);
        this.alertaLlamada.realizarLlamada(idUsuario);
    }
    
}
