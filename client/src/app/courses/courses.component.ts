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
  courseIds: number[];
  currentUser: any;
  filter: string = 'All';

  constructor(private coursesService: CoursesService, private auth: AuthService, private router: Router) {
    this.courses = [];
    this.courseIds = [];
  }

  ngOnInit() {
    this.currentUser = this.auth.currentUser();
    this.loadCourses(this.filter);
  }

  loadCourses(filter: string) {
    this.coursesService.getAllCourses(filter).subscribe({
      next: res => {
        this.courses = res;
        this.courseIds = this.courses.map(course => course.id);
        this.isJoined();    
      }, error: (err: HttpErrorResponse) => {
        if (err.status === 401) {
          this.auth.logout();
          this.router.navigate(['/']);
        }
      }
    });
  }

  isJoined() {
    this.coursesService.isJoined(this.courseIds, this.currentUser.id).subscribe({
      next: res => {
        this.courseIds.forEach((courseId, i) => {
          this.courses[i].isJoined = res[i].first;
        });
      }, error: (err: HttpErrorResponse) => {
        if (err.status === 401) {
          this.auth.logout();
          this.router.navigate(['/']);
        }
      }
    });
  }

  onFilterChange() {
    this.loadCourses(this.filter);
  }

  joinCourse(id: number) {
    if (this.currentUser === null) {
      alert('You need to login to join a course');
      this.router.navigate(['/login']);
    } else {
      this.coursesService.joinCourse(id, this.currentUser.id).subscribe({
        next: res => {
          this.router.navigate(['/myprofile']);
        }, error: (err: HttpErrorResponse) => {
          if (err.status === 401) {
            this.auth.logout();
            this.router.navigate(['/']);
          }
        }
      });
    }
  }

  goToCourse(id: number, joined: boolean) {
    if (joined)
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
