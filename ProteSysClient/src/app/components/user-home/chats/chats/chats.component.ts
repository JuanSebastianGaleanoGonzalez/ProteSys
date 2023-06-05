import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { Chat } from 'src/app/model/Chat/chat';
import { Grupo } from 'src/app/model/Grupo/grupo';
import { Mensaje } from 'src/app/model/Mensaje/mensaje';
import { Usuario } from 'src/app/model/Usuario/usuario';
import { ChatService } from 'src/app/services/chat/chat.service';
import { GrupoService } from 'src/app/services/grupo/grupo.service';
import { MensajeService } from 'src/app/services/mensaje/mensaje.service';
import { UsuarioService } from 'src/app/services/usuario/usuario.service';

@Component({
  selector: 'app-chats',
  templateUrl: './chats.component.html',
  styleUrls: ['./chats.component.css']
})
export class ChatsComponent implements OnInit {

  chats: Chat[] = [];
  usuario?: Usuario;
  mensajes: Mensaje[] = [];
  chatImgSrc: string = "https://rickandmortyapi.com/api/character/avatar/260.jpeg";
  selectedOption?: number;
  inputMessage?: string;
  crear_chat: boolean = false;
  chat_seleccionado_bandera: boolean = false;
  chat_seleccionado?: Chat;
  //Crear chat
  nombreChat?: string;
  usuariosAsignados: Usuario[] = [];
  usuariosNoAsignados: Usuario[] = [];
  grupo?: Grupo;


  constructor(
    private keycloakService: KeycloakService,
    private usuarioService: UsuarioService,
    private chatService: ChatService,
    private mensajeService: MensajeService,
    private grupoService: GrupoService
  ) { }

  ngOnInit(): void {
    this.usuarioService.traerUsuarios().subscribe(responseUsuario => {
      for (let usuario of responseUsuario) {
        if (usuario.credencial?.username === this.keycloakService.getUsername()) {
          this.usuario = usuario;
        }
      }
      this.chatService.traerChats().subscribe(responseChats => {
        for (let chat of responseChats) {
          for (let usuario of chat.usuarios!) {
            if (usuario.idUsuario === this.usuario?.idUsuario) {
              this.chats.push(chat);
            }
          }
        }
      });
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

  public selectOption(option: number) {
    this.selectedOption = option;
    this.chat_seleccionado = this.chats[option - 1];
    this.chat_seleccionado_bandera = true;
    this.mensajes.splice(0, this.mensajes.length);
    this.chatService.traerChatId(option).subscribe(responseChat => {
      for (let mensaje of responseChat.mensajes!) {
        this.mensajes.push(mensaje);
      }
    });
  }

  public sendMessage() {
    let message: Mensaje = new Mensaje();
    message.mensaje = this.inputMessage;    
    message.usuarioEmisor = this.usuario;
    this.mensajeService.crearMensaje(message).subscribe(responseMensaje => {
        this.chat_seleccionado?.mensajes?.push(responseMensaje);
        this.chatService.actualizarChat(this.chat_seleccionado!).subscribe(responseUpdate =>{
          this.chat_seleccionado = responseUpdate;
          this.mensajes.splice(0, this.mensajes.length);
          for(let mensaje of this.chat_seleccionado.mensajes!){
            this.mensajes.push(mensaje);
          }
        });
    });
  }

  public form_create() {
    this.crear_chat = !this.crear_chat;
  }

  public crearChat() {
    let chat: Chat = new Chat();
    chat.nombre = this.nombreChat;
    chat.usuarios = this.usuariosAsignados;
    chat.usuarios.push(this.usuario!);
    this.chatService.crearChat(chat).subscribe(responseChat => {
      this.crear_chat = !this.crear_chat;
      if(responseChat){
        this.chats.push(chat);
        this.selectOption(chat.idChat!);
      }
    });
  }

  public agregarUsuario(usuario: Usuario) {
    this.usuariosAsignados.push(usuario);
    this.usuariosNoAsignados.splice(this.getIdUsuario(usuario, this.usuariosNoAsignados), 1);
  }

  public descartarUsuario(usuario: Usuario) {
    this.usuariosNoAsignados.push(usuario);
    this.usuariosAsignados.splice(this.getIdUsuario(usuario, this.usuariosAsignados), 1);
  }

  public getIdUsuario(usuario: Usuario, usuarios: Usuario[]): number {
    let idUsuario = -1;
    let contador = 0;
    for (let usuarioIterador of usuarios) {
      if (usuario.idUsuario === usuarioIterador.idUsuario) {
        idUsuario = contador;
      }
      contador++;
    }
    return idUsuario;
  }
}
