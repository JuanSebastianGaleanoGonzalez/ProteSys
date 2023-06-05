import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { NotificationNormal } from 'src/app/model/NotificationNormal/notification-normal';

@Injectable({
  providedIn: 'root'
})
export class NotificationNormalService {

  private httpOptions = {
    headers: new HttpHeaders({
      "Content-Type": "application/json"
    })
  };

  private API_SERVER = "http://localhost:9090/notification-grave"

  constructor(private httpClient: HttpClient) { }

  public traerNotificaciones(): Observable<NotificationNormal[]> {
    return this.httpClient.get<NotificationNormal[]>(this.API_SERVER + `/search`);
  }
}
