import { Component } from '@angular/core';

@Component({
  selector: 'app-popular-courses',
  templateUrl: './popular-courses.component.html',
  styleUrl: './popular-courses.component.css',
})
export class PopularCoursesComponent {
  courses: any = [
    {
      name: 'Web Development Course for 2nd year',
      image: '../../assets/images/dev.jpg',
      instructor: 'Ms. Imen Kamoun',
      duration: '1.49 Hrs',
      rating: {
        value: 4.5,
        nonDecimal: 4,
        decimal: '50%',
      },
      enrolledSudents: 30,
    },
    {
      name: 'Data Structure for 2nd year',
      image: '../../assets/images/datastruct.jpg',
      instructor: 'Mr. Faouzi Jaidi',
      duration: '1.49 Hrs',
      rating: {
        value: 3.25,
        nonDecimal: 3,
        decimal: '25%',
      },
      enrolledSudents: 0,
    },
    {
      name: 'CyberSecurity for 3rd year',
      image: '../../assets/images/cyber2.jpg',
      instructor: 'Ms. Imen Kamoun',
      duration: '1.49 Hrs',
      rating: {
        value: 3.25,
        nonDecimal: 3,
        decimal: '25%',
      },
      enrolledSudents: 150,
    },
  ];
}
