import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { NotificationLeve } from 'src/app/model/NotificationLeve/notification-leve';

@Injectable({
  providedIn: 'root'
})
export class NotificationLeveService {

  private httpOptions = {
    headers: new HttpHeaders({
      "Content-Type": "application/json"
    })
  };

  private API_SERVER = "http://localhost:9090/notification-leve"

  constructor(private httpClient: HttpClient) { }

  public traerNotificacionesGraves(): Observable<NotificationLeve[]> {
    return this.httpClient.get<NotificationLeve[]>(this.API_SERVER + `/search`);
  }
}
