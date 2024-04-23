import { Component, ViewChild, ElementRef, OnInit } from '@angular/core';
import { CarouselModule } from 'ngx-owl-carousel-o';
import { CommonModule } from '@angular/common';
import { CommentsService } from '../services/comments.service';
@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styleUrl: './comments.component.css',
})
export class CommentsComponent implements OnInit {

  comments:any;

  constructor(public commentService: CommentsService) { }
  
  ngOnInit(): void {
    this.commentService.getAllStudentsReviews().subscribe(
      res=>{
        console.log(res);
        this.comments=res;
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
