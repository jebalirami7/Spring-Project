import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css',
})
export class NavbarComponent {
  isLoggedIn: boolean = false;
  isTokenExpired: boolean = false;
  currentUser: any;

  constructor( private authService: AuthService, private router: Router) {}
  
  ngOnInit() {
    this.isTokenExpired = this.authService.checkTokenExpiration();
    if (this.isTokenExpired) {
      this.authService.logout();
    }
    this.isLoggedIn = this.authService.isLoggedIn();
    if (this.isLoggedIn) {
      this.currentUser = this.authService.currentUser();
    }
  }

  logout() {
    this.authService.logout();
  }
}
