import { Component, OnInit } from '@angular/core';
import { LectureService } from '../services/lecture.service';
import { LectureDTO } from '../entities/DTO/LectureDTO';
import { environment } from '../../environments/environment';

@Component({
  selector: 'app-lecture-material',
  templateUrl: './lecture-material.component.html',
  styleUrl: './lecture-material.component.css'
})
export class LectureMaterialComponent implements OnInit{

  src : string = `${environment.apiURL}/uploads/`
  lecture: LectureDTO = 
    {
      id: 1,
      title: "Lecture 1",
        content: "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Sapiente officiis vero est iste a, tempora accusantium blanditiis inventore ad saepe molestiae eaque voluptatum ex eos soluta. Magnam nesciunt libero ipsam.",
      type: "text"
    };


  constructor(private service : LectureService) { }
  

  ngOnInit(): void {
    this.service.data$.subscribe(data => {
      if ( data !== null) {
        this.lecture = data;
      } 
    });
  }

}
