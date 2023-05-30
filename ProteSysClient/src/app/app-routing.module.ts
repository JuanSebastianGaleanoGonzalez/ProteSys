import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { AdminHomeComponent } from './components/administrador/admin-home/admin-home.component';
import { AdminUsuarioCreateComponent } from './components/administrador/usuario/admin-usuario-create/admin-usuario-create.component';
import { AuthGuard } from './guards/auth.guard';
import { UserHomeComponent } from './components/user-home/user-home.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent}, 
  {path: '', pathMatch: 'full', redirectTo: '/home' },
  {path: 'user-home', component: UserHomeComponent, canActivate: [AuthGuard]},
  {path: 'admin-home', component:AdminHomeComponent, canActivate: [AuthGuard]},
  {path: 'admin/usuario/create', component: AdminUsuarioCreateComponent, canActivate: [AuthGuard], data: {roles: ['ROLE_ADMINISTRADOR']}}
  //{ path: '**', component: NotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
