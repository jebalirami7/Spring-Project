import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class InstructorService {

  constructor(private http:HttpClient) { }
  getAllinstructors(){
    return this.http.get(`${environment.apiURL}/tutor`);
  }
}
