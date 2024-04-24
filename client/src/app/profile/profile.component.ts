import { Component, OnInit } from "@angular/core";
import { CoursesService } from '../services/courses.service';
import { HttpErrorResponse } from "@angular/common/http";
import { AuthService } from "../services/auth.service";
import { Router } from "@angular/router";
import { Course } from "../entities/course";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css',
})
export class ProfileComponent implements OnInit {
  courses: Course[];

  constructor(private coursesService: CoursesService, private auth: AuthService, private router: Router) {
    this.courses = [];
  }

  ngOnInit() {
    this.loadReclamation();
  }

  loadReclamation() {
    this.coursesService.getCoursesByStudent(3).subscribe({
      next: res => {
        this.courses = res;
      }, error: (err: HttpErrorResponse) => {
        if (err.status === 401) {
          this.auth.logout();
          this.router.navigate(['/']);
        }
      }
    });
  }
}
