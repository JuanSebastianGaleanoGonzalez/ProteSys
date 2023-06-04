import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { Chat } from 'src/app/model/Chat/chat';
import { Mensaje } from 'src/app/model/Mensaje/mensaje';
import { Usuario } from 'src/app/model/Usuario/usuario';
import { ChatService } from 'src/app/services/chat/chat.service';
import { MensajeService } from 'src/app/services/mensaje/mensaje.service';
import { UsuarioService } from 'src/app/services/usuario/usuario.service';

@Component({
  selector: 'app-chats',
  templateUrl: './chats.component.html',
  styleUrls: ['./chats.component.css']
})
export class ChatsComponent implements OnInit{
  
  chats: Chat[] = [];
  usuario?: Usuario;
  mensajes: Mensaje[] = [];
  numbers: number[] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19];
  chatImgSrc: string = "https://rickandmortyapi.com/api/character/avatar/260.jpeg";
  selectedOption?: number;
  inputMessage?: string;
  crear_chat: boolean = true;

  constructor(
    private keycloakService: KeycloakService,
    private usuarioService: UsuarioService,
    private chatService: ChatService,
    private mensajeService: MensajeService
  ){}

  ngOnInit(): void {
    let chatAux = new Chat();
    chatAux.idChat = 1;
    chatAux.nombre = "Grupo Familiar";
    let mensajeAux = new Mensaje();
    mensajeAux.idMensaje = 1;
    mensajeAux.mensaje = "Hola!";
    this.mensajes.push(mensajeAux);
    chatAux.mensajes?.push(mensajeAux);
    mensajeAux.idMensaje = 2;
    mensajeAux.mensaje = "Como estás?";
    this.mensajes.push(mensajeAux);
    chatAux.mensajes?.push(mensajeAux);
    mensajeAux.idMensaje = 3;
    mensajeAux.mensaje = "Como te ha ido?";
    this.mensajes.push(mensajeAux);
    chatAux.mensajes?.push(mensajeAux);
    this.chats.push(chatAux);
    /* 
    this.usuarioService.traerUsuarios().subscribe(responseUsuario => {
      for(let usuario of responseUsuario){
        if(usuario.nombre === this.keycloakService.getUsername()){
          this.usuario = usuario;
        }
      }
      this.chatService.traerChats().subscribe(responseChats => {
        for(let chat of responseChats){
          for(let usuario of chat.usuarios!){
            if(usuario.idUsuario === this.usuario?.idUsuario){
              this.chats.push(chat);
            }
          }
        }
      });
    });*/
  }

  public selectOption(option: number){
    this.selectedOption = option;
  }

  public sendMessage(messageContent: string){
    console.log(messageContent);  
  }

  public form_create(){
    this.crear_chat = !this.crear_chat;
  }
}
