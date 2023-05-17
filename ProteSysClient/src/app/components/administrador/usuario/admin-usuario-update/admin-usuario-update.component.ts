import { Component } from '@angular/core';

@Component({
  selector: 'app-admin-usuario-update',
  templateUrl: './admin-usuario-update.component.html',
  styleUrls: ['./admin-usuario-update.component.css']
})
export class AdminUsuarioUpdateComponent {
  opcionSeleccionada: string = 'Usuarios';
  opciones: string[] = ['ADMINISTRADOR', ' ADMIN_GRUPO', 'NORMAL', 'INVITADO'];
  
}
