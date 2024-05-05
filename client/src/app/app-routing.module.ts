import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { authGuard, loginGuard } from './auth.guard';
import { CoursesComponent } from './courses/courses.component';
import { EditProfileComponent } from './edit-profile/edit-profile.component';
import { CourseSidebarComponent } from './course-sidebar/course-sidebar.component';
import { CourseComponent } from './course/course.component';
import { QuizComponent } from './quiz/quiz.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    title: 'E-learning Platform',
  },
  {
    path: 'login',
    component: LoginComponent,
    title: 'Sign In',
    canActivate: [loginGuard],
  },
  {
    path: 'register',
    component: LoginComponent,
    title: 'Sign Up',
    canActivate: [loginGuard],
  },
  {
    path: 'myprofile',
    component: ProfileComponent,
    title: 'My Profile',
    canActivate: [authGuard],
  },
  {
    path: 'dashboard',
    component: DashboardComponent,
    title: 'dashboard',
    canActivate : [authGuard],
  },
  {
    path:'courses',
    component: CoursesComponent,
    title: 'Courses Available'
  },
  {
    path:'myprofile/edit',
    component: EditProfileComponent,
    title: 'Edit Profile',
    canActivate : [authGuard],
  },
  {
    path: 'course/:id',
    component: CourseComponent,
    title: 'Course Details'
  },
  {
    path: 'quiz/:id',
    component: QuizComponent,
    title: 'Quiz',
    canActivate : [authGuard],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
