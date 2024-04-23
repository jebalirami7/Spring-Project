import { Component } from '@angular/core';

@Component({
  selector: 'app-popular-courses',
  templateUrl: './popular-courses.component.html',
  styleUrl: './popular-courses.component.css',
})
export class PopularCoursesComponent {
  courses: any = [
    {
      name: 'Web Development Course for 2nd year informatique',
      image: '../../assets/images/dev.jpg',
      instructor: 'John Doe',
      duration: '1.49 Hrs',
      rating: {
        value: 4.5,
        nonDecimal: 4,
        decimal: '50%',
      },
      enrolledSudents: 30,
    },
    {
      name: 'Data Structure for 2nd year informatique',
      image: '../../assets/images/datastruct.jpg',
      instructor: 'John Doe',
      duration: '1.49 Hrs',
      rating: {
        value: 3.25,
        nonDecimal: 3,
        decimal: '25%',
      },
      enrolledSudents: 10,
    },
    {
      name: 'CyberSecurity for 3rd year informatique',
      image: '../../assets/images/cyber2.jpg',
      instructor: 'John Doe',
      duration: '1.49 Hrs',
      rating: {
        value: 3.25,
        nonDecimal: 3,
        decimal: '25%',
      },
      enrolledSudents: 0,
    },
  ];
}
