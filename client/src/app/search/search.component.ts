import { Component } from '@angular/core';
import { Course } from '../entities/course';
import { CoursesService } from '../services/courses.service';
import { AuthService } from '../services/auth.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrl: './search.component.css'
})
export class SearchComponent {
  courses: Course[] = [];
  keyWord: string = '';

  constructor(private coursesService: CoursesService, private auth: AuthService, private router: Router) {
    this.courses = [];
  }

  loadCourses() {
    if (this.keyWord !== '') {
      this.coursesService.searchCourses(this.keyWord).subscribe({
        next: res => {
          this.courses = res;
          console.log(this.courses);
        }, error: (err: HttpErrorResponse) => {
          if (err.status === 401) {
            this.auth.logout();
            this.router.navigate(['/']);
          }
        }
      });
    }
  }
}
