import { Component } from '@angular/core';

@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.css']
})
export class UserHomeComponent {
  options: boolean = false;
  listadoOpciones : String[] = ["Grupo", "Notificaciones", "Chats", "Domicilio", "Administracion", "Grupo - Admin."];
  rol: String = "ROLE_INVITADO";

  selectOptions(){
    this.options = !this.options;    
  }
}
