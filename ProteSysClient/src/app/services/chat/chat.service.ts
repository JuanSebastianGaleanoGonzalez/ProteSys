import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Chat } from 'src/app/model/Chat/chat';

@Injectable({
  providedIn: 'root'
})
export class ChatService {

  private httpOptions = {
    headers: new HttpHeaders({
      "Content-Type": "application/json"
    })
  };

  private API_SERVER = "http://localhost:8080/chat"

  constructor(private httpClient: HttpClient) { }

  public traerChats(): Observable<Chat[]> {
    return this.httpClient.get<Chat[]>(this.API_SERVER + `/search`);
  }

  public traerChatId(id: number): Observable<Chat> {
    return this.httpClient.get<Chat>(this.API_SERVER + `/search/${id}`);
  }

  public crearChat(chat: Chat): Observable<Chat> {
    return this.httpClient.post<Chat>(this.API_SERVER + `/create`, chat, this.httpOptions);
  }

  public eliminarChat(id: number): Observable<Chat> {
    return this.httpClient.delete<Chat>(this.API_SERVER + `/delete/${id}`);
  }

  public actualizarChat(chat: Chat): Observable<Chat> {
    return this.httpClient.put<Chat>(this.API_SERVER + `/update`, chat, this.httpOptions);
  }
}
