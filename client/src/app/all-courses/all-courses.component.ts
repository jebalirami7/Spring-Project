import { Component,OnInit } from '@angular/core';
import { NavbarComponent } from '../navbar/navbar.component';
import { CommonModule } from '@angular/common';
import { CourseServiceService } from '../services/course-service.service';
@Component({
  selector: 'app-all-courses',
  standalone: true,
  imports: [NavbarComponent,CommonModule],
  templateUrl: './all-courses.component.html',
  styleUrl: './all-courses.component.css'
})
export class AllCoursesComponent  {
    
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
