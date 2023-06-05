import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { KeycloakService } from 'keycloak-angular';
import { Chat } from 'src/app/model/Chat/chat';
import { Grupo } from 'src/app/model/Grupo/grupo';
import { Usuario } from 'src/app/model/Usuario/usuario';
import { ChatService } from 'src/app/services/chat/chat.service';
import { GrupoService } from 'src/app/services/grupo/grupo.service';
import { UsuarioService } from 'src/app/services/usuario/usuario.service';

@Component({
  selector: 'app-create-chat',
  templateUrl: './create-chat.component.html',
  styleUrls: ['./create-chat.component.css']
})
export class CreateChatComponent implements OnInit{
  nombreChat?: string;
  usuariosAsignados: Usuario[] = [];
  usuariosNoAsignados: Usuario[] = [];
  usuario?: Usuario;
  grupo?: Grupo;

  constructor(
    private keycloakService: KeycloakService,
    private usuarioService: UsuarioService,
    private grupoService: GrupoService,
    private chatService: ChatService, 
    private router: Router
  ){}

  ngOnInit(): void {
    this.usuarioService.traerUsuarios().subscribe(responseUsuario => {
      for(let usuario of responseUsuario){
        if(usuario.credencial?.username === this.keycloakService.getUsername()){
          this.usuario = usuario;
        }
      }
      this.grupoService.traerGrupos().subscribe(responseGrupo => {
        for(let grupo of responseGrupo){
          for(let usuarioGrupo of grupo.usuarios!){
            if(usuarioGrupo.idUsuario === this.usuario?.idUsuario){
              this.grupo = grupo;
            }
          }
        }
        for(let usuario of this.grupo?.usuarios!){
          if(!(usuario.idUsuario === this.usuario?.idUsuario)){ 
            this.usuariosNoAsignados.push(usuario);
          } 
        }
      });
    });
  }
  public crearChat(){
    let chat: Chat = new Chat();
    chat.nombre = this.nombreChat;
    chat.usuarios = this.usuariosAsignados;
    chat.usuarios.push(this.usuario!);
    this.chatService.crearChat(chat).subscribe(responseChat => {
      console.log(responseChat);
    });
    this.router.navigate(['user-home/']);
  }

  public agregarUsuario(usuario: Usuario){
    this.usuariosAsignados.push(usuario);
    this.usuariosNoAsignados.splice(this.getIdUsuario(usuario, this.usuariosNoAsignados), 1);
  }

  public descartarUsuario(usuario: Usuario){
    this.usuariosNoAsignados.push(usuario);
    this.usuariosAsignados.splice(this.getIdUsuario(usuario, this.usuariosAsignados), 1);
  }

  public getIdUsuario(usuario: Usuario, usuarios: Usuario[]): number{
    let idUsuario = -1;
    let contador = 0;
    for(let usuarioIterador of usuarios){
      if(usuario.idUsuario === usuarioIterador.idUsuario){
        idUsuario = contador;
      }
      contador++;
    }
    return idUsuario;
  }
}
