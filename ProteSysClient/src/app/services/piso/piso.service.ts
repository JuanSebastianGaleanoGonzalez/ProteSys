import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Piso } from 'src/app/model/Piso/piso';

@Injectable({
  providedIn: 'root'
})
export class PisoService {
  private httpOptions = {
    headers: new HttpHeaders({
      "Content-Type": "application/json"
    })
  };

  private API_SERVER = "http://localhost:8080/piso"

  constructor(private httpClient: HttpClient) { }

  public traerPisos(): Observable<Piso[]> {
    return this.httpClient.get<Piso[]>(this.API_SERVER + `/search`);
  }

  public traerPisoId(id: number): Observable<Piso> {
    return this.httpClient.get<Piso>(this.API_SERVER + `/search/${id}`);
  }

  public crearPiso(piso: Piso): Observable<Piso> {
    return this.httpClient.post<Piso>(this.API_SERVER + `/create`, piso, this.httpOptions);
  }

  public eliminarPiso(id: number): Observable<Piso> {
    return this.httpClient.delete<Piso>(this.API_SERVER + `/delete/${id}`);
  }

  public actualizarPiso(piso: Piso): Observable<Piso> {
    return this.httpClient.put<Piso>(this.API_SERVER + `/update`, piso, this.httpOptions);
  }
}
