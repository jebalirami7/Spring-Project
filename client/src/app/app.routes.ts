import { Routes } from '@angular/router';
import { NavbarComponent } from './navbar/navbar.component';
import { HomepageComponent } from './homepage/homepage.component';
import { LoginComponent } from './login/login.component';

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
];
