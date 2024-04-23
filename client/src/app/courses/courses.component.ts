import { Component } from "@angular/core";

@Component({
  selector: "app-courses",
  templateUrl: "./courses.component.html",
  styleUrl: "./courses.component.css",
})
export class CoursesComponent {
  courses = [
    {
      name: "course 1",
      tutor: "hamma",
      image: "../../assets/images/woman2.jpg",
    },
    {
      name: "course 2",
      tutor: "hamma",
      image: "../../assets/images/woman2.jpg",
    },
    {
      name: "course 3",
      tutor: "hamma",
      image: "../../assets/images/woman2.jpg",
    },
    {
      name: "course4",
      tutor: "nasro",
      image: "../../assets/images/woman2.jpg",
    },
  ];
}