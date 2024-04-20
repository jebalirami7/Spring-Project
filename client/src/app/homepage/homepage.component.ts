import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from '../navbar/navbar.component';
import { Interface1Component } from '../interface1/interface1.component';
import { TheServicesComponent } from '../the-services/the-services.component';
import { CategoriesComponent } from '../categories/categories.component';
import { PopularCoursesComponent } from '../popular-courses/popular-courses.component';
import { TutorsComponent } from '../tutors/tutors.component';
import { CommentsComponent } from '../comments/comments.component';
import { FooterComponent } from '../footer/footer.component';

@Component({
  selector: 'app-homepage',
  standalone: true,
  imports: [CommonModule,NavbarComponent,Interface1Component,TheServicesComponent,CategoriesComponent,PopularCoursesComponent,TutorsComponent,CommentsComponent,FooterComponent],
  templateUrl: './homepage.component.html',
  styleUrl: './homepage.component.css'
})
export class HomepageComponent {

}
