import { Routes } from '@angular/router';
import { HomepageComponent } from './homepage/homepage.component';
import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './profile/profile.component';
import { DashboardComponent } from './dashboard/dashboard.component';

export const routes: Routes = [

    {
        path: '',
        component: HomepageComponent,
        title: 'E-learning Platform'
      },
      {
        path: 'login',
        component: LoginComponent,
        title: 'sign in'
      },
      {
        path: 'register',
        component: LoginComponent,
        title: 'sign up'
      },
      {
        path: 'myprofile',
        component:ProfileComponent,
        title: 'myprofile'
      },
      {
        path: 'dashboard',
        component: DashboardComponent,
        title: 'dashboard'
      }
];
