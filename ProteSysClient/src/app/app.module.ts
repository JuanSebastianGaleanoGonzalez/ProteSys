import { APP_INITIALIZER, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { AdminHomeComponent } from './components/administrador/admin-home/admin-home.component';
import { AdminUsuarioCreateComponent } from './components/administrador/usuario/admin-usuario-create/admin-usuario-create.component';
import { AdminUsuarioUpdateComponent } from './components/administrador/usuario/admin-usuario-update/admin-usuario-update.component';
import { AdminUsuarioViewComponent } from './components/administrador/usuario/admin-usuario-view/admin-usuario-view.component';
import { AdminGrupoViewComponent } from './components/administrador/grupo/admin-grupo-view/admin-grupo-view.component';
import { AdminGrupoUpdateComponent } from './components/administrador/grupo/admin-grupo-update/admin-grupo-update.component';
import { AdminGrupoCreateComponent } from './components/administrador/grupo/admin-grupo-create/admin-grupo-create.component';
import { AdminPisoCreateComponent } from './components/administrador/piso/admin-piso-create/admin-piso-create.component';
import { AdminPisoUpdateComponent } from './components/administrador/piso/admin-piso-update/admin-piso-update.component';
import { AdminPisoViewComponent } from './components/administrador/piso/admin-piso-view/admin-piso-view.component';
import { AdminCasaViewComponent } from './components/administrador/casa/admin-casa-view/admin-casa-view.component';
import { AdminCasaUpdateComponent } from './components/administrador/casa/admin-casa-update/admin-casa-update.component';
import { AdminCasaCreateComponent } from './components/administrador/casa/admin-casa-create/admin-casa-create.component';
import { KeycloakAngularModule, KeycloakService } from 'keycloak-angular';
import { UserHomeComponent } from './components/user-home/user-home.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { IconGrupo } from "./components/material/icon-grupo/icon-grupo";
import { IconNotificaciones } from './components/material/icon-notificaciones/icon-notificaciones';
import { IconChats } from './components/material/icon-chats/icon-chats';
import { IconDomicilio } from './components/material/icon-domicilio/icon-domicilio';
import { IconAdministracion } from './components/material/icon-administracion/icon-administracion';
import { IconAdminGrupo } from './components/material/icon-admin-grupo/icon-admin-grupo';
import { InfoUsuarioComponent } from './components/user-home/info-usuario/info-usuario/info-usuario.component';
import { InfoGrupoComponent } from './components/user-home/info-grupo/info-grupo/info-grupo.component';
import { NotificationsComponent } from './components/user-home/notifications/notifications/notifications.component';
import { ChatsComponent } from './components/user-home/chats/chats/chats.component';
import { InfoDomicilioComponent } from './components/user-home/info-domicilio/info-domicilio/info-domicilio.component';
import { AdministracionComponent } from './components/user-home/administracion/administracion/administracion.component';
import { AdminGrupoComponent } from './components/user-home/admin-grupo/admin-grupo/admin-grupo.component';
import { IconSendMessage } from './components/material/icon-send-message/icon-send-message/icon-send-message';
import { IconPlus } from './components/material/icon-plus/icon-plus/icon-plus';
import { IconMinus } from './components/material/icon-minus/icon-minus/icon-minus';

function initializeKeycloak(keycloak: KeycloakService) {
  return () =>
  keycloak.init({
      config: {
        url: 'http://localhost:8080',
        realm: 'protesys-dev',
        clientId: 'protesys-app'
      },
      loadUserProfileAtStartUp: true,
      initOptions: {
        onLoad: 'check-sso',
        silentCheckSsoRedirectUri:
          window.location.origin + '/assets/silent-check-sso.html'
      }
    });
}

@NgModule({
    declarations: [
        AppComponent,
        HomeComponent,
        AdminHomeComponent,
        AdminUsuarioCreateComponent,
        AdminUsuarioUpdateComponent,
        AdminUsuarioViewComponent,
        AdminGrupoViewComponent,
        AdminGrupoUpdateComponent,
        AdminGrupoCreateComponent,
        AdminPisoCreateComponent,
        AdminPisoUpdateComponent,
        AdminPisoViewComponent,
        AdminCasaViewComponent,
        AdminCasaUpdateComponent,
        AdminCasaCreateComponent,
        UserHomeComponent,
        InfoUsuarioComponent,
        InfoGrupoComponent,
        NotificationsComponent,
        ChatsComponent,
        InfoDomicilioComponent,
        AdministracionComponent,
        AdminGrupoComponent
    ],
    providers: [
        {
            provide: APP_INITIALIZER,
            useFactory: initializeKeycloak,
            multi: true,
            deps: [KeycloakService]
        }
    ],
    bootstrap: [AppComponent],
    imports: [
        BrowserModule,
        AppRoutingModule,
        KeycloakAngularModule,
        HttpClientModule,
        ReactiveFormsModule,
        FormsModule,
        BrowserAnimationsModule,
        IconGrupo,
        IconNotificaciones,
        IconChats,
        IconDomicilio,
        IconAdministracion,
        IconAdminGrupo,
        IconSendMessage,
        IconPlus,
        IconMinus
    ]
})

export class AppModule { }
