import { Component, ViewChild, ElementRef } from '@angular/core';

@Component({
  selector: 'app-instructors',
  templateUrl: './instructors.component.html',
  styleUrl: './instructors.component.css'
})
export class InstructorsComponent {
  @ViewChild('instructorGalleryCont') instructorGalleryCont!: ElementRef;

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
    },
    {
      name: 'Instructor 3',
      position: 'Web Design & Development',
      image: '../../assets/images/man1.jpg',
      
    },
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
    },    
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
