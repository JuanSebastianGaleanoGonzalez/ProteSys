import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { SignInComponent } from './components/sign-in/sign-in.component';
import { AdminHomeComponent } from './components/administrador/admin-home/admin-home.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  { path: '', pathMatch: 'full', redirectTo: '/home' },
  {path: 'sign-in', component: SignInComponent},
  {path: 'admin-home/:id', component:AdminHomeComponent}
  //{ path: '**', component: NotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
