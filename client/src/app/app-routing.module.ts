import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { authGuard, loginGuard } from './auth.guard';
import { CoursesComponent } from './courses/courses.component';
import { CourseSidebarComponent } from './course-sidebar/course-sidebar.component';
import { CourseComponent } from './course/course.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    title: 'E-learning Platform',
  },
  {
    path: 'login',
    component: LoginComponent,
    title: 'sign in',
    canActivate: [loginGuard],
  },
  {
    path: 'register',
    component: LoginComponent,
    title: 'sign up',
    canActivate: [loginGuard],
  },
  {
    path: 'myprofile',
    component: ProfileComponent,
    title: 'myprofile',
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
    path: 'course/:id',
    component: CourseComponent,
    title: 'Course Details'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
