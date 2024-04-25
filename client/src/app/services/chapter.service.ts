import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { ChapterDTO } from '../models/DTO/ChapterDTO';
import { Chapter } from '../models/Chapter';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ChapterService {

  constructor( private http : HttpClient) { }



  getAllCourseChapters(id : string) : Observable<ChapterDTO[]> {
    return this.http.get<ChapterDTO[]>(`${environment.apiURL}/chapter/course/${id}`);
  }

  
  convertToEntity(chapterDTO : ChapterDTO) : Chapter{
    return {
      id: chapterDTO.id,
      title: chapterDTO.title,
      courseMaterials: chapterDTO.courseMaterials
    }
  }


}
