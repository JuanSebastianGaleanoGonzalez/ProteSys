import { APP_INITIALIZER, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { SignInComponent } from './components/sign-in/sign-in.component';
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

function initializeKeycloak(keycloak: KeycloakService) {
  return () =>
    keycloak.init({
      config: {
        url: 'http://localhost:8080',
        realm: 'protesys-dev',
        clientId: 'protesys-app',
      },
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
    SignInComponent,
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
    AdminCasaCreateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    KeycloakAngularModule,
    HttpClientModule, 
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [
    {
      provide: APP_INITIALIZER,
      useFactory: initializeKeycloak,
      multi: true,
      deps: [KeycloakService]
    }
  ],
  bootstrap: [AppComponent]
})

export class AppModule { }
