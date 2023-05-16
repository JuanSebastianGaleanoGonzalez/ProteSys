import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from 'src/app/model/Usuario/usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private httpOptions = {
    headers: new HttpHeaders({
      "Content-Type": "application/json"
    })
  };

  private API_SERVER = "http://localhost:8080/usuario"

  constructor(private httpClient: HttpClient) { }

  public traerUsuarios(): Observable<Usuario[]> {
    return this.httpClient.get<Usuario[]>(this.API_SERVER + `/search`);
  }

  public traerUsuarioId(id: number): Observable<Usuario> {
    return this.httpClient.get<Usuario>(this.API_SERVER + `/search/${id}`);
  }

  public crearUsuario(usuario: Usuario): Observable<Usuario> {
    return this.httpClient.post<Usuario>(this.API_SERVER + `/create`, usuario, this.httpOptions);
  }

  public eliminarUsuario(id: number): Observable<Usuario> {
    return this.httpClient.delete<Usuario>(this.API_SERVER + `/delete/${id}`);
  }

  public actualizarUsuario(usuario: Usuario): Observable<Usuario> {
    return this.httpClient.put<Usuario>(this.API_SERVER + `/update`, usuario, this.httpOptions);
  }
}
