import { Component, OnInit } from '@angular/core';
import { CoursesService } from '../services/courses.service';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { Course } from "../entities/course";
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-popular-courses',
  templateUrl: './popular-courses.component.html',
  styleUrl: './popular-courses.component.css',
})
export class PopularCoursesComponent implements OnInit {
  courses: Course[];
  courseIds: number[];
  enrolledStudents: number[];
  currentUser: any;

  constructor(private coursesService: CoursesService, private auth: AuthService, private router: Router) {
    this.courses = [];
    this.courseIds = [];
    this.enrolledStudents = [];
  }

  ngOnInit() {
    this.currentUser = this.auth.currentUser();
    this.loadCourses();
  }

  loadCourses() {
    this.coursesService.getPopularCourses().subscribe({
      next: res => {
        this.courses = res;
        this.courseIds = this.courses.map(course => course.id);
        this.isJoined(); 
      }, error: (err) => {
        console.log(err);
      }
    });
  }

  isJoined() {
    this.coursesService.isJoined(this.courseIds, this.currentUser.id).subscribe({
      next: res => {
        this.courseIds.forEach((courseId, i) => {
          this.courses[i].isJoined = res[i].first;
          this.enrolledStudents.push(res[i].second);
        });
        console.log(res);
        
      }, error: (err: HttpErrorResponse) => {
        if (err.status === 401) {
          this.auth.logout();
          this.router.navigate(['/']);
        }
      }
    });
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

  goToCourse(id: number) {
    this.router.navigate(['/course/' + id]);
  }

  getNonDecimalRating(rating: number): number {
    return Math.floor(rating);
  }

  getDecimalRating(rating: number): number {
    const res = rating - Math.floor(rating);
    return res;
  }
}
