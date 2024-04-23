import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { Course } from '../entities/course';

@Injectable({
  providedIn: 'root',
})
export class CoursesService {
  constructor(private http: HttpClient) {}

  getAllCourses(): Observable<Course[]> {
    return this.http.get<Course[]>(`${environment.apiURL}/course`);
  }

  getCoursesByTutor(tutorId: number): Observable<Course[]> {
    return this.http.get<Course[]>(`${environment.apiURL}/course/tutor/${tutorId}`);
  }

  getCoursesByStudent(studentId: number): Observable<Course[]> {
    return this.http.get<Course[]>(`${environment.apiURL}/course/student/${studentId}`);
  }

}
