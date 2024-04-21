import { Component } from '@angular/core';
import { NavbarComponent } from '../navbar/navbar.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [NavbarComponent,CommonModule],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent {
      
  courses = [
    {
      name: 'course 1',
      tutor: 'hamma',
      image: '../../assets/images/woman2.jpg',
      
    },
    {
      name: 'course 2',
      tutor: 'hamma',
      image: '../../assets/images/woman2.jpg',
    },
    {
      name: 'course 3',
      tutor: 'hamma',
      image: '../../assets/images/woman2.jpg',
    },
    {
      name: 'course4',
      tutor: 'nasro',
      image: '../../assets/images/woman2.jpg',
    }
    
    
  ];
}