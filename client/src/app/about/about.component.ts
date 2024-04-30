import { Component } from '@angular/core';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrl: './about.component.css',
})
export class About {
  services: any = [
    {
      name: 'Skilled Instructors',
      description:
        'Embark on your learning journey with our instructors, guiding you every step of the way.',
      icon: 'fa fa-3x fa-graduation-cap mb-4',
    },
    {
      name: 'Online Classes',
      description:
        'Master Your Skills Anywhere: Join Our Virtual Classroom for Interactive Online Classes.',
      icon: 'fa fa-3x fa-globe mb-4',
    },
    {
      name: 'Home Projects',
      description:
        'Crafting Comfort: Elevate Your Living Space with Engaging Home Projects Tailored to Your Needs.',
      icon: 'fa fa-3x fa-home mb-4',
    },
    {
      name: 'Online Evaluation',
      description:
        'Measure Progress, Elevate Learning: Engage with Our Online Evaluation Tools.',
      icon: 'fa fa-3x fa-book-open mb-4',
    },
  ];
}
