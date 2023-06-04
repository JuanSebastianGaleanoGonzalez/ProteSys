import { Component, OnInit } from '@angular/core';
import { format } from 'date-fns';
import { KeycloakService } from 'keycloak-angular';
import { Grupo } from 'src/app/model/Grupo/grupo';
import { Usuario } from 'src/app/model/Usuario/usuario';
import { GrupoService } from 'src/app/services/grupo/grupo.service';
import { UsuarioService } from 'src/app/services/usuario/usuario.service';

@Component({
  selector: 'app-info-grupo',
  templateUrl: './info-grupo.component.html',
  styleUrls: ['./info-grupo.component.css']
})
export class InfoGrupoComponent implements OnInit{
  grupo?: Grupo;
  usuario?: Usuario;
  imageGrupo : string = 'https://rickandmortyapi.com/api/character/avatar/';
  constructor(
    private keycloakService: KeycloakService,
    private usuarioService: UsuarioService,
    private  grupoService: GrupoService
  ){}

  ngOnInit(): void {
    this.usuarioService.traerUsuarios().subscribe( response => {
      for(let usuario of response){
        if(usuario.credencial?.username === this.keycloakService.getUsername()){
          this.usuario = usuario;
        }
      }
      
      this.grupoService.traerGrupos().subscribe(response2 => {
        
        for(let grupo of response2){
          for(let usuarioGrupo of grupo.usuarios!){
            if(usuarioGrupo.idUsuario === this.usuario?.idUsuario){
              this.grupo = grupo;
              this.grupo.cantidad_usuarios = grupo.usuarios?.length;
              this.imageGrupo = this.imageGrupo + "13" + grupo.idGrupo + ".jpeg";
            }
          }
        }
      });  
    }); 
  }
}
