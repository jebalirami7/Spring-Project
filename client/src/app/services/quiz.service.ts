import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class QuizService {

  constructor(private http: HttpClient) {}

  getQuiz(id: number): Observable<any> {
    return this.http.get<any>(`${environment.apiURL}/quizz/${id}`);
  }
}
