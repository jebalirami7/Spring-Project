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
import { ProvidedServicesComponent } from './provided-services/provided-services.component';
import { SearchComponent } from './search/search.component';
import { AuthService } from './services/auth.service';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { TokenInterceptorService } from './services/token-interceptor.service';

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
    ProvidedServicesComponent,
    SearchComponent,
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
