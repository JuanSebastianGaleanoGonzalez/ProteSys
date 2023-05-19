import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/model/Usuario/usuario';
import { UsuarioService } from 'src/app/services/usuario/usuario.service';

@Component({
  selector: 'app-admin-usuario-create',
  templateUrl: './admin-usuario-create.component.html',
  styleUrls: ['./admin-usuario-create.component.css']
})
export class AdminUsuarioCreateComponent {
  opcionSeleccionada: string = 'Usuarios';
  opciones: string[] = ['ADMINISTRADOR', ' ADMIN_GRUPO', 'NORMAL', 'INVITADO'];
  usuarioForm: FormGroup = this.formBuilder.group({
    cedula: ['', Validators.required],
    nombre: ['', Validators.required],
    correo: ['', Validators.required],
    telefono: ['', Validators.required],
    rol: ['', Validators.required]
  });

  constructor(
    private formBuilder: FormBuilder,
    private usuarioService: UsuarioService, 
    private router: Router
  ) { }

  onSubmit() {
    let usuario: Usuario = new Usuario();
    usuario.cedula = this.usuarioForm.value.cedula;
    usuario.nombre = this.usuarioForm.value.nombre;
    usuario.correo = this.usuarioForm.value.correo;
    usuario.telefono = this.usuarioForm.value.telefono;
    usuario.rol = this.usuarioForm.value.rol;
    
  }
}
