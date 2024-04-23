import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CommentsService {

  constructor(private http:HttpClient) { }
  getAllStudentsReviews(){
    return this.http.get(`${environment.apiURL}/review`);
  }
}
