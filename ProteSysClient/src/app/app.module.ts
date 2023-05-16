import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { SignInComponent } from './components/sign-in/sign-in.component';
import { AdminHomeComponent } from './components/administrador/admin-home/admin-home.component';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { UsuarioViewComponent } from './components/administrador/usuario/usuario-view/usuario-view.component';
import { UsuarioUpdateComponent } from './components/administrador/usuario/usuario-update/usuario-update.component';
import { GrupoUpdateComponent } from './components/administrador/grupo/grupo-update/grupo-update.component';
import { GrupoViewComponent } from './components/administrador/grupo/grupo-view/grupo-view.component';
import { PisoViewComponent } from './components/administrador/piso/piso-view/piso-view.component';
import { PisoUpdateComponent } from './components/administrador/piso/piso-update/piso-update.component';
import { CasaUpdateComponent } from './components/administrador/casa/casa-update/casa-update.component';
import { CasaViewComponent } from './components/administrador/casa/casa-view/casa-view.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SignInComponent,
    AdminHomeComponent,
    UsuarioViewComponent,
    UsuarioUpdateComponent,
    GrupoUpdateComponent,
    GrupoViewComponent,
    PisoViewComponent,
    PisoUpdateComponent,
    CasaUpdateComponent,
    CasaViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule, 
    ReactiveFormsModule,
    FormsModule,
    MatButtonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
