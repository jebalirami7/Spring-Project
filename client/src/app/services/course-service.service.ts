import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class CourseServiceService {

  
  constructor(private http: HttpClient) { }
  url = 'http://localhost:5000/course';
  
   getAllCourses(): Observable<any[]> {
    return this.http.get<any[]>(this.url);
  }
  
}
