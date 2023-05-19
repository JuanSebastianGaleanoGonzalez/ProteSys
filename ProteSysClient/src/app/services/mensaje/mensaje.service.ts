import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Mensaje } from 'src/app/model/Mensaje/mensaje';

@Injectable({
  providedIn: 'root'
})
export class MensajeService {

  private httpOptions = {
    headers: new HttpHeaders({
      "Content-Type": "application/json"
    })
  };

  private API_SERVER = "http://localhost:9090/mensaje"

  constructor(private httpClient: HttpClient) { }

  public traerMensajes(): Observable<Mensaje[]> {
    return this.httpClient.get<Mensaje[]>(this.API_SERVER + `/search`);
    }

  public traerMensajeId(id: number): Observable<Mensaje> {
    return this.httpClient.get<Mensaje>(this.API_SERVER + `/search/${ id }`);
  }

  public crearMensaje(mensaje: Mensaje): Observable<Mensaje> {
    return this.httpClient.post<Mensaje>(this.API_SERVER + `/create`, mensaje, this.httpOptions);
    }

  public eliminarMensaje(id: number): Observable<Mensaje> {
    return this.httpClient.delete<Mensaje>(this.API_SERVER + `/delete/${ id }`);
  }

  public actualizarMensaje(mensaje: Mensaje): Observable<Mensaje> {
    return this.httpClient.put<Mensaje>(this.API_SERVER + `/update`, mensaje, this.httpOptions);
    }
}
