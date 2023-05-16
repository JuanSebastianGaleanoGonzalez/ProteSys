import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Casa } from 'src/app/model/Casa/casa';

@Injectable({
  providedIn: 'root'
})
export class CasaService {
  private httpOptions = {
    headers: new HttpHeaders({
      "Content-Type": "application/json"
    })
  };

  private API_SERVER = "http://localhost:8080/casa"

  constructor(private httpClient: HttpClient) { }

  public traerCasas(): Observable<Casa[]> {
    return this.httpClient.get<Casa[]>(this.API_SERVER + `/search`);
  }

  public traerCasaId(id: number): Observable<Casa> {
    return this.httpClient.get<Casa>(this.API_SERVER + `/search/${id}`);
  }

  public crearCasa(casa: Casa): Observable<Casa> {
    return this.httpClient.post<Casa>(this.API_SERVER + `/create`, casa, this.httpOptions);
  }

  public eliminarCasa(id: number): Observable<Casa> {
    return this.httpClient.delete<Casa>(this.API_SERVER + `/delete/${id}`);
  }

  public actualizarCasa(casa: Casa): Observable<Casa> {
    return this.httpClient.put<Casa>(this.API_SERVER + `/update`, casa, this.httpOptions);
  }
}
