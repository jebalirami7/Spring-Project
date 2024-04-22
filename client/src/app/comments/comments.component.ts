import { Component, ViewChild, ElementRef } from '@angular/core';
import { CarouselModule } from 'ngx-owl-carousel-o';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-comments',
  standalone: true,
  imports: [CarouselModule, CommonModule],
  templateUrl: './comments.component.html',
  styleUrl: './comments.component.css',
})
export class CommentsComponent {
  @ViewChild('instructorGalleryCont') instructorGalleryCont!: ElementRef;
  
  testimonials = [
    {
      name: 'Client Name 1',
      profession: 'Profession 1',
      content:
        'Tempor erat elitr rebum at clita. Diam dolor diam ipsum sit diam amet diam et eos. Clita erat ipsum et lorem et sit.',
      image: '../../assets/images/man3.jpg',
    },
    {
      name: 'Client Name 2',
      profession: 'Profession 1',
      content:
        'Tempor erat elitr rebum at clita. Diam dolor diam ipsum sit diam amet diam et eos. Clita erat ipsum et lorem et sit.',
      image: '../../assets/images/man3.jpg',
    },
    {
      name: 'Client Name 3',
      profession: 'Profession 1',
      content:
        'Tempor erat elitr rebum at clita. Diam dolor diam ipsum sit diam amet diam et eos. Clita erat ipsum et lorem et sit.',
      image: '../../assets/images/man3.jpg',
    },
    {
      name: 'Client Name 4',
      profession: 'Profession 1',
      content:
        'Tempor erat elitr rebum at clita. Diam dolor diam ipsum sit diam amet diam et eos. Clita erat ipsum et lorem et sit.',
      image: '../../assets/images/man3.jpg',
    },
    {
      name: 'Client Name 5',
      profession: 'Profession 1',
      content:
        'Tempor erat elitr rebum at clita. Diam dolor diam ipsum sit diam amet diam et eos. Clita erat ipsum et lorem et sit.',
      image: '../../assets/images/man3.jpg',
    },
    {
      name: 'Client Name 5',
      profession: 'Profession 1',
      content:
        'Tempor erat elitr rebum at clita. Diam dolor diam ipsum sit diam amet diam et eos. Clita erat ipsum et lorem et sit.',
      image: '../../assets/images/man3.jpg',
    },
    {
      name: 'Client Name 5',
      profession: 'Profession 1',
      content:
        'Tempor erat elitr rebum at clita. Diam dolor diam ipsum sit diam amet diam et eos. Clita erat ipsum et lorem et sit.',
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
