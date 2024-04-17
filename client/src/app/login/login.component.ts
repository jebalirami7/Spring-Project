import { Component } from '@angular/core';
import { NavbarComponent } from '../navbar/navbar.component';
import { Router, RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FormBuilder, FormGroup, Validators, } from '@angular/forms';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-login',
  standalone: true,
  imports: [NavbarComponent,RouterModule,FormsModule,ReactiveFormsModule,CommonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  public isLoginFormActive: boolean = true;
  loginForm: FormGroup;
  signupForm: FormGroup;
  signupError: string= ''; 
  constructor(
    private router: Router,  
    private fb: FormBuilder
  ) {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });

    this.signupForm = this.fb.group({
      name: ['', Validators.required],
      email: ['', [Validators.required,Validators.email]],
      password: ['', Validators.required]
    });
  }

  toggleForm() {
    if (this.isLoginFormActive) {
      this.router.navigate(['/register']);
    } else {
      this.router.navigate(['/login']);
    }
    this.isLoginFormActive = !this.isLoginFormActive;
  }
}
