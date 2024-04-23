import { Component, ViewChild, ElementRef, OnInit } from '@angular/core';
import { InstructorService } from '../services/instructor.service';

@Component({
  selector: 'app-instructors',
  templateUrl: './instructors.component.html',
  styleUrl: './instructors.component.css'
})
export class InstructorsComponent implements OnInit {

  instructors:any;

  constructor(public instructorService: InstructorService) { }
  
  ngOnInit(): void {
    this.instructorService.getAllinstructors().subscribe(
      res=>{
        console.log(res);
        this.instructors=res;
      },
      err=>{
        console.log(err);
      }
    )
  }
  
  @ViewChild('instructorGalleryCont') instructorGalleryCont!: ElementRef;


  scrollLeft(): void {
    this.instructorGalleryCont.nativeElement.style.scrollBehavior = 'smooth';
    this.instructorGalleryCont.nativeElement.scrollLeft -= 900;
  }

  scrollRight(): void {
    this.instructorGalleryCont.nativeElement.style.scrollBehavior = 'smooth';
    this.instructorGalleryCont.nativeElement.scrollLeft += 900;
  }
}
