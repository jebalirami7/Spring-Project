import { Component, OnInit } from "@angular/core";
import { CoursesService } from '../services/courses.service';
import { HttpErrorResponse } from "@angular/common/http";
import { AuthService } from "../services/auth.service";
import { Router } from "@angular/router";
import { Course } from "../entities/course";

@Component({
  selector: "app-courses",
  templateUrl: "./courses.component.html",
  styleUrl: "./courses.component.css",
})
export class CoursesComponent implements OnInit {
  courses: Course[];

  constructor(private coursesService: CoursesService, private auth: AuthService, private router: Router) {
    this.courses = [];
  }

  ngOnInit() {
    this.loadCourses();
  }

  loadCourses() {
    this.coursesService.getAllCourses().subscribe({
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
