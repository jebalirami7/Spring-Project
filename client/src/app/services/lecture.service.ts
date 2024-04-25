import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { LectureDTO } from '../models/DTO/LectureDTO';

@Injectable({
  providedIn: 'root'
})
export class LectureService {

  private dataSubject = new BehaviorSubject<LectureDTO | null>(null);
  public data$ = this.dataSubject.asObservable();

  constructor( private http : HttpClient) { }



  setData(id : number) {
    this.getLectureById(id).subscribe(data => {
      this.dataSubject.next(data);
    });
  }

  getData() {
    return this.dataSubject.value;
  }

  
  getLectureById(id: number): Observable<LectureDTO> {
    return this.http.get<LectureDTO>(`${environment.apiURL}/lecture/${id}`);
  }
  




}
