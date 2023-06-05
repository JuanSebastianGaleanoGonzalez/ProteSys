import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { KeycloakService } from 'keycloak-angular';
import { AuthGuard } from 'src/app/guards/auth.guard';
import { Usuario } from 'src/app/model/Usuario/usuario';
import { UsuarioService } from 'src/app/services/usuario/usuario.service';

@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.css']
})
export class UserHomeComponent {
  options: boolean = true;
  selectedOption: string = 'Usuario';
  roles: String[] = [];
  

  constructor(
    private keycloakService: KeycloakService,
    private usuarioService: UsuarioService,
    private router: Router
  ) {
    this.roles = this.keycloakService.getUserRoles();
  }
  

  selectOptions() {
    this.options = !this.options;
  }

  selectOption(option: string) {
    this.selectedOption = option;
  }

  logout() {
    this.keycloakService.logout('http://localhost:4200');
  }
}
