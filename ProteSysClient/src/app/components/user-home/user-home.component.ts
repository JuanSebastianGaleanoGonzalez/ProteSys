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
export class UserHomeComponent implements OnInit {
  options: boolean = true;
  selectedOption: string = 'Usuario';
  roles: String[] = [];
  usuario: Usuario = new Usuario();
  imageUsuario: string = 'https://rickandmortyapi.com/api/character/avatar/';

  constructor(
    private keycloakService: KeycloakService,
    private usuarioService: UsuarioService,
    private router: Router
  ) {
    this.roles = this.keycloakService.getUserRoles();
  }
  ngOnInit(): void {
    this.usuarioService.traerUsuarios().subscribe(response => {
      for (let usuario of response) {
        if (usuario.credencial?.username === this.keycloakService.getUsername()) {
          this.usuario = usuario;
          this.imageUsuario = this.imageUsuario + this.usuario.idUsuario + '.jpeg';
          if (this.roles.includes('ROLE_ADMINISTRADOR')) {
            this.usuario.rol = 'ADMINISTRADOR';
          } else if (this.roles.includes('ROLE_ADMIN_GRUPO')) {
            this.usuario.rol = 'ADMINISTRADOR DE GRUPO';
          }
          else if (this.roles.includes('ROLE_NORMAL')) {
            this.usuario.rol = 'NORMAL';
          } else {
            this.usuario.rol = 'INVITADO';
          }
        }
      }
    });
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
