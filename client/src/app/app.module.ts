import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { CategoriesComponent } from './categories/categories.component';
import { CommentsComponent } from './comments/comments.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { PopularCoursesComponent } from './popular-courses/popular-courses.component';
import { ProfileComponent } from './profile/profile.component';
import { InstructorsComponent } from './instructors/instructors.component';
import { About } from './about/about.component';
import { SearchComponent } from './search/search.component';
import { AuthService } from './services/auth.service';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { TokenInterceptorService } from './services/token-interceptor.service';
import { CoursesComponent } from './courses/courses.component';
import { EditProfileComponent } from './edit-profile/edit-profile.component';
import { CourseSidebarComponent } from './course-sidebar/course-sidebar.component';
import { CourseComponent } from './course/course.component';
import { LectureMaterialComponent } from './lecture-material/lecture-material.component';
import { QuizComponent } from './quiz/quiz.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    CategoriesComponent,
    CommentsComponent,
    DashboardComponent,
    FooterComponent,
    HomeComponent,
    NavbarComponent,
    PopularCoursesComponent,
    ProfileComponent,
    InstructorsComponent,
    About,
    SearchComponent,
    CoursesComponent,
    EditProfileComponent,
    CourseSidebarComponent,
    CourseComponent,
    LectureMaterialComponent,
    QuizComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
    HttpClientModule,
  ],
  providers: [AuthService, {
    provide : HTTP_INTERCEPTORS,
    useClass: TokenInterceptorService,
    multi: true,
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
