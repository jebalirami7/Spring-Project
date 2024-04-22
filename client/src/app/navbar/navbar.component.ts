import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [CommonModule,RouterModule],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {
  
  isCoursesRoute: boolean = false;

constructor(private router: Router) {
  router.events.subscribe((val) => {
    this.isCoursesRoute = router.url === '/dashboard';
  });
}
}
