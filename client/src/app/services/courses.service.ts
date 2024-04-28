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

  getAllCourses(filter: string): Observable<Course[]> {
    return this.http.get<Course[]>(`${environment.apiURL}/course/bySection/${filter}`);
  }

  getCoursesByTutor(tutorId: number): Observable<Course[]> {
    return this.http.get<Course[]>(`${environment.apiURL}/course/tutor/${tutorId}`);
  }

  getCoursesByStudent(studentId: number): Observable<Course[]> {
    return this.http.get<Course[]>(`${environment.apiURL}/course/student/${studentId}`);
  }

  getCourseById(id: String): Observable<Course> {
    return this.http.get<Course>(`${environment.apiURL}/course/${id}`);
  }

  joinCourse(courseId: number, studentId: number): Observable<any> {
    return this.http.put<any>(`${environment.apiURL}/course/${courseId}/student/${studentId}`, {});
  }

  searchCourses(keyWord: string): Observable<Course[]> {
    return this.http.get<Course[]>(`${environment.apiURL}/course/search/${keyWord}`);
  }

  getPopularCourses(): Observable<Course[]> {
    return this.http.get<Course[]>(`${environment.apiURL}/course/popular`);
  }

  isJoined(courseIds: number[], studentId: number): Observable<any> {
    return this.http.post<any>(`${environment.apiURL}/course/isJoined/${studentId}`, courseIds);
  }
}
