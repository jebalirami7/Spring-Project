import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { DashboardComponent } from './dashboard/dashboard.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    title: 'E-learning Platform',
  },
  {
    path: 'login',
    component: LoginComponent,
    title: 'sign in',
  },
  {
    path: 'register',
    component: LoginComponent,
    title: 'sign up',
  },
  {
    path: 'myprofile',
    component: ProfileComponent,
    title: 'myprofile',
  },
  {
    path: 'dashboard',
    component: DashboardComponent,
    title: 'dashboard',
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
