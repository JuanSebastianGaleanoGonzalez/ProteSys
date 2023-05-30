import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { KeycloakService } from 'keycloak-angular';

@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.css']
})
export class UserHomeComponent {
  options: boolean = true;
  selectedOption: string = 'Usuario';
  roles: String[] = []; 

  constructor(
    private keycloakService: KeycloakService,
    private router: Router
  ){
    this.roles = this.keycloakService.getUserRoles();
  }

  selectOptions(){
    this.options = !this.options;    
  }

  selectOption(option: string){
    this.selectedOption = option;
  }

  logout(){
    this.keycloakService.logout('http://localhost:4200');
  }
}
