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
  currentUser: any;

  constructor(private coursesService: CoursesService, private auth: AuthService, private router: Router) {
    this.courses = [];
  }

  ngOnInit() {
    this.currentUser = this.auth.currentUser();
    this.refreshUser();
    this.loadCourses();
  }

  refreshUser() {
    this.auth.refreshToken().subscribe({
      next: (result) => {
        this.auth.setToken(result.token);
        this.currentUser = this.auth.currentUser(result.token);
      },
      error: (err) => {
        this.auth.logout();
        this.router.navigate(['/login']);
      },
    });
  }

  loadCourses() {
    if (this.currentUser.role === 'student') {
      this.coursesService.getCoursesByStudent(this.currentUser.id).subscribe({
        next: res => {
          this.courses = res;
        }, error: (err: HttpErrorResponse) => {
          if (err.status === 401) {
            this.auth.logout();
            this.router.navigate(['/']);
          }
        }
      });
    } else if (this.currentUser.role === 'tutor') {
      this.coursesService.getCoursesByTutor(this.currentUser.id).subscribe({
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

  goToCourse(id: number) {
    this.router.navigate(['/course/' + id]);
  }

  goToQuiz(id: number) {
    this.router.navigate(['/quiz/' + id]); 
  }

  getNonDecimalRating(rating: number): number {
    return Math.floor(rating);
  }

  getDecimalRating(rating: number): number {
    const res = rating - Math.floor(rating);
    return res;
  }
}
