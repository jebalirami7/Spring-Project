import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css',
})
export class NavbarComponent {
  isCoursesRoute: boolean = false;

  constructor(private router: Router) {
    router.events.subscribe((val) => {
      this.isCoursesRoute = router.url === '/dashboard';
    });
  }
}
