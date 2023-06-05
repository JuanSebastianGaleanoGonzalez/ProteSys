import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { NotificationGrave } from 'src/app/model/NotificationGrave/notification-grave';
import { NotificationLeve } from 'src/app/model/NotificationLeve/notification-leve';
import { NotificationNormal } from 'src/app/model/NotificationNormal/notification-normal';
import { Usuario } from 'src/app/model/Usuario/usuario';
import { NotificationGraveService } from 'src/app/services/notificationGrave/notification-grave.service';
import { NotificationLeveService } from 'src/app/services/notificationLeve/notification-leve.service';
import { NotificationNormalService } from 'src/app/services/notificationNormal/notification-normal.service';
import { UsuarioService } from 'src/app/services/usuario/usuario.service';

@Component({
  selector: 'app-notifications',
  templateUrl: './notifications.component.html',
  styleUrls: ['./notifications.component.css']
})
export class NotificationsComponent implements OnInit{
  usuario: Usuario = new Usuario();
  notificaciones_graves: NotificationGrave[] = [];
  notificaciones_normales: NotificationNormal[] = [];
  notificaciones_leves: NotificationLeve[] = [];

  constructor(
    private keycloakService: KeycloakService,
    private usuarioService: UsuarioService,
    private notificationGraveService: NotificationGraveService,
    private notificationNormalService: NotificationNormalService,
    private notificationLeveService: NotificationLeveService
  ){

  }
  ngOnInit(): void {
    this.usuarioService.traerUsuarios().subscribe(responseUsuarios => {
      for(let usuario of responseUsuarios){
        if(usuario.credencial?.username === this.keycloakService.getUsername()){
          this.usuario = usuario;
        }
      }

      this.notificationGraveService.traerNotificaciones().subscribe(responseNotificationGrave => {
        for(let notificationGrave of responseNotificationGrave){
          if(notificationGrave.usuario?.idUsuario === this.usuario.idUsuario){
            this.notificaciones_graves.push(notificationGrave);
          }
        }
      });
  
      this.notificationNormalService.traerNotificaciones().subscribe(responseNotificationNormal => {
        for(let notificationNormal of responseNotificationNormal){
          if(notificationNormal.usuario?.idUsuario === this.usuario.idUsuario){
            this.notificaciones_normales.push(notificationNormal);
          }
        }
      });
  
      this.notificationLeveService.traerNotificaciones().subscribe(responseNotificationLeve => {
        for(let notificationLeve of responseNotificationLeve){
          if(notificationLeve.usuario?.idUsuario === this.usuario.idUsuario){
            this.notificaciones_leves.push(notificationLeve);
          }
        }
      });

    });
  }
}
