import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { KeycloakProfile } from 'keycloak-js';

@Injectable({
  providedIn: 'root'
})
export class SecurityService {

  constructor(private http: HttpClient, private keycloakService: KeycloakService) { }

  login() {
  }

  logout() {
    this.keycloakService.clearToken();
    this.keycloakService.logout("http://localhost:4200/");
  }

  getUserRoles(): string[]{
    return this.keycloakService.getUserRoles();
  }
  getData(): Promise<KeycloakProfile>{
    return this.keycloakService.loadUserProfile();
  }
}
