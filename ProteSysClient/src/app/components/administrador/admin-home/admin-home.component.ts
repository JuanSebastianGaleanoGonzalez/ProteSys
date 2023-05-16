import { Component } from '@angular/core';
import { Casa } from 'src/app/model/Casa/casa';
import { Grupo } from 'src/app/model/Grupo/grupo';
import { Piso } from 'src/app/model/Piso/piso';
import { Usuario } from 'src/app/model/Usuario/usuario';
import { CasaService } from 'src/app/services/casa/casa.service';
import { GrupoService } from 'src/app/services/grupo/grupo.service';
import { PisoService } from 'src/app/services/piso/piso.service';
import { UsuarioService } from 'src/app/services/usuario/usuario.service';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent {
  opcionSeleccionada: String = 'Inicio';
  usuarios: Usuario[] = [];
  grupos: Grupo[] = [];
  pisos: Piso[] = [];
  casas: Casa[] = [];

  constructor(
    private usuarioService: UsuarioService,
    private grupoService: GrupoService,
    private pisoService: PisoService,
    private CasaService: CasaService
  ){}

  public cambiarOpcion(opcion: String){
    this.opcionSeleccionada = opcion;
    switch(this.opcionSeleccionada){
      case 'Inicio':
        break;
      case 'Usuarios':
        this.usuarioService.traerUsuarios().subscribe( response => {
          this.usuarios = response;
        });
        break;
      case 'Grupos':
        this.grupoService.traerGrupos().subscribe( response => {
          this.grupos = response;
        });
        break;
      case 'Pisos':
        this.pisoService.traerPisos().subscribe( response => {
          this.pisos = response;
        });
        break;
      case 'Casas':
        this.CasaService.traerCasas().subscribe( response => {
          this.casas = response;
        });
        break;
    }
  }

  public eliminarUsuario(usuario: Usuario){

  }

  public eliminarGrupo(grupo: Grupo){

  }

  public eliminarPiso(piso: Piso){

  }
  public eliminarCasa(casa: Casa){

  }
}
