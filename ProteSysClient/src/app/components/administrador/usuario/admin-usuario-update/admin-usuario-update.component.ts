import { Component } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-admin-usuario-update',
  templateUrl: './admin-usuario-update.component.html',
  styleUrls: ['./admin-usuario-update.component.css']
})
export class AdminUsuarioUpdateComponent {
  opcionSeleccionada: string = 'Usuarios';
  opciones: string[] = ['ADMINISTRADOR', ' ADMIN_GRUPO', 'NORMAL', 'INVITADO'];
  usuarioForm?: FormGroup;

  onSubmit(){}
}
