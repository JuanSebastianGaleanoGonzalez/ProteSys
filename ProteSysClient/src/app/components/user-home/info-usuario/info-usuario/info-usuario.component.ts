import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { Usuario } from 'src/app/model/Usuario/usuario';
import { UsuarioService } from 'src/app/services/usuario/usuario.service';

@Component({
  selector: 'app-info-usuario',
  templateUrl: './info-usuario.component.html',
  styleUrls: ['./info-usuario.component.css']
})
export class InfoUsuarioComponent implements OnInit{

  usuario: Usuario = new Usuario();
  imageUsuario: string = 'https://rickandmortyapi.com/api/character/avatar/';
  roles: String[] = [];

  constructor(
    private keycloakService: KeycloakService,
    private usuarioService: UsuarioService
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
}
