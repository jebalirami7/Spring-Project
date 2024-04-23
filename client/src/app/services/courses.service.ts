import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class Courses {
  constructor(private http: HttpClient) {}

  getAllCourses(filter: String): Observable<any> {
    return this.http.post<any>(`${environment.apiURL}/course`, filter);
  }

}
