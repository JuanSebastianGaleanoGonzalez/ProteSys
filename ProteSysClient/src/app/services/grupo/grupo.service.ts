import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Grupo } from 'src/app/model/Grupo/grupo';

@Injectable({
  providedIn: 'root'
})
export class GrupoService {
  private httpOptions = {
    headers: new HttpHeaders({
      "Content-Type": "application/json"
    })
  };

  private API_SERVER = "http://localhost:9090/grupo"

  constructor(private httpClient: HttpClient) { }

  public traerGrupos(): Observable<Grupo[]> {
    return this.httpClient.get<Grupo[]>(this.API_SERVER + `/search`);
  }

  public traerGrupoId(id: number): Observable<Grupo> {
    return this.httpClient.get<Grupo>(this.API_SERVER + `/search/${id}`);
  }

  public crearGrupo(grupo: Grupo): Observable<Grupo> {
    return this.httpClient.post<Grupo>(this.API_SERVER + `/create`, grupo, this.httpOptions);
  }

  public eliminarGrupo(id: number): Observable<Grupo> {
    return this.httpClient.delete<Grupo>(this.API_SERVER + `/delete/${id}`);
  }

  public actualizarGrupo(grupo: Grupo): Observable<Grupo> {
    return this.httpClient.put<Grupo>(this.API_SERVER + `/update`, grupo, this.httpOptions);
  }
}
