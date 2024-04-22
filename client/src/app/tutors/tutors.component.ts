import { Component,  ViewChild, ElementRef } from '@angular/core';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-tutors',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './tutors.component.html',
  styleUrl: './tutors.component.css'
})
export class TutorsComponent {
  @ViewChild('instructorGalleryCont') instructorGalleryCont!: ElementRef;

  instructors1 = [
    {
      name: 'Instructor 4',
      position: 'Web Design & Development',
      image: '../../assets/images/woman2.jpg',
      
    },
    {
      name: 'Instructor 5',
      position: 'Web Design & Development',
      image: '../../assets/images/man2.jpg',
      
    },
    {
      name: 'Instructor 6',
      position: 'Web Design & Development',
      image: '../../assets/images/man3.jpg',
      
    }
    
  ];
  instructors = [

    {
      name: 'Instructor 1',
      position: 'Web Design & Development',
      image: '../../assets/images/woman.jpg',
      
    },
    {
      name: 'Instructor 2',
      position: 'Web Design & Development',
      image: '../../assets/images/woman1.jpg',
      
    }, {
      name: 'Instructor 3',
      position: 'Web Design & Development',
      image: '../../assets/images/man1.jpg',
      
    }
    
  ];

  scrollLeft(): void {
    this.instructorGalleryCont.nativeElement.style.scrollBehavior = 'smooth';
    this.instructorGalleryCont.nativeElement.scrollLeft -= 900;
  }

  scrollRight(): void {
    this.instructorGalleryCont.nativeElement.style.scrollBehavior = 'smooth';
    this.instructorGalleryCont.nativeElement.scrollLeft += 900;
  }
 
}
