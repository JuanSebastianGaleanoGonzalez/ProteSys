import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { NotificationGrave } from 'src/app/model/NotificationGrave/notification-grave';

@Injectable({
  providedIn: 'root'
})
export class NotificationGraveService {

  private httpOptions = {
    headers: new HttpHeaders({
      "Content-Type": "application/json"
    })
  };

  private API_SERVER = "http://localhost:9090/notification-grave"

  constructor(private httpClient: HttpClient) { }

  public traerNotificaciones(): Observable<NotificationGrave[]> {
    return this.httpClient.get<NotificationGrave[]>(this.API_SERVER + `/search`);
  }
}
